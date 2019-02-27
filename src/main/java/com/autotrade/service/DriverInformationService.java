package com.autotrade.service;

import com.autotrade.entity.DriverInformation;

public interface DriverInformationService {

	Integer insertDriver(DriverInformation driverInformation);
	
	String findByLimit(Integer page,Integer limit,String keyWord);
	
	String updateDriver(DriverInformation driver);
	
	String findDriverByPhone(String phone);
}
