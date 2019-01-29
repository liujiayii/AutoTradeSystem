package com.autotrade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autotrade.dao.SellCarDao;
import com.autotrade.entity.SellCar;
import com.autotrade.entityVo.SellCarVo;
import com.autotrade.service.SellCarService;

@Service
public class SellCarServiceImpl implements SellCarService{
	
	
	@Autowired
	private SellCarDao sellCarDao;

	@Override
	public List<SellCarVo> findByLimit(Integer page, Integer limit) {
		List<SellCarVo> lists  =   sellCarDao.findByLimit(page, limit);
		if(lists.size()>=0){
			return lists;
		}
		return null;
	}

	@Override
	public Integer findAllCount() {
		Integer count = sellCarDao.findAllCount();
		return count;
	}
	
	
}















