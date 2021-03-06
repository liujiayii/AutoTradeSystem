package com.autotrade.entityVo;

import java.math.BigDecimal;

import com.autotrade.entity.SellCar;

/**
  * @ClassName: ShowCarVo
  * @description 售车管理模块，显示单条订单的售车信息以及用户信息
  * @author ZhaoSong
  * @createDate 2019年1月30日
 */
public class ShowCarVo extends SellCar{

	/*买车客户姓名*/
	private String name;
	/*买车客户电话*/
	private String phone;
	/*买车客户地址*/
	private String address;
	/*售车信息付款类型*/
	private Integer type;
	/*售车信息首付款*/
	private BigDecimal first_payment;
	/*售车信息最后成交金额*/
	private BigDecimal money;
	/*售车信息 分期月数*/
	private Integer monthly_number;
	/*售车信息月供*/
	private BigDecimal monthly_supply;
	/*售车信息保险地址*/
	private Integer insurance;
	/*售车信息入库编号*/
	private String vehile_number;
	/*售车信息 车辆售价*/
	private BigDecimal s_money;
	/*售车信息 业务员*/
	private String person;
	/*车辆信息车辆类型*/
	private String vehicle_type;
	/*车辆信息车辆品牌(车牌)*/
	private String brand;
	/*车辆信息车型代码*/
	private String vehicle_code;
	/*车辆信息 产地*/
	private String place;
	/*车辆信息发动机号*/
	private String engine_number;
	/*车辆信息合格证号*/
	private String qualified_number;
	/*车辆信息底盘号*/
	private String chassis_number;
	/*车辆信息进口证号*/
	private String imported_number;
	/*车辆信息商检单号*/
	private String inspection_number;
	/*车辆信息提单号*/
	private String carry_number;
	/*车辆信息自编号*/
	private String self_number;
	/*车辆信息钥匙号*/
	private String key_number;
	/*车辆信息行驶里程*/
	private String mileage;
	/*车辆信息出场时间*/
	
	/*车辆信息制单人*/
	private String single_person;
	/*车辆信息售价*/
	private BigDecimal selling_price;
	/*该车状态（0，未售出，1，已售出）默认是0*/
	private Integer vehicle_types;
	/*此订单关联用户的id*/
	private Long id;
	/*此售车订单的id*/
	private Long c_id;
	/*此车辆信息的id*/
	private Long v_id;
	
	
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public BigDecimal getFirst_payment() {
		return first_payment;
	}
	public void setFirst_payment(BigDecimal first_payment) {
		this.first_payment = first_payment;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public Integer getMonthly_number() {
		return monthly_number;
	}
	public void setMonthly_number(Integer monthly_number) {
		this.monthly_number = monthly_number;
	}
	public BigDecimal getMonthly_supply() {
		return monthly_supply;
	}
	public void setMonthly_supply(BigDecimal monthly_supply) {
		this.monthly_supply = monthly_supply;
	}
	public Integer getInsurance() {
		return insurance;
	}
	public void setInsurance(Integer insurance) {
		this.insurance = insurance;
	}
	public String getVehile_number() {
		return vehile_number;
	}
	public void setVehile_number(String vehile_number) {
		this.vehile_number = vehile_number;
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
	public String getChassis_number() {
		return chassis_number;
	}
	public void setChassis_number(String chassis_number) {
		this.chassis_number = chassis_number;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getC_id() {
		return c_id;
	}
	public void setC_id(Long c_id) {
		this.c_id = c_id;
	}
	public Long getV_id() {
		return v_id;
	}
	public void setV_id(Long v_id) {
		this.v_id = v_id;
	}
	
	public String getVehicle_code() {
		return vehicle_code;
	}
	public void setVehicle_code(String vehicle_code) {
		this.vehicle_code = vehicle_code;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Integer getVehicle_types() {
		return vehicle_types;
	}
	public void setVehicle_types(Integer vehicle_types) {
		this.vehicle_types = vehicle_types;
	}
	
	public BigDecimal getS_money() {
		return s_money;
	}
	public void setS_money(BigDecimal s_money) {
		this.s_money = s_money;
	}
	@Override
	public String toString() {
		return "ShowCarVo [name=" + name + ", phone=" + phone + ", address=" + address + ", type=" + type
				+ ", first_payment=" + first_payment + ", money=" + money + ", monthly_number=" + monthly_number
				+ ", monthly_supply=" + monthly_supply + ", insurance=" + insurance + ", vehile_number=" + vehile_number
				+ ", s_money=" + s_money + ", person=" + person + ", vehicle_type=" + vehicle_type + ", brand=" + brand
				+ ", vehicle_code=" + vehicle_code + ", place=" + place + ", engine_number=" + engine_number
				+ ", qualified_number=" + qualified_number + ", chassis_number=" + chassis_number + ", imported_number="
				+ imported_number + ", inspection_number=" + inspection_number + ", carry_number=" + carry_number
				+ ", self_number=" + self_number + ", key_number=" + key_number + ", mileage=" + mileage
				+ ", single_person=" + single_person + ", selling_price=" + selling_price + ", vehicle_types="
				+ vehicle_types + ", id=" + id + ", c_id=" + c_id + ", v_id=" + v_id + "]";
	}
}
