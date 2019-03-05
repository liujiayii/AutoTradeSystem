package com.autotrade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autotrade.service.BillService;
/**
 * 
 *
 * @ClassName: BillController

 * @description 用一句话描述这个类的作用
 *
 * @author lishaozhang
 * @createDate 2019年3月4日
 */
@RestController
@RequestMapping("bill")
public class BillController {
	
	@Autowired
	private BillService billService;
	
	@RequestMapping("creatBill")
	public String creatBill(Long repair_id){
		
			
		return  billService.creatBill(repair_id);
		
	}

}
