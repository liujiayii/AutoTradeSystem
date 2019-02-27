package com.autotrade.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autotrade.dao.MaintenanceTypeDao;
import com.autotrade.entity.MaintenanceType;
import com.autotrade.service.MaintenanceTypeService;
import com.autotrade.utils.JsonUtil;
/**
 * 维修类型表service层实现类
 *
 * @ClassName: MaintenanceTypeServiceImpl

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年2月20日-上午11:18:53
 */
@Service
public class MaintenanceTypeServiceImpl implements MaintenanceTypeService {

	@Autowired
	private MaintenanceTypeDao maintenanceTypeDao;
	
	/**
	 * 通过id查询
	 */
	@Override
	public MaintenanceType selectById(Long id) {
		
		return maintenanceTypeDao.selectById(id);
	}

	/**
	 * 通过指定条件查询
	 */
	@Override
	public List<MaintenanceType> selectBySelective(Map<String, Object> map) {
		
		return maintenanceTypeDao.selectBySelective(map);
	}

	/**
	 * 插入全部
	 */
	@Override
	public int insertAll(MaintenanceType maintenanceType) {
		
		return maintenanceTypeDao.insertAll(maintenanceType);
	}

	/**
	 * 插入指定数据
	 */
	@Override
	public int insertSelective(MaintenanceType maintenanceType) {
		
		return maintenanceTypeDao.insertSelective(maintenanceType);
	}

	@Override
	public String selectAll() {
		
		String str; 
		try {
			List<MaintenanceType>list=maintenanceTypeDao.selectAll();
			if(list.size()>0){
				str = JsonUtil.getResponseJson(1,"查询成功", null, list);
			}else{
				str = JsonUtil.getResponseJson(1,"暂无数据",null, null);
			}
			
		} catch (Exception e) {
		e.printStackTrace();
		str = JsonUtil.getResponseJson(-1,"暂无数据",null, null);
		}
		return str;
		
	}

	@Override
	public String selectAllByString() {
	String str; 
	try {
		List<MaintenanceType>list=maintenanceTypeDao.selectAllByString();
		if(list.size()>0){
			str = JsonUtil.getResponseJson(1,"查询成功", null, list);
		}else{
			str = JsonUtil.getResponseJson(1,"暂无数据",null, null);
		}
		
	} catch (Exception e) {
	e.printStackTrace();
	str = JsonUtil.getResponseJson(-1,"暂无数据",null, null);
	}
	return str;
	}

	@Override
	public MaintenanceType selectByName(String name) {
		// TODO Auto-generated method stub
		return maintenanceTypeDao.selectByName(name);
	}
	
	

}
