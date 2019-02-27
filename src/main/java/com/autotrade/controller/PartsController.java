package com.autotrade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autotrade.entity.Parts;
import com.autotrade.service.PartsService;

/**
 * 
 *
 * @ClassName: PartsController

 * @description 领料单控制器
 *
 * @author lishaozhang
 * @createDate 2019年2月22日
 */
@RestController
@RequestMapping("Parts")
public class PartsController {
	
	@Autowired
	private PartsService partsService;
	/**
	 * 
	*
	 * @Title: insert
	
	 * @description 
	*
	 * @param @param parts
	 * @param @return 
	   
	 * @return String    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年2月23日
	 */
	@RequestMapping("insert")
	public String insert (@RequestBody Parts parts){
		
		return partsService.insert(parts);
		
	}
	/**
	 * 
	*
	 * @Title: delete
	
	 * @description 
	*
	 * @param @param id
	 * @param @return 
	   
	 * @return String    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年2月23日
	 */
	@RequestMapping("delete")
	public String delete (Long id){
		
		return partsService.delete(id);
		
	}
	/***
	 * 
	*
	 * @Title: selectAll
	
	 * @description 
	*
	 * @param @param page
	 * @param @param limit
	 * @param @return 
	   
	 * @return String    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年2月23日
	 */
	@RequestMapping("selectAll")
	public String selectAll (Integer page, Integer limit){
		
		return partsService.selectAll(page,limit);
		
	}
	/**
	 * 
	*
	 * @Title: update
	
	 * @description 
	*
	 * @param @param parts
	 * @param @return 
	   
	 * @return String    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年2月23日
	 */
	@RequestMapping("update")
	public String update (@RequestBody Parts parts){
		
		return partsService.update(parts);
		
	}
	/**
	 * 
	*
	 * @Title: selectPartsShow
	
	 * @description 查询某个工单使用的材料
	*
	 * @param @param repair_id
	 * @param @param page
	 * @param @param limit
	 * @param @return 
	   
	 * @return String    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年2月24日
	 */
	@RequestMapping("selectPartsShow")
	public String selectPartsShow (Long repair_id,Integer page, Integer limit){
		
		return partsService.selectPartsShow(repair_id,page,limit);
		
	}
	
	
}
