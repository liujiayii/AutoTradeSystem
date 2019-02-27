package com.autotrade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autotrade.dao.VehichleClassificationDao;
import com.autotrade.entity.VehicleClassification;
import com.autotrade.service.VehichleClassificationService;
@Service
public class VehichleClassificationServiceImpl implements VehichleClassificationService{

	@Autowired
	private VehichleClassificationDao vehichleClassificationDao;
	
	@Override
	public List<VehicleClassification> findCarType() {
		
		return vehichleClassificationDao.findCarType();
	}
	
	

}
