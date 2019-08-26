package com.autotrade.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.autotrade.dao.StockDao;
import com.autotrade.entity.Purchase;
import com.autotrade.entityVo.PurchaseList;
import com.autotrade.service.PurchaseService;
import com.autotrade.service.StockService;
import com.autotrade.service.ex.ServiceException;
import com.autotrade.utils.JsonUtil;

/**
 * 采购表控制层
 *
 * @ClassName: PurchaseController
 * 
 * @description
 *
 * @author lujinpeng
 * @createDate 2019年2月13日-上午9:31:05
 */
@RestController
@RequestMapping("/purchase")
public class PurchaseController {

	@Autowired
	private PurchaseService purchaseService;
	@Autowired
	private StockService stockService;

	@Autowired
	private StockDao stockDao;

	/**
	 * 分页查询采购表信息
	 *
	 * @Title: showAllPurchase
	 * 
	 * @description
	 *
	 * @param page
	 * @param limit
	 * @return
	 * 
	 *         String
	 *
	 * @author lujinpeng
	 * @createDate 2019年2月13日-上午9:42:32
	 */
	@RequestMapping("/showAllPurchase")
	public String showAllPurchase(Integer page, Integer limit) {
		int code = 1;
		int count = 0;
		String msg = "查询成功";
		List<Purchase> purchaseList = null;

		if (page <= 0 || page == null) {
			page = 1;
		}
		page = (page - 1) * limit;

		Map<String, Object> map = new HashMap<>();
		map.put("page", page);
		map.put("limit", limit);

		try {
			purchaseList = purchaseService.selectAllPurchase(map);
			count = purchaseService.getCount(null);
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "系统异常";
		}

		return JsonUtil.getResponseJson(code, msg, count, purchaseList);
	}

	/**
	 * 搜索接口
	 *
	 * @Title: searchPurchase
	 * 
	 * @description
	 *
	 * @param searchKeyWords
	 * @param page
	 * @param limit
	 * @return
	 * 
	 *         String
	 *
	 * @author lujinpeng
	 * @createDate 2019年2月14日-上午10:02:27
	 */
	@RequestMapping("/searchPurchase")
	public String searchPurchase(String searchKeyWords, Integer page, Integer limit) {
		int code = 1;
		int count = 0;
		String msg = "查询成功";
		List<Purchase> purchaseList = null;

		if (page <= 0 || page == null) {
			page = 1;
		}
		page = (page - 1) * limit;

		Map<String, Object> map = new HashMap<>();
		map.put("s", searchKeyWords);
		map.put("page", page);
		map.put("limit", limit);

		try {
			/*
			 * purchaseList = purchaseService.selectBySelective(map); count =
			 * purchaseService.getCount(map);
			 */
			purchaseList = purchaseService.searchByLike(map);
			count = purchaseService.getCountByLike(map);
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "系统异常";
		}

		return JsonUtil.getResponseJson(code, msg, count, purchaseList);
	}

	/**
	 * 批量新增采购信息
	 *
	 * @Title: insertPurchase
	 * 
	 * @description
	 *
	 * @param purchase
	 * @return String
	 *
	 * @author lujinpeng
	 * @createDate 2019年2月14日-上午10:18:08
	 */
	@RequestMapping("/insertPurchase")
	@ResponseBody
	public Map<String, Object> insertPurchase(String name, BigDecimal purchaseMoney, Date createTime, String[] type,
			String[] brand, String[] purchase, String[] commodityNumber, String[] quantity, String[] priace,
			Integer library, String remark, String singName) {
		// List<Purchase> purchases = purchaseList.getPurchases();
		Map<String, Object> map = new HashMap<>();
		try {
			Integer row = purchaseService.insertSelective(name, purchaseMoney, createTime, type, brand, purchase,
					commodityNumber, quantity, priace, library, remark, singName);
			if (row == 0) {
				map.put("code", 0);
				map.put("msg", "添加失败，请联系管理员");
			}
		} catch (ServiceException e) {

			map.put("code", 0);
			map.put("msg", e.getMessage());
		}

		return map;
	}

	/**
	 * 通过id查询采购表信息
	 *
	 * @Title: selectPurchaseById
	 * 
	 * @description
	 *
	 * @param id
	 * @return String
	 *
	 * @author lujinpeng
	 * @createDate 2019年2月14日-上午10:21:56
	 */
	@RequestMapping("/selectPurchaseById")
	public String selectPurchaseById(String[] id) {
		int code = 1;
		String msg = "查询成功";
		Purchase purchase = null;
		PurchaseList purchases = new PurchaseList();
		List<Purchase> p = new ArrayList<>();
		try {
			if (id != null && !id.equals("")) {

				for (int i = 0; i < id.length; i++) {

					purchase = purchaseService.selectById(Long.parseLong(id[i]));
					purchases.setCreateTime(purchase.getCreateTime());
					purchases.setLibrary(purchase.getLibrary());
					purchases.setName(purchase.getName());
					purchases.setPurchaseMoney(purchase.getPurchaseMoney());
					purchases.setRemark(purchase.getRemark());
					purchases.setSingName(purchase.getSingName());
					p.add(purchase);

				}
				purchases.setPurchases(p);
			}

		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "系统异常";
		}

		return JsonUtil.getResponseJson(code, msg, null, purchases);
	}

	/**
	 * 修改采购表信息
	 *
	 * @Title: updatePurchaseById
	 * 
	 * @description
	 *
	 * @param purchase
	 * @return
	 * 
	 *         String
	 *
	 * @author lujinpeng
	 * @createDate 2019年2月15日-上午10:12:52
	 */
	@RequestMapping("/updatePurchaseById")
	public String updatePurchaseById(Purchase purchase) {
		int code = 1;
		String msg = "更新成功";

		try {
			purchaseService.updateByIdSelective(purchase);
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = e.getMessage();
		}

		return JsonUtil.getResponseJson(code, msg, null, null);
	}

}
