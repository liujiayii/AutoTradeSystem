package com.autotrade.service;

import com.autotrade.entity.Staff;
/***
 * 
 *
 * @ClassName: StaffService

 * @description 员工实现接口
 *
 * @author lishaozhang
 * @createDate 2019年2月13日
 */
public interface StaffService {
    /**
     * 新增
     * */
	String insert(Staff staff);
  /**
   * 
  *
   * @Title: deleteByPrimaryKey
  
   * @description 通过主键删除
  *
   * @param @param id
   * @param @return 
     
   * @return String    
  
   *
   * @author lishaozhang
   * @createDate 2019年2月13日
   */
	String deleteByPrimaryKey(Long id);
	/**
	 * 
	*
	 * @Title: selectAll
	
	 * @description 分页查询
	*
	 * @param @param page
	 * @param @param limit
	 * @param @return 
	   
	 * @return String    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年2月13日
	 */
	String selectAll(Integer page, Integer limit);
    /**
     * 
    *
     * @Title: selectById
    
     * @description 通过主键查询
    *
     * @param @param id
     * @param @return 
       
     * @return String    
    
     *
     * @author lishaozhang
     * @createDate 2019年2月13日
     */
	String selectById(Long id);
    /**
     * 
    *
     * @Title: hybridSelect
    
     * @description 通过姓名 电话 模糊查询你
    *
     * @param @param s
     * @param @param page
     * @param @param limit
     * @param @return 
       
     * @return String    
    
     *
     * @author lishaozhang
     * @createDate 2019年2月13日
     */
	String hybridSelect(String s, Integer page, Integer limit);
    /**
     * 
    *
     * @Title: update
    
     * @description 修改
    *
     * @param @param staff
     * @param @return 
       
     * @return String    
    
     *
     * @author lishaozhang
     * @createDate 2019年2月13日
     */
	String update(Staff staff);

}
