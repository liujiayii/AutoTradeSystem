package com.autotrade.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autotrade.dao.VehicleArchivesDao;
import com.autotrade.entity.Parts;
import com.autotrade.entity.Repair;
import com.autotrade.entity.RepairProject;
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

	@Override
	public String closeAnAccount(Long id) {
		String str;
		BigDecimal money=BigDecimal.ZERO;
		try {
			List<Parts> partsList = vehicleArchivesDao.closeAnAccountParts(id);
			List<RepairProject> repairProjectList = vehicleArchivesDao.closeAnAccountRepairProject(id);
			if(partsList!=null && partsList.size()>0 && repairProjectList!=null && repairProjectList.size()>0){
				for(Parts p:partsList){
					if(p.getMoney()!=null){
						money=money.add(p.getMoney());
					}
				}
				for(RepairProject r:repairProjectList){
					if(r.getMoney()!=null){
						money =money.add(r.getMoney());
					}
				}
				    str = JsonUtil.getResponseJson(1, "结算完成",null, money);
			}else{
					str = JsonUtil.getResponseJson(-1,"暂无数据", null, money);

			}
		} catch (Exception e) {
					str = JsonUtil.getResponseJson(-1, "系统异常",null, null);
	}
		return str;
	}

	@Override
	public String windUpAnAccount(Repair epair) {
		String str;
		try {
			Integer row = vehicleArchivesDao.windUpAnAccount(epair);
			if(row>0){
				str =  JsonUtil.getResponseJson(1, "处理完成", null, null);
			}else{
				str= JsonUtil.getResponseJson(-1,"处理失败",null, null);
			}
		} catch (Exception e) {
			str = JsonUtil.getResponseJson(-1, "系统异常", null,null);
		}
		return str;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
