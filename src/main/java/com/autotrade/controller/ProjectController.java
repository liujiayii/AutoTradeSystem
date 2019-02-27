package com.autotrade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.autotrade.entity.BuyingCustomer;
import com.autotrade.entity.MaintenanceMaterials;
import com.autotrade.entity.MaintenanceParts;
import com.autotrade.entity.MaintenanceType;
import com.autotrade.entity.Project;
import com.autotrade.entity.Relation;
import com.autotrade.entity.VehicleClassification;
import com.autotrade.entityVo.ProjectVo;
import com.autotrade.service.MaintenancePartsService;
import com.autotrade.service.MaintenanceTypeService;
import com.autotrade.service.ProjectService;
import com.autotrade.service.VehichleClassificationService;
import com.autotrade.utils.JsonUtil;

/**
 * 维修项目设置工时、材料控制器；
* @ClassName: ProjectController
* @Description: TODO
* @author lichangchun
* @date 2019年2月21日
*
 */
@Controller
@RequestMapping("Project")
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	@Autowired
	private VehichleClassificationService vehichleClassificationService;
	
	@Autowired
	private MaintenancePartsService maintenancePartsService;
	
	@Autowired
	private MaintenanceTypeService maintenanceTypeService;
	
	
	/**
	 * 查询全部的项目
	*@author lichangchun
	* @param page
	* @param limit
	* @return
	*@return String
	*@date 2019年2月21日    
	*
	 */
	@RequestMapping(value = "/selectAll", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String selectAll(Integer page, Integer limit){
		
		return projectService.selectAll(page, limit);
	}
	/**
	 * 查询全部车类
	*@author lichangchun
	* @return
	*@return String
	*@date 2019年2月22日    
	*
	 */
	
	@RequestMapping(value = "/selecttype", produces = "application/json; charset=utf-8")
	@ResponseBody
       public String selecttype(){
          String str;
		
		try {
			List<VehicleClassification> list = vehichleClassificationService.findCarType();
			if (list.size() >= 1) {
				str = JsonUtil.getResponseJson(1, "查询成功", null, list);
			} else {
				str = JsonUtil.getResponseJson(1, "无数据", null, list);
			}
		} catch (Exception e) {
			e.printStackTrace();
			str = JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
		System.out.println("che类型"+str);
		return str;
	}
	/**
	 * 查询全部的客户类型
	*@author lichangchun
	* @return
	*@return String
	*@date 2019年2月26日    
	*
	 */
	@RequestMapping(value = "/selectMaintenance", produces = "application/json; charset=utf-8")
	@ResponseBody
       public String selectMaintenance(){

		return maintenancePartsService.selectAll();
	}
	
	/***
	 * 添加项目
	*@author lichangchun
	* @param project
	* @return
	*@return String
	*@date 2019年2月26日    
	*
	 */
	@RequestMapping(value = "/insertMaintenance", produces = "application/json; charset=utf-8")
	@ResponseBody
	
	public String insertMaintenance(MaintenanceParts maintenanceParts){
		
		return maintenancePartsService.insert(maintenanceParts);
	 
	 
}
	
	
	@RequestMapping(value = "/updateMaintenance", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String updateMaintenance(MaintenanceParts maintenanceParts){
		System.out.println("-*--");
		return maintenancePartsService.update(maintenanceParts);
	}
	/***
	 * 添加项目
	*@author lichangchun
	* @param project
	* @return
	*@return String
	*@date 2019年2月26日    
	*
	 */
	@RequestMapping(value = "/AddMaintenance", produces = "application/json; charset=utf-8")
	@ResponseBody
	
	public String AddMaintenance(Project project){
		System.out.println("project"+project);
		String s;
		
		try {
			int a=projectService.insertAll(project);
			
			if(a>0){
				s = JsonUtil.getResponseJson(1, "添加成功", null, null);
			} else {
				s = JsonUtil.getResponseJson(1, "添加失败", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			s = JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
	 return s;
	 
	 
}

	/**
	 * 查询全部的项目
	*@author lichangchun
	* @param page
	* @param limit
	* @return
	*@return String
	*@date 2019年2月21日    
	*
	 */
	@RequestMapping(value = "/selectAllbytype", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String selectAllbytype(String s,Integer page, Integer limit){
		
		String str;
		Integer star = (page - 1) * limit;
		try {
			
		List<ProjectVo> list=projectService.selectAllbytype(s, star, limit);
		if (list.size() <= 0) {
			System.out.println("shibai");
			str = JsonUtil.getResponseJson(1, "暂无数据", null, null);
		} else {
			System.out.println("chneggong");
			
			// 查询到数据返回总数及当前页数据
			str = JsonUtil.getResponseJson(1, "查询成功", projectService.countAllbytype(s), list);
		}
			
		} catch (Exception e) {
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
		return str;
	}
	
	@RequestMapping(value = "/Addrepair", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String Addrepair(@RequestBody JSONObject obj){
		
		
		return projectService.AddRelation(obj);
	}
	@RequestMapping(value = "/selcectByproject", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String selcectByproject(Long id){
		
		
		return projectService.selcectByproject(id);
	}
	
	@RequestMapping(value = "/selectAllByString", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String selectAllByString(){
		
		
		return maintenanceTypeService.selectAllByString();
	}
	/*@RequestMapping(value = "/insertSelective", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String insertSelective(List<MaintenanceMaterials> record){
		
		
		return maintenanceTypeService.selectAllByString(s);
	}
	*/
	
	@RequestMapping(value = "/insertAll", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String insertAll(ProjectVo projectVo){
		
		Project p=new Project();
		p.setName(projectVo.getName());
		p.setMaintenance_type_id(maintenanceTypeService.selectByName(projectVo.getNames()).getId());
		String str;
		try {
			int a=projectService.insertAll(p);
			
			if(a>=0){
				str = JsonUtil.getResponseJson(1, "添加成功", null, null);
			}else{
				str = JsonUtil.getResponseJson(1, "添加失败", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			str = JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
		return str;
	}
}
