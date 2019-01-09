package com.autotrade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public String insert(Income income) {
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
	public String updateById(Income income) {
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
	public String selectAll() {
		String reulst = incomeService.selectAll();
		return reulst;

	}

}
