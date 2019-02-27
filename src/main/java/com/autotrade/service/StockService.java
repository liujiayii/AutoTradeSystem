package com.autotrade.service;

import java.util.List;

import com.autotrade.entity.Stock;
import com.autotrade.entityVo.StockVo;

public interface StockService {
	
	 int insertSelective(Stock record);

	    List<StockVo> selectByPrimaryKey(Integer page, Integer limit);
	    int updateByPrimaryKeySelective(Stock record);
	    Stock selectById(String commodity_number);
	    Integer getcount();

}
