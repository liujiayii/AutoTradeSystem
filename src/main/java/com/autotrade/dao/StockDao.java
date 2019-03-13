package com.autotrade.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.autotrade.entity.Stock;
import com.autotrade.entityVo.StockVo;

public interface StockDao {
   

    
	int updateByPrimaryKeySelective(Stock record);
	
	int updateByPrimaryKeySelectives(Stock record);
    int insertSelective(Stock record);

    List<StockVo> selectByPrimaryKey(@Param("star")Integer star,@Param("limit")Integer limit);
    
    List<StockVo> selectByPrimaryKeys(@Param("s")String s,@Param("star")Integer star,@Param("limit")Integer limit);
    Integer getcount();
    Integer getcounts(String s);
    
    Stock selectById(String commodity_number);

    
}