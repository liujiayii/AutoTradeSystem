package com.autotrade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.autotrade.entity.SellCar;
import com.autotrade.entityVo.SellCarVo;
import com.autotrade.service.SellCarService;
import com.autotrade.utils.JsonUtil;

/**
 * @ClassName: SellCarController
 * @description 售车模块控制器
 * @author ZhaoSong
 * @createDate 2019年1月29日
 */
@Controller
@RequestMapping("/sellCar")
public class SellCarController {

	@Autowired
	private SellCarService sellCarService;

	/**
	 * @Title: findByLimit
	 * @description 分页查询售车信息
	 * @param @param
	 *            page 页数
	 * @param @param
	 *            limit 每页显示的数量
	 * @return String JSON字符串，分页结果信息
	 * @author ZhaoSong
	 * @createDate 2019年1月29日
	 */
	@RequestMapping(value = "/findByLimit", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String findByLimit(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit) {
		if (page <= 0) {
			page = 1;
		}
		page = (page - 1) * limit;
		List<SellCarVo> lists = sellCarService.findByLimit(page, limit);
		System.out.println(lists.toString());
		try {
			if (lists.size() >= 1) {
				return JsonUtil.getResponseJson(1, "查询成功", sellCarService.findAllCount(), lists);
			} else {
				return JsonUtil.getResponseJson(1, "数据为空", sellCarService.findAllCount(), lists);
			}
		} catch (Exception e) {
			return JsonUtil.getResponseJson(-1, "系统异常"+e.getMessage(), null, null);
		}
	}

}
