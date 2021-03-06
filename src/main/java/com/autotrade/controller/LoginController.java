package com.autotrade.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.autotrade.entity.User;
import com.autotrade.service.UserService;
import com.autotrade.utils.JsonUtil;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/toLogin", produces = "application/json; charset=utf-8")
	public ModelAndView Login() {
		ModelAndView model = new ModelAndView();
		/** 生成随机数 */
		int number_1 = (int) (Math.random() * 65535) + 1;
		int number_2 = (int) (Math.random() * 65535) + 1;
		String s_rnd = (new Integer(number_1)).toString() + (new Integer(number_2)).toString();
		/** 将生成的随机数赋值给成员变量 */
		String rnd = s_rnd;
		model.addObject("rnd", rnd);
		model.setViewName("login/login");
		return model;
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
	@RequestMapping(value = "/login_handle", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String LoginHandle(String username, String password, HttpSession session) {
		Integer code = 1;
		String msg;
		User user = null;
		Subject subject = SecurityUtils.getSubject();
		AuthenticationToken usernamePasswordToken = new UsernamePasswordToken(username, password);
		try {
			subject.login(usernamePasswordToken);
			user = userService.findUserByUserName(username);
			session.setAttribute("user", user);
			msg = "登陆成功:" + user.getUserName();
		} catch (UnknownAccountException e) {
			e.printStackTrace();
			code = -1;
			msg = "登录失败:" + e.getMessage();
		} catch (LockedAccountException e) {
			e.printStackTrace();
			code = -1;
			msg = "登录失败:" + e.getMessage();
		} catch (IncorrectCredentialsException e) {
			e.printStackTrace();
			code = -1;
			msg = "登录失败:密码错误";
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "登陆失败:系统异常";
		}
		return JsonUtil.getResponseJson(code, msg, null, user);
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
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		// Shiro登出
		Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated()) {
			session.removeAttribute("user");
			subject.logout();
		}
		return "redirect:./toLogin.action";
	}

	/**
	 * 后台画验证码 ，前端页面显示，并计算结果
	 * 
	 * @param session
	 *            把计算结果result存到session中
	 * @param resp
	 */
	@RequestMapping(value = "/showAuthCode")
	public void showAuthCode(HttpSession session, HttpServletResponse resp, Model model) {

	
		int width = 150; // 宽
		int height = 60; // 高
		int codeCount = 4; // 产生随机的数量
		int x = 0; //
		int fontHeight; // 字体高度
		int codeY;
		// 随机产生的字符
		char[] codeSequence = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		char[] codenumber = { '+', '-' };

		// 显示是x轴的位置
		x = width / (codeCount + 1);
		// 显示字体的高度
		fontHeight = height - 2;
		// y轴的位置
		codeY = height - 4;
		BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = buffImg.createGraphics();
		// 创建一个随机数生成器
		Random r = new Random();
		Color c = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
		g.setColor(c);
		g.fillRect(0, 0, width, height);
		// 创建字体，字体的大小由图片的高度来定
		Font font = new Font("Fixedsys", Font.PLAIN, fontHeight);
		// 设置字体
		g.setFont(font);
		// 随即产生160条干扰线，使图像中的认证码不易被其它程序探测到
		int lines = 10;
		for (int i = 0; i < lines; i++) {
			// 设置干扰线颜色
			Color c1 = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
			g.setColor(c1);
			g.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width), r.nextInt(height));
		}

		// randomCode 用于保存随机产生的验证码，以使用户登录后进行验证
		StringBuffer randomCode = new StringBuffer();
		int red = 0, green = 0, blue = 0;
		// 随机产生codeCount数字的验证码
		// 前一个数字
		String strRnd = String.valueOf(codeSequence[r.nextInt(10)]);
		// 中间的符号
		String s = String.valueOf(codenumber[r.nextInt(2)]);
		// 后面的数字
		String strRndlast = String.valueOf(codeSequence[r.nextInt(10)]);

		String coderesult = "=";
		String strRndwhy = "?";
		if (Integer.parseInt(strRnd) < Integer.parseInt(strRndlast)) {
			String a = strRndlast;
			strRndlast = strRnd;
			strRnd = a;
		}
		// 产生随机的颜色分量来构造颜色值。这样输出的每位数字的颜色值都将不同
		red = r.nextInt(255);
		green = r.nextInt(255);
		blue = r.nextInt(255);
		// 用随机产生的颜色将验证码绘制到图像中
		g.setColor(new Color(red, green, blue));
		g.drawString(strRnd, 1 * x / 3, codeY);
		g.drawString(s, 1 * x + 1, codeY);
		g.drawString(strRndlast, 2 * x, codeY);
		g.drawString(coderesult, 3 * x, codeY);
		g.drawString(strRndwhy, 4 * x, codeY);
		// 将产生的四个随机数组合到一起
		randomCode.append(strRnd);
		randomCode.append(s);
		randomCode.append(strRndlast);

		int start = Integer.parseInt(randomCode.substring(0, 1));
		String cen = randomCode.substring(1, 2);
		int end = Integer.parseInt(randomCode.substring(2, 3));
		int result = 0;
		if (cen.equals("-")) {
			result = start - end;
		

		} else if (cen.equals("+")) {
			result = start + end;
		
		}
		// 不需要计算的
		randomCode.append(coderesult);
		randomCode.append(strRndwhy);

		
		session.setAttribute("validateCode", randomCode.toString());
	
		session.setAttribute("results", result);
		model.addAttribute("results", result);
		ServletOutputStream sos;
		try {
			sos = resp.getOutputStream();
			ImageIO.write(buffImg, "jpg", sos);
			sos.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@RequestMapping("/loginTwo")
	@ResponseBody
	public String loginTwo(HttpSession session, User user, HttpServletRequest request) throws Exception {

		String str;
		// 前端输入的值
		String auth_code = request.getParameter("auth_code").toString();
	
		// 验证码获取的结果值
		String resultNum = (String) session.getAttribute("results").toString();

		if (user != null) {
			if (resultNum.equals(auth_code)) {
				str = JsonUtil.getResponseJson(1, "成功", null, null);
			} else {
				str = JsonUtil.getResponseJson(-1, "验证失败", null, null);
			}
		} else {
			str = JsonUtil.getResponseJson(-1, "验证失败", null, null);
		}
		return str;
	}

}
