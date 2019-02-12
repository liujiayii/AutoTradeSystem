package com.autotrade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.autotrade.entity.VehichileDetailed;
import com.autotrade.service.VehichileDetailedService;

@Controller
@RequestMapping("VehichileDetailed")
public class VehichileDetailedController {
	
	@Autowired
	private VehichileDetailedService vehichileDetailedService;
	/**
	 * 
	*
	 * @Title: insert
	
	 * @description 添加车型码信息
	*
	 * @param @param vehic
	 * @param @return 
	   
	 * @return String    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年2月12日
	 */
	@RequestMapping("insert")
	@ResponseBody
	public String insert(VehichileDetailed vehic){
		
		return vehichileDetailedService.insert(vehic);
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
	 * @createDate 2019年2月12日
	 */
	@RequestMapping("delete")
	@ResponseBody
	public String deleteByPrimaryKey(Long id ){
		
		return vehichileDetailedService.deleteByPrimaryKey(id);
	}
	/**
	 * 
	*
	 * @Title: deleteByPrimaryKey
	
	 * @description 
	*
	 * @param @param id
	 * @param @return 
	   
	 * @return String    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年2月12日
	 */
	@RequestMapping("selectAll")
	@ResponseBody
	public String selectAll(Integer page,Integer limit){
		
		return vehichileDetailedService.selectAll(page,limit);
	}
	/**
	 * 
	*
	 * @Title: update
	
	 * @description 修改
	*
	 * @param @param vehic
	 * @param @return 
	   
	 * @return String    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年2月12日
	 */
	@RequestMapping("update")
	@ResponseBody
	public String update(VehichileDetailed vehic){
		
		return vehichileDetailedService.update(vehic);
	}
}
