package com.autotrade.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autotrade.dao.MaintenanceMaterialsDao;
import com.autotrade.entity.Assessment;
import com.autotrade.entity.MaintenanceMaterials;
import com.autotrade.service.MaintenanceMaterialsService;
import com.autotrade.utils.JsonUtil;
@Service
public class MaintenanceMaterialsServiceImpl implements MaintenanceMaterialsService {
	
	@Autowired
	private MaintenanceMaterialsDao maintenanceMaterialsDao;
	

	@Override
	public String deleteByPrimaryKey(Long id) {
		String string;

		try {

			Integer deleteByBrand = maintenanceMaterialsDao.deleteByPrimaryKey(id);

			if (deleteByBrand >= 1) {
				string = JsonUtil.getResponseJson(1, "删除成功", null, null);
			} else {
				string = JsonUtil.getResponseJson(1, "记录不存在", null, null);
			}

			return string;
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
	}

	@Override
	public String insertSelective(MaintenanceMaterials record) {
		String string;
		try {
		

			Integer result = maintenanceMaterialsDao.insertSelective(record);
			// 返回值 >= 1 代表添加成功
			if (result >= 1) {

				string = JsonUtil.getResponseJson(1, "添加成功", null, null);
			} else {
				string = JsonUtil.getResponseJson(1, "添加失败", null, null);
			}

			return string;

		} catch (Exception e) {
			// 程序异常
			e.printStackTrace();
			return string = JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
	}

	@Override
	public String selectByPrimaryKey(Long id) {
		String string;

		try {

			MaintenanceMaterials selectAssessmentById = maintenanceMaterialsDao.selectByPrimaryKey(id);

			string = JsonUtil.getResponseJson(1, "查询成功", 1, selectAssessmentById);

			return string;
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
	}

	@Override
	public String updateByPrimaryKeySelective(MaintenanceMaterials record) {
		String string;

		try {

			Integer updateByPrimaryKey = maintenanceMaterialsDao.updateByPrimaryKeySelective(record);

			if (updateByPrimaryKey >= 1) {
				string = JsonUtil.getResponseJson(1, "修改成功", null, null);
			} else {
				string = JsonUtil.getResponseJson(1, "记录不存在", null, null);
			}

			return string;
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
	}

	/**
	 * 根据指定条件获取材料信息
	 */
	@Override
	public List<MaintenanceMaterials> selectBySelective(MaintenanceMaterials maintenanceMaterials) {

		return maintenanceMaterialsDao.selectBySelective(maintenanceMaterials);
	}

	
}
