package com.autotrade.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.autotrade.entity.BuyingCustomer;
import com.autotrade.entity.ByStages;
import com.autotrade.entity.DetailsInstallments;
import com.autotrade.service.BuyingCustomerService;
import com.autotrade.service.ByStagesService;
import com.autotrade.service.DetailsInstallmentsService;
import com.autotrade.utils.JsonUtil;

/**
 * 分期表控制层
 *
 * @ClassName: ByStagesController

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年1月29日-上午11:18:35
 */
@RestController
@RequestMapping("/byStages")
public class ByStagesController {

	//分期表接口
	@Autowired
	private ByStagesService byStagesService;
	//分期详情表接口
	@Autowired
	private DetailsInstallmentsService detailsInstallmentsService;
	//买车客户表接口
	@Autowired
	private BuyingCustomerService buyingCustomerService;
	
	/**
	 * 显示分期管理页数据
	 *
	 * @Title: showByStages
	
	 * @description 
	 *
	 * @param page 当前页
	 * @param size 每页显示条数
	 * @return String
	 *
	 * @author lujinpeng
	 * @createDate 2019年1月29日-上午11:33:15
	 */
	@RequestMapping("/showByStages")
	public String showByStages (Integer page, Integer limit) {
		if(page <= 0 || page == null){
			page = 1;
		}
		page = (page - 1) * limit;
		
		Map<String, Object> map = new HashMap<> ();
		map.put("page", page);
		map.put("size", limit);
		
		return byStagesService.selectByLimit(map);
	}
	
	/**
	 * 显示分期详情信息
	 *
	 * @Title: showDetailsByStages
	
	 * @description 
	 *
	 * @param id 分期表id
	 * @param page
	 * @param limit
	 * @return 
	   
	 * String
	 *
	 * @author lujinpeng
	 * @createDate 2019年1月30日-下午4:26:35
	 */
	@RequestMapping("/showDetailsByStages")
	public String showDetailsByStages(Integer id, Integer page, Integer limit) {
		if (page != null && limit != null) {
			page = (page - 1) * limit;
		}
		Map<String, Object> map = new HashMap<> ();
		map.put("id", id);
		map.put("page", page);
		map.put("size", limit);
		
		return detailsInstallmentsService.selectDetailsInstallments(map);
	}	
	
	/**
	 * 显示分期数据对应买车客户信息
	 *
	 * @Title: showBuyingCustomer
	
	 * @description 
	 *
	 * @param id 分期表主键id
	 * @return 
	 * String
	 *
	 * @author lujinpeng
	 * @createDate 2019年1月30日-下午5:07:40
	 */
	@RequestMapping("/showBuyingCustomer")
	public String showBuyingCustomer(Long id) {
		
		return byStagesService.selectBuyingCustomer(id);
	}
	
	/**
	 * 分期页面搜索接口
	 *
	 * @Title: searchByStages
	
	 * @description 
	 *
	 * @param searchField 搜索数据（电话或者姓名）
	 * @param page 当前页
	 * @param limit 每页显示条数
	 * @return String
	 *
	 * @author lujinpeng
	 * @createDate 2019年1月31日-上午11:02:54
	 */
	@RequestMapping("/searchByStages")
	public String searchByStages(String searchField, Integer page, Integer limit) {
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
		
		return byStagesService.selectBySearchField(map);
	}
	
	/**
	 * 新增分期数据
	 *
	 * @Title: insertByStages
	
	 * @description 
	 *
	 * @param map
	 * @return String
	 *
	 * @author lujinpeng
	 * @createDate 2019年1月31日-下午3:06:34
	 */
	@RequestMapping("/insertByStages")
	@Transactional
	public String insertByStages(@RequestBody Map<String, Object> map) {
		List<BuyingCustomer> buyingCustomerList = null;
		Long buyingId = 0L;
		int code = 1;
		String msg = "插入成功";
		
		// 将map对象转换成json字符串
		String carFormStr = JSONObject.toJSONString(map.get("carForm"));
		// 将json字符串转换成json对象
		JSONObject carFormJsonObj = JSONObject.parseObject(carFormStr);
		
		/* 获取买车客户对象 */
		BuyingCustomer buyingCustomer = JSON.parseObject(JSONObject.toJSONString(map.get("buyingCustomer")), BuyingCustomer.class);
		/* 获取录入客户电话  */
		String phone = buyingCustomer.getPhone();
		/* 获取分期表对象 */
		ByStages byStages = JSON.parseObject(JSONObject.toJSONString(carFormJsonObj.get("byStages")), ByStages.class);
		/* 获取分期详情表对象 */
		DetailsInstallments detailsInstallments = JSON.parseObject(JSONObject.toJSONString(map.get("carForm")), DetailsInstallments.class);

		try {
			buyingCustomerList = buyingCustomerService.selectByPhone(phone);
			
			 /*判断买车客户表是否存在当前客户 */
			if (buyingCustomerList.size() == 0) {
				// 如果不存在当前客户则添加
				buyingCustomer.setCreateTime(new Date());
				buyingCustomerService.insertSelective(buyingCustomer);
				// 获取添加成功客户的id
				buyingId = buyingCustomerService.selectByPhone(phone).get(0).getId();
				// 设置分期表和分期详情表buyingId值
				byStages.setBuyingId(buyingId);
				detailsInstallments.setBuyingId(buyingId);
			} else {
				buyingId = buyingCustomerList.get(0).getId();
				byStages.setBuyingId(buyingId);
				detailsInstallments.setBuyingId(buyingId);
			}
			
			 /*设置创建时间*/ 
			byStages.setCreateTime(new Date());
			detailsInstallments.setCreateTime(new Date());
			// 设置分期详情表当前期数（首次新增，当前期数为1）
			detailsInstallments.setNowStage(1);
			// 设置还款状态（0为还款中）
			detailsInstallments.setBeOverdue(0);
			
			// 插入数据到分期表
			byStagesService.insertAll(byStages);
			// 插入数据到分期详情表
			detailsInstallmentsService.insertAll(detailsInstallments);
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "系统异常";
		}
		
		return JsonUtil.getResponseJson(code, msg, null, null);
	}
	
	/**
	 * 修改分期数据
	 *
	 * @Title: updateByStages
	
	 * @description 
	 *
	 * @param map
	 * @return String
	 *
	 * @author lujinpeng
	 * @createDate 2019年2月1日-上午9:45:55
	 */
	@RequestMapping("/updateByStages")
	@Transactional
	public String updateByStages(@RequestBody Map<String, Object> map) {
		int code = 1;
		String msg = "修改成功";
		
		try {
			if (map.get("byStages") != null) {
				//获取分期表数据
				ByStages byStages = JSON.parseObject(JSONObject.toJSONString(map.get("byStages")), ByStages.class);
				// 更新分期表
				byStagesService.updateByIdSelective(byStages);
			}
			
			DetailsInstallments detailsInstallments = JSON.parseObject(JSONObject.toJSONString(map), DetailsInstallments.class);
			// 更新分期详情表
			detailsInstallmentsService.updateByIdSelective(detailsInstallments);
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "系统异常";
		}
		
		return JsonUtil.getResponseJson(code, msg, null, null);
	}
	
	/**
	 * 修改分期详情表
	 *
	 * @Title: updateDetailsInstallments
	
	 * @description 
	 *
	 * @param detailsInstallments
	 * @return 
	   
	 * String
	 *
	 * @author lujinpeng
	 * @createDate 2019年2月15日-下午4:27:22
	 */
	@RequestMapping("/updateDetailsInstallments")
	@Transactional
	public String updateDetailsInstallments(@RequestBody DetailsInstallments detailsInstallments) {
		int code = 1;
		String msg = "修改成功";
		DetailsInstallments newDetailsInstallments = new DetailsInstallments();
		Calendar cal = Calendar.getInstance();
		ByStages byStages = detailsInstallments.getByStages();
		
		try {
			
			// 判断状态是否改为1（0.还款中，1.已还，2.逾期， 默认0）
			if (detailsInstallments.getBeOverdue() == 1) {
				
				// 获得总期数
				int totalPeriod = byStages.getTotalPeriod();
				// 获取当前分期表type状态
				int type = byStages.getType();
				
				// 如果修改成功,并且当前期数小于总期数则在详情表中添加下一条还款记录
				if (detailsInstallments.getNowStage() < totalPeriod) {
					// 如果逾期,修改分期表状态为 0（还款中）
					if (type == 2) {
						byStages.setType(0);
						byStagesService.updateByIdSelective(byStages);
					}
					// 设置新增分期详情数据创建时间
					newDetailsInstallments.setCreateTime(new Date());
					// 还款当前期数增加 1 
					newDetailsInstallments.setNowStage(detailsInstallments.getNowStage() + 1);
					// 设置买车客户id
					newDetailsInstallments.setBuyingId(detailsInstallments.getBuyingId());
					// 设置还款日
					cal.setTime(detailsInstallments.getRepaymentDate());
					cal.add(Calendar.MONTH, 1);
					newDetailsInstallments.setRepaymentDate(cal.getTime());
					// 在分期详情表中新增一条数据
					detailsInstallmentsService.insertSelective(newDetailsInstallments);
				} else {
					// 如果全部还完,修改状态为 1（已还）
					byStages.setType(1);
					byStagesService.updateByIdSelective(byStages);
				}
				// 修改分期详情表数据
				detailsInstallmentsService.updateByIdSelective(detailsInstallments);
			} else {
				// 修改分期表状态
				byStages.setType(detailsInstallments.getBeOverdue());
				byStagesService.updateByIdSelective(byStages);
				// 修改分期详情表
				detailsInstallmentsService.updateByIdSelective(detailsInstallments);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "系统异常";
		}
		
		return JsonUtil.getResponseJson(code, msg, null, null);
	}
	
	
}
