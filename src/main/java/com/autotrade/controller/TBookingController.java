package com.autotrade.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.autotrade.entity.Assessment;
import com.autotrade.entity.TBooking;
import com.autotrade.entityVo.bookingVo;
import com.autotrade.service.BuyingCustomerService;
import com.autotrade.service.TBookingService;
@Controller
@RequestMapping("/booking")
public class TBookingController {
	
	@Autowired
	private TBookingService tBookingService;
	
	@RequestMapping("selectAllBooking")
	@ResponseBody
	public String selectAllBooking(Integer page, Integer limit){
		System.out.println("******"+page+"///"+limit);
		
		return tBookingService.selectAll(page,limit);
		
	}
	
	@RequestMapping("insertbooking")
	@ResponseBody
	public String insertAssessment(TBooking record) {
		
	
		System.out.println("增加"+record);
		String string = tBookingService.insert(record);
		return string;

	}
	
	@RequestMapping("updatebooking")
	@ResponseBody
	public String updatebooking(TBooking record) {
		System.out.println("ttttttttttt");
	
		System.out.println("修改"+record);
		String string = tBookingService.updateByPrimaryKeySelective(record);
		return string;

	}
	
	@RequestMapping("findById")
	@ResponseBody
	public String selectById(Long id){
		System.out.println("id"+id);
		
		return tBookingService.selectAllbookbyId(id);
	}

}
