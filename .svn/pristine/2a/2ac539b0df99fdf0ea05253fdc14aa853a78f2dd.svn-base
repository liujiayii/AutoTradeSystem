package com.autotrade.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autotrade.dao.UserDao;
import com.autotrade.entity.User;
import com.autotrade.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	public User findUserByUserName(String username) {
		return userDao.findUserByUserName(username);
	}

}
