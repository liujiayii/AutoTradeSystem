package com.autotrade.controller;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.autotrade.entity.User;
import com.autotrade.service.UserService;
import com.autotrade.utils.JsonUtil;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping("/toLogin")
	public ModelMap Login(ModelMap map) {
		/** 生成随机数 */
		int number_1 = (int) (Math.random() * 65535) + 1;
		int number_2 = (int) (Math.random() * 65535) + 1;
		String s_rnd = (new Integer(number_1)).toString() + (new Integer(number_2)).toString();
		/** 将生成的随机数赋值给成员变量 */
		String rnd = s_rnd;
		map.addAttribute("rnd", rnd);
		return map;
	}

	/**
	 * @Title: LoginInfo
	 * @description Shiro框架验证登录并授权的方法
	 * @param @param
	 *            username 用户名
	 * @param @param
	 *            password 密码
	 * @param @param
	 *            session Session对象
	 * @return Map<String,Object> 登陆结果
	 * @author ZhaoSong
	 * @createDate 2019年1月3日
	 */
	@RequestMapping(value="/login_handle",method=RequestMethod.POST)
	@ResponseBody
	public String LoginHandle(String username, String password, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("------>获得主体，登录");
		Subject subject = SecurityUtils.getSubject();
		AuthenticationToken usernamePasswordToken = new UsernamePasswordToken(username, password);
		try {
			subject.login(usernamePasswordToken);
			User user = userService.findUserByUserName(username);
			session.setAttribute("user", user);
			map.put("code", 1);
			map.put("msg", "登陆成功:" + user.getUserName());
			System.out.println("登录成功");
		} catch (UnknownAccountException e) {
			map.put("code", -1);
			map.put("msg", "登录失败:" + e.getMessage());
		} catch (LockedAccountException e) {
			map.put("code", -1);
			map.put("msg", "登录失败:" + e.getMessage());
		} catch (IncorrectCredentialsException e) {
			map.put("code", -1);
			map.put("msg", "登录失败:密码错误");
		} catch (Exception e) {
			map.put("code", -1);
			map.put("msg", "登录失败" + e);
		}
		return JsonUtil.getResponseJson(null, null,null, map);
	}

	/**
	 * @Title: logout
	 * @description Shiro登出的方法，删除Session所绑定的数据
	 * @param @param
	 *            session Session对象
	 * @return String 重定向去某个页面
	 * @author ZhaoSong
	 * @createDate 2019年1月3日
	 */
	@RequestMapping("/logout")
	@ResponseBody
	public String logout(HttpSession session) {
		// Shiro登出
		Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated()) {
			System.out.println("清除前" + session.getAttribute("user"));
			session.removeAttribute("user");
			System.out.println("清除后" + session.getAttribute("user"));
			subject.logout();
		}
		return "redirect:toLogin.action";
	}
}
