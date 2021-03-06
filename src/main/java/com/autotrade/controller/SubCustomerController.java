package com.autotrade.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.autotrade.entity.SubCustomer;
import com.autotrade.entity.SubCustomer;
import com.autotrade.service.SubCustomerService;
import com.autotrade.utils.JsonUtil;

@Controller
public class SubCustomerController {
	@Autowired 
	private SubCustomerService subCustomerService;
	/**
	 * 
	  * @Title: selectAll
	  * @description 分页查询所有
	  * @param @param page
	  * @param @param limit
	  * @param @return   
	  * @return String    
	  * @author XiaoYuChao
	  * @createDate 2019年1月11日
	 */
	@RequestMapping(value = "/selectAllSubCustomer", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String selectAll(int page,int limit){
		String str;
		int star = (page-1)*limit;
		try {
			List<SubCustomer> list = subCustomerService.selectAll(star, limit);
			if(list.size()>=1){
				str = JsonUtil.getResponseJson(1, "查询成功", subCustomerService.selectAllCount(), list);
					}else{
				str = JsonUtil.getResponseJson(1, "无数据", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			str = JsonUtil.getResponseJson(-1, "异常", null, null);
		}
		return str;
	}
	
	@RequestMapping(value = "/selectBysubCustomer", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String selectBysubCustomer(String s,Integer page, Integer limit){
		
		
		String str = null;
		if (page <= 0 || page == null) {
			page = 1;
		}
		int star = (page - 1) * limit;
		try {
			List<SubCustomer> list = subCustomerService.selectByCustomer(s, star, limit);
			if (list.size() >= 1) {
				str = JsonUtil.getResponseJson(1, "查询成功", subCustomerService.selectCountByCustomer(s), list);
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
	 * @Title: selectById
	 * @description 根据id查询
	 * @param @param
	 *            id
	 * @param @return
	 * @return String
	 * @author XiaoYuChao
	 * @createDate 2019年1月11日
	 */
	@RequestMapping(value = "/selectSubCustomerById", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String selectById(Long id) {
		
		String str = null;
		try {
			SubCustomer bc = subCustomerService.selectById(id);
		
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
	 *//*
	@RequestMapping("/selectSubCustomerByName")
	@ResponseBody
	public String selectByName(String name) {
		String str = null;
		String names = "%" + name + "%";
		System.out.println(names);
		try {
			List<SubCustomer> list = subCustomerService.selectByName(names);
			if (list.size() >= 1) {
				str = JsonUtil.getResponseJson(1, "查询成功", list.size(), list);
			} else {
				str = JsonUtil.getResponseJson(1, "暂无数据", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			str = JsonUtil.getResponseJson(-1, "异常", null, null);
		}
		System.out.println(str);
		return str;
	}

	*//**
	 * 
	 * @Title: selectByPhone
	 * @description 根据电话查询
	 * @param @param
	 *            phone
	 * @param @return
	 * @return String
	 * @author XiaoYuChao
	 * @createDate 2019年1月11日
	 *//*
	@RequestMapping("/selectSubCustomerByPhone")
	@ResponseBody
	public String selectByPhone(String phone) {
		String str = null;
		String phones = "%" + phone + "%";
		try {
			List<SubCustomer> list = subCustomerService.selectByPhone(phones);
			if (list.size() >= 1) {
				str = JsonUtil.getResponseJson(1, "查询成功", list.size(), list);
			} else {
				str = JsonUtil.getResponseJson(1, "暂无数据", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			str = JsonUtil.getResponseJson(-1, "异常", null, null);
		}
		System.out.println(str);
		return str;
	}
*/
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
	@RequestMapping("/deleteSubCustomerById")
	@ResponseBody
	public String deleteById(Long id) {
		String str = null;
		int rows = 0;
		try {
			rows = subCustomerService.deleteById(id);
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
	@RequestMapping("/insertAllSubCustomer")
	@ResponseBody
	public String insertAll(@RequestBody SubCustomer bc) {
		String str = null;
		int rows = 0;
		
		bc.setCreate_time(new Date());
		
		try {
			rows = subCustomerService.insertAll(bc);
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
	@RequestMapping("/insertSubCustomerSelective")
	@ResponseBody
	public String insertSelective(SubCustomer bc) {
		String str = null;
		int rows = 0;
		bc.setCreate_time(new Date());
		try {
			rows = subCustomerService.insertSelective(bc);
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
	@RequestMapping(value = "/updateSubCustomerById", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String updateAllById(@RequestBody SubCustomer bc) {
		String str = null;
		int rows = 0;

		try {
			rows = subCustomerService.updateAllById(bc);
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
	
	
}
