package com.autotrade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.autotrade.entity.SubCustomer;
import com.autotrade.service.SubCustomerService;
import com.autotrade.utils.JsonUtil;

@Controller
public class SubCustmoerController {
	@Autowired private SubCustomerService subCustomerService;
	
	@RequestMapping("/selectAllSubCustmoer")
	@ResponseBody
	public String selectAll(int page,int limit){
		String str;
		int star = (page-1)*limit;
		try {
			List<SubCustomer> list = subCustomerService.selectAll(star, limit);
			if(list.size()>=1){
				str = JsonUtil.getResponseJson(1, "查询成功", list.size(), list);
			}else{
				str = JsonUtil.getResponseJson(-1, "查询失败", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			str = JsonUtil.getResponseJson(-1, "异常", null, null);
		}
		return str;
	}
}
