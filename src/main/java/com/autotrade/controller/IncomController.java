package com.autotrade.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.autotrade.entity.Income;
import com.autotrade.service.IncomeService;

@Controller
@RequestMapping("Incom")
public class IncomController {

	@Autowired
	private IncomeService incomeService;

	/***
	 * 
	 *
	 * @Title: insert
	 * 
	 * @description 添加收入数据
	 *
	 * @param @param
	 *            income
	 * @param @return
	 * 
	 * @return String
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年1月8日
	 */
	@RequestMapping("insertIncom")
	@ResponseBody
	public String insert(@RequestBody Income income) {
		String reulst = incomeService.insertIncom(income);
		return reulst;

	}

	/***
	 * 
	 *
	 * @Title: deleteById
	 * 
	 * @description 删除
	 *
	 * @param @param
	 *            id
	 * @param @return
	 * 
	 * @return String
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年1月8日
	 */
	@RequestMapping("deleteById")
	@ResponseBody
	public String deleteById(Long id) {
		String reulst = incomeService.deleteById(id);
		return reulst;

	}

	/**
	 * 
	 *
	 * @Title: updateById
	 * 
	 * @description
	 *
	 * @param @param
	 *            id
	 * @param @return
	 * 
	 * @return String
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年1月8日
	 */
	@RequestMapping("updateById")
	@ResponseBody
	public String updateById(@RequestBody Income income) {
		String reulst = incomeService.updateById(income);
		return reulst;

	}

	/**
	 * 
	 *
	 * @Title: selectByPrimaryKey
	 * 
	 * @description 根据id查询单条数据
	 *
	 * @param @param
	 *            id
	 * @param @return
	 * 
	 * @return String
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年1月8日
	 */
	@RequestMapping("selectByPrimaryKey")
	@ResponseBody
	public String selectByPrimaryKey(Long id) {
		String reulst = incomeService.selectByPrimaryKey(id);
		return reulst;

	}
	/**
	 * 
	*
	 * @Title: selectExpenditureByDepartmentId
	
	 * @description 根据部门名称查询
	*
	 * @param @param department_id
	 * @param @param page
	 * @param @param limit
	 * @param @return 
	   
	 * @return String    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年2月2日
	 */
	@RequestMapping("selectIncomByDepartmentId")
	@ResponseBody
	public String selectExpenditureByDepartmentId(String department_id,Integer page, Integer limit) {
		String reulst = incomeService.selectIncomeByDepartmentId(department_id,page,limit);
		return reulst;

	}

	/**
	 * 
	 *
	 * @Title: selectAll
	 * 
	 * @description
	 *
	 * @param @param
	 * @param @return
	 * 
	 * @return String
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年1月8日
	 */
	@RequestMapping("selectAll")
	@ResponseBody
	public String selectAll(Integer page, Integer limit) {
		String reulst = incomeService.selectAll(page,limit);
		return reulst;

	}
	/**
	 * 
	*
	 * @Title: hybridSelect
	
	 * @description 混合查询
	*
	 * @param @param s
	 * @param @param page
	 * @param @param limit
	 * @param @return 
	   
	 * @return String    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年1月31日
	 */
	@RequestMapping("hybridSelect")
	@ResponseBody
	public String hybridSelect(String department_id, String s, Integer page, Integer limit) {
		
		return incomeService.hybridSelect(department_id,s,page,limit);

	}

}
