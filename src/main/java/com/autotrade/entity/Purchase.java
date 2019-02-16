package com.autotrade.entity;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 
 *
 * @ClassName: Purchase

 * @description 采购表
 *
 * @author lishaozhang
 * @createDate 2019年1月4日
 */
public class Purchase {
	
    private Long id;
    /**姓名*/
    private String name;
    /**采购详情*/
    private String purchase;
    /**采购金额*/
    private BigDecimal purchaseMoney;
    /**时间*/
    private Date createTime;
    /** 类型 */
    private String type;
    /** 制单人 */
    private String singName;
    /** 备注 */
    private String remark;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPurchase() {
        return purchase;
    }

    public void setPurchase(String purchase) {
        this.purchase = purchase == null ? null : purchase.trim();
    }

    public BigDecimal getPurchaseMoney() {
        return purchaseMoney;
    }

    public void setPurchaseMoney(BigDecimal purchaseMoney) {
        this.purchaseMoney = purchaseMoney;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSingName() {
		return singName;
	}

	public void setSingName(String singName) {
		this.singName = singName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Purchase [id=" + id + ", name=" + name + ", purchase=" + purchase + ", purchaseMoney=" + purchaseMoney
				+ ", createTime=" + createTime + ", type=" + type + ", singName=" + singName + ", remark=" + remark
				+ "]";
	}

    
}