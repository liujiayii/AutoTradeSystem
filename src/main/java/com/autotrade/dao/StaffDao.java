package com.autotrade.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.autotrade.entity.Staff;
import com.autotrade.entityVo.StaffVo;

/**
 * 
 *
 * @ClassName: StaffDao
 * 
 * @description 员工dao
 *
 * @author lishaozhang
 * @createDate 2019年2月13日
 */
public interface StaffDao {

	/**
	 * 根据主键删除
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * 新增
	 */
	int insert(Staff record);

	/**
	 * 根据主键查询
	 */
	StaffVo selectByPrimaryKey(Long id);

	/**
	 * 根据主键修改
	 */
	int updateByPrimaryKey(Staff record);

	/**
	 * 分页查询
	 */
	List<StaffVo> selectAll(@Param("star") Integer star, @Param("limit") Integer limit);

	/**
	 * 查询总数数量
	 */
	Integer selectAllCount();

	/**
	 * 根据姓名电话模糊查询
	 */
	List<StaffVo> hybridSelect(@Param("s") String s, @Param("star") Integer star, @Param("limit") Integer limit);

	/**
	 * 根据姓名电话模糊查询数量
	 */
	Integer hybridSelectCount(@Param("s") String s);
}