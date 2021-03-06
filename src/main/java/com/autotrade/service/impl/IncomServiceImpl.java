package com.autotrade.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autotrade.dao.IncomeDao;
import com.autotrade.entity.Expenditure;
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
		income.setCreateTime(new Date());
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
			string = JsonUtil.getResponseJson(1, "", null, result);
		}
		
		return string;
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
	}

	@Override
	public String hybridSelect(String department_id,String s, Integer page, Integer limit) {
		try {
		
		Integer star =(page - 1)*limit;
		List<Income> list=incomDao.hybridSelect(department_id,s,star,limit);
		Integer count = incomDao.hybridSelectCount(department_id, s);
		
		return JsonUtil.getResponseJson(1, "查询成功", count, list);
		
		} catch (Exception e) {
			return JsonUtil.getResponseJson(-1, "程序错误", null, null);
		}
	}

	@Override
	public String selectIncomeByDepartmentId(String department_id, Integer page, Integer limit) {
		String string;
		Integer star =(page - 1) * limit;
		try {

			List<Expenditure> result = incomDao.selectIncomeByDepartmentId(department_id, star, limit);

			if (result.size() >= 1) {
				string = JsonUtil.getResponseJson(1, "查询成功", incomDao.selectIncomeCountByDepartmentId(department_id),
						result);
			} else {
				string = JsonUtil.getResponseJson(1, "", 0, result);
			}

			return string;

		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
		
	}

	

}
