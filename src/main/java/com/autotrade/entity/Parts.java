package com.autotrade.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 领料详情表实体
 *
 * @ClassName: Parts

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年2月21日-上午9:54:52
 */
public class Parts {
	
	// 主键
	private Long id;
	// 配件编号id（和库存配件的id对应）
	/*private String commodity_number;*/
	// 数量
	private Integer number;
	// 单价
	private BigDecimal price;
	// 总价钱
	private BigDecimal money;
	// 维修工单id
	private Long repair_id;
	// 创建时间
	private Date create_time;
	//品牌
	private String brand;
	//型号
	private String model;
	//型号
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
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
	public Long getRepair_id() {
		return repair_id;
	}
	public void setRepair_id(Long repair_id) {
		this.repair_id = repair_id;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Parts [id=" + id + ",, number=" + number + ", price=" + price
				+ ", money=" + money + ", repair_id=" + repair_id + ", create_time=" + create_time + ", brand=" + brand
				+ ", model=" + model + ", name=" + name + "]";
	}
	
	
	
	
}
