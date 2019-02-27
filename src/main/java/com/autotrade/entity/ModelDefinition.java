package com.autotrade.entity;


/**
  * @ClassName: ModelDefinition
  * @description 维修车型定义表
  * @author ZhaoSong
  * @createDate 2019年2月19日
 */
public class ModelDefinition {
	
	/**
	 * 主键Id
	 */
	private Long model_definition_id;
	/**
	 * 维修车型分类表id
	 */
	private Long vehicle_classification_id;
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
	public Long getModel_definition_id() {
		return model_definition_id;
	}
	public void setModel_definition_id(Long model_definition_id) {
		this.model_definition_id = model_definition_id;
	}
	public Long getVehicle_classification_id() {
		return vehicle_classification_id;
	}
	public void setVehicle_classification_id(Long vehicle_classification_id) {
		this.vehicle_classification_id = vehicle_classification_id;
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
	@Override
	public String toString() {
		return "ModelDefinition [model_definition_id=" + model_definition_id + ", vehicle_classification_id="
				+ vehicle_classification_id + ", vehicle_type=" + vehicle_type + ", range_rover=" + range_rover
				+ ", brand=" + brand + "]";
	}
}
