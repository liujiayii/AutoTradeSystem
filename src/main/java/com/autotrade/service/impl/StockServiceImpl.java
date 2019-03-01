package com.autotrade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autotrade.dao.StockDao;
import com.autotrade.dao.VehichleClassificationDao;
import com.autotrade.entity.Stock;
import com.autotrade.entityVo.StockVo;
import com.autotrade.service.StockService;
import com.autotrade.utils.JsonUtil;
@Service
public class StockServiceImpl implements StockService  {
	@Autowired
	private StockDao stockDao;

	@Override
	public int insertSelective(Stock record) {
	
		int a=stockDao.insertSelective(record);
		return a ;
	}

	@Override
	public List<StockVo> selectByPrimaryKey(Integer page, Integer limit) {
		
		return stockDao.selectByPrimaryKey( page, limit);
	}

	@Override
	public String updateByPrimaryKeySelective(Stock record) {
		
		String str;
		try{
			
			int insert=stockDao.updateByPrimaryKeySelective(record);
		if (insert >= 1) {
			str= JsonUtil.getResponseJson(1, "修改成功", null, null);
		} else {
			str=JsonUtil.getResponseJson(1, "修改失败", null, null);
		}

	} catch (Exception e) {
		e.printStackTrace();
		str= JsonUtil.getResponseJson(-1, "系统异常", null, null);
	}



		
		return str;
	}

	
	@Override
	public String updateByPrimaryKeySelectives(Stock record) {
		
		String str;
		try{
			
			int insert=stockDao.updateByPrimaryKeySelectives(record);
		if (insert >= 1) {
			str= JsonUtil.getResponseJson(1, "修改成功", null, null);
		} else {
			str=JsonUtil.getResponseJson(1, "修改失败", null, null);
		}

	} catch (Exception e) {
		e.printStackTrace();
		str= JsonUtil.getResponseJson(-1, "系统异常", null, null);
	}



		
		return str;
	}
	@Override
	public Stock selectById(String commodity_number) {
		Stock a=stockDao.selectById(commodity_number);
		return a;
	}

	@Override
	public Integer getcount() {
		Integer a=stockDao.getcount();
		return a;
	}

}
