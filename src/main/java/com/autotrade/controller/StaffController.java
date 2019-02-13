package com.autotrade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.autotrade.entity.Staff;
import com.autotrade.service.StaffService;

/**
 * 
 *
 * @ClassName: StaffController

 * @description 员工控制器
 *
 * @author lishaozhang
 * @createDate 2019年2月13日
 */
@Controller
@RequestMapping("staff")
public class StaffController {
	@Autowired
	private StaffService staffService;
	/**
	 * 
	*
	 * @Title: insert
	
	 * @description 添加用户
	*
	 * @param @param staff
	 * @param @return 
	   
	 * @return String    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年2月13日
	 */
	@RequestMapping("insert")
	@ResponseBody
	public String insert(@RequestBody Staff staff){
		
		return staffService.insert(staff);
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
	 * @createDate 2019年2月13日
	 */
	@RequestMapping("delete")
	@ResponseBody
	public String deleteByPrimaryKey(Long id ){
		
		return staffService.deleteByPrimaryKey(id);
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
	 * @createDate 2019年2月13日
	 */
	@RequestMapping("selectAll")
	@ResponseBody
	public String selectAll(Integer page,Integer limit){
		return staffService.selectAll(page,limit);
	}
	/**
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
	 * @createDate 2019年2月13日
	 */
	@RequestMapping("selectById")
	@ResponseBody
	public String selectById(Long id){
		
		return staffService.selectById(id);
	}
	/**
	 * 
	*
	 * @Title: hybridSelect
	
	 * @description 
	*
	 * @param @param s
	 * @param @param page
	 * @param @param limit
	 * @param @return 
	   
	 * @return String    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年2月13日
	 */
	@RequestMapping("hybridSelect")
	@ResponseBody
	public String hybridSelect(String s, Integer page, Integer limit){
		
		return staffService.hybridSelect(s,page,limit);
	}
	
	/**
	 * 
	*
	 * @Title: update
	
	 * @description 修改
	*
	 * @param @param staff
	 * @param @return 
	   
	 * @return String    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年2月13日
	 */
	@RequestMapping("update")
	@ResponseBody
	public String update(@RequestBody Staff staff){
		
		return staffService.update(staff);
	}
}
