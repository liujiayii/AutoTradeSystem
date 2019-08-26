package com.autotrade.controller;


import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.autotrade.entity.Repair;
import com.autotrade.entityVo.RepairSelect;
import com.autotrade.service.RepairService;

/**
 * 
 *
 * @ClassName: RepairController
 * 
 * @description 工单控制器
 *
 * @author lishaozhang
 * @createDate 2019年2月20日
 */
@RestController
@RequestMapping("Repair")
public class RepairController {
    @Autowired
	private RepairService repairService;
	
    /**
     * 
    *
     * @Title: insert
    
     * @description 添加工单
    *
     * @param @return 
       
     * @return String    
    
     *
     * @author lishaozhang
     * @createDate 2019年2月20日
     */
	@RequestMapping("insert")
	public String insert(@RequestBody Repair repair) {
		if(repair.getMoney()==null || repair.getMoney().equals("")){
			repair.setMoney(new BigDecimal(0));
		}
		//System.out.println(repair);
		return repairService.insert(repair);

	}
	
	/**
	 * 
	*
	 * @Title: deleteByPrimaryKey
	
	 * @description 根据主键删除
	*
	 * @param @param id
	 * @param @return 
	   
	 * @return String    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年2月20日
	 */
	@RequestMapping("deleteByPrimaryKey")
	public String deleteByPrimaryKey(Long id) {

		return repairService.deleteByPrimaryKey(id);

	}
	/**
	 * 
	*
	 * @Title: updateByPrimaryKey
	
	 * @description 根据主键修改没有的属性将不变
	*
	 * @param @param repair
	 * @param @return 
	   
	 * @return String    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年2月20日
	 */
	@RequestMapping("updateByPrimaryKey")
	public String updateByPrimaryKey(@RequestBody Repair repair) {

		return repairService.updateByPrimaryKeySelective(repair);

	}
	
	/***
	 * 
	*
	 * @Title: hybridSelect
	
	 * @description 工单查询功能
	*
	 * @param @param repair
	 * @param @return 
	   
	 * @return String    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年2月20日
	 */
	@RequestMapping("hybridSelect")
	public String hybridSelect(RepairSelect repair) {
		 
		return repairService.hybridSelect(repair);

	}
	/**
	 * 
	*
	 * @Title: detailsSelect
	
	 * @description 工单详细信息查询功能
	*
	 * @param @param repair
	 * @param @return 
	   
	 * @return String    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年2月20日
	 */
	@RequestMapping("detailsSelect")
	public String detailsSelect(Long vehicleId,Long repair_id) {

		return repairService.detailsSelect(vehicleId,repair_id);

	}
	
	/**
	 * 
	*
	 * @Title: detailsSelectByVehicleNumber
	
	 * @description 
	*
	 * @param @param VehicleNumber
	 * @param @return 
	   
	 * @return String    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年2月21日
	 */
	@RequestMapping("detailsSelectByVehicleNumber")
	@ResponseBody
	public String detailsSelectByVehicleNumber(String VehicleNumber) {
		
		String detailsSelectByVehicleNumber = repairService.detailsSelectByVehicleNumber(VehicleNumber);
	
		return detailsSelectByVehicleNumber;
	}
	

/**
 * 
*
 * @Title: selectPartsShow

 * @description 查询工单耗材
*
 * @param @param repair_id
 * @param @param page
 * @param @param limit
 * @param @return 
   
 * @return String    

 *
 * @author lishaozhang
 * @createDate 2019年2月23日
 */
	@RequestMapping("selectPartsShow")
	public String selectPartsShow(Long repair_id, Integer page, Integer limit) {
		
		
		return repairService.selectPartsShow(repair_id,page,limit);
	}
	/**
	 * 
	*
	 * @Title: upadteState
	
	 * @description 改变工单状态
	*
	 * @param @param id
	 * @param @param state
	 * @param @return 
	   
	 * @return String    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年2月25日
	 */
	@RequestMapping("upadteState")
	public String upadteState (Long id, Integer state){
		
		return repairService.upadteState(id,state);
		
	}

}
