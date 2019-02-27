package com.autotrade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autotrade.dao.VehicleArchivesDao;
import com.autotrade.entity.VehicleArchives;
import com.autotrade.entity.VehicleArchivesVo;
import com.autotrade.service.VehicleArchivesService;
import com.autotrade.utils.JsonUtil;

@Service
public class VehicleArchivesServiceImpl implements VehicleArchivesService {

	@Autowired
	private VehicleArchivesDao vehicleArchivesDao;
	
	@Override
	public String findByLimit(Integer page, Integer limit, String keyWord) {
		List<VehicleArchivesVo> lists;
		String str;
		//try {
			if(!keyWord.equals("")&&keyWord!=null){//关键字分页
				lists = vehicleArchivesDao.findKeyWordByLimit(page, limit, keyWord);
				if(lists.size()>0){
					str = JsonUtil.getResponseJson(1,"查询成功",vehicleArchivesDao.findKeyWordCount(keyWord),lists);
				}else{
					str = JsonUtil.getResponseJson(1, "暂无数据", null, null);
				}
			}else{//普通分页
				lists = vehicleArchivesDao.findByLimit(page, limit);
				if(lists.size()>0){
					str = JsonUtil.getResponseJson(1, "查询成功", vehicleArchivesDao.findAllCount(), lists);
				}else{
					str = JsonUtil.getResponseJson(1,"暂无数据", null, null);
				}
			}
		//} catch (Exception e) {
				//	str = JsonUtil.getResponseJson(-1,"系统异常", null, null);
		//}
		return str;
	}

	@Override
	public String findCarArchivesById(Long id) {
		String str;
		//try {
			VehicleArchivesVo vehicleArchivesVo = vehicleArchivesDao.findCarArchivesById(id);
			str = JsonUtil.getResponseJson(1, "查询成功", null, vehicleArchivesVo);
		//} catch (Exception e) {
			//str = JsonUtil.getResponseJson(-1,"系统异常", null, null);
		//}
		return str;
	}

	@Override
	public String updateCarArchives(VehicleArchives vehicleArchives) {
		String str;
		try {
			Integer row=vehicleArchivesDao.updateCarArchives(vehicleArchives);
			if(row>0){
				str = JsonUtil.getResponseJson(1,"修改成功", null, null);
			}else{
				str = JsonUtil.getResponseJson(-1, "修改失败", null, null);
			}
		} catch (Exception e) {
			str = JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
		return str;
	}

	@Override
	public String insertCarArchives(VehicleArchives vehicleArchives) {
		String str;
		try {
			Integer row =vehicleArchivesDao.insertCarArchives(vehicleArchives);
			if(row>0){
				str = JsonUtil.getResponseJson(1,"添加成功", null, null);
			}else{
				str = JsonUtil.getResponseJson(-1,"添加失败",null, null);
			}	
		} catch (Exception e) {
			str = JsonUtil.getResponseJson(-1,"请输入有效信息", null, null);
		}		
		
		return str;
	}

	@Override
	public VehicleArchives findVehicleArchivesByVehicleNumber(String vehicle_number) {
		VehicleArchives vehicleArchives  = vehicleArchivesDao.findVehicleArchivesByVehicleNumber(vehicle_number);
		return vehicleArchives;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
