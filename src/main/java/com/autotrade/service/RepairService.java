package com.autotrade.service;

import com.autotrade.entity.Repair;
import com.autotrade.entityVo.RepairSelect;

/**
 * 
 *
 * @ClassName: RepairService

 * @description 工单实现层接口
 *
 * @author lishaozhang
 * @createDate 2019年2月20日
 */
public interface RepairService {
    /**
     * 添加
     * @param vehicle_number 
     * 未使用
     * */
	String insert(Repair repair, String vehicle_number);
	 /**
     * 删除
     * */
	String deleteByPrimaryKey(Long id);
	/**
	 * 没有传来的属性将保持不变
	 * */
	String updateByPrimaryKeySelective(Repair repair);
	/**工单条件粗略 查询*/
	String hybridSelect(RepairSelect repair);
	/**工单详情查询*/
	String detailsSelect(Long vehicleId, Long repair_id);
	/**根据车牌号码查询工单详细信息**/
	String detailsSelectByVehicleNumber(String vehicleNumber);
	/**查询工单耗材*/
	String selectPartsShow(Long repair_id, Integer page, Integer limit);
	/**改变工单状态**/
	String upadteState(Long id, Integer state);
	/**
     * 添加
     * @param vehicle_number 
     * */
	String insert(Repair repair);
	

	
	

}
