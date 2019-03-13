package com.autotrade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.autotrade.dao.PostDao;
import com.autotrade.entity.Department;
import com.autotrade.entity.Post;
import com.autotrade.service.DepartmentService;
import com.autotrade.utils.JsonUtil;

@Controller
@RequestMapping("department")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private PostDao postDao;
	
	
	@RequestMapping("selectAllPost")
	@ResponseBody
	public String selectAllPost(){
		List<Post> selectAllPost = postDao.selectAllPost();
		return JsonUtil.getResponseJson(1, "查询成功", selectAllPost.size(), selectAllPost);
		
	}
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
