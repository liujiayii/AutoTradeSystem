package com.autotrade.service;

import com.autotrade.entity.Income;
/**
 * 
 *
 * @ClassName: IncomeService

 * @description 用一句话描述这个类的作用
 *
 * @author lishaozhang
 * @createDate 2019年1月8日
 */
public interface IncomeService {

	String insertIncom(Income income);

	String deleteById(Long id);

	String updateById(Income income);

	String selectByPrimaryKey(Long id);
    /**分页查询所有
     * @param limit 
     * @param page */
	String selectAll(Integer page, Integer limit);
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
 * @param s2 
    * @createDate 2019年1月31日
    */
	String hybridSelect(String department_id, String s, Integer page, Integer limit);
    /**
     * 
    *
     * @Title: selectExpenditureByDepartmentId
    
     * @description 通过部门名称查询
    *
     * @param @param department_id
     * @param @return 
       
     * @return String    
    
     *
     * @author lishaozhang
     * @param limit 
     * @param page 
     * @createDate 2019年2月2日
     */
    String selectIncomeByDepartmentId(String department_id, Integer page, Integer limit);

	

}
