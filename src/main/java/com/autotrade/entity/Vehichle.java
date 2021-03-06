package com.autotrade.entity;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 
 *
 * @ClassName: Vehichle

 * @description 汽车管理实体类
 *
 * @author lishaozhang
 * @createDate 2019年1月10日
 */
public class Vehichle {

	/*主键id*/
	private Long id;
	/*车辆型号（车型）*/
	private String vehicle_type;
	/*车辆品牌（车牌）*/
	private String brand;
	/*车类 1.新车 2.旧车*/
	private Integer type;
	/*创建时间*/
	private Date create_time;
	/*车辆颜色*/
	private String color;
	/*底盘号*/
	private String chassis_number;
	/*发动机号*/
	private String engine_number;
	/*合格证号*/
	private String qualified_number;
	/*进口号*/
	private String imported_number;
	/*商检单号*/
	private String inspection_number;
	/*提单号*/
	private String carry_number;
	/*自编号*/
	private String self_number;
	/*钥匙号*/
	private String key_number;
	/*行驶里程*/
	private String mileage;
	/*业务员*/
	private String business;
	/*制单人*/
	private String single_person;
	/*购车价格*/
	private BigDecimal selling_price;
	/*备注*/
	private String remark;
	/*卖车客户id*/
	private Integer seling_id;
	/*供应商id*/
	private Integer supplier_id;
	/*入库编号*/
	private  String vehile_number;
	/*产地*/
	private String place;
	/*车型代码*/
	private String vehicle_code;
	/*该车状态（0，未售出，1，已售出）默认是0*/
	private Integer vehicle_types;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getChassis_number() {
		return chassis_number;
	}
	public void setChassis_number(String chassis_number) {
		this.chassis_number = chassis_number;
	}
	public String getEngine_number() {
		return engine_number;
	}
	public void setEngine_number(String engine_number) {
		this.engine_number = engine_number;
	}
	public String getQualified_number() {
		return qualified_number;
	}
	public void setQualified_number(String qualified_number) {
		this.qualified_number = qualified_number;
	}
	public String getImported_number() {
		return imported_number;
	}
	public void setImported_number(String imported_number) {
		this.imported_number = imported_number;
	}
	public String getInspection_number() {
		return inspection_number;
	}
	public void setInspection_number(String inspection_number) {
		this.inspection_number = inspection_number;
	}
	public String getCarry_number() {
		return carry_number;
	}
	public void setCarry_number(String carry_number) {
		this.carry_number = carry_number;
	}
	public String getSelf_number() {
		return self_number;
	}
	public void setSelf_number(String self_number) {
		this.self_number = self_number;
	}
	public String getKey_number() {
		return key_number;
	}
	public void setKey_number(String key_number) {
		this.key_number = key_number;
	}
	public String getMileage() {
		return mileage;
	}
	public void setMileage(String mileage) {
		this.mileage = mileage;
	}
	public String getBusiness() {
		return business;
	}
	public void setBusiness(String business) {
		this.business = business;
	}
	public String getSingle_person() {
		return single_person;
	}
	public void setSingle_person(String single_person) {
		this.single_person = single_person;
	}
	public BigDecimal getSelling_price() {
		return selling_price;
	}
	public void setSelling_price(BigDecimal selling_price) {
		this.selling_price = selling_price;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getSeling_id() {
		return seling_id;
	}
	public void setSeling_id(Integer seling_id) {
		this.seling_id = seling_id;
	}
	public Integer getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(Integer supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getVehile_number() {
		return vehile_number;
	}
	public void setVehile_number(String vehile_number) {
		this.vehile_number = vehile_number;
	}
	
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getVehicle_code() {
		return vehicle_code;
	}
	public void setVehicle_code(String vehicle_code) {
		this.vehicle_code = vehicle_code;
	}
	public Integer getVehicle_types() {
		return vehicle_types;
	}
	public void setVehicle_types(Integer vehicle_types) {
		this.vehicle_types = vehicle_types;
	}
	@Override
	public String toString() {
		return "Vehichle [id=" + id + ", vehicle_type=" + vehicle_type + ", brand=" + brand + ", type=" + type
				+ ", create_time=" + create_time + ", color=" + color + ", chassis_number=" + chassis_number
				+ ", engine_number=" + engine_number + ", qualified_number=" + qualified_number + ", imported_number="
				+ imported_number + ", inspection_number=" + inspection_number + ", carry_number=" + carry_number
				+ ", self_number=" + self_number + ", key_number=" + key_number + ", mileage=" + mileage + ", business="
				+ business + ", single_person=" + single_person + ", selling_price=" + selling_price + ", remark="
				+ remark + ", seling_id=" + seling_id + ", supplier_id=" + supplier_id + ", vehile_number="
				+ vehile_number + ", place=" + place + ", vehicle_code=" + vehicle_code + ", vehicle_types="
				+ vehicle_types + "]";
	}
}