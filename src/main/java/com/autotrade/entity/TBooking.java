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
	/*订车主键id */
    private Long id;
    /*买车客户id	*/
    private Long buyingId;
    /*车型代码 */	
    private String vehicleCode;
    /*预定数量 */
    private Integer number;
    /*订金 */
    private Long deposit;
    /*订车日期 */
    private Date time;
    /* 业务员*/
    private String business;
    /* 制单让人*/
    private String singlePerson;
    /*备注*/
    private String remark;
    /*创建时间 */
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