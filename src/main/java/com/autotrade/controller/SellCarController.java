package com.autotrade.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.autotrade.entity.BuyingCustomer;
import com.autotrade.entity.Vehichle;
import com.autotrade.entityVo.SellCarVo;
import com.autotrade.entityVo.ShowCarVo;
import com.autotrade.service.SellCarService;
import com.autotrade.utils.JsonUtil;

/**
 * @ClassName: SellCarController
 * @description 售车模块控制器
 * @author ZhaoSong
 * @createDate 2019年1月29日
 */
@Controller
@RequestMapping("/sellCar")
public class SellCarController {
	
	@Autowired
	private SellCarService sellCarService;
	
	private Date date = new Date();
	/**
	 * @Title: findByLimit
	 * @description 分页查询售车信息
	 * @param @param
	 *            page 页数
	 * @param @param
	 *            limit 每页显示的数量
	 * @return String JSON字符串，分页结果信息
	 * @author ZhaoSong
	 * @createDate 2019年1月29日
	 */
	@RequestMapping(value = "/findByLimit", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String findByLimit(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit) {
		if (page <= 0) {
			page = 1;
		}
		page = (page - 1) * limit;
		List<SellCarVo> lists = sellCarService.findByLimit(page, limit);
		try {
			if (lists.size() >= 1) {
				return JsonUtil.getResponseJson(1, "查询成功", sellCarService.findAllCount(), lists);
			} else {
				return JsonUtil.getResponseJson(1, "数据为空", sellCarService.findAllCount(), lists);
			}
		} catch (Exception e) {
			return JsonUtil.getResponseJson(-1, "系统异常" + e.getMessage(), null, null);
		}
	}

	/**
	 * @Title: findById
	 * @description 通过售车订单Id查询订单信息以及此订单所属用户信息
	 * @param @param
	 *            id 售车订单id
	 * @return String JSON字符串售车订单对象
	 * @author ZhaoSong
	 * @createDate 2019年1月30日
	 */
	@RequestMapping("/findById")
	@ResponseBody
	public String findById(@RequestParam("c_id") Integer id) {
		System.out.println("id"+id);
		ShowCarVo showCarVo = sellCarService.findById(id);
		if (!showCarVo.equals(null)) {
			return JsonUtil.getResponseJson(1, "查询成功", null, showCarVo);
		} else {
			return JsonUtil.getResponseJson(-1, "系统异常,您访问的数据可能被管理员删除", null, null);
		}
	}

	/**
	 * @Title: updateSellCar
	 * @description 修改售车订单，根据id
	 * @param @param
	 *            ShowCarVo 售车订单对象
	 * @return String Json字符串，处理结果
	 * @author ZhaoSong
	 * @createDate 2019年1月30日
	 */
	@RequestMapping("/updateSellCar")
	@ResponseBody
	public String updateSellCar(@RequestBody ShowCarVo showCarVo) {
		
		Integer row = sellCarService.updateSellCar(showCarVo);
		if (row == 1) {
			return JsonUtil.getResponseJson(1, "修改成功", null, null);
		} else {
			return JsonUtil.getResponseJson(-1, "系统异常，联系管理员", null, null);
		}
	}
	
	
	/**
	  * @Title: findByKeyWord
	  * @description 根据关键字分页查询售车订单信息
	  * @param @param keyWord 关键字
	  * @param @param page 页数
	  * @param @param limit 每页显示的条数
	  * @return String  JSON字符串，返回查询结果  
	  * @author ZhaoSong
	  * @createDate 2019年1月30日
	 */
	@RequestMapping(value = "/findByKeyWord", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String findByKeyWord(@RequestParam("keyWord")String keyWord,@RequestParam("page")Integer page,@RequestParam("limit")Integer limit){
		if (page <= 0) {
			page = 1;
		}
		page = (page - 1) * limit;
		keyWord = "%"+keyWord+"%";
		List<SellCarVo> lists = sellCarService.findByKeyWord(keyWord, page, limit);
		try {
			if (lists!=null) {
				return JsonUtil.getResponseJson(1, "查询成功", lists.size(), lists);
			} else {
				return JsonUtil.getResponseJson(1, "没有符合条件的数据", null, null);
			}
		} catch (Exception e) {
			return JsonUtil.getResponseJson(-1, "系统异常" + e.getMessage(), null, null);
		}
			
	}
	
	
	/**
	  * @Title: findClientByPhone
	  * @description 根据买车客户电话查询其信息
	  * @param @param phone 电话号码
	  * @return String JSON字符串，返回符合查询条件的用户
	  * @author ZhaoSong
	  * @createDate 2019年1月30日
	 */
	@RequestMapping("/findClientByPhone")
	@ResponseBody
	public String findClientByPhone(String phone){
		BuyingCustomer buyingCustomer = sellCarService.findClientByPhone(phone);
		if(buyingCustomer!=null){
			return JsonUtil.getResponseJson(1, "查询成功", null, buyingCustomer);
		}
		return JsonUtil.getResponseJson(-1, "请输入正确的电话号码", null, null);
	}
	
	
	
	
	/**
	  * @Title: addSellCar
	  * @description 根据用户所填购车信息增加售车订单表数据
	  * @param @param showCarVo 用户所填数据
	  * @return String   JSON字符串，处理结果
	  * @author ZhaoSong
	  * @createDate 2019年1月31日
	 */
	@RequestMapping("/addSellCar")
	@ResponseBody
	public String addSellCar(@RequestBody ShowCarVo showCarVo){
	
		String json="";
		System.out.println("showCarVo"+showCarVo);
		if( showCarVo.getVehile_number()!="" && showCarVo.getVehile_number()!=null){
			 json = sellCarService.addCarOrder(showCarVo);
		}else{
			json = JsonUtil.getResponseJson(-1, "请检查入库编号", null, null);
		}
		return json;
	}
	
	@RequestMapping("/findCarByNumber")
	@ResponseBody
	public String findCarByNumber(String vehile_number){
		if(vehile_number != null && vehile_number!=""){
		Vehichle vehichle = sellCarService.findCarByNumber(vehile_number);
		if(vehichle!=null&&vehichle.getVehicle_types()==0){
			return JsonUtil.getResponseJson(1, "查询成功", null, vehichle);
		}else{
			return JsonUtil.getResponseJson(-1, "无此库存车辆", null, null);
		}
		}else{
			return JsonUtil.getResponseJson(-1, "请输入有效编号", null, null);
		}
		
	}
	
	
	
	
	
}
