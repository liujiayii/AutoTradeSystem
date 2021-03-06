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

	/** 主键id */
	private Long id;
	/** 买车的客户id */
	private Long buying_id;
	/** 付款类型  1.全款 2.分期*/
	private Integer type;
	/** 首付款 */
	private BigDecimal first_payment;
	/** 月供 */
	private BigDecimal monthly_supply;
	/** 分期月数 */
	private Integer monthly_number;
	/** 车辆售价 */
	private BigDecimal s_money;
	/** 客户上保险地址 1.本店 2.外部 */
	private Integer insurance;
	/** 最后成交额 */
	private BigDecimal money;
	/** 创建时间 */
	private Date create_time;
	/** 修改时间 */
	private Date update_time;
	/** 入库编号 */
	private String vehile_number;
	/** 备注 */
	private String remark;
	/** 制单人 */
	private String single_person;
	/** 业务员 */
	private String person;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBuying_id() {
		return buying_id;
	}

	public void setBuying_id(Long buying_id) {
		this.buying_id = buying_id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public BigDecimal getFirst_payment() {
		return first_payment;
	}

	public void setFirst_payment(BigDecimal first_payment) {
		this.first_payment = first_payment;
	}

	public BigDecimal getMonthly_supply() {
		return monthly_supply;
	}

	public void setMonthly_supply(BigDecimal monthly_supply) {
		this.monthly_supply = monthly_supply;
	}

	public Integer getMonthly_number() {
		return monthly_number;
	}

	public void setMonthly_number(Integer monthly_number) {
		this.monthly_number = monthly_number;
	}

	public BigDecimal getS_money() {
		return s_money;
	}

	public void setS_money(BigDecimal s_money) {
		this.s_money = s_money;
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

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public String getVehile_number() {
		return vehile_number;
	}

	public void setVehile_number(String vehile_number) {
		this.vehile_number = vehile_number;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSingle_person() {
		return single_person;
	}

	public void setSingle_person(String single_person) {
		this.single_person = single_person;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "CarInformation [id=" + id + ", buying_id=" + buying_id + ", type=" + type + ", first_payment="
				+ first_payment + ", monthly_supply=" + monthly_supply + ", monthly_number=" + monthly_number
				+ ", s_money=" + s_money + ", insurance=" + insurance + ", money=" + money + ", create_time="
				+ create_time + ", update_time=" + update_time + ", vehile_number=" + vehile_number + ", remark="
				+ remark + ", single_person=" + single_person + ", person=" + person + "]";
	}
	
}
