package com.autotrade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autotrade.dao.IncomeDao;
import com.autotrade.entity.Income;
import com.autotrade.service.IncomeService;
import com.autotrade.utils.JsonUtil;
/**
 * 
 *
 * @ClassName: IncomServiceImpl

 * @description 实现类
 *
 * @author lishaozhang
 * @createDate 2019年1月8日
 */
@Service
public class IncomServiceImpl implements IncomeService {
	@Autowired
	private IncomeDao incomDao;

	@Override
	public String insertIncom(Income income) {
		String string;
		try {
			
		
		Integer result = incomDao.insertIncome(income);
		
		if(result >= 1){
			string = JsonUtil.getResponseJson(1, "添加成功", null, null);
		}else{
			string = JsonUtil.getResponseJson(1, "添加失败", null, null);
		}
		
		return string;
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
	}

	@Override
	public String deleteById(Long id) {
		
		String string;
		try {
			
		
		Integer result = incomDao.deleteById(id);
		
		if(result >= 1){
			string = JsonUtil.getResponseJson(1, "删除成功", null, null);
		}else{
			string = JsonUtil.getResponseJson(1, "删除失败", null, null);
		}
		
		return string;
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
	}

	@Override
	public String updateById(Income income) {
		String string;
		try {
	
		Integer result = incomDao.updateById(income);
		
		if(result >= 1){
			string = JsonUtil.getResponseJson(1, "修改成功", null, null);
		}else{
			string = JsonUtil.getResponseJson(1, "修改失败", null, null);
		}
		
		return string;
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
	}

	@Override
	public String selectByPrimaryKey(Long id) {
		
		String string;
		try {
	
		Income result = incomDao.selectByPrimaryKey(id);
		
		if(null != result || !"".equals(result)){
			string = JsonUtil.getResponseJson(1, "查询成功", 1, result);
		}else{
			string = JsonUtil.getResponseJson(1, "暂无数据", null, null);
		}
		
		return string;
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
		
		
	}

	@Override
	public String selectAll(Integer page,Integer limit) {
		String string;
		Integer star =(page - 1) * limit;
		try {
	
		List<Income> result = incomDao.selectAll(star,limit);
		
		if(result.size() >= 1){
			string = JsonUtil.getResponseJson(1, "查询成功", incomDao.selectAllCount(), result);
		}else{
			string = JsonUtil.getResponseJson(1, "暂无数据", null, null);
		}
		
		return string;
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
	}

	

}
