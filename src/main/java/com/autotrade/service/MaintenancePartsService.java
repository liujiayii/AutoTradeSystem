package com.autotrade.service;

import java.util.List;

import com.autotrade.entity.MaintenanceParts;

public interface MaintenancePartsService {
	/**查询客户类型*/
	String  selectAll();
	/*添加客户类型*/
	String insert(MaintenanceParts record);
	/**修改客户类型*/
	String update(MaintenanceParts record);
}
