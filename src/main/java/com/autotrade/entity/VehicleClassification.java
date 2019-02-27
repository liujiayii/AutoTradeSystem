package com.autotrade.entity;


/**
  * @ClassName: VehicleClassification
  * @description 维修车型分类
  * @author ZhaoSong
  * @createDate 2019年2月19日
 */
public class VehicleClassification {

	/**
	 * 主键Id
	 */
	private Long id;
	/**
	 * 车型分类
	 */
	private String vehicle_classification;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVehicle_classification() {
		return vehicle_classification;
	}
	public void setVehicle_classification(String vehicle_classification) {
		this.vehicle_classification = vehicle_classification;
	}
	@Override
	public String toString() {
		return "VehicleClassification [id=" + id + ", vehicle_classification=" + vehicle_classification + "]";
	}
}
