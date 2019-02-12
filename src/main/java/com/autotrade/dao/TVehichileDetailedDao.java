package com.autotrade.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.autotrade.entity.TVehichileDetailed;


public interface TVehichileDetailedDao {
   
    int deleteByPrimaryKey(Long id);

    int insert(TVehichileDetailed record);

    int insertSelective(TVehichileDetailed record);

   

    TVehichileDetailed selectByPrimaryKey(Long id);

    
    int updateByPrimaryKeySelective(TVehichileDetailed record);

    int updateByPrimaryKey(TVehichileDetailed record);
}