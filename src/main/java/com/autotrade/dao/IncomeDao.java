package com.autotrade.dao;

import java.util.List;

import com.autotrade.entity.Income;
/**
 * 
 *
 * @ClassName: IncomeDao

 * @description 收入表dao
 *
 * @author lishaozhang
 * @createDate 2019年1月8日
 */

public interface IncomeDao {
    /**插入*/
	Integer insertIncome(Income record);
	/**根据主键删除*/
	Integer deleteById(Long id);  
    /**修改*/
	Integer updateById(Income record);
    /**根据主键查询*/
    Income selectByPrimaryKey(Long id);
    /**查询所有数据*/
    List<Income> selectAll();
    /**查询所有数据数量*/  
    Integer selectAllCount();
}