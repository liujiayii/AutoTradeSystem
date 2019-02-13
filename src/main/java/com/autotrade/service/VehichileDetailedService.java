package com.autotrade.service;


import com.autotrade.entity.VehichileDetailed;

public interface VehichileDetailedService {

	String insert(VehichileDetailed vehic);

	String deleteByPrimaryKey(Long id);

	String selectAll(Integer page, Integer limit);

	String update(VehichileDetailed vehic);

	String selectById(Long id);

	String hybridSelect(String s, Integer page, Integer limit);
   
	
}
