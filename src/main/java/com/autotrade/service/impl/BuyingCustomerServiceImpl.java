package com.autotrade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autotrade.dao.BuyingCustomerDao;
import com.autotrade.entity.BuyingCustomer;
import com.autotrade.service.BuyingCustomerService;
@Service
public class BuyingCustomerServiceImpl implements BuyingCustomerService{
	@Autowired private BuyingCustomerDao buyingCustomerDao;
	public List<BuyingCustomer> selectAll(Integer star, Integer limit) {
		return buyingCustomerDao.selectAll(star, limit);
	}

	public BuyingCustomer selectById(Long id) {
		return buyingCustomerDao.selectById(id);
	}
	public List<BuyingCustomer> selectByName(String name){
		return buyingCustomerDao.selectByName(name);
	}
	
	public List<BuyingCustomer> selectByPhone(String phone) {
		return buyingCustomerDao.selectByPhone(phone);
	}
	
	public int deleteById(Long id) {
		return buyingCustomerDao.deleteById(id);
	}

	public int insertAll(BuyingCustomer buyingCustomer) {
		return buyingCustomerDao.insertAll(buyingCustomer);
	}

	public int insertSelective(BuyingCustomer buyingCustomer) {
		return buyingCustomerDao.insertSelective(buyingCustomer);
	}

	public int updateAllById(BuyingCustomer buyingCustomer) {
		return buyingCustomerDao.updateAllById(buyingCustomer);
	}

	public int updateByIdSelective(BuyingCustomer buyingCustomer) {
		return buyingCustomerDao.updateByIdSelective(buyingCustomer);
	}
	@Override
	public int selectAllCount() {
		return buyingCustomerDao.selectAllCount();
	}

	@Override
	public List<BuyingCustomer> selectByCustomer(String str, Integer star, Integer limit) {
	
		return buyingCustomerDao.selectByCustomer(str, star, limit);
	}

	@Override
	public int selectCountByCustomer(String str) {
		
		return buyingCustomerDao.selectCountByCustomer(str);
	}

	
	
	
	
}
