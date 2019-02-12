package com.autotrade.entity;

import java.util.Date;
/**
 * 订车表
* @ClassName: TBooking
* @Description: TODO
* @author lichangchun
* @date 2019年2月11日
*
 */
public class TBooking {
    private Long id;

    private Long buyingId;

    private String vehicleCode;

    private Integer number;

    private Long deposit;

    private Date time;

    private String business;

    private String singlePerson;

    private String remark;

    private Date createTime;

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

    public String getVehicleCode() {
        return vehicleCode;
    }

    public void setVehicleCode(String vehicleCode) {
        this.vehicleCode = vehicleCode == null ? null : vehicleCode.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Long getDeposit() {
        return deposit;
    }

    public void setDeposit(Long deposit) {
        this.deposit = deposit;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business == null ? null : business.trim();
    }

    public String getSinglePerson() {
        return singlePerson;
    }

    public void setSinglePerson(String singlePerson) {
        this.singlePerson = singlePerson == null ? null : singlePerson.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	@Override
	public String toString() {
		return "TBooking [id=" + id + ", buyingId=" + buyingId + ", vehicleCode=" + vehicleCode + ", number=" + number
				+ ", deposit=" + deposit + ", time=" + time + ", business=" + business + ", singlePerson="
				+ singlePerson + ", remark=" + remark + ", createTime=" + createTime + "]";
	}
    
}