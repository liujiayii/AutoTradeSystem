package com.autotrade.entityVo;

public class StockVo {
	
	 private Long id;
	  /** 型号 */
    private String type;
    /*品牌*/
    private String brand;
    /**名称*/
    private String purchase;
    /*数量*/
    private Integer number;
    /*商品编号*/
    private String commodity_number;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getPurchase() {
		return purchase;
	}
	public void setPurchase(String purchase) {
		this.purchase = purchase;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getCommodity_number() {
		return commodity_number;
	}
	public void setCommodity_number(String commodity_number) {
		this.commodity_number = commodity_number;
	}
	@Override
	public String toString() {
		return "StockVo [id=" + id + ", type=" + type + ", brand=" + brand + ", purchase=" + purchase + ", number="
				+ number + ", commodity_number=" + commodity_number + "]";
	}
    

}
