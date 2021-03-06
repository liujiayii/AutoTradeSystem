package com.autotrade.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.autotrade.entity.SellingCustomer;

/**
 *  卖车客户业务层
 * @ClassName: BuyingCustomerService
 * @description 
 * @author xiaoyuchao
 * @createDate 2019年1月7日
 */
public interface SellingCustomerService {
	/**
	 * 分页查询全部
	 */
	List<SellingCustomer> selectAll(Integer star,Integer limit);
	/**
	 * 根据主键id查询
	 */
	SellingCustomer selectById(Long id);
	/**
	 * 根据姓名查询
	 */
	SellingCustomer selectByName(String name);
	/**
	 * 根据电话查询
	 */
	List<SellingCustomer> selectByPhone(String phone);
	/**
	 * 根据主键id删除
	 */
	int deleteById(Long id);
	/**
	 * 插入全部字段数据
	 */
	int insertAll(SellingCustomer sellingCustomer);
	/**
	 * 插入指定字段数据
	 */
	int insertSelective(SellingCustomer sellingCustomer);
	/**
	 * 修改全部字段
	 */
	int updateAllById(SellingCustomer sellingCustomer);
	/**
	 * 修改指定字段
	 */
	int updateByIdSelective(SellingCustomer sellingCustomer);
	/**
	 * 查询总数量
	 */
	int selectAllCount();
	/**
	 * 
	*@author lichangchun
	* @param str
	* @param star
	* @param limit
	* @return
	*@return List<SellingCustomer>
	*@date 2019年1月30日    
	*
	 */
	 List<SellingCustomer> selectByCustomer(String str,Integer star,Integer limit);
	 
	  
	  /**
	   * 根据 姓名，电话，地址，车型，车牌，模糊查询总数量
	  *@author lichangchun
	  * @param str
	  * @return
	  *@return int
	  *@date 2019年1月30日    
	  *
	   */
	   int selectCountByCustomer(String str);
}
