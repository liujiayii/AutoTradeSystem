package com.autotrade.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autotrade.dao.DepartmentDao;
import com.autotrade.entity.Department;
import com.autotrade.service.DepartmentService;
import com.autotrade.utils.JsonUtil;
/**.
 * 
 *
 * @ClassName: DepartmentServiceImpl

 * @description 用一句话描述这个类的作用
 *
 * @author lishaozhang
 * @createDate 2019年1月31日
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;

	@Override
	public String insertDepartment(String departmen) {
		 Department department = new Department();
		 department.setDepartment(departmen);
		 department.setCreate_time(new Date());
		try {

			Integer result = departmentDao.insertDepartment(department);

			if (result >= 1) {
				return JsonUtil.getResponseJson(1, "添加成功", null, null);
			} else {
				return JsonUtil.getResponseJson(1, "添加失败", null, null);
			}
		} catch (Exception e) {
			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
	}

	@Override
	public Integer selectId(String department) {
		Integer id = departmentDao.selectId(department);

		return id;
	}

	@Override
	public String selectAll(Integer page, Integer limit) {
		try {

			Integer star = (page - 1) * limit;

			List<Department> selectAllDepartment = departmentDao.selectAllDepartment(star, limit);
			Integer count = departmentDao.getCount();
			if (count >= 1) {
				return JsonUtil.getResponseJson(1, "查询成功", count, selectAllDepartment);
			} else {
				return JsonUtil.getResponseJson(1, "暂无数据", count, selectAllDepartment);
			}
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String deleteById(Long id) {
		try {

			Integer deleteById = departmentDao.deleteById(id);

			if (deleteById >= 1) {
				return JsonUtil.getResponseJson(1, "删除成功", null, null);
			} else {
				return JsonUtil.getResponseJson(1, "删除失败", null, null);
			}
	
		} catch (Exception e) {
			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
	}

}
