package com.autotrade.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.autotrade.entity.Expenditure;
 /**
  * 
  *
  * @ClassName: ExpenditureDao
 
  * @description 
  *
  * @author lishaozhang
  * @createDate 2019年1月7日
  */
public interface ExpenditureDao {
	/**插入*/
	Integer insert(Expenditure expenditure);
	/**根据id删除*/
	Integer deleteByPrimaryKey(Long id);
	/**修改若参数为空则置换为null*/
	Integer updateByPrimaryKey(Expenditure expenditure);
	/**修改若参数为空则不变*/
	Integer updateByPrimaryKeySelective(Expenditure expenditure);
	/**分页查询所有*/
	List<Expenditure> selectAllExpenditure(@Param("star")Integer star,@Param("limit")Integer limit);
	/**所有数据数量*/
	Integer selectAllExpenditureCount();
	/**根据主键查询*/
	Expenditure selectByPrimaryKey(Long id);
	/**根据部门id分页查询*/
	List<Expenditure> selectExpenditureByDepartmentId(@Param("departmentId") String department_id, @Param("star")Integer star,@Param("limit")Integer limit);
	/**根据部门id查询数据数量*/
	Integer selectExpenditureCountByDepartmentId(String id);
	/**根据支出项目模糊查询*/
	List<Expenditure> selectExpenditureByExpenditure(@Param("expenditure") String expenditure,
			@Param("star") Integer star, @Param("limit") Integer limit);
	/**根据支出项目模糊查询数据数量*/
	Integer selectExpenditureByExpenditureCount(String expenditure);
	/**混合查询
	 * @param department_id */
	List<Expenditure> hybridSelect(@Param("department_id")String department_id,@Param("s")String s, @Param("star") Integer star,@Param("limit") Integer limit);
	/**混合查询数量*/
	Integer hybridSelectCount(@Param("department_id")String department_id,@Param("s")String s);
}
