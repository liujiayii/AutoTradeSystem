package com.autotrade.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.autotrade.dao.MaintenanceMaterialsDao;
import com.autotrade.entity.Assessment;
import com.autotrade.entity.MaintenanceMaterials;
import com.autotrade.entity.Relation;
import com.autotrade.service.MaintenanceMaterialsService;
import com.autotrade.utils.FastJsonUtil;
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
	public String insertSelective(@RequestBody JSONObject obj) {

		String string = null;
		Integer number = 0;
	
		String data = obj.toJSONString();
		// 解析json数据
		JSONObject json = JSON.parseObject(data);

		String xmid = json.getString("id");

		long xid = Long.parseLong(xmid);
		
       int a=maintenanceMaterialsDao.deleteByPid(xid);
		String str = json.getString("data");
		Relation r = new Relation();
		List<MaintenanceMaterials> rS = FastJsonUtil.jsonString2BeanList(str, MaintenanceMaterials.class);
		try {
		if (rS != null) {
			for(int a1= 0; a1 < rS.size(); a1++) {
				rS.get(a1).setProject_id(xid);
				Integer result = maintenanceMaterialsDao.insertSelective(rS.get(a1));
				number = number + result;
			}
			if (number >= rS.size()) {

				string = JsonUtil.getResponseJson(1, "添加成功", null, null);
			} else {
				string = JsonUtil.getResponseJson(1, "添加失败", null, null);
			}
		} else {
			string = JsonUtil.getResponseJson(1, "没有数据添加", null, null);
		}
	}catch(Exception e)
	{
		string = JsonUtil.getResponseJson(-1, "系统异常", null, null);
	}

	return string;
	}


	@Override
	public String selectByPrimaryKey(Long id) {
		String string;

		try {

			List<MaintenanceMaterials> selectAssessmentById = maintenanceMaterialsDao.selectByPrimaryKey(id);
          
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
