package com.autotrade.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autotrade.dao.RelationDao;
import com.autotrade.entity.MaintenanceParts;
import com.autotrade.entity.Relation;
import com.autotrade.service.RelationService;

/**
 * 车型，维修项目、维修类别关联表service层实现类
 *
 * @ClassName: RelationServiceImpl

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年2月20日-下午2:44:53
 */
@Service
public class RelationServiceImpl implements RelationService {

	@Autowired
	private RelationDao relationDao;
	
	/**
	 * 通过关联关系id查询
	 */
	@Override
	public Relation selectByRelationId(Map<String, Object> map) {
		
		return relationDao.selectByRelationId(map);
	}

	/**
	 * 通过维修客户电话查询维修客户类型信息
	 */
	@Override
	public MaintenanceParts selectMaintenancePartsId(String phone_number, String customer_name) {
		
		return relationDao.selectMaintenancePartsId(phone_number, customer_name);
	}

}
