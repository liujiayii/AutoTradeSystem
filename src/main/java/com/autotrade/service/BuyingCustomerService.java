package com.autotrade.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.autotrade.entity.BuyingCustomer;
import com.autotrade.entity.SellingCustomer;

/**
 *  买车客户业务层
 *
 * @ClassName: BuyingCustomerService

 * @description 
 *
 * @author xiaoyuchao
 * @createDate 2019年1月7日
 */
public interface BuyingCustomerService {
	/**
	 * 分页查询全部
	 */
	List<BuyingCustomer> selectAll(Integer star,Integer limit);
	/**
	 * 根据主键id查询
	 */
	BuyingCustomer selectById(Long id);
	/**
	 * 根据姓名查询
	 */
	List<BuyingCustomer> selectByName(String name);
	/**
	 * 根据电话查询
	 */
	List<BuyingCustomer> selectByPhone(String phone);
	/**
	 * 根据主键id删除
	 */
	int deleteById(Long id);
	/**
	 * 插入全部字段数据
	 */
	int insertAll(BuyingCustomer buyingCustomer);
	/**
	 * 插入指定字段数据
	 */
	int insertSelective(BuyingCustomer buyingCustomer);
	/**
	 * 修改全部字段
	 */
	int updateAllById(BuyingCustomer buyingCustomer);
	/**
	 * 修改指定字段
	 */
	int updateByIdSelective(BuyingCustomer buyingCustomer);
	/**
	 * 查询总数量
	 */
	int selectAllCount();
	/**
	 * 
	*@author lichangchun
	* @param str
	* @return
	*@return int
	*@date 2019年1月30日    
	*
	 */
	 int selectCountByCustomer(String str);
	/**
	 * 
	*@author lichangchun
	* @param str
	* @param star
	* @param limit
	* @return
	*@return List<BuyingCustomer>
	*@date 2019年1月30日    
	*
	 */
	 List<BuyingCustomer> selectByCustomer(String str,Integer star,Integer limit);
}
