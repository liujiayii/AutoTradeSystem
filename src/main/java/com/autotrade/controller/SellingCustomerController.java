package com.autotrade.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	@Autowired private SellingCustomerService sellingCustomerService;
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
	@RequestMapping("/selectAllSellingCustomer")
	@ResponseBody
	public String selectAll(Integer page, Integer limit){
		String str = null;
		int star = (page-1)*limit;
		try {
			List<SellingCustomer> list = sellingCustomerService.selectAll(star, limit);
			if(list.size()>=1){
				str = JsonUtil.getResponseJson(1, "查询成功", list.size(), list);
			}else{
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
	  * @param @param id
	  * @param @return   
	  * @return String    
	  * @author XiaoYuChao
	  * @createDate 2019年1月11日
	 */
	@RequestMapping("/selectSellingCustomerById")
	@ResponseBody
	public String selectById(Long id){
		String str;
		try {
			SellingCustomer sc = sellingCustomerService.selectById(id);
			if(sc!=null){
				str = JsonUtil.getResponseJson(1, "查询成功", 1, sc);
			}else{
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
	  * @param @param name
	  * @param @return   
	  * @return String    
	  * @author XiaoYuChao
	  * @createDate 2019年1月11日
	 */
	@RequestMapping("/selectSellingCustomerByName")
	@ResponseBody
	public String selectByName(String name){
		String str;
		String names = "%"+name+"%";
		try {
			SellingCustomer sc = sellingCustomerService.selectByName(names);
			if(sc!=null){
				str = JsonUtil.getResponseJson(1, "成功", 1, sc);
			}else{
				str = JsonUtil.getResponseJson(1, "无此数据", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			str = JsonUtil.getResponseJson(-1, "异常", null, null);
		}
		return str;
	}
	/**
	 * 
	  * @Title: SelectByPhone
	  * @description 根据电话查询
	  * @param @param phone
	  * @param @return   
	  * @return String    
	  * @author XiaoYuChao
	  * @createDate 2019年1月14日
	 */
	@RequestMapping("/selectSellingCustomerByPhone")
	@ResponseBody
	public String SelectByPhone(String phone){
		String str;
		String phones = "%"+phone+"%";
		try {
			List<SellingCustomer> list =  sellingCustomerService.selectByPhone(phones);
			if(list!=null){
				str = JsonUtil.getResponseJson(1, "查询成功", 1, list);
			}else{
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
	public String deleteById(Long id){
		String str;
		try {
			int rows = sellingCustomerService.deleteById(id);
			if(rows>=1){
				str = JsonUtil.getResponseJson(1, "成功", 1, null);
			}else{
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
	  * @description 添加售车客户
	  * @param @param sc
	  * @param @return   
	  * @return String    
	  * @author XiaoYuChao
	  * @createDate 2019年1月11日
	 */
	@RequestMapping("/insertAllSellingCustomer")
	@ResponseBody
	public String insertAll(SellingCustomer sc){
		String str = null;
		sc = new SellingCustomer();
		sc.setId(11L);
		sc.setName("韩猛");
		sc.setPhone("1583321254");
		sc.setAddress("党家庄");
		sc.setVehicle_type("陆地巡洋舰");
		sc.setBrand("K3");
		sc.setService_life("5");
		sc.setKilometres(10000);
		sc.setMaintenance_record("2018年1.11号");
		sc.setMajor_accidents(0);
		sc.setOffer(80000);
		sc.setCreate_time(new Date());
		sc.setUpdate_time(new Date());
		try {
			int rows = sellingCustomerService.insertAll(sc);
			if(rows>=1){
				str = JsonUtil.getResponseJson(1, "添加成功", rows, sc);
			}else{
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
	  * @param @param sc
	  * @param @return   
	  * @return String    
	  * @author XiaoYuChao
	  * @createDate 2019年1月14日
	 */
	@RequestMapping("/updateSellingCustomerById")
	@ResponseBody
	public String updateSellingCustomerById(SellingCustomer sc){
		String str;
		try {
			sc = sellingCustomerService.selectById(1L);
			System.out.println(sc);
			sc.setName("哈哈哈");
			sc.setAddress("石家庄");
			int rows = sellingCustomerService.updateAllById(sc);
			if(rows>=1){
				str = JsonUtil.getResponseJson(1, "修改成功", 1, sc);
			}else{
				str = JsonUtil.getResponseJson(1, "修改失败", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			str = JsonUtil.getResponseJson(-1, "异常", null, null);
		}
		return str;
	}
}
