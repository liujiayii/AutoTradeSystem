package com.autotrade.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.stereotype.Component;

/**
  * @ClassName: SellCar
  * @description 售车模块实体类
  * @author ZhaoSong
  * @createDate 2019年1月29日
 */
public class SellCar {

	/*主键id*/
	private Long id;
	/*买车客户id*/
	private Long buyingId;
	/*付款类型。1全款   2分期*/
	private Integer type;
	/*首付款*/
	private BigDecimal firstPayment;
	/*月供*/
	private BigDecimal monthlySupply;
	/*分期月数*/
	private Integer monthlyNumber;
	/*上保险地址  1.本店   2.外部*/
	private Integer insurance;
	/*最后成交金额*/
	private BigDecimal money;
	/*创建时间*/
	private Date createTime;
	/*修改时间*/
	private Date updateTime;
	/*对应用户的信息*/
	private User user;
	/*车辆类型 0新车 1二手车*/
	private Integer types;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getBuyingId() {
		return buyingId;
	}
	public void setBuyingId(Long buyingId) {
		this.buyingId = buyingId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public BigDecimal getFirstPayment() {
		return firstPayment;
	}
	public void setFirstPayment(BigDecimal firstPayment) {
		this.firstPayment = firstPayment;
	}
	
	public BigDecimal getMonthlySupply() {
		return monthlySupply;
	}
	public void setMonthlySupply(BigDecimal monthlySupply) {
		this.monthlySupply = monthlySupply;
	}
	
	public Integer getMonthlyNumber() {
		return monthlyNumber;
	}
	public void setMonthlyNumber(Integer monthlyNumber) {
		this.monthlyNumber = monthlyNumber;
	}
	public Integer getInsurance() {
		return insurance;
	}
	public void setInsurance(Integer insurance) {
		this.insurance = insurance;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Integer getTypes() {
		return types;
	}
	public void setTypes(Integer types) {
		this.types = types;
	}
	@Override
	public String toString() {
		return "SellCar [id=" + id + ", buyingId=" + buyingId + ", type=" + type + ", firstPayment=" + firstPayment
				+ ", monthlySupply=" + monthlySupply + ", monthlyNumber=" + monthlyNumber + ", insurance=" + insurance
				+ ", money=" + money + ", createTime=" + createTime + ", updateTime=" + updateTime + ", user=" + user
				+ ", types=" + types + "]";
	}
	
}
