package com.autotrade.dao;

import java.util.List;

import com.autotrade.entity.VehicleClassification;

public interface VehichleClassificationDao {

	
		/**
		  * @Title: findCarType
		  * @description 查询所有车型
		  * @return List<VehicleClassification> 所有车型信息    
		  * @author ZhaoSong
		  * @createDate 2019年2月20日
		 */
		List<VehicleClassification> findCarType();
}
