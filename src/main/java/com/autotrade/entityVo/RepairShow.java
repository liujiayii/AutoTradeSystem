package com.autotrade.entityVo;

import java.util.Date;

/**
 * 
 *
 * @ClassName: RepairShow
 * 
 * @description 工单查询显示信息
 *
 * @author lishaozhang
 * @createDate 2019年2月20日
 */
public class RepairShow {

	/** 工单id(车辆档案id) */
	private Long repair_id;
	
	/** 车辆代码id(车辆档案id) */
	private Long vehicleId;
	/** 车牌号(在车辆档案中) */
	private String vehicleNumber;
	/** 客户姓名 */
	private String customerName;
	/**客户电话*/
	private String phone_number;
	/**客户电话*/
	private String address;
	/** 车型（车型分类表） */
	private String vehicleType;
	/** 进场世间（ 维修工单表） */
	private Date enterTime;
	/** 状态（维修工单表） */
	private String state;
   
	
	public Long getRepair_id() {
		return repair_id;
	}

	public void setRepair_id(Long repair_id) {
		this.repair_id = repair_id;
	}

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Date getEnterTime() {
		return enterTime;
	}

	public void setEnterTime(Date enterTime) {
		this.enterTime = enterTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "RepairShow [vehicleId=" + vehicleId + ", vehicleNumber=" + vehicleNumber + ", customerName="
				+ customerName + ", vehicleType=" + vehicleType + ", enterTime=" + enterTime + ", state=" + state + "]";
	}

}
