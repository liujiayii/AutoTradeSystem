package com.autotrade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.autotrade.entity.Department;
import com.autotrade.service.DepartmentService;

@Controller
@RequestMapping("department")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	/**
	 * 
	*
	 * @Title: insertDepartment
	
	 * @description 新增部门
	*
	 * @param @param department
	 * @param @return 
	   
	 * @return String    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年1月31日
	 */
	@RequestMapping("insertDepartment")
	@ResponseBody
	public String insertDepartment(String department){
		
		return departmentService.insertDepartment(department);
		
	}
	/**
	 * 
	*
	 * @Title: selectId
	
	 * @description 查询所有
	*
	 * @param @param department
	 * @param @return 
	   
	 * @return String    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年1月31日
	 */
	@RequestMapping("selectAll")
	@ResponseBody
	public String selectAll(Integer page, Integer limit){
		
		return departmentService.selectAll(page,limit);
		
	}
	/**
	 * 
	*
	 * @Title: deleteById
	
	 * @description 
	*
	 *
	 * @param @return 
	   
	 * @return String    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年1月31日
	 */
	@RequestMapping("deleteById")
	@ResponseBody
	public String deleteById(Long id){
		
		return departmentService.deleteById(id);
		
	}

}