package com.autotrade.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.RespectBinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autotrade.dao.StockDao;
import com.autotrade.entity.Purchase;
import com.autotrade.entity.Stock;
import com.autotrade.service.PurchaseService;
import com.autotrade.service.StockService;
import com.autotrade.utils.JsonUtil;

/**
 * 采购表控制层
 *
 * @ClassName: PurchaseController

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
	
	 * @description 
	 *
	 * @param page
	 * @param limit
	 * @return 
	   
	 * String
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
	
	 * @description 
	 *
	 * @param searchKeyWords
	 * @param page
	 * @param limit
	 * @return 
	   
	 * String
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
		
		Map<String, Object> map = new HashMap<> ();
		map.put("s", searchKeyWords);
		map.put("page", page);
		map.put("limit", limit);
		
		try {
			/*purchaseList = purchaseService.selectBySelective(map);
			count = purchaseService.getCount(map);*/
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
	 * 新增采购信息
	 *
	 * @Title: insertPurchase
	
	 * @description 
	 *
	 * @param purchase
	 * @return String
	 *
	 * @author lujinpeng
	 * @createDate 2019年2月14日-上午10:18:08
	 */
	@RequestMapping("/insertPurchase")
	public String insertPurchase(@RequestBody Purchase purchase) {
		System.out.println("编号"+purchase);
		int code = 1;
		String msg = "新增成功";
		Stock stock=new Stock();
		stock.setCommodity_number(purchase.getCommodityNumber());
		stock.setNumber(purchase.getQuantity());
		try {
			purchaseService.insertSelective(purchase);
			if(purchase.getLibrary()==null){//后台处理没有选择入库状态抛异常的情况
				
				code = -1;
				msg = "请选择入库状态";
			}else {
			if(purchase.getLibrary()==0){
				
				Stock s=stockService.selectById(purchase.getCommodityNumber());
				
				if(s!=null){
				
					int a=stockDao.updateByPrimaryKeySelective(stock);
				}else{
					int a=stockService.insertSelective(stock);
				}
				
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "系统异常";
		}
		
		return JsonUtil.getResponseJson(code, msg, null, null);
	}
	
	/**
	 * 通过id查询采购表信息
	 *
	 * @Title: selectPurchaseById
	
	 * @description 
	 *
	 * @param id
	 * @return String
	 *
	 * @author lujinpeng
	 * @createDate 2019年2月14日-上午10:21:56
	 */
	@RequestMapping("/selectPurchaseById")
	public String selectPurchaseById(Long id) {
		int code = 1;
		String msg = "查询成功";
		Purchase purchase = null;
		
		try {
			purchase = purchaseService.selectById(id);
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "系统异常";
		}
		
		return JsonUtil.getResponseJson(code, msg, null, purchase);
	}
	
	/**
	 * 修改采购表信息
	 *
	 * @Title: updatePurchaseById
	
	 * @description 
	 *
	 * @param purchase
	 * @return 
	   
	 * String
	 *
	 * @author lujinpeng
	 * @createDate 2019年2月15日-上午10:12:52
	 */
	@RequestMapping("/updatePurchaseById")
	public String updatePurchaseById(@RequestBody Purchase purchase) {
		int code = 1;
		String msg = "更新成功";
		
		try {
			purchaseService.updateByIdSelective(purchase);
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "更新失败";
		}
		
		return JsonUtil.getResponseJson(code, msg, null, null);
	}
	
}
