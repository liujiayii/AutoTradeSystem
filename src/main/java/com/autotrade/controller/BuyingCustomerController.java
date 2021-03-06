package com.autotrade.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.autotrade.entity.BuyingCustomer;
import com.autotrade.entity.SellingCustomer;
import com.autotrade.service.BuyingCustomerService;
import com.autotrade.utils.JsonUtil;

/**
 * 
 * @ClassName: BuyingCustomerController
 * @description 买车客户控制器
 * @author XiaoYuChao
 * @createDate 2019年1月11日
 */
@Controller
public class BuyingCustomerController {
	@Autowired
	private BuyingCustomerService buyingCustomerService;

	/**
	 * @Title: selectAll
	 * @description 分页查询全部买车客户
	 * @param @param
	 *            page
	 * @param @param
	 *            limit
	 * @param @return
	 * @return String
	 * @author XiaoYuChao
	 * @createDate 2019年1月11日
	 */
	@RequestMapping(value = "/selectAllBuyingCustomer", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String selectAll(Integer page, Integer limit) {
		String str;
		Integer star = (page - 1) * limit;
		try {
			List<BuyingCustomer> list = buyingCustomerService.selectAll(star, limit);
			if (list.size() >= 1) {
				str = JsonUtil.getResponseJson(1, "查询成功", buyingCustomerService.selectAllCount(), list);
			} else {
				str = JsonUtil.getResponseJson(1, "无数据", null, list);
			}
		} catch (Exception e) {
			e.printStackTrace();
			str = JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
		
		return str;
	}

	/**
	 * @Title: selectById
	 * @description 根据id查询
	 * @param @param
	 *            id
	 * @param @return
	 * @return String
	 * @author XiaoYuChao
	 * @createDate 2019年1月11日
	 */
	@RequestMapping(value = "/selectBuyingCustomerById", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String selectById(Long id) {
	
		String str = null;
		try {
			BuyingCustomer bc = buyingCustomerService.selectById(id);
		
			if (bc != null) {
				str = JsonUtil.getResponseJson(1, "成功", 1, bc);
			} else {
				str = JsonUtil.getResponseJson(1, "无数据", 0, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			str = JsonUtil.getResponseJson(-1, "异常", null, null);
		}
	
		return str;
	}

	/**
	 * 
	 * @Title: selectByName
	 * @description 根据姓名查询
	 * @param @param
	 *            name
	 * @param @return
	 * @return String
	 * @author XiaoYuChao
	 * @createDate 2019年1月11日
	 */
	@RequestMapping("/selectBuyingCustomerByName")
	@ResponseBody
	public String selectByName(String name) {
		String str = null;
		String names = "%" + name + "%";
	
		try {
			List<BuyingCustomer> list = buyingCustomerService.selectByName(names);
			if (list.size() >= 1) {
				str = JsonUtil.getResponseJson(1, "查询成功", list.size(), list);
			} else {
				str = JsonUtil.getResponseJson(1, "暂无数据", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			str = JsonUtil.getResponseJson(-1, "异常", null, null);
		}
	
		return str;
	}

	/**
	 * 
	 * @Title: selectByPhone
	 * @description 根据电话查询
	 * @param @param
	 *            phone
	 * @param @return
	 * @return String
	 * @author XiaoYuChao
	 * @createDate 2019年1月11日
	 */
	@RequestMapping("/selectBuyingCustomerByPhone")
	@ResponseBody
	public String selectByPhone(String phone) {
		String str = null;
		String phones = "%" + phone + "%";
		try {
			List<BuyingCustomer> list = buyingCustomerService.selectByPhone(phones);
			if (list.size() >= 1) {
				str = JsonUtil.getResponseJson(1, "查询成功", list.size(), list);
			} else {
				str = JsonUtil.getResponseJson(1, "暂无数据", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			str = JsonUtil.getResponseJson(-1, "异常", null, null);
		}
	
		return str;
	}

	/**
	 * 
	 * @Title: deleteById
	 * @description 根据id删除
	 * @param @param
	 *            id
	 * @param @return
	 * @return String
	 * @author XiaoYuChao
	 * @createDate 2019年1月11日
	 */
	@RequestMapping("/deleteBuyingCustomerById")
	@ResponseBody
	public String deleteById(Long id) {
		String str = null;
		int rows = 0;
		try {
			rows = buyingCustomerService.deleteById(id);
			if (rows >= 1) {
				str = JsonUtil.getResponseJson(1, "删除成功", null, null);
			} else {
				str = JsonUtil.getResponseJson(1, "没有此条数据", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			str = JsonUtil.getResponseJson(-1, "异常", null, null);
		}
	
		return str;
	}

	/**
	 * 
	 * @Title: insertAll
	 * @description 添加买车客户
	 * @param @param
	 *            bc
	 * @param @return
	 * @return String
	 * @author XiaoYuChao
	 * @createDate 2019年1月11日
	 */
	@RequestMapping("/insertAllBuyingCustomer")
	@ResponseBody
	public String insertAll(@RequestBody BuyingCustomer bc) {
		String str = null;
		int rows = 0;
		

		try {
			
			bc.setCreateTime(new Date());
			rows = buyingCustomerService.insertAll(bc);
			if (rows >= 1) {
				str = JsonUtil.getResponseJson(1, "添加成功", null, null);
			} else {
				str = JsonUtil.getResponseJson(1, "添加失败", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			str = JsonUtil.getResponseJson(-1, "发生异常", null, null);
		}
	
		return str;
	}

	/**
	 * 
	 * @Title: insertSelective
	 * @description 插入部分字段
	 * @param @param
	 *            bc
	 * @param @return
	 * @return String
	 * @author XiaoYuChao
	 * @createDate 2019年1月11日
	 */
	@RequestMapping("/insertBuyingCustomerSelective")
	@ResponseBody
	public String insertSelective(BuyingCustomer bc) {
		String str = null;
		int rows = 0;
		bc = new BuyingCustomer();
		
		bc.setCreateTime(new Date());
		bc.setUpdateTime(new Date());
		try {
			rows = buyingCustomerService.insertSelective(bc);
			if (rows >= 1) {
				str = JsonUtil.getResponseJson(1, "添加成功", 1, bc);
			} else {
				str = JsonUtil.getResponseJson(1, "添加失败", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			str = JsonUtil.getResponseJson(-1, "异常", null, null);
		}
		return str;
	}

	/**
	 * 
	 * @Title: updateAllById
	 * @description 根据id修改
	 * @param @param
	 *            bc
	 * @param @return
	 * @return String
	 * @author XiaoYuChao
	 * @createDate 2019年1月11日
	 */
	@RequestMapping(value = "/updateBuyingCustomerById", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String updateAllById(@RequestBody BuyingCustomer bc) {
		String str = null;
		int rows = 0;

		try {
			rows = buyingCustomerService.updateAllById(bc);
			if (rows >= 1) {
				str = JsonUtil.getResponseJson(1, "修改成功", null, null);
			} else {
				str = JsonUtil.getResponseJson(1, "修改失败", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			str = JsonUtil.getResponseJson(-1, "异常", null, null);
		}
		return str;
	}
	
	@RequestMapping(value = "/selectByBuyingCustomer", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String selectByBuyingCustomer(String s,Integer page, Integer limit){
		
		
		String str = null;
		if (page <= 0 || page == null) {
			page = 1;
		}
		int star = (page - 1) * limit;
		try {
			List<BuyingCustomer> list = buyingCustomerService.selectByCustomer(s, star, limit);
			if (list.size() >= 1) {
				str = JsonUtil.getResponseJson(1, "查询成功", buyingCustomerService.selectCountByCustomer(s), list);
			} else {
				str = JsonUtil.getResponseJson(1, "暂无数据", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			str = JsonUtil.getResponseJson(-1, "异常", null, null);
		}
		return str;
	}
}
