package com.autotrade.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autotrade.dao.SellCarDao;
import com.autotrade.entity.BuyingCustomer;
import com.autotrade.entity.Vehichle;
import com.autotrade.entityVo.SellCarVo;
import com.autotrade.entityVo.ShowCarVo;
import com.autotrade.service.SellCarService;
import com.autotrade.utils.JsonUtil;

@Service
public class SellCarServiceImpl implements SellCarService {

	@Autowired
	private SellCarDao sellCarDao;

	@Override
	public List<SellCarVo> findByLimit(Integer page, Integer limit) {
		List<SellCarVo> lists = sellCarDao.findByLimit(page, limit);
		if (lists.size() >= 0) {
			return lists;
		}
		return null;
	}

	@Override
	public Integer findAllCount() {
		Integer count = sellCarDao.findAllCount();
		return count;
	}

	@Override
	public ShowCarVo findById(Integer id) {
		return sellCarDao.findById(id);
	}

	@Override
	public Integer updateSellCar(ShowCarVo showCarVo) {
		Integer row = sellCarDao.updateSellCar(showCarVo);
		return row;
	}

	@Override
	public List<SellCarVo> findByKeyWord(String keyWord, Integer page, Integer limit) {
		List<SellCarVo> list = sellCarDao.findByKeyWord(keyWord, page, limit);
		if(list.size()>0){
			return list;
		}
		return null;
	}

	@Override
	public BuyingCustomer findClientByPhone(String phone) {
		BuyingCustomer buyingCustomer = sellCarDao.findClientByPhone(phone);
		if(buyingCustomer==null){
			return null;
		}
		return buyingCustomer;
	}


	@Override
	public Vehichle findCarByNumber(String vehile_number) {
		Vehichle vehichle = sellCarDao.findCarByNumber(vehile_number);
		return vehichle;
	}

	@Override
	public String addCarOrder(ShowCarVo showCarVo) {
		Date date = new Date();
		showCarVo.setCreate_time(date);
		showCarVo.setUpdate_time(date);
		//TODO
		String json = "";
		//设置状态为1.已售卖
		Integer row = sellCarDao.updateCarStatus(1,showCarVo.getV_id());
		Integer rows = sellCarDao.addCarOrder(showCarVo);
		if(row>0 && rows>0){
			 json = JsonUtil.getResponseJson(1,"创建订单成功",null, null);
		}else{
			 json = JsonUtil.getResponseJson(-1, "添加失败", null, null);
		}
		return json;
	}

}
