package com.autotrade.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autotrade.dao.VehichleDao;
import com.autotrade.entity.VehichileDetailed;
import com.autotrade.entity.Vehichle;
import com.autotrade.service.VehichleService;
import com.autotrade.utils.JsonUtil;
@Service
public class VehichleServiceImpl implements VehichleService{
	
	@Autowired
	private VehichleDao vehichleDao;

	@Override
	public String insert(Vehichle vehichle) {
		vehichle.setCreate_time(new Date());
		String string;
		try {
			Integer count1 = vehichleDao.selectByProperty(vehichle.getVehile_number());
			
			if(count1 >= 1){
				return JsonUtil.getResponseJson(1,"该入库编号已存在", null, null);
			}
		
		Integer result = vehichleDao.insert(vehichle);
		if(result >=1 ){
			string = JsonUtil.getResponseJson(1, "添加成功", null, null);
		}else{
			string = JsonUtil.getResponseJson(1, "添加失败", null, null);
		}
		} catch (Exception e) {
			e.printStackTrace();
			string = JsonUtil.getResponseJson(-1,"系统异常", null, null);
		}
		
		return string;
	}

	@Override
	public String deleteByPrimaryKey(Long id) {
		String string;
		try {
	
		Integer result = vehichleDao.deleteByPrimaryKey(id);
		if(result >=1 ){
			string = JsonUtil.getResponseJson(1, "删除成功", null, null);
		}else{
			string = JsonUtil.getResponseJson(1, "删除失败", null, null);
		}
		} catch (Exception e) {
			string = JsonUtil.getResponseJson(-1,"系统异常", null, null);
		}
		
		return string;
	}

	@Override
	public String deleteByBrand(String brand) {
		String string;
		try {
	
		Integer result = vehichleDao.deleteByBrand(brand);
		if(result >=1 ){
			string = JsonUtil.getResponseJson(1, "删除成功", null, null);
		}else{
			string = JsonUtil.getResponseJson(1, "删除失败", null, null);
		}
		} catch (Exception e) {
			string = JsonUtil.getResponseJson(-1,"系统异常", null, null);
		}
		
		return string;
	}

	@Override
	public String updateByPrimaryKey(Vehichle vehichle) {
		String string;
		try {
	
		Integer result = vehichleDao.updateByPrimaryKey(vehichle);
		if(result >=1 ){
			string = JsonUtil.getResponseJson(1, "修改成功", null, null);
		}else{
			string = JsonUtil.getResponseJson(1, "修改失败", null, null);
		}
		} catch (Exception e) {
			e.printStackTrace();
			string = JsonUtil.getResponseJson(-1,"系统异常", null, null);
		}
		
		return string;
	
	}

	@Override
	public String selectByPrimaryKey(Long id) {
		String string;
		try {
	       Vehichle result = vehichleDao.selectByPrimaryKey(id);
        if( null != result || !"".equals(result) ){
			string = JsonUtil.getResponseJson(1, "查询成功", 1, result);
		}else{
			string = JsonUtil.getResponseJson(1, "查询失败", null, null);
		}
		} catch (Exception e) {
			string = JsonUtil.getResponseJson(-1,"查询异常", null, null);
		}
		
		return string;
	}

	@Override
	public String selectAll(Integer star,Integer limit) {
		String string;
		try {
	       List<Vehichle> result = vehichleDao.selectAll(star, limit);
        if( result.size()>=1){
			string = JsonUtil.getResponseJson(1, "查询成功", vehichleDao.selectAllCount(), result);
		}else{
			string = JsonUtil.getResponseJson(1, "查询失败", null, null);
		}
		} catch (Exception e) {
			string = JsonUtil.getResponseJson(-1,"查询异常", null, null);
		}
		
		return string;
	}

	@Override
	public String hybridSelect(String s, Integer page, Integer limit) {
		try {
			Integer star = (page - 1) * limit;
			List<Vehichle> list = vehichleDao.hybridSelect(s, star, limit);
			Integer count = vehichleDao.hybridSelectCount(s);
			return JsonUtil.getResponseJson(1, "查询成功", count, list);
		} catch (Exception e) {
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
	}

}
