package com.autotrade.entity;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 
 *
 * @ClassName: VehichileDetailed

 * @description 车型代码实体
 *
 * @author lishaozhang
 * @createDate 2019年2月11日
 */
public class VehichileDetailed {
    private Long id;

    private String vehicleCode;

    private String vehicle_type;

    private String brand;

    private String place;

    private BigDecimal selling_price;

    private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVehicleCode() {
		return vehicleCode;
	}

	public void setVehicleCode(String vehicleCode) {
		this.vehicleCode = vehicleCode;
	}

	public String getVehicle_type() {
		return vehicle_type;
	}

	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public BigDecimal getSelling_price() {
		return selling_price;
	}

	public void setSelling_price(BigDecimal selling_price) {
		this.selling_price = selling_price;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "VehichileDetailed [id=" + id + ", vehicleCode=" + vehicleCode + ", vehicle_type=" + vehicle_type
				+ ", brand=" + brand + ", place=" + place + ", selling_price=" + selling_price + ", createTime="
				+ createTime + "]";
	}

   
    
    
}