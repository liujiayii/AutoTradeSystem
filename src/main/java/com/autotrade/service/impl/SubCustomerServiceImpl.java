package com.autotrade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autotrade.dao.SellingCustomerDao;
import com.autotrade.dao.SubCustomerDao;
import com.autotrade.entity.SubCustomer;
import com.autotrade.service.SubCustomerService;
@Service
public class SubCustomerServiceImpl implements SubCustomerService{
	@Autowired private SubCustomerDao subCustomerDao;
	public List<SubCustomer> selectAll(Integer star, Integer limit) {
		return subCustomerDao.selectAll(star, limit);
	}

	public SubCustomer selectById(Long id) {
		return subCustomerDao.selectById(id);
	}

	public int deleteById(Long id) {
		return subCustomerDao.deleteById(id);
	}

	public int insertAll(SubCustomer subCustomer) {
		return subCustomerDao.insertAll(subCustomer);
	}

	public int insertSelective(SubCustomer subCustomer) {
		return subCustomerDao.insertSelective(subCustomer);
	}

	public int updateAllById(SubCustomer subCustomer) {
		return subCustomerDao.updateAllById(subCustomer);
	}

	public int updateByIdSelective(SubCustomer subCustomer) {
		return subCustomerDao.updateByIdSelective(subCustomer);
	}
	@Override
	public int selectAllCount() {
		return subCustomerDao.selectAllCount();
	}

	@Override
	public int selectCountByCustomer(String str) {
	
		return subCustomerDao.selectCountByCustomer(str);
	}

	@Override
	public List<SubCustomer> selectByCustomer(String str, Integer star, Integer limit) {
		
		return subCustomerDao.selectByCustomer(str, star, limit);
	}

}
