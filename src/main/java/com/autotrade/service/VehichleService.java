package com.autotrade.service;

import com.autotrade.entity.Vehichle;

public interface VehichleService {

	String insert(Vehichle vehichle);

	String deleteByPrimaryKey(Long id);

	String deleteByBrand(String brand);

	String updateByPrimaryKey(Vehichle vehichle);

	String selectByPrimaryKey(Long id);

	String selectAll(Integer star, Integer limit);

	String hybridSelect(String s, Integer page, Integer limit);

}
