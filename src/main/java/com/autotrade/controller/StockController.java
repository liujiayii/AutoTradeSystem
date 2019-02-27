package com.autotrade.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.autotrade.entity.Insurance;
import com.autotrade.entityVo.StockVo;
import com.autotrade.service.StockService;
import com.autotrade.utils.JsonUtil;



@Controller
@RequestMapping("/stock")
public class StockController {
	
	@Autowired
	private StockService stockService;
	
	/**
	 * 显示保险表所有数据
	 *
	 * @Title: showInsurance
	
	 * @description 
	 *
	 * @param page
	 * @param limit
	 * @return String
	 *
	 * @author lujinpeng
	 * @createDate 2019年2月11日-上午11:20:23
	 */
	@RequestMapping("/selectStock")
	@ResponseBody
	public String showInsurance(Integer page, Integer limit) {
		int code = 1;
		int count = 0;
		String msg = "查询成功";
		List<StockVo> insuranceList = null;
		
		if(page <= 0 || page == null){
			page = 1;
		}
		page = (page - 1) * limit;
		
		
		
		try {
			// 查询保险表所有数据
			insuranceList = stockService.selectByPrimaryKey(page, limit);
			// 获取总条数
			count = stockService.getcount();
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "查询失败";
		}
		return JsonUtil.getResponseJson(code, msg, count, insuranceList);
	}
	

}
