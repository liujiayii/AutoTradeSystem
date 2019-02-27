package com.autotrade.entityVo;

import java.math.BigDecimal;
/**
 * 
 *
 * @ClassName: PartsShow

 * @description 工单用料展示
 *
 * @author lishaozhang
 * @createDate 2019年2月23日
 */
public class PartsShow {
	/**配件编号*/
	private String commodity_number;
	
	/**名称*/
	private String purchase;
	
	/**车辆类型**/
	private String vehicle_type;
	
	/**数量*/
	private Integer number;
	
	/**工单号*/
	private Long repair_id;
	
	/**单价*/
	private BigDecimal price;
	
	/**总价*/
	private BigDecimal money;

	public String getCommodity_number() {
		return commodity_number;
	}

	public void setCommodity_number(String commodity_number) {
		this.commodity_number = commodity_number;
	}

	public String getPurchase() {
		return purchase;
	}

	public void setPurchase(String purchase) {
		this.purchase = purchase;
	}

	public String getVehicle_type() {
		return vehicle_type;
	}

	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Long getRepair_id() {
		return repair_id;
	}

	public void setRepair_id(Long repair_id) {
		this.repair_id = repair_id;
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

	@Override
	public String toString() {
		return "PartsShow [commodity_number=" + commodity_number + ", purchase=" + purchase + ", vehicle_type="
				+ vehicle_type + ", number=" + number + ", repair_id=" + repair_id + ", price=" + price + ", money="
				+ money + "]";
	}
	
}
