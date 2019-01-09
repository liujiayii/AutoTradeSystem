package com.autotrade.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.autotrade.entity.Popedom;
import com.autotrade.entity.User;
import com.autotrade.service.PopedomService;
import com.autotrade.utils.JsonUtil;

@Controller("/popedom")
public class PopedomController {

	@Autowired
	private PopedomService popedomService;
	
	
	/**
	  * @Title: updatePopedomById
	  * @description 根据用户id修改权限
	  * @param @param id 用户id
	  * @param @param popedoms 权限编号数组
	  * @return String  JSON字符串  
	  * @author ZhaoSong
	  * @createDate 2019年1月9日
	 */
	@RequestMapping("/updatePopedom")
	@ResponseBody
	public String updatePopedomById(Long id, Integer [] popedoms){
		Integer row = popedomService.updatePopedomById(id,popedoms);
		String msg;
		if(row==1){
			msg = "修改权限成功";
			return JsonUtil.getResponseJson(row, msg, null, null);
		}else{
			msg = "修改权限失败";
			return JsonUtil.getResponseJson(row, msg, null, null);
		}
	}
	
	
	/**
	  * @Title: findPopedomByUserId
	  * @description 根据用户id查询所有权限
	  * @param @param id 用户id
	  * @return String  JSON 字符串
	  * @author ZhaoSong
	  * @createDate 2019年1月9日
	 */
	@RequestMapping("/findPopedomByUserId")
	@ResponseBody
	public String findPopedomByUserId(Long id){
		Integer code=1;
		String msg;
		List<Popedom> popedoms = popedomService.findPopedomByUserId(id);
		if(popedoms!=null){
			msg="查询成功";
			return JsonUtil.getResponseJson(code, msg, null, popedoms);
		}else{
			code=-1;
			msg="查询失败";
			return JsonUtil.getResponseJson(null, msg, null, null);
		}
	}
	
	
	/**
	  * @Title: findByLimit
	  * @description 分页查询用户信息
	  * @param @param page 页数
	  * @param @param limit 条数
	  * @return String  JSON字符串  
	  * @author ZhaoSong
	  * @createDate 2019年1月9日
	 */
	@RequestMapping("/findByLimit")
	@ResponseBody
	public String findByLimit(Integer page,Integer limit){
		List<User> users;
		Integer code=1;
		String msg;
		if(page==null||page<=0){
			page=1;
		}
		page=page-1*limit;
		users = popedomService.findByLimit(page,limit);
		try {
			if(users.size()!=0){
				msg="查询成功";
				return JsonUtil.getResponseJson(code, msg,popedomService.findAll().size(), users);
			}else{
				msg="无数据";
				return JsonUtil.getResponseJson(code, msg, popedomService.findAll().size(),users);
			}
		} catch (Exception e) {
			code=-1;
			msg="系统异常";
			return JsonUtil.getResponseJson(code, msg, null, null);
		}
	}
		
	
	/**
	 * @Title: finaUserByPhone
	 * @description 通过电话号码查询用户
	 * @param phone
	 *            用户电话号码
	 * @return String JSON字符串
	 * @author ZhaoSong
	 * @createDate 2019年1月9日
	 */
	@RequestMapping(value = "/findUserByPhone", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String finaUserByPhone(@Param("phone") String phone, @Param("page") Integer page,
			@Param("limit") Integer limit) {
		System.out.println(page);
		int code = 1;
		String msg = null;
		if (phone.equals("") || phone == null) {
			if (page <= 0) {
				page = 1;
			}
			page = (page - 1) * limit;
			List<User> users = popedomService.findByLimit(page, limit);
			if (users.size() <= 0) {
				msg = "查询数据为空";
			}
			if (users != null) {
				msg = "查询成功";
			}
			return JsonUtil.getResponseJson(code, msg, popedomService.findAll().size(), users);
		} else {
			if (page <= 0) {
				page = 1;
			}
			page = (page - 1) * limit;
			String phones = "%" + phone + "%";
			List<User> users = popedomService.findUserByPhone(phones, page, limit);
			System.out.println(users.size());

			if (users.size() <= 0) {
				msg = "查询数据为空";
			}
			if (users != null) {
				msg = "查询成功";
			}
			return JsonUtil.getResponseJson(code, msg, popedomService.findPhoneCount(phones), users);
		}

	}
	
	
}
