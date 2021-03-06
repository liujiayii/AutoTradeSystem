package com.autotrade.service;

import java.util.List;

import com.autotrade.entity.User;

public interface UserService {

	public User findUserByUserName(String username);

	public Integer updateUser( User user);

	public Integer insertUser(User user);
	
	public List<User> findByLimit(Integer page,Integer limit);
	
	public Integer  findAllCount();
	
	public User findById(Long id);
}
