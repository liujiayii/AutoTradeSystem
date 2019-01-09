package com.autotrade.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.autotrade.entity.BuyingCustomer;
import com.autotrade.service.BuyingCustomerService;
import com.autotrade.utils.JsonUtil;

@Controller
public class BuyingCustomerController {
	@Autowired private BuyingCustomerService buyingCustomerService;
	int code = 1;
	String msg = "成功";
	@RequestMapping("/selectAll")
	@ResponseBody
	public String selectAll(Integer page, Integer limit) {
		String str = null;
		Integer star = (page-1)*limit;
		try {
			List<BuyingCustomer> list =  buyingCustomerService.selectAll(star, limit);
			if(list.size()>=1){
				str = JsonUtil.getResponseJson(code, msg, list.size(), list);
			}else{
				str = JsonUtil.getResponseJson(code, msg, null, list);
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "失败";
			str = JsonUtil.getResponseJson(code, msg, null, null);
		}
		return str;
	} 
}
