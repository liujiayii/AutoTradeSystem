package com.autotrade.entityVo;

import java.math.BigDecimal;
import java.util.Date;

public class bookingVo {
	/*主键id*/
	private long id;
	/*客户id*/
	private long buyingId;
	
	/*姓名*/
	private String name;
	/*电话*/
	private String phone;
	/*地址*/
	private String address;
	/*车型代码*/
	private String vehicleCode;
	 /*类型*/
	private String vehicle_type ;
	  /*厂牌型号*/
	private String brand;
	  /*产地*/
	private String place;
	  /*价格*/
	private String selling_price ;
	/*数量*/
	private Integer number;
   /*订金*/
    private BigDecimal deposit;
   /*交车时间*/
    private Date time;
   /*业务员*/
    private String business;
   /*制单人*/
    private String singlePerson;
   /*备注*/
    private String remark;
  /*创建时间*/
    private Date create_time;
    

	public long getBuyingId() {
		return buyingId;
	}
	public void setBuyingId(long buyingId) {
		this.buyingId = buyingId;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getSelling_price() {
		return selling_price;
	}
	public void setSelling_price(String selling_price) {
		this.selling_price = selling_price;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public BigDecimal getDeposit() {
		return deposit;
	}
	public void setDeposit(BigDecimal deposit) {
		this.deposit = deposit;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getBusiness() {
		return business;
	}
	public void setBusiness(String business) {
		this.business = business;
	}
	public String getSinglePerson() {
		return singlePerson;
	}
	public void setSinglePerson(String singlePerson) {
		this.singlePerson = singlePerson;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "bookingVo [id=" + id + ", buyingId=" + buyingId + ", name=" + name + ", phone=" + phone + ", address="
				+ address + ", vehicleCode=" + vehicleCode + ", vehicle_type=" + vehicle_type + ", brand=" + brand
				+ ", place=" + place + ", selling_price=" + selling_price + ", number=" + number + ", deposit="
				+ deposit + ", time=" + time + ", business=" + business + ", singlePerson=" + singlePerson + ", remark="
				+ remark + ", create_time=" + create_time + "]";
	}
	
	
	
   
}
