package com.autotrade.entity;

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
    private Long strongDanger;
    /** 商业险金额 */
    private Long commercialInsurance;
    /** 创建时间 */
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

    public Long getStrongDanger() {
        return strongDanger;
    }

    public void setStrongDanger(Long strongDanger) {
        this.strongDanger = strongDanger;
    }

    public Long getCommercialInsurance() {
        return commercialInsurance;
    }

    public void setCommercialInsurance(Long commercialInsurance) {
        this.commercialInsurance = commercialInsurance;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	@Override
	public String toString() {
		return "Insurance [id=" + id + ", buyingId=" + buyingId + ", strongDanger=" + strongDanger
				+ ", commercialInsurance=" + commercialInsurance + ", createTime=" + createTime + "]";
	}
    
    
}