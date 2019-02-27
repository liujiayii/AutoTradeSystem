package com.autotrade.service;




import com.autotrade.entity.ModelDefinition;

public interface ModelDefinitionService {

	
	
	Integer insertModelDefinition(ModelDefinition modelDefinition);
	
	ModelDefinition findByRangeRover(String range_rover);
	
	String findCarTypeByLimit(Integer page,Integer limit,String keyWord);
	
	String updateCarType(ModelDefinition modelDefinition);
	
	String findCarNameByid(Long id);
}
