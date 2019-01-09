package com.autotrade.service;

import com.autotrade.entity.User;

public interface UserService {

	public User findUserByUserName(String username);
}
