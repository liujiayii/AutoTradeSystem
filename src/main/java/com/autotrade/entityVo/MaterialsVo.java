package com.autotrade.entityVo;

import java.math.BigDecimal;

import com.autotrade.entity.Parts;
/**
  * @ClassName: MaterialsVo
  * @description 领料单打印辅助类
  * @author ZhaoSong
  * @createDate 2019年3月4日
 */
public class MaterialsVo extends Parts{
	//配件表Id
	private Long id ;
	//数量
	private Integer number;
	//单价
	private BigDecimal price;
	//总价
	private BigDecimal money;
	//型号
	private String model;
	//名称
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
		return "MaterialsVo [id=" + id + ", number=" + number + ", price=" + price + ", money=" + money 
				 + ", model=" + model + ", name=" + name + "]";
	}
	
}
