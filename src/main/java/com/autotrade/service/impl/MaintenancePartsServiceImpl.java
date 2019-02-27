package com.autotrade.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autotrade.dao.MaintenancePartsDao;
import com.autotrade.entity.Assessment;
import com.autotrade.entity.MaintenanceParts;
import com.autotrade.service.MaintenancePartsService;
import com.autotrade.utils.JsonUtil;

@Service
public class MaintenancePartsServiceImpl  implements MaintenancePartsService{
	@Autowired
	private MaintenancePartsDao maintenancePartsDao;

	@Override
	public String selectAll() {
	
		String string;
			List<MaintenanceParts> AssessmentList = maintenancePartsDao.selectAll();
			// 未查到数据
			if (AssessmentList.size() <= 0) {
				string = JsonUtil.getResponseJson(1, "暂无数据", null, null);
			} else {
				// 查询到数据返回总数及当前页数据
				string = JsonUtil.getResponseJson(1, "查询成功", maintenancePartsDao.count(), AssessmentList);
			}
	return string;
	}

	@Override
	public String insert(MaintenanceParts record) {
	
		
		String str;
		try {
			record.setCreate_time(new Date());
			int a=maintenancePartsDao.insert(record);
			
			if(a>=1){
				str=JsonUtil.getResponseJson(1, "添加成功", null, null);
			}
			else{
				str=JsonUtil.getResponseJson(1, "修改失败", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			str=JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
		return str;
		
	}

	@Override
	public String update(MaintenanceParts record) {
		String str;
		try {
			int a=maintenancePartsDao.updateByPrimaryKeySelective(record);
			
			if(a>=1){
				str=JsonUtil.getResponseJson(1, "修改成功", null, null);
			}
			else{
				str=JsonUtil.getResponseJson(1, "修改失败", null, null);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			str=JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
		return str;
		
		
	}

}
