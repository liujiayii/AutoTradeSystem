package com.autotrade.service;

import java.util.List;

import com.autotrade.entity.BuyingCustomer;

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
}
