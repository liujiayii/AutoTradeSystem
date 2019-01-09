package com.autotrade.service;

import com.autotrade.entity.Expenditure;

/**
 * 
 *
 * @ClassName: ExpenditureService
 * 
 * @description service
 *
 * @author lishaozhang
 * @createDate 2019年1月7日
 */
public interface ExpenditureService {
	/** 增加 */
	String insertExpenditure(Expenditure expenditure);

	/** 根据id删除 */
	String deleteByPrimaryKey(Long id);

	/** 修改 */
	String updateByPrimaryKey(Expenditure expenditure);

	/**
	 * 分页查询所有
	 * 
	 * @param limit
	 * @param star
	 */
	String selectAllExpenditure(Integer star, Integer limit);

	/**
	 * 
	 *
	 * @Title: selectByPrimaryKey
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
	 * @createDate 2019年1月7日
	 */
	String selectByPrimaryKey(Long id);

	/** 根据部门id分页查询 */
	String selectExpenditureByDepartmentId(Long id, Integer star, Integer limit);

	/** 根据支出项目名称分页查询 */
	String selectExpenditureByExpenditure(String expenditure, Integer star, Integer limit);

}
