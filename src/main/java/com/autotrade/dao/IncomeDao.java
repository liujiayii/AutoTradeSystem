package com.autotrade.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.autotrade.entity.Expenditure;
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
    /**查询所有数据
     * @param limit 
     * @param star */
    List<Income> selectAll(@Param("star")Integer star,@Param("limit") Integer limit);
    /**查询所有数据数量*/  
    Integer selectAllCount();
    /**混合查询*/
	List<Income> hybridSelect(@Param("department_id")String department_id,@Param("s")String s,@Param("star") Integer star,@Param("limit") Integer limit);
	 /**混合查询数量*/
	Integer hybridSelectCount(@Param("department_id")String department_id,@Param("s") String s);
	/**根据部门名称查询*/
	List<Expenditure> selectIncomeByDepartmentId(@Param("departmentId")String department_id,@Param("star") Integer star,@Param("limit") Integer limit);
	/**根据部门名称查询数量*/
	Integer selectIncomeCountByDepartmentId(String department_id);
	
}