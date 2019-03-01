package com.autotrade.service.impl;

import java.lang.reflect.Field;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.autotrade.dao.RepairDao;
import com.autotrade.dao.RepairProjectDao;
import com.autotrade.dao.VehicleArchivesDao;
import com.autotrade.entity.Repair;
import com.autotrade.entity.RepairProject;
import com.autotrade.entity.VehicleArchives;
import com.autotrade.entityVo.PartsShow;
import com.autotrade.entityVo.RepairDetails;
import com.autotrade.entityVo.RepairId;
import com.autotrade.entityVo.RepairSelect;
import com.autotrade.entityVo.RepairShow;
import com.autotrade.service.RepairService;
import com.autotrade.utils.JsonUtil;

@Service
public class RepairServiceImpl implements RepairService {

	@Autowired
	private RepairDao repairDao;

	@Autowired
	private RepairProjectDao repairProjectDao;
	
	@Autowired
	private VehicleArchivesDao vehicleArchivesDao;

	@Override
	@Transactional
	public String insert(Repair repair) {
	
		try {
			repair.setState(0);
			

		
			
			/*//如果车辆档案id为空则新建一个车辆档案并将车牌号码添加进去
			if(repair.getVehicleId() == null){
				VehicleArchives vehicleArchives = new VehicleArchives();
				vehicleArchives.setVehicle_number(repair.getVehicle_number());
				//添加车辆档案
				vehicleArchivesDao.insert(vehicleArchives);
				//获取车辆档案id
				Long id2 = vehicleArchives.getId();
				//添加车辆档案id
				repair.setVehicleId(id2);
			}*/
			//没有车辆档案不允许添加工单
			if(repair.getVehicleId() == null){
				return JsonUtil.getResponseJson(-1, "请先行添加车辆档案", null,null );
			}
			
			
			
			//保存工单
			int result = repairDao.insert(repair);
			Long id = repair.getId();
			// 同时往维修单添加一条
			/*
			 * RepairProject record = new RepairProject();
			 * record.setRepair_id(id); record.setCreate_time(new Date() );
			 * repairProjectDao.insertSelective(record);
			 */

			if (result >= 1) {
				RepairId repairId = new RepairId();
				repairId.setRepair_id(id);
				return JsonUtil.getResponseJson(1, "添加成功", null,repairId );
			} else {
				return JsonUtil.getResponseJson(1, "添加失败", null, null);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}

	}

	@Override
	public String deleteByPrimaryKey(Long id) {

		try {

			int result = repairDao.deleteByPrimaryKey(id);
			if (result >= 1) {
				return JsonUtil.getResponseJson(1, "删除成功", null, null);
			} else {
				return JsonUtil.getResponseJson(1, "删除失败", null, null);
			}

		} catch (Exception e) {
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
	}

	@Override
	public String updateByPrimaryKeySelective(Repair repair) {

		try {

			int result = repairDao.updateByPrimaryKeySelective(repair);
			if (result >= 1) {
				return JsonUtil.getResponseJson(1, "修改成功", null, null);
			} else {
				return JsonUtil.getResponseJson(1, "修改失败", null, null);
			}

		} catch (Exception e) {
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}

	}

	@Override
	public String hybridSelect(RepairSelect repair) {

		SimpleDateFormat sif = new SimpleDateFormat("yyyy-MM-dd");

		try {
			// 先判断有没有属性是""如果有置为null
			Class cls = repair.getClass();
			Field[] fields = cls.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				Field f = fields[i];
				f.setAccessible(true);
				if ("".equals(f.get(repair))) {
					f.set(repair, null);
				}
				// 判断有没有时间属性有将时间格式化
				if (f.getName().contains("Time")) {
					if (!"".equals(f.get(repair)) && null != f.get(repair)) {
						Date date = new Date(Long.parseLong((String) f.get(repair)));
						String format = sif.format(date);
						f.set(repair, format);
					}
				}
			}
			// 根据page limit 计算 分页开始的数据条数star
			Integer star = ((repair.getPage() - 1) * repair.getLimit());
			repair.setStar(star);
			List<RepairShow> result = repairDao.hybridSelect(repair);
			Integer count = repairDao.hybridSelectCount(repair);
			if (result.size() >= 1) {
				return JsonUtil.getResponseJson(1, "查询成功", count, result);
			} else {
				return JsonUtil.getResponseJson(1, "查询失败", count, result);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
	}

	@Override
	public String detailsSelect(Long vehicleId, Long repair_id) {
		try {

			List<RepairDetails> result = repairDao.SelectRepairShow(vehicleId, repair_id);

			if (result.size() >= 1) {
				return JsonUtil.getResponseJson(1, "查询成功", null, result.get(0));
			} else {
				return JsonUtil.getResponseJson(1, "查询失败", null, result.get(0));
			}

		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
	}

	@Override
	public String detailsSelectByVehicleNumber(String vehicleNumber) {
		try {
			Long id = repairDao.selectIdByVehicleNumber(vehicleNumber);
			
			List<RepairDetails> result =repairDao.selectRepairDetailsByVehicleNumber(vehicleNumber);
			/*List<RepairDetails> result = repairDao.SelectRepairShow(id, null);*/

			
			if (result.size() >= 1) {
				//将不需要的属性置为null
				RepairDetails repairDetails = result.get(0);
				repairDetails.setRemark(null);
				repairDetails.setEnter_time(null);
				repairDetails.setAppointment_time(null);
				repairDetails.setClosing_date(null);
				repairDetails.setMoney(null);
				repairDetails.setMakespan_time(null);
				repairDetails.setType(null);
				repairDetails.setEntry_person(null);
				repairDetails.setState(null);
				repairDetails.setSettlement(null);

				return JsonUtil.getResponseJson(1, "查询成功", null, repairDetails);
			} else {
				return JsonUtil.getResponseJson(2, "查询失败", null, null);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}

	}

	

	@Override
	public String selectPartsShow(Long repair_id, Integer page, Integer limit) {
		try {
			Integer star = (page - 1) * limit;
			List<PartsShow> result = repairDao.selectPartsShow(repair_id, star, limit);
			Integer count = repairDao.selectPartsShowCount(repair_id);
			if (result.size() >= 1) {
				return JsonUtil.getResponseJson(1, "查询成功", count, result);
			} else {
				return JsonUtil.getResponseJson(1, "查询失败", count, result);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
	}

	@Override
	public String upadteState(Long id, Integer state) {
		try {
			Repair record = new Repair();
			record.setId(id);
			record.setState(state);
			int result = repairDao.updateByPrimaryKeySelective(record);
			
			if (result >= 1) {
				return JsonUtil.getResponseJson(1, "修改成功", null, null);
			} else {
				return JsonUtil.getResponseJson(1, "修改失败", null, null);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
	}

	@Override
	public String insert(Repair repair, String vehicle_number) {
		System.out.println(repair);
		try {
			repair.setState(0);
			int result = repairDao.insert(repair);

			Long id = repair.getId();
			
			//如果车辆档案id为空则新建一个车辆档案并将车牌号码添加进去
			if(repair.getVehicleId() == null){
				VehicleArchives vehicleArchives = new VehicleArchives();
				vehicleArchives.setVehicle_number(vehicle_number);
				vehicleArchivesDao.insertCarArchives(vehicleArchives);
				Long id2 = vehicleArchives.getId();
				repair.setVehicleId(id2);
			}

			

			if (result >= 1) {
				RepairId repairId = new RepairId();
				repairId.setRepair_id(id);
				return JsonUtil.getResponseJson(1, "添加成功", null,repairId );
			} else {
				return JsonUtil.getResponseJson(1, "添加失败", null, null);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
	}

}
