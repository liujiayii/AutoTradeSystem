package com.autotrade.service;


import com.autotrade.entity.CustomerArchives;

public interface CustomerArchivesService {

	Integer insertCustomerArchives(CustomerArchives customerArchives);
	
	String findLast();
	
	String findByLimit(Integer page,Integer limit,String keyWord);
	
	String updateCustomer(CustomerArchives customerArvchives);
	
	String findClientByPhone(String phone);

	String deleteCustomerById(Long id);
}
