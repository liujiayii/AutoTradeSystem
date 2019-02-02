package com.autotrade.entity;

import java.util.Date;

/***
 * 部门表
 *
 * @ClassName: Department

 * @description 用一句话描述这个类的作用
 *
 * @author lishaozhang
 * @createDate 2019年1月31日
 */
public class Department {
    /**主键*/
	private Long id;
	/**部门名称*/
	private String department;
	/**创建时间*/
	private Date create_time;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", department=" + department + ", create_time=" + create_time + "]";
	}
	
	
	
	
}
