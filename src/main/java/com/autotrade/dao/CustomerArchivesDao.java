package com.autotrade.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.autotrade.entity.CustomerArchives;

public interface CustomerArchivesDao {

	
	/**
	  * @Title: insertCustomerArchives
	  * @description 增加维修客户档案
	  * @param @param customerArchives 维修客户实体对象
	  * @return Integer 生效行数   
	  * @author ZhaoSong
	  * @createDate 2019年2月19日
	 */
	Integer insertCustomerArchives(CustomerArchives customerArchives);
	
	
	/**
	  * @Title: findLast
	  * @description 查找最后一条客户编号
	  * @return String 返回最后一条客户编号   
	  * @author ZhaoSong
	  * @createDate 2019年2月20日
	 */
	String findLast();
	
	
	
	/**
	  * @Title: findByLimit
	  * @description 分页查询用户档案信息
	  * @param @param page 页数
	  * @param @param limit 每页显示条数
	  * @return List<CustomerArchives> 返回用户档案信息    
	  * @author ZhaoSong
	  * @createDate 2019年2月25日
	 */
	List<CustomerArchives> findByLimit(@Param("page")Integer page,@Param("limit")Integer limit);
	
	/**
	  * @Title: findAllCustomerCount
	  * @description 查询所有用户档案条数
	  * @return Integer 返回所有用户档案条数   
	  * @author ZhaoSong
	  * @createDate 2019年2月25日
	 */
	Integer findAllCustomerCount();
	
	
	/**
	  * @Title: findLimitByKeyWord
	  * @description 根据关键字分页查询用户档案
	  * @param @param page 页数
	  * @param @param limit 条数
	  * @param @param keyWord 关键字
	  * @return List<CustomerArchives> 返回符合条件的用户档案    
	  * @author ZhaoSong
	  * @createDate 2019年2月25日
	 */
	List<CustomerArchives> findLimitByKeyWord(@Param("page")Integer page,@Param("limit")Integer limit,@Param("keyWord")String keyWord);
	
	
	/**
	  * @Title: findCountByKeyWord
	  * @description 根据关键字查询用户档案条数
	  * @param @param keyWord 关键字
	  * @return Integer 符合关键字条件的用户档案数量   
	  * @author ZhaoSong
	  * @createDate 2019年2月25日
	 */
	Integer findCountByKeyWord(String keyWord);
	
	
	/**
	  * @Title: updateCustomer
	  * @description 修改用户档案信息
	  * @param @param customerArchives 用户档案对象
	  * @return Integer  返回生效行数  
	  * @author ZhaoSong
	  * @createDate 2019年2月25日
	 */
	Integer updateCustomer(CustomerArchives customerArchives);
	
	
	/**
	  * @Title: findClientByPhone
	  * @description 根据电话号码查询用户档案
	  * @param @param phone 电话号码
	  * @return CustomerArchives 用户档案   
	  * @author ZhaoSong
	  * @createDate 2019年2月25日
	 */
	CustomerArchives findClientByPhone(String phone);
	
	
}
