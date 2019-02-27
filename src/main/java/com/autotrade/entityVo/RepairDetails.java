package com.autotrade.entityVo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 *
 * @ClassName: RepairDetails

 * @description 工单详情实体类
 * 
 * @author lishaozhang
 * @createDate 2019年2月20日
 */
public class RepairDetails {
	
	
	/**
	 * 工单id
	 */
	private String repair_id;
	
	/**
	 * 车型分类id
	 * */
	private Long vehicle_classification_id;
	
	
	/**
	 * 车辆档案id
	 */
	private String vehicle_id;

	/**
	 * 车牌号
	 */
	private String vehicle_number;
	/**
	 * 来源
	 */
	private String source;
	/**
	 * 性质
	 */
	private String nature;
	/**
	 * 发动机号
	 */
	private String engine_number;
	/**
	 * 底盘号
	 */
	private String chassis_number;
	/**
	 * 变速箱号
	 */
	private String gearbox_number;
	/**
	 * 类别
	 */
	private String category;
	/**
	 * 机型
	 */
	private String aircraft_type;
	/**
	 * vin号，车辆识别码
	 */
	private String vin;
	/**
	 * 内部编号
	 */
	private String internal_number;
	/**
	 * 车身颜色
	 */
	private String color;
	/**
	 * 车型定义表id
	 */
	private Long model_definition_id;
	/**
	 * 维修客户档案id
	 */
	private Long customer_archives_id;
	/**
	 * 驾驶员id
	 */
	private Long driver_id;
	/**
	 * 三包单位
	 */
	private String three_guarantees;
	/**
	 * 经销商
	 */
	private String dealer;
	/**
	 * 车辆备注
	 */
	private String vehicle_note;
	
	private String vehicle_classification;
	/**
	 * 车型
	 */
	private String vehicle_type;
	/**
	 * 车名
	 */
	private String range_rover;
	/**
	 * 厂牌？？
	 */
	private String brand;
	
	/**
	 * 客户编号
	 */
	private String customer_id;
	/**
	 * 客户类型
	 */
	private String customer_type;
	/**
	 * 区域
	 */
	private String area;
	/**
	 * 客户姓名
	 */
	private String customer_name;
	/**
	 * 邮编
	 */
	private String postcode;
	
	/**
	 * 省份
	 */
	private String province;
	/**
	 * 地区
	 */
	private String region;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 传真
	 */
	private String fax;
	/**
	 * 公司名称
	 */
	private String company;
	private String driver_name;
	/**
	 * 性别
	 */
	private Integer gender;
	/**
	 * 职务
	 */
	private String duty;
	/**
	 * 出生日期
	 */
	private Date brithday;
	/**
	 * 省份证号
	 */
	private String id_number;
	/**
	 * 手机号码
	 */
	private String move_number;
	/**
	 * 住宅电话号码
	 */
	private String phone_number;
	/**
	 * 驾驶证号
	 */
	private String driver_license_number;
	/**
	 * 准驾车型
	 */
	private String quasi_driving_type;
	/**
	 * 发证日期
	 */
	private Date opening_date;
	/**
	 * 失效日期
	 */
	private Date expiry_date;
	/**
	 * 电子邮箱
	 */
	private String e_mail;
	/**
	 * 联系电话
	 */
	private String office_telephone;
	/**
	 * 车辆备注
	 */
	private String remark;
	/**
	 * 进厂时间
	 * */
	private Date enter_time;
	
	/**
	 * 预约进厂时间
	 * */
	private Date appointment_time;
	/**
	 * 结算日期
	 * */
	private Date settlement;
	/**
	 * 结账日期
	 * */
	private Date closing_date;
	
	/**
	 * 结账金额
	 * */
	private BigDecimal money;
	/**
	 * 结账方式
	 * */
	private String type;
	/**
	 * 当前状态
	 * */
	private String state;
	/**
	 * 当前状态
	 * */
	private String entry_person;
	/**
	 * 预约完工时间
	 * */
	private Date makespan_time;
	
	public Date getMakespan_time() {
		return makespan_time;
	}
	public void setMakespan_time(Date makespan_time) {
		this.makespan_time = makespan_time;
	}
	public Long getVehicle_classification_id() {
		return vehicle_classification_id;
	}
	public void setVehicle_classification_id(Long vehicle_classification_id) {
		this.vehicle_classification_id = vehicle_classification_id;
	}
	public String getRepair_id() {
		return repair_id;
	}
	public void setRepair_id(String repair_id) {
		this.repair_id = repair_id;
	}
	public String getEntry_person() {
		return entry_person;
	}
	public void setEntry_person(String entry_person) {
		this.entry_person = entry_person;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getEnter_time() {
		return enter_time;
	}
	public void setEnter_time(Date enter_time) {
		this.enter_time = enter_time;
	}
	public Date getAppointment_time() {
		return appointment_time;
	}
	public void setAppointment_time(Date appointment_time) {
		this.appointment_time = appointment_time;
	}
	public Date getSettlement() {
		return settlement;
	}
	public void setSettlement(Date settlement) {
		this.settlement = settlement;
	}
	public Date getClosing_date() {
		return closing_date;
	}
	public void setClosing_date(Date closing_date) {
		this.closing_date = closing_date;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getVehicle_number() {
		return vehicle_number;
	}
	public void setVehicle_number(String vehicle_number) {
		this.vehicle_number = vehicle_number;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getNature() {
		return nature;
	}
	public void setNature(String nature) {
		this.nature = nature;
	}
	public String getEngine_number() {
		return engine_number;
	}
	public void setEngine_number(String engine_number) {
		this.engine_number = engine_number;
	}
	public String getChassis_number() {
		return chassis_number;
	}
	public void setChassis_number(String chassis_number) {
		this.chassis_number = chassis_number;
	}
	public String getGearbox_number() {
		return gearbox_number;
	}
	public void setGearbox_number(String gearbox_number) {
		this.gearbox_number = gearbox_number;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getAircraft_type() {
		return aircraft_type;
	}
	public void setAircraft_type(String aircraft_type) {
		this.aircraft_type = aircraft_type;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getInternal_number() {
		return internal_number;
	}
	public void setInternal_number(String internal_number) {
		this.internal_number = internal_number;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Long getModel_definition_id() {
		return model_definition_id;
	}
	public void setModel_definition_id(Long model_definition_id) {
		this.model_definition_id = model_definition_id;
	}
	public Long getCustomer_archives_id() {
		return customer_archives_id;
	}
	public void setCustomer_archives_id(Long customer_archives_id) {
		this.customer_archives_id = customer_archives_id;
	}
	public Long getDriver_id() {
		return driver_id;
	}
	public void setDriver_id(Long driver_id) {
		this.driver_id = driver_id;
	}
	public String getThree_guarantees() {
		return three_guarantees;
	}
	public void setThree_guarantees(String three_guarantees) {
		this.three_guarantees = three_guarantees;
	}
	public String getDealer() {
		return dealer;
	}
	public void setDealer(String dealer) {
		this.dealer = dealer;
	}
	public String getVehicle_note() {
		return vehicle_note;
	}
	public void setVehicle_note(String vehicle_note) {
		this.vehicle_note = vehicle_note;
	}
	public String getVehicle_classification() {
		return vehicle_classification;
	}
	public void setVehicle_classification(String vehicle_classification) {
		this.vehicle_classification = vehicle_classification;
	}
	public String getVehicle_type() {
		return vehicle_type;
	}
	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}
	public String getRange_rover() {
		return range_rover;
	}
	public void setRange_rover(String range_rover) {
		this.range_rover = range_rover;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_type() {
		return customer_type;
	}
	public void setCustomer_type(String customer_type) {
		this.customer_type = customer_type;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDriver_name() {
		return driver_name;
	}
	public void setDriver_name(String driver_name) {
		this.driver_name = driver_name;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public Date getBrithday() {
		return brithday;
	}
	public void setBrithday(Date brithday) {
		this.brithday = brithday;
	}
	public String getId_number() {
		return id_number;
	}
	public void setId_number(String id_number) {
		this.id_number = id_number;
	}
	public String getMove_number() {
		return move_number;
	}
	public void setMove_number(String move_number) {
		this.move_number = move_number;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getDriver_license_number() {
		return driver_license_number;
	}
	public void setDriver_license_number(String driver_license_number) {
		this.driver_license_number = driver_license_number;
	}
	public String getQuasi_driving_type() {
		return quasi_driving_type;
	}
	public void setQuasi_driving_type(String quasi_driving_type) {
		this.quasi_driving_type = quasi_driving_type;
	}
	public Date getOpening_date() {
		return opening_date;
	}
	public void setOpening_date(Date opening_date) {
		this.opening_date = opening_date;
	}
	public Date getExpiry_date() {
		return expiry_date;
	}
	public void setExpiry_date(Date expiry_date) {
		this.expiry_date = expiry_date;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	public String getOffice_telephone() {
		return office_telephone;
	}
	public void setOffice_telephone(String office_telephone) {
		this.office_telephone = office_telephone;
	}
	public String getVehicle_id() {
		return vehicle_id;
	}
	public void setVehicle_id(String vehicle_id) {
		this.vehicle_id = vehicle_id;
	}
	@Override
	public String toString() {
		return "RepairDetails ["+"vehicle_id"+vehicle_id+"vehicle_number=" + vehicle_number + ", source=" + source + ", nature=" + nature
				+ ", engine_number=" + engine_number + ", chassis_number=" + chassis_number + ", gearbox_number="
				+ gearbox_number + ", category=" + category + ", aircraft_type=" + aircraft_type + ", vin=" + vin
				+ ", internal_number=" + internal_number + ", color=" + color + ", model_definition_id="
				+ model_definition_id + ", customer_archives_id=" + customer_archives_id + ", driver_id=" + driver_id
				+ ", three_guarantees=" + three_guarantees + ", dealer=" + dealer + ", vehicle_note=" + vehicle_note
				+ ", vehicle_classification=" + vehicle_classification + ", vehicle_type=" + vehicle_type
				+ ", range_rover=" + range_rover + ", brand=" + brand + ", customer_id=" + customer_id
				+ ", customer_type=" + customer_type + ", area=" + area + ", customer_name=" + customer_name
				+ ", postcode=" + postcode + ", province=" + province + ", region=" + region + ", address=" + address
				+ ", fax=" + fax + ", company=" + company + ", driver_name=" + driver_name + ", gender=" + gender
				+ ", duty=" + duty + ", brithday=" + brithday + ", id_number=" + id_number + ", move_number="
				+ move_number + ", phone_number=" + phone_number + ", driver_license_number=" + driver_license_number
				+ ", quasi_driving_type=" + quasi_driving_type + ", opening_date=" + opening_date + ", expiry_date="
				+ expiry_date + ", e_mail=" + e_mail + ", office_telephone=" + office_telephone + "]";
	}
	
	
	
	
}
