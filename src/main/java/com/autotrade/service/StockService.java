package com.autotrade.service;

import java.util.List;

import com.autotrade.entity.Stock;
import com.autotrade.entityVo.StockVo;

public interface StockService {

	int insertSelective(Stock record);

	List<StockVo> selectByPrimaryKey(Integer page, Integer limit);

	List<StockVo> selectByPrimaryKeys(String s, Integer page, Integer limit);

	String updateByPrimaryKeySelective(Stock record);

	String updateByPrimaryKeySelectives(Stock record);

	Stock selectById(String commodity_number);

	Integer getcount();

	Integer getcounts(String s);
	 /**
     * 
         * @Title: getStocksLessThree
         * @description 获得库存数量少于三个的商品
         * @param  
         * @return    
         * @author chenshuxian
         * @createDate 2019年7月15日
     */
	List<StockVo> inventoryWarning(Integer page,Integer limit);
	 /**
     * 
         * @Title: getStocksLessThree
         * @description 获得库存数量少于三个的商品的总数量
         * @param  
         * @return    
         * @author chenshuxian
         * @createDate 2019年7月15日
     */
	Integer inventoryWarningCount();
}
