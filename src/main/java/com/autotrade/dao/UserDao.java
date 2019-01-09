package com.autotrade.dao;

import com.autotrade.entity.User;

public interface UserDao {

	
	
	/**
	 * @Title: findUserByUserName
	 * @description 根据用户名查询用户
	 * @param @param username 用户名
	 * @return User 返回用户对象   
	 * @author ZhaoSong
	 * @createDate 2019年1月3日
	 */
	User findUserByUserName(String username);
	
	
	/**
	  * @Title: insert
	  * @description 添加用户
	  * @param @param user 参数对象
	  * @return Integer 生效行数   
	  * @author ZhaoSong 
	  * @createDate 2019年1月7日
	 */
	Integer insert(User user);
	
	/**
	  * @Title: updateUserById
	  * @description 通过id修改用户信息
	  * @param @param id 用户id
	  * @return Integer 生效行数   
	  * @author ZhaoSong
	  * @createDate 2019年1月7日
	 */
	Integer updateUserById(Long id);
	
	
	
	
	
	
	
	
	
	
}
