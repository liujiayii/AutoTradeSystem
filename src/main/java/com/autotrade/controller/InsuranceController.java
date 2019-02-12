package com.autotrade.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.autotrade.entity.BuyingCustomer;
import com.autotrade.entity.Insurance;
import com.autotrade.service.BuyingCustomerService;
import com.autotrade.service.InsuranceService;
import com.autotrade.utils.JsonUtil;

/**
 * 保险表控制层
 *
 * @ClassName: InsuranceController

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年2月11日-上午10:38:14
 */
@RestController
@RequestMapping("/insurance")
public class InsuranceController {
	
	// 保险表
	@Autowired
	private InsuranceService insuranceService;
	//买车客户表接口
	@Autowired
	private BuyingCustomerService buyingCustomerService;
	
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
	@RequestMapping("/showInsurance")
	public String showInsurance(Integer page, Integer limit) {
		int code = 1;
		int count = 0;
		String msg = "查询成功";
		List<Insurance> insuranceList = null;
		
		if(page <= 0 || page == null){
			page = 1;
		}
		page = (page - 1) * limit;
		
		Map<String, Object> map = new HashMap<> ();
		map.put("page", page);
		map.put("size", limit);
		
		try {
			// 查询保险表所有数据
			insuranceList = insuranceService.selectInsuranceByLimit(map);
			// 获取总条数
			count = insuranceService.getCount(map);
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "查询失败";
		}
		return JsonUtil.getResponseJson(code, msg, count, insuranceList);
	}
	
	/**
	 * 保险凭证搜索接口
	 *
	 * @Title: searchInsurance
	
	 * @description 
	 *
	 * @param searchField
	 * @param page
	 * @param limit
	 * @return 
	   
	 * String
	 *
	 * @author lujinpeng
	 * @createDate 2019年2月11日-上午11:27:51
	 */
	@RequestMapping("/searchInsurance")
	public String searchInsurance(String searchField, Integer page, Integer limit) {
		int code = 1;
		int count = 0;
		String msg = "查询成功";
		List<Insurance> insuranceList = null;
		
		if(page <= 0 || page == null){
			page = 1;
		}
		page = (page - 1) * limit;
		
		Map<String, Object> map = new HashMap<> ();
		// 判断搜索参数是否为数字 
		if (Pattern.compile("[0-9]{1,11}").matcher(searchField).matches()) {
			map.put("phone", searchField);
		} else {
			map.put("name", searchField);
		}
		map.put("page", page);
		map.put("size", limit);
		
		try {
			// 查询符合条件的数据
			insuranceList = insuranceService.selectInsuranceByLimit(map);
			// 获取总条数
			count = insuranceService.getCount(map);
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "查询失败";
		}
		
		return JsonUtil.getResponseJson(code, msg, count, insuranceList);
	}
	
	/**
	 * 显示保险表信息
	 *
	 * @Title: showDetailsInsurance
	
	 * @description 
	 *
	 * @param id
	 * @return 
	   
	 * String
	 *
	 * @author lujinpeng
	 * @createDate 2019年2月11日-下午2:25:34
	 */
	@RequestMapping("/showDetailsInsurance")
	public String showDetailsInsurance(Long id) {
		int code = 1;
		int count = 0;
		String msg = "查询成功";
		Insurance insurance = null;
		
		try {
			insurance = insuranceService.selectById(id);
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "系统异常";
		}
		
		return JsonUtil.getResponseJson(code, msg, count, insurance);
	}
	
	/**
	 * 显示保险数据对应客户信息 
	 *
	 * @Title: showBuyingCustomer
	
	 * @description 
	 *
	 * @param id
	 * @return String
	 *
	 * @author lujinpeng
	 * @createDate 2019年2月11日-下午2:16:18
	 */
	@RequestMapping("/showBuyingCustomer")
	public String showBuyingCustomer(Long id) {
		int code = 1;
		int count = 0;
		String msg = "查询成功";
		BuyingCustomer buyingCustomer = null;
		
		try {
			buyingCustomer = insuranceService.selectBuyingCustomer(id);
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "系统异常";
		}
		
		return JsonUtil.getResponseJson(code, msg, count, buyingCustomer);
	}
	
	/**
	 * 修改保险表数据
	 *
	 * @Title: updateInsurance
	
	 * @description 
	 *
	 * @param insurance
	 * @return 
	   
	 * String
	 *
	 * @author lujinpeng
	 * @createDate 2019年2月11日-下午4:47:33
	 */
	@RequestMapping("/updateInsurance")
	public String updateInsurance(@RequestBody Insurance insurance) {
		int code = 1;
		String msg = "修改成功";
		
		try {
			insuranceService.updateByIdSelective(insurance);
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "系统异常";
		}
		
		return JsonUtil.getResponseJson(code, msg, null, null);
	}
	
	/**
	 * 保险添加接口
	 *
	 * @Title: insertInsurance
	
	 * @description 
	 *
	 * @param map
	 * @return 
	   
	 * String
	 *
	 * @author lujinpeng
	 * @createDate 2019年2月11日-下午5:00:53
	 */
	@RequestMapping("/insertInsurance")
	public String insertInsurance(@RequestBody Map<String, Object> map) {
		int code = 1;
		String msg = "添加成功";
		Long buyingId = 0L;
		
		try {
			/** 获取买车客户对象 */
			BuyingCustomer buyingCustomer = JSON.parseObject(JSONObject.toJSONString(map.get("buyingCustomer")), BuyingCustomer.class);
			String phone = buyingCustomer.getPhone();
			List<BuyingCustomer> buyingCustomerList = buyingCustomerService.selectByPhone(phone);
			/** 
			 *  判断当前用户是否存在，
			 *  如果不存在，则执行添加操作
			 */
			if (buyingCustomerList.size() == 0) {
				buyingCustomer.setCreateTime(new Date());
				buyingCustomerService.insertSelective(buyingCustomer);
				// 获取添加成功客户的id
				buyingId = buyingCustomerService.selectByPhone(phone).get(0).getId();
			} else {
				buyingId = buyingCustomerList.get(0).getId();
			}
			
			/** 获取保险表对象 */
			Insurance insurance = JSON.parseObject(JSONObject.toJSONString(map.get("insurance")), Insurance.class);
			insurance.setCreateTime(new Date());
			insurance.setBuyingId(buyingId);
			insuranceService.insertSelective(insurance);
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "系统异常";
		}
		
		return JsonUtil.getResponseJson(code, msg, null, null);
	}
	
}
