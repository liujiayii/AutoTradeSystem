package com.autotrade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.autotrade.entity.Expenditure;
import com.autotrade.service.ExpenditureService;

@Controller
@RequestMapping("Expenditure")
public class ExpenditureController {

	@Autowired
	private ExpenditureService expenditureService;

	/**
	 * 
	 *
	 * @Title: insert
	 * 
	 * @description 添加支出记录
	 *
	 * @param @param
	 *            expenditure
	 * @param @return
	 * 
	 * @return String
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年1月7日
	 */
	@RequestMapping("insertExpenditure")
	@ResponseBody
	public String insert(@RequestBody Expenditure expenditure) {

		String result = expenditureService.insertExpenditure(expenditure);
		return result;

	}

	/***
	 * 
	 *
	 * @Title: deleteByPrimaryKey
	 * 
	 * @description 删除支出记录
	 *
	 * @param @param
	 *            id
	 * @param @return
	 * 
	 * @return String
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年1月7日
	 */
	@RequestMapping("deleteByPrimaryKey")
	@ResponseBody
	public String deleteByPrimaryKey(Long id) {

		String result = expenditureService.deleteByPrimaryKey(id);
		return result;

	}

	/***
	 * 
	 *
	 * @Title: updateByPrimaryKey
	 * 
	 * @description 修改支出记录
	 *
	 * @param @param
	 *            expenditure
	 * @param @return
	 * 
	 * @return String
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年1月7日
	 */
	@RequestMapping("updateByPrimaryKey")
	@ResponseBody
	public String updateByPrimaryKey(@RequestBody Expenditure expenditure) {

		String result = expenditureService.updateByPrimaryKey(expenditure);
		return result;

	}

	/**
	 * 
	 *
	 * @Title: selectAllExpenditure
	 * 
	 * @description
	 *
	 * @param @return
	 * 
	 * @return String
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年1月7日
	 */
	@RequestMapping("selectAllExpenditure")
	@ResponseBody
	public String selectAllExpenditure(Integer page, Integer limit) {
		Integer star =(page - 1) * limit;
		String result = expenditureService.selectAllExpenditure(star, limit);
		return result;

	}

	/**
	 * 
	 *
	 * @Title: selectByPrimaryKey
	 * 
	 * @description 根据id查询
	 *
	 * @param @param
	 *            id
	 * @param @return
	 * 
	 * @return String
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年1月7日
	 */
	@RequestMapping("selectByPrimaryKey")
	@ResponseBody
	public String selectByPrimaryKey(Long id) {

		String result = expenditureService.selectByPrimaryKey(id);
		return result;

	}

	/**
	 * 
	 *
	 * @Title: selectExpenditureByDepartmentId
	 * 
	 * @description 根据部门id分页查询
	 *
	 * @param @param
	 *            id
	 * @param @return
	 * 
	 * @return String
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年1月7日
	 */
	@RequestMapping("selectExpenditureByDepartmentId")
	@ResponseBody
	public String selectExpenditureByDepartmentId(String department_id, Integer page, Integer limit) {

		Integer star =(page - 1) * limit;
		String result = expenditureService.selectExpenditureByDepartmentId(department_id, star, limit);
		return result;

	}

	/**
	 * 
	 *
	 * @Title: selectExpenditureByExpenditure
	 * 
	 * @description 根据支出项目名称分页查询
	 *
	 * @param @param
	 *            expenditure
	 * @param @param
	 *            star
	 * @param @param
	 *            limit
	 * @param @return
	 * 
	 * @return String
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年1月7日
	 */
	@RequestMapping("selectExpenditureByExpenditure")
	@ResponseBody
	public String selectExpenditureByExpenditure(String expenditure, Integer page, Integer limit) {
		Integer star =(page - 1) * limit;
		String result = expenditureService.selectExpenditureByExpenditure(expenditure, star, limit);
		return result;

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
		Integer star =(page - 1) * limit;
		String result = expenditureService.hybridSelect(department_id, s, star, limit);
		return result;

	}
	
	

}
