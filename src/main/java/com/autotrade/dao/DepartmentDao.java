package com.autotrade.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.autotrade.entity.Department;
/**
 * 
 *
 * @ClassName: DepartmentDao

 * @description 用一句话描述这个类的作用
 *
 * @author lishaozhang
 * @createDate 2019年1月31日
 */
public interface DepartmentDao {
	/**
	 * 新增部门
	 * */
	Integer insertDepartment(Department department);
	/**
	 * 查询部门id
	 * */
	Integer selectId (String department);
	
	/**
	 * 查询所有
	 * */
	List<Department> selectAllDepartment(@Param("star")Integer star, @Param("limit")Integer limit);
	
	/**
	 * 查询所有数据的数量
	 * */
	Integer getCount();
	
	/**
	 * 删除数据
	 * */
	Integer deleteById(Long id);
}
