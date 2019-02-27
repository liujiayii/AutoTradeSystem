package com.autotrade.service;

import java.util.Map;

import com.autotrade.entity.MaintenanceParts;
import com.autotrade.entity.Relation;

/**
 * 车型，维修项目、维修类别关联表service层
 *
 * @ClassName: RelationService

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年2月20日-下午2:43:52
 */
public interface RelationService {

	/**
	 * 通过关联关系id查询
	 *
	 * @Title: selectByRelationId
	
	 * @description 
	 *
	 * @param map
	 * @return 
	   
	 * Relation
	 *
	 * @author lujinpeng
	 * @createDate 2019年2月23日-下午2:20:08
	 */
	Relation selectByRelationId(Map<String, Object> map);
	
	/**
	 * 通过维修客户电话查询维修客户类型信息
	 *
	 * @Title: selectMaintenancePartsId
	
	 * @description 
	 *
	 * @param phone
	 * @return 
	   
	 * MaintenanceParts
	 *
	 * @author lujinpeng
	 * @createDate 2019年2月23日-下午2:40:21
	 */
	MaintenanceParts selectMaintenancePartsId(String phone);
	
	
	
}
