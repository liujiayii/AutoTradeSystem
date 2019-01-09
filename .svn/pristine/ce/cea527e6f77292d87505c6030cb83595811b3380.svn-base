package com.autotrade.service;

import java.util.List;

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
}
