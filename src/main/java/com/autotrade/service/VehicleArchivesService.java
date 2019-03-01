package com.autotrade.service;

import com.autotrade.entity.Repair;
import com.autotrade.entity.VehicleArchives;
import com.autotrade.entity.VehicleArchivesVo;

public interface VehicleArchivesService {

	String findByLimit(Integer page,Integer limit,String keyWord);
	
	String findCarArchivesById(Long id);
	
	String updateCarArchives(VehicleArchives vehicleArchives);
	
	String insertCarArchives(VehicleArchives vehicleArchives);
	
	VehicleArchives findVehicleArchivesByVehicleNumber(String vehicle_number);
	
	String closeAnAccount(Long id);
	
	String windUpAnAccount(Repair epair);
}
