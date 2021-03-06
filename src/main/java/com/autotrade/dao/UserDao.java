package com.autotrade.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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
	  * @param @param user 用户信息对象
	  * @return Integer 生效行数   
	  * @author ZhaoSong
	  * @createDate 2019年1月7日
	 */
	Integer updateUserById(User user);
	
	
	/**
	  * @Title: findByLimit
	  * @description 分页查询所有用户信息
	  * @param @param page 页数
	  * @param @param limit 每页显示条数
	  * @return List<User> 根据条件查询到的用户集合   
	  * @author ZhaoSong
	  * @createDate 2019年2月11日
	 */
	List<User> findByLimit(@Param("page")Integer page ,@Param("limit")Integer limit);
	
	
	/**
	  * @Title: findAllCount
	  * @description 查询所有用户数量
	  * @return Integer 所有用户数量   
	  * @author ZhaoSong
	  * @createDate 2019年2月11日
	 */
	Integer findAllCount();

	/**
	  * @Title: findbyId
	  * @description 根据用户id查询信息
	  * @param @param id 用户id
	  * @return User 返回用户对象   
	  * @author ZhaoSong
	  * @createDate 2019年2月14日
	 */
	User findbyId(Long id);
	
	
}
