package com.autotrade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autotrade.dao.SellingCustomerDao;
import com.autotrade.entity.SellingCustomer;
import com.autotrade.service.SellingCustomerService;
/**
 * 
  * @ClassName: SellingCustomerServiceImpl
  * @description service实现类
  * @author XiaoYuChao
  * @createDate 2019年1月11日
 */
@Service
public class SellingCustomerServiceImpl implements SellingCustomerService {
	@Autowired private SellingCustomerDao sellingCustomerDao;
	
	public List<SellingCustomer> selectAll(Integer star, Integer limit) {
		return sellingCustomerDao.selectAll(star, limit);
	}

	public SellingCustomer selectById(Long id) {
		return sellingCustomerDao.selectById(id);
	}
	
	public SellingCustomer selectByName(String name) {
		return sellingCustomerDao.selectByName(name);
	}
	
	public List<SellingCustomer> selectByPhone(String phone) {
		return sellingCustomerDao.selectByPhone(phone);
	}
	
	
	public int deleteById(Long id) {
		return sellingCustomerDao.deleteById(id);
	}

	public int insertAll(SellingCustomer sellingCustomer) {
		return sellingCustomerDao.insertAll(sellingCustomer);
	}

	public int insertSelective(SellingCustomer sellingCustomer) {
		return sellingCustomerDao.insertSelective(sellingCustomer);
	}

	public int updateAllById(SellingCustomer sellingCustomer) {
		return sellingCustomerDao.updateAllById(sellingCustomer);
	}

	public int updateByIdSelective(SellingCustomer sellingCustomer) {
		return sellingCustomerDao.updateByIdSelective(sellingCustomer);
	}

	@Override
	public int selectAllCount() {
		return sellingCustomerDao.selectAllCount();
	}

	@Override
	public List<SellingCustomer> selectByCustomer(String str, Integer star, Integer limit) {
		
		return sellingCustomerDao.selectByCustomer(str, star, limit);
	}

	@Override
	public int selectCountByCustomer(String str) {
		
		return sellingCustomerDao.selectCountByCustomer(str);
	}
	
}
