package com.autotrade.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autotrade.dao.UserDao;
import com.autotrade.entity.User;
import com.autotrade.service.UserService;
import com.autotrade.utils.Md5Util;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	public User findUserByUserName(String username) {
		return userDao.findUserByUserName(username);
	}
	
	@Override
	public Integer updateUser(Long id, User user) {
		if(userDao.updateUserById(id, user)>0){
			return 1;
		}else{
			return -1;
		}
		
	}

	@Override
	public Integer insertUser(User user) {
		Date date = new Date();
		Integer row=-1;
		//判断次用户名是否可用
		if(findUserByUserName(user.getUserName())==null){//次用户名可用
			//对应Shiro框架密码加密，将密码进行加密
			String passWord=Md5Util.md5(user.getPassWord(), user.getUserName());
			user.setPassWord(passWord);
			user.setCreateTime(date);
			user.setUpdateTime(date);
			row = userDao.insert(user);
		}else{
			return row;
		}
		return row;
	}

	@Override
	public List<User> findByLimit(Integer page, Integer limit) {
		return userDao.findByLimit(page, limit);
	}

	@Override
	public Integer findAllCount() {
		return userDao.findAllCount();
	}

}
