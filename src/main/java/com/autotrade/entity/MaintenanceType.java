package com.autotrade.entity;

/**
 * 维修类型表实体类
 *
 * @ClassName: MaintenanceType

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年2月20日-上午9:39:51
 */
public class MaintenanceType {

	// 主键
	private Long id; 
	// 维修类型
	private String name;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "MaintenanceType [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
