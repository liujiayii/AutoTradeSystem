package com.autotrade.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.autotrade.dao.PartsDao;
import com.autotrade.dao.RelationDao;
import com.autotrade.dao.RepairDao;
import com.autotrade.entity.MaintenanceParts;
import com.autotrade.entity.Parts;
import com.autotrade.entity.Relation;
import com.autotrade.entity.Repair;
import com.autotrade.entity.RepairProject;
import com.autotrade.entityVo.RepairProjectVo;
import com.autotrade.service.RepairProjectService;
import com.autotrade.utils.JsonUtil;

/**
 * 维修修理单表控制层
 *
 * @ClassName: RepairProjectController

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年2月21日-上午9:06:37
 */
@RestController
@RequestMapping("/repairProject")
public class RepairProjectController {

	@Autowired
	private RepairProjectService repairProjectService;
	@Autowired
	private RelationDao relationDao;
	/** 工单dao对象 */
	@Autowired
	private RepairDao repairDao;
	@Autowired
	private PartsDao partsDao;
	
	/**
	 * 显示所有工单维修信息
	 *
	 * @Title: showRepairProject
	
	 * @description 
	 *
	 * @param repair_id 工单id
	 * @param page 当前页
	 * @param limit 每页显示条数
	 * @return 
	 * String
	 *
	 * @author lujinpeng
	 * @createDate 2019年2月21日-上午9:17:52
	 */
	@RequestMapping("/showRepairProject")
	public String showRepairProject(Long repair_id, Integer page, Integer limit) {
		int code = 1;
		int count = 0;
		String msg = "查询成功";
		Map<String, Object> map = new HashMap<> ();
		List<RepairProjectVo> repairProjectList = null;
		
		if (page == null || page <= 0) {
			page = 1;
		}
		page = (page - 1) * limit;
		
		map.put("repair_id", repair_id);
		map.put("page", page);
		map.put("limit", limit);
		
		try {
			repairProjectList = repairProjectService.selectDetailsRepairProject(map);
			count = repairProjectService.getCount(map);
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "系统异常";
		}
		
		return JsonUtil.getResponseJson(code, msg, count, repairProjectList);
	}
	
	/**
	 * 修改维修修理单表数据
	 *
	 * @Title: dispatching
	
	 * @description 
	 *
	 * @param repairProject
	 * @return 
	   
	 * String
	 *
	 * @author lujinpeng
	 * @createDate 2019年2月23日-下午5:39:20
	 */
	@RequestMapping("/updateRepairProject")
	public String updateRepairProject(@RequestBody RepairProject repairProject) {
		int code = 1;
		String msg = "查询成功";
		
		try {
			repairProjectService.updateBySelective(repairProject);
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "系统异常";
		}
		
		return JsonUtil.getResponseJson(code, msg, null, null);
	}
	
	/**
	 * 插入指定数据
	 *
	 * @Title: insertSelective
	
	 * @description 
	 *
	 * @param repairProject 
	 * @param phone 维修客户电话
	 * @param project_id 维修项目id
	 * @param vehicle_classification_id 维修车型id
	 * @return 
	 * String
	 *
	 * @author lujinpeng
	 * @createDate 2019年2月23日-下午2:52:57
	 */
	@RequestMapping("/insertSelective")
	public String insertSelective(@RequestBody Map<String, Object> map) {
		System.out.println("map="+map);
		int code = 1;
		String msg = "查询成功";
		BigDecimal totalMoney = null;
		Map<String, Object> newMap = new HashMap<> ();
		RepairProject repairProject = JSON.parseObject(JSONObject.toJSONString(map.get("repairProject")), RepairProject.class);

		try {
			// 获取工单信息
			Repair repair = repairDao.selectByPrimaryKey(repairProject.getRepair_id());
			/**
			 * 如果工单状态>=2(2完工,3结算，4结账)则阻止添加操作
			 * 如果所添加的项目已存在，则阻止添加操作
			 */
			if (repair.getState() >= 2) {
				return JsonUtil.getResponseJson(code, "已完工，禁止添加项目", null, null);
			} else if (repairProjectService.selectBySelective(repairProject).size() > 0) {
				return JsonUtil.getResponseJson(code, "该项目已存在", null, null);
			}
			// 通过维修客户电话查询维修客户类别
			MaintenanceParts maintenanceParts = relationDao.selectMaintenancePartsId(map.get("phone").toString());
			if (maintenanceParts == null) {
				return JsonUtil.getResponseJson(code, "请检查该客户电话是否正确", null, null);
			}
			// 从车型，维修项目、维修类别关联表查询工时和工时单价
			newMap.put("project_id", map.get("project_id"));
			newMap.put("vehicle_classification_id", map.get("vehicle_classification_id"));
			newMap.put("maintenance_parts_id", maintenanceParts.getId());
			Relation relation = relationDao.selectByRelationId(newMap);
			
			if (relation != null) {
				// 设置工时单价
				repairProject.setPrice(relation.getPrice());
				// 设置工时
				repairProject.setWorking_hours(relation.getHouser());
				// 计算总工时费
				totalMoney = (new BigDecimal(relation.getHouser())).multiply(relation.getPrice());
				// 设置总工时费用
				repairProject.setMoney(totalMoney);
			}
			
			// 设置创建时间
			repairProject.setCreate_time(new Date());
			// 将数据插入维修修理单表
			repairProjectService.insertSelective(repairProject);
			
			//获取工单id维修项目名称
			String name = repairProject.getName();
			Long repair_id = repairProject.getRepair_id();
			//获取所有材料的名称
			List<String> selectMNameByProjectName = partsDao.selectMNameByProjectName(name);
			//保存至用料表
			for (String pname : selectMNameByProjectName) {
				Parts parts = new Parts();
				parts.setRepair_id(repair_id);
				parts.setName(pname);
				parts.setCreate_time(new Date());
				partsDao.insert(parts);
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "系统异常";
		}
		
		return JsonUtil.getResponseJson(code, msg, null, null);
	}
	
	
	
}
