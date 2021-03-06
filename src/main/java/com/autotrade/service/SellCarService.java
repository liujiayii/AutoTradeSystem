package com.autotrade.service;

import java.util.List;


import com.autotrade.entity.BuyingCustomer;
import com.autotrade.entity.Vehichle;
import com.autotrade.entityVo.SellCarVo;
import com.autotrade.entityVo.ShowCarVo;

public interface SellCarService {

	List<SellCarVo> findByLimit(Integer page, Integer limit);

	Integer findAllCount();

	ShowCarVo findById(Integer id);

	Integer updateSellCar(ShowCarVo showCarVo);

	List<SellCarVo> findByKeyWord(String keyWord,Integer page,Integer limit);

	BuyingCustomer findClientByPhone(String phone);
	
	Vehichle findCarByNumber(String vehile_number);
	
	String addCarOrder(ShowCarVo showCarVo);
}
