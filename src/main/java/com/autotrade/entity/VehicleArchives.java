package com.autotrade.entity;

/**
  * @ClassName: VehicleArchives
  * @description 维修车辆档案实体类
  * @author ZhaoSong
  * @createDate 2019年2月19日
 */
public class VehicleArchives {
	
	/**
	 * 主键id
	 */
	private Long id;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "VehicleArchives [id=" + id + ", vehicle_number=" + vehicle_number + ", source=" + source + ", nature="
				+ nature + ", engine_number=" + engine_number + ", chassis_number=" + chassis_number
				+ ", gearbox_number=" + gearbox_number + ", category=" + category + ", aircraft_type=" + aircraft_type
				+ ", vin=" + vin + ", internal_number=" + internal_number + ", color=" + color
				+ ", model_definition_id=" + model_definition_id + ", customer_archives_id=" + customer_archives_id
				+ ", driver_id=" + driver_id + ", three_guarantees=" + three_guarantees + ", dealer=" + dealer
				+ ", vehicle_note=" + vehicle_note + "]";
	}
}	
