package com.autotrade.dao;

import java.util.List;

import com.autotrade.entity.MaintenanceParts;

public interface MaintenancePartsDao {
    int deleteByPrimaryKey(Long id);

    int insert(MaintenanceParts record);

    int insertSelective(MaintenanceParts record);

    MaintenanceParts selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MaintenanceParts record);

    int updateByPrimaryKey(MaintenanceParts record);
    
    List<MaintenanceParts> selectAll();
    
    Integer count();
}