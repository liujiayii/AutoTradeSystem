package com.autotrade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.autotrade.entity.User;
import com.autotrade.service.UserService;
import com.autotrade.utils.JsonUtil;


@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	  * @Title: updateUser
	  * @description 根据id修改用户信息
	  * @param @param user 用户对象
	  * @param @param id 用户id
	  * @return String  JSON字符串  
	  * @author ZhaoSong
	  * @createDate 2019年1月11日
	 */
	@RequestMapping(value="/updateUser",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String updateUser(Long id ,User user){
		String msg;
		Integer code = userService.updateUser(id,user);
		if(code > 0){
			msg="修改用户信息成功";
			return JsonUtil.getResponseJson(code, msg, null, null);
		}else{
			code=-1;
			msg="修改用户信息失败";
		return JsonUtil.getResponseJson(code, msg, null,null);
		}
	}
	
	
	
	/**
	 * 
	  * @Title: insertUser
	  * @description 添加用户的方法
	  * @param @param user 用户对象信息
	  * @return String   JSON字符串
	  * @author ZhaoSong
	  * @createDate 2019年1月11日
	 */
	@RequestMapping(value="/insertUser",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String insertUser(User user){
		Integer code = 1;
		String msg;
		if(userService.insertUser(user)>0){
			msg= "注册新用户成功";
			return JsonUtil.getResponseJson(code, msg, null, null);
		}else{
			code= -1;
			msg ="注册失败：用户名已存在";
			return JsonUtil.getResponseJson(code, msg, null, null);
		}
		
	}
	
	
	
	
	
	
	
}
