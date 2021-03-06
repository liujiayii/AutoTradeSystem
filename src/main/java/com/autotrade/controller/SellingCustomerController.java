package com.autotrade.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.autotrade.entity.SellingCustomer;
import com.autotrade.service.SellingCustomerService;
import com.autotrade.utils.JsonUtil;

/**
 *
 * @ClassName: SellingCustomerController
 * @description 卖车客户控制层
 * @author XiaoYuChao
 * @createDate 2019年1月11日
 */
@Controller
public class SellingCustomerController {
	@Autowired
	private SellingCustomerService sellingCustomerService;

	/**
	 * 
	 * @Title: selectAll
	 * @description 分页查询所有
	 * @param @param
	 *            page
	 * @param @param
	 *            limit
	 * @param @return
	 * @return String
	 * @author XiaoYuChao
	 * @createDate 2019年1月11日
	 */
	@RequestMapping(value = "/selectAllSellingCustomer", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String selectAll(Integer page, Integer limit) {
		String str = null;
		if (page <= 0 || page == null) {
			page = 1;
		}
		int star = (page - 1) * limit;
		try {
			List<SellingCustomer> list = sellingCustomerService.selectAll(star, limit);
			if (list.size() >= 1) {
				str = JsonUtil.getResponseJson(1, "查询成功", sellingCustomerService.selectAllCount(), list);
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
	 * @Title: selectById
	 * @description 根据id查询
	 * @param @param
	 *            id
	 * @param @return
	 * @return String
	 * @author XiaoYuChao
	 * @createDate 2019年1月11日
	 */
	@RequestMapping(value = "/selectSellingCustomerById", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String selectById(Long id) {
		String str;
		try {
			SellingCustomer sc = sellingCustomerService.selectById(id);
			if (sc != null) {
				str = JsonUtil.getResponseJson(1, "查询成功", 1, sc);
			} else {
				str = JsonUtil.getResponseJson(1, "无此条数据", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			str = JsonUtil.getResponseJson(-1, "失败", null, null);
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
	@RequestMapping("/selectSellingCustomerByName")
	@ResponseBody
	public String selectByName(String name) {
		String str;
		String names = "%" + name + "%";
		try {
			SellingCustomer sc = sellingCustomerService.selectByName(names);
			if (sc != null) {
				str = JsonUtil.getResponseJson(1, "成功", 1, sc);
			} else {
				str = JsonUtil.getResponseJson(1, "无此数据", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			str = JsonUtil.getResponseJson(-1, "异常", null, null);
		}
		return str;
	}

	/**
	 * @Title: SelectByPhone
	 * @description 根据电话查询
	 * @param @param
	 *            phone
	 * @param @return
	 * @return String
	 * @author XiaoYuChao
	 * @createDate 2019年1月14日
	 */
	@RequestMapping(value = "/selectSellingCustomerByPhone", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String SelectByPhone(String phone) {
		String str;
		String phones = "%" + phone + "%";
		try {
			List<SellingCustomer> list = sellingCustomerService.selectByPhone(phones);
			if (list.size() != 0 && list != null) {
				str = JsonUtil.getResponseJson(1, "查询成功", 1, list);
			} else {
				str = JsonUtil.getResponseJson(1, "没有数据", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			str = JsonUtil.getResponseJson(-1, "异常", null, null);
		}
		return str;
	}

	@RequestMapping("/deleteSellingCustomerById")
	@ResponseBody
	public String deleteById(Long id) {
		String str;
		try {
			int rows = sellingCustomerService.deleteById(id);
			if (rows >= 1) {
				str = JsonUtil.getResponseJson(1, "成功", 1, null);
			} else {
				str = JsonUtil.getResponseJson(1, "要删除的数据不存在", null, null);
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
	 * @description 添加卖车客户
	 * @param @param
	 *            sc
	 * @param @return
	 * @return String
	 * @author XiaoYuChao
	 * @createDate 2019年1月11日
	 */
	@RequestMapping("/insertAllSellingCustomer")
	@ResponseBody
	public String insertAll(@RequestBody SellingCustomer sc) {
		
		String str = null;
		sc.setCreate_time(new Date());
		sc.setUpdate_time(new Date());
		try {
			int rows = sellingCustomerService.insertAll(sc);
			if (rows >= 1) {
				str = JsonUtil.getResponseJson(1, "添加成功", rows, sc);
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
	 * @Title: updateSellingCustomerById
	 * @description 根据id修改
	 * @param @param
	 *            sc
	 * @param @return
	 * @return String
	 * @author XiaoYuChao
	 * @createDate 2019年1月14日
	 */
	@RequestMapping(value = "/updateSellingCustomerById", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String updateSellingCustomerById(@RequestBody SellingCustomer sc) {
	
		String str;
		try {

			int rows = sellingCustomerService.updateAllById(sc);
			if (rows >= 1) {
				str = JsonUtil.getResponseJson(1, "修改成功", 1, sc);
			} else {
				str = JsonUtil.getResponseJson(1, "修改失败", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			str = JsonUtil.getResponseJson(-1, "异常", null, null);
		}
		return str;
	}

	@RequestMapping(value = "/selectByCustomer", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String selectByCustomer(String s, Integer page, Integer limit) {

		String str = null;
		if (page <= 0 || page == null) {
			page = 1;
		}
		int star = (page - 1) * limit;
		try {
		
			List<SellingCustomer> list = sellingCustomerService.selectByCustomer(s, star, limit);
		
			if (list.size() >= 1) {
				str = JsonUtil.getResponseJson(1, "查询成功", sellingCustomerService.selectCountByCustomer(s), list);
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
