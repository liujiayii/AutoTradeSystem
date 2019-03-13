package com.autotrade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autotrade.dao.VehichleClassificationDao;
import com.autotrade.entity.VehicleClassification;
import com.autotrade.service.VehichleClassificationService;
import com.autotrade.utils.JsonUtil;

/**
 * 
 *
 * @ClassName: VehicleClassificationController

 * @description 车型分类
 *
 * @author lishaozhang
 * @createDate 2019年3月7日
 */
@RestController
@RequestMapping("VehicleClassification")
public class VehicleClassificationController {
   
	@Autowired
	private VehichleClassificationDao vehichleClassificationDao;
	
	/**
	 * 
	*
	 * @Title: insert
	
	 * @description 车型添加
	*
	 * @param @param record
	 * @param @return 
	   
	 * @return String    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年3月7日
	 */
	@RequestMapping("insert")
	public String insert(VehicleClassification record){
		try {
	
		 vehichleClassificationDao.insert(record);
		return JsonUtil.getResponseJson(1, "添加成功", null, null);
		} catch (Exception e) {
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
	}
	/**
	 * 
	*
	 * @Title: delete
	
	 * @description 根据id删除
	*
	 * @param @param id
	 * @param @return 
	   
	 * @return String    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年3月7日
	 */
	@RequestMapping("delete")
	public String delete(Long id){
		try {
	
		 vehichleClassificationDao.deleteByPrimaryKey(id);
		return JsonUtil.getResponseJson(1, "删除成功", null, null);
		} catch (Exception e) {
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
	}
	/**
	 * 
	*
	 * @Title: update
	
	 * @description 根据id修改
	*
	 * @param @param record
	 * @param @return 
	   
	 * @return String    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年3月7日
	 */
	@RequestMapping("update")
	public String update(VehicleClassification record){
		try {
	
		 vehichleClassificationDao.updateByPrimaryKey(record);
		return JsonUtil.getResponseJson(1, "修改成功", null, null);
		} catch (Exception e) {
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
	}
	/**
	 * 
	*
	 * @Title: selectByid
	
	 * @description 根据id查询
	*
	 * @param @param id
	 * @param @return 
	   
	 * @return String    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年3月7日
	 */
	@RequestMapping("selectByid")
	public String selectByid(Long id){
		try {
	
		 VehicleClassification selectByPrimaryKey = vehichleClassificationDao.selectByPrimaryKey(id);
		return JsonUtil.getResponseJson(1, "查询成功", 1, selectByPrimaryKey);
		} catch (Exception e) {
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
	}
	
	
	//vehichleClassificationDao
	
	@RequestMapping("selectAll")
	public String selectAll(Integer page, Integer limit){
		try {
	    Integer star =(page - 1 ) * limit;
		 List<VehicleClassification> findCarType = vehichleClassificationDao.selectAll(star,limit);
		 Integer count = vehichleClassificationDao.selectAllCount();
		return JsonUtil.getResponseJson(1, "查询成功", count, findCarType);
		
		} catch (Exception e) {
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
	}
	
}
