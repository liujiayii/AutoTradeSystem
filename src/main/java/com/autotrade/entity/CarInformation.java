package com.autotrade.entity;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 
 *
 * @ClassName: TCarInformation

 * @description 售车信息实体
 *
 * @author lishaozhang
 * @createDate 2019年1月4日
 */
public class CarInformation {
	/**主键id*/
    private Long id;
    /**买车的客户id*/
    private Long buyingId;
    /**付款类型*/
    private Integer type;
    /**首付款*/
    private BigDecimal firstPayment;

    private BigDecimal monthlySupply;
    /**分期月数*/
    private Integer monthlyNumber;
    /**客户上保险地址（1，本店，2，外部）*/
    private Integer insurance;
    /**最后成交额*/
    private BigDecimal money;
    /**创建时间*/
    private Date crateTime;
    /**修改时间*/
    private Date updateTime;
    /*所购车型*/
    private String vehicle_type;
    /*所购*/
    private String vehile_name;
    /*0代表新车，1代表二手车默认二手车*/
    private int types;

    public int getTypes() {
		return types;
	}

	public void setTypes(int types) {
		this.types = types;
	}

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

    public Date getCrateTime() {
        return crateTime;
    }

    public void setCrateTime(Date crateTime) {
        this.crateTime = crateTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

	public String getVehicle_type() {
		return vehicle_type;
	}

	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}

	public String getVehile_name() {
		return vehile_name;
	}

	public void setVehile_name(String vehile_name) {
		this.vehile_name = vehile_name;
	}

	@Override
	public String toString() {
		return "CarInformation [id=" + id + ", buyingId=" + buyingId + ", type=" + type + ", firstPayment="
				+ firstPayment + ", monthlySupply=" + monthlySupply + ", monthlyNumber=" + monthlyNumber
				+ ", insurance=" + insurance + ", money=" + money + ", crateTime=" + crateTime + ", updateTime="
				+ updateTime + ", vehicle_type=" + vehicle_type + ", vehile_name=" + vehile_name + ", types=" + types
				+ "]";
	}

    
    
}