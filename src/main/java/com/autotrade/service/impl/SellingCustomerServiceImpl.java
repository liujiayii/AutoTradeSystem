package com.autotrade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autotrade.dao.SellingCustomerDao;
import com.autotrade.entity.SellingCustomer;
import com.autotrade.service.SellingCustomerService;
@Service
public class SellingCustomerServiceImpl implements SellingCustomerService {
	@Autowired private SellingCustomerDao sellingCustomerDao;
	public List<SellingCustomer> selectAll(Integer star, Integer limit) {
		
		return null;
	}

	public SellingCustomer selectById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertAll(SellingCustomer sellingCustomer) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertSelective(SellingCustomer sellingCustomer) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateAllById(SellingCustomer sellingCustomer) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByIdSelective(SellingCustomer sellingCustomer) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
