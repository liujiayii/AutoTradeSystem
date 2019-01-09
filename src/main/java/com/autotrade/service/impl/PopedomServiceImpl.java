package com.autotrade.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autotrade.dao.PopedomDao;
import com.autotrade.entity.Popedom;
import com.autotrade.entity.User;
import com.autotrade.entity.UserPopedom;
import com.autotrade.service.PopedomService;

@Service
public class PopedomServiceImpl implements PopedomService{
	
	@Autowired
	private PopedomDao popedomDao;

	private Date date=new Date();
	
	public List<Popedom> findPopedomByUserId(Long id) {
		return popedomDao.findPopedomByUserId(id);
	}

	public Integer deletePopedomById(Long id) {
		return popedomDao.deletePopedomById(id);
	}

	public Integer addPopedomById(UserPopedom userPopedom) {
		return popedomDao.addPopedomById(userPopedom);
	}

	public Integer updatePopedomById(Long id, Integer[] popedoms) {
		Integer row = deletePopedomById(id);
		if(row != 0&& popedoms != null){
			for(Integer popedom:popedoms){
				UserPopedom userPopedom = new UserPopedom();
				userPopedom.setpId(popedom);
				userPopedom.setId(null);
				userPopedom.setUserId(id);
				userPopedom.setUpdateTime(date);
				addPopedomById(userPopedom);
 			}
			return 1;
		}else{
			return -1;
		}
	}

	public List<Popedom> selectAllById(Long id) {
		return  popedomDao.findPopedomByUserId(id);
	}

	public List<User> findByLimit(Integer page, Integer limit) {
		return popedomDao.findByLimit(page,limit);
	}

	public List<User> findAll() {
		List<User> users= popedomDao.findAll();
		if(users.size()==0||users==null){
			return null;
		}
		return users;
	}

	public List<User> findUserByPhone(String phones, Integer page, Integer limit) {
		return popedomDao.findUserByPhone(phones,page,limit);
	}

	public Integer findPhoneCount(String phones) {
		return popedomDao.findPhoneCount(phones);
	}
}
