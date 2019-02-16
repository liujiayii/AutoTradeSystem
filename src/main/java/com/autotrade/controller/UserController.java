package com.autotrade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.autotrade.entity.User;
import com.autotrade.service.UserService;
import com.autotrade.utils.JsonUtil;

@RequestMapping("/user")
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
	public String updateUser(User user){
		String msg;
		Integer code = userService.updateUser(user);
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
		System.out.println("user :"+user.toString());
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
	
	/**
	  * @Title: findByLimit
	  * @description 分页查询所有用户信息
	  * @param @param page 页数
	  * @param @param limit 每页显示条数
	  * @return String JSON字符串，根据条件查询到的信息
	  * @author ZhaoSong
	  * @createDate 2019年2月11日
	 */
	@RequestMapping(value="/findUserByLimit",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String findByLimit(Integer page , Integer limit){
		if (page <= 0) {
			page = 1;
		}
		page = (page - 1) * limit;
		List<User> users = userService.findByLimit(page, limit);
		try {
			if(users!=null){
				return JsonUtil.getResponseJson(1, "查询成功",userService.findAllCount(), users);
			}else{
				return JsonUtil.getResponseJson(1, "暂无信息", userService.findAllCount(), users);
			}
		} catch (Exception e) {
			return JsonUtil.getResponseJson(-1, "系统异常"+e.getMessage(), null, null);
		}
	}
	
	@RequestMapping("/findById")
	@ResponseBody
	public String findById(Long id){
		User user = userService.findById(id);
		if(user!=null){
			return JsonUtil.getResponseJson(1, "查询成功", null, user);
		}else{
			return JsonUtil.getResponseJson(-1, "查询失败，信息可能被删除", null, null);
		}
	}
	
	
}
