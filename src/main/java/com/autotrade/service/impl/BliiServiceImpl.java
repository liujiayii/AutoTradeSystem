package com.autotrade.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autotrade.dao.BillDao;
import com.autotrade.dao.PartsDao;
import com.autotrade.dao.RepairDao;
import com.autotrade.dao.RepairProjectDao;
import com.autotrade.entity.Parts;
import com.autotrade.entity.Repair;
import com.autotrade.entity.RepairProject;
import com.autotrade.entityVo.Closebills;
import com.autotrade.service.BillService;
import com.autotrade.utils.JsonUtil;
import com.autotrade.utils.MoneyUntil;

/**
 * 
 *
 * @ClassName: BliiServiceImpl
 * 
 * @description 账单生成
 *
 * @author lishaozhang
 * @createDate 2019年3月4日
 */
@Service
public final class BliiServiceImpl implements BillService {

	@Autowired
	private BillDao billDao;
	@Autowired
	private RepairProjectDao repairProjectDao;
	@Autowired
	private PartsDao partsDao;
	@Autowired
	private RepairDao repairDao;

	@Override
	public String creatBill(Long repair_id) {

		try {

			// 查询工单状态
			Repair selectByPrimaryKey = repairDao.selectByPrimaryKey(repair_id);
			// 未完工不可结算
			if (selectByPrimaryKey.getState() <= 2) {
				return JsonUtil.getResponseJson(1, "未完工不可结账", -1, null);
			}

			// 查询车辆信息
			Closebills bill = billDao.creatBill(repair_id);

			// 根据工单号查询工单维修项目工时工钱等信息
			RepairProject repairProject = new RepairProject();
			repairProject.setRepair_id(repair_id);
			List<RepairProject> selectBySelective = repairProjectDao.selectBySelective(repairProject);

			// 根据工单号查询工单维修用料信息
			Parts parts = new Parts();
			parts.setRepair_id(repair_id);
			List<Parts> partList = partsDao.selectBySelective(parts);

			// 遍历工时去取出个项目的工时费
			BigDecimal hour_cost = new BigDecimal("0");
			for (RepairProject repairProject2 : selectBySelective) {
				try {

					BigDecimal money = repairProject2.getMoney();

					hour_cost = hour_cost.add(money);
				} catch (Exception e) {

				}
			}

			// 计算材料费
			BigDecimal materials = new BigDecimal("0");
			for (Parts parts2 : partList) {

				try {
					BigDecimal money = parts2.getMoney();

					materials = materials.add(money);

				} catch (Exception e) {

				}
			}

			// 计算总额 总额=材料费+工时费

			BigDecimal count_money = materials.add(hour_cost);
			// 实收总额转大写
			BigDecimal money = bill.getMoney();
			String big_count_money = MoneyUntil.toChinese(money + "");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年-MM月-dd日");
			//工单号
			String order_number;
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmm");
			
			Date date = new Date();
			String re = simpleDateFormat.format(date);
			order_number = "WX"+re+bill.getRepair_id();
			//状态
			Integer state = bill.getState();
			String stateChinese;
			if(state == 3){
				stateChinese = "挂单";
			}else{
				stateChinese = "结账";
			}
			try {
                
				bill.setOrder_number(order_number);
				bill.setBillParts(partList);
				bill.setBillProject(selectBySelective);
				bill.setHour_cost(hour_cost);
				bill.setMaterials(materials);
				bill.setCount_money(count_money);
				bill.setBig_count_money(big_count_money);
				bill.setColse_date(new Date());
				Date colse_date = bill.getClosing_date();
				String format = sdf.format(colse_date);
				bill.setsColse_date(format);
				Date appointment_time = bill.getAppointment_time();
				String appo_date = sdf.format(appointment_time);
				bill.setAppo_date(appo_date);
				bill.setStateChinese(stateChinese);
				

			} catch (Exception e) {
				return JsonUtil.getResponseJson(-1, "错误的工单号", null, null);
			}
			return JsonUtil.getResponseJson(1, "创建成功", 1, bill);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
	}

}
