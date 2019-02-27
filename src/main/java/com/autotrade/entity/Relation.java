package com.autotrade.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 车型，维修项目、维修类别关联表实体类
 *
 * @ClassName: Relation

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年2月20日-下午2:28:40
 */
public class Relation {

	// 主键
	private Long id;
	// 维修项目表id
	private Long project_id;
	// 车型分类表id
	private Long vehicle_classification_id;
	// 维修类别id
	private Long maintenance_parts_id;
	// 工时
	private Integer houser;
	// 单价
	private BigDecimal price;
	// 创建时间
	private Date create_time;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getProject_id() {
		return project_id;
	}
	public void setProject_id(Long project_id) {
		this.project_id = project_id;
	}
	public Long getVehicle_classification_id() {
		return vehicle_classification_id;
	}
	public void setVehicle_classification_id(Long vehicle_classification_id) {
		this.vehicle_classification_id = vehicle_classification_id;
	}
	public Long getMaintenance_parts_id() {
		return maintenance_parts_id;
	}
	public void setMaintenance_parts_id(Long maintenance_parts_id) {
		this.maintenance_parts_id = maintenance_parts_id;
	}
	public Integer getHouser() {
		return houser;
	}
	public void setHouser(Integer houser) {
		this.houser = houser;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	@Override
	public String toString() {
		return "Relation [id=" + id + ", project_id=" + project_id + ", vehicle_classification_id="
				+ vehicle_classification_id + ", maintenance_parts_id=" + maintenance_parts_id + ", houser=" + houser
				+ ", price=" + price + ", create_time=" + create_time + "]";
	}
	
	
	
}
