package com.autotrade.entity;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 保险表实体类
 *
 * @ClassName: Insurance

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年1月4日-下午2:07:06
 */
public class Insurance {
	/** 主键 */
    private Long id;
    /** 买车客户id */
    private Long buyingId;
    /** 强险金额 */
    private BigDecimal strongDanger;
    /** 商业险金额 */
    private BigDecimal commercialInsurance;
    /** 创建时间 */
    private Date createTime;
    /** 买车客户信息表 */
    private BuyingCustomer buyingCustomer;

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

    public BigDecimal getStrongDanger() {
        return strongDanger;
    }

    public void setStrongDanger(BigDecimal strongDanger) {
        this.strongDanger = strongDanger;
    }

    public BigDecimal getCommercialInsurance() {
        return commercialInsurance;
    }

    public void setCommercialInsurance(BigDecimal commercialInsurance) {
        this.commercialInsurance = commercialInsurance;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public BuyingCustomer getBuyingCustomer() {
		return buyingCustomer;
	}

	public void setBuyingCustomer(BuyingCustomer buyingCustomer) {
		this.buyingCustomer = buyingCustomer;
	}

	@Override
	public String toString() {
		return "Insurance [id=" + id + ", buyingId=" + buyingId + ", strongDanger=" + strongDanger
				+ ", commercialInsurance=" + commercialInsurance + ", createTime=" + createTime + ", buyingCustomer="
				+ buyingCustomer + "]";
	}

}