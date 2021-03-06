package com.autotrade.service.impl;

import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autotrade.dao.ExpenditureDao;
import com.autotrade.entity.Expenditure;
import com.autotrade.service.ExpenditureService;
import com.autotrade.utils.JsonUtil;

@Service
public class ExpenditureServiceImpl implements ExpenditureService {

	@Autowired
	private ExpenditureDao expenditureDao;

	@Override
	public String insertExpenditure(Expenditure expenditure) {

		String string;
		expenditure.setCreateTime(new Date());
		try {

			Integer result = expenditureDao.insert(expenditure);

			if (result >= 1) {
				string = JsonUtil.getResponseJson(1, "添加成功", null, null);
			} else {
				string = JsonUtil.getResponseJson(1, "添加失败", null, null);
			}

			return string;

		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}

	}

	@Override
	public String deleteByPrimaryKey(Long id) {

		String string;
		try {

			Integer result = expenditureDao.deleteByPrimaryKey(id);

			if (result >= 1) {
				string = JsonUtil.getResponseJson(1, "删除成功", null, null);
			} else {
				string = JsonUtil.getResponseJson(1, "删除失败", null, null);
			}

			return string;

		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}

	}

	@Override
	public String updateByPrimaryKey(Expenditure expenditure) {

		String string;
		try {

			Integer result = expenditureDao.updateByPrimaryKey(expenditure);

			if (result >= 1) {
				string = JsonUtil.getResponseJson(1, "修改成功", null, null);
			} else {
				string = JsonUtil.getResponseJson(1, "修改失败", null, null);
			}

			return string;

		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
	}

	@Override
	public String selectAllExpenditure(Integer star, Integer limit) {

		String string;
		try {

			List<Expenditure> result = expenditureDao.selectAllExpenditure(star, limit);

			if (result.size() >= 1) {
				string = JsonUtil.getResponseJson(1, "查询成功", expenditureDao.selectAllExpenditureCount(), result);
			} else {
				string = JsonUtil.getResponseJson(1, "", 0, result);
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

			Expenditure result = expenditureDao.selectByPrimaryKey(id);

			if (null != result || !"".equals(result)) {
				string = JsonUtil.getResponseJson(1, "查询失败", null, null);
			} else {
				string = JsonUtil.getResponseJson(1, "查询成功", 1, result);
			}

			return string;

		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}

	}

	@Override
	public String selectExpenditureByDepartmentId(String department_id, Integer star, Integer limit) {

		String string;
		try {

			List<Expenditure> result = expenditureDao.selectExpenditureByDepartmentId(department_id, star, limit);

			if (result.size() >= 1) {
				string = JsonUtil.getResponseJson(1, "查询成功", expenditureDao.selectExpenditureCountByDepartmentId(department_id),
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

	@Override
	public String selectExpenditureByExpenditure(String expenditure, Integer star, Integer limit) {

		String string;
		try {

			List<Expenditure> result = expenditureDao.selectExpenditureByExpenditure(expenditure, star, limit);

			if (result.size() >= 1) {
				string = JsonUtil.getResponseJson(1, "查询成功",
						expenditureDao.selectExpenditureByExpenditureCount(expenditure), result);
			} else {
				string = JsonUtil.getResponseJson(1, "", null, null);
			}

			return string;

		} catch (Exception e) {
				e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
	}

	@Override
	public String hybridSelect(String department_id,String s, Integer star, Integer limit) {
				
		try {
			
		
		List<Expenditure> result =	expenditureDao.hybridSelect(department_id,s,star,limit);
		
		Integer count = expenditureDao.hybridSelectCount(department_id,s);
		
		if(count <= 0){
			return JsonUtil.getResponseJson(1, "", null, result);
		}
		
		return  JsonUtil.getResponseJson(1, "查询成功", count, result);
		
		} catch (Exception e) {
			e.printStackTrace();
			return  JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
	}

}
