package com.autotrade.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 维修修理单表实体类
 *
 * @ClassName: RepairProject

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年2月20日-下午5:00:06
 */
public class RepairProject {
	
	// 主键
	private Long id;
	// 项目名称
	private String name;
	// 维修工单id
	private Long repair_id;
	// 工时
	private Integer working_hours;
	// 工时单价
	private BigDecimal price;
	// 总的工时费
	private BigDecimal money;
	// 维修人
	private String repairman;
	// 创建时间
	private Date create_time;
	
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
	public Long getRepair_id() {
		return repair_id;
	}
	public void setRepair_id(Long repair_id) {
		this.repair_id = repair_id;
	}
	public Integer getWorking_hours() {
		return working_hours;
	}
	public void setWorking_hours(Integer working_hours) {
		this.working_hours = working_hours;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public String getRepairman() {
		return repairman;
	}
	public void setRepairman(String repairman) {
		this.repairman = repairman;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	
	@Override
	public String toString() {
		return "RepairProject [id=" + id + ", name=" + name + ", repair_id=" + repair_id + ", working_hours="
				+ working_hours + ", price=" + price + ", money=" + money + ", repairman=" + repairman
				+ ", create_time=" + create_time + "]";
	}
	
	
	
}
