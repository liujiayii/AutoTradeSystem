package com.autotrade.entity;

/**
 * 维修项目表实体类
 *
 * @ClassName: Project

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年2月20日-上午9:33:46
 */
public class Project {
	// 主键
	private Long id;
	// 维修项目类型id
	private Long maintenance_type_id;
	// 具体维修项目
	private String name;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getMaintenance_type_id() {
		return maintenance_type_id;
	}
	public void setMaintenance_type_id(Long maintenance_type_id) {
		this.maintenance_type_id = maintenance_type_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Project [id=" + id + ", maintenance_type_id=" + maintenance_type_id + ", name=" + name + "]";
	}
	
	
}
