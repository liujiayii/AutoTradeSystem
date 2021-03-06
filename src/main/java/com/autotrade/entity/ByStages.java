package com.autotrade.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 分期表实体类
 *
 * @ClassName: ByStages

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年1月4日-下午1:40:34
 */
public class ByStages {
	/** 主键 */
    private Long id;
    /** 买车客户id */
    private Long buyingId;
    /** 总期数 */
    private Integer totalPeriod;
    /** 月供 */
    private BigDecimal monthlySupply;
    /** 时间 */
    private Date createTime;
    /** 贷款金额 */
    private BigDecimal loanAmount;
    /** 买车客户信息表 */
    private BuyingCustomer buyingCustomer;
    /** 状态（0，还款中，1，已还，2，逾期， 默认0） */
    private Integer type;

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

    public Integer getTotalPeriod() {
        return totalPeriod;
    }

    public void setTotalPeriod(Integer totalPeriod) {
        this.totalPeriod = totalPeriod;
    }

    public BigDecimal getMonthlySupply() {
        return monthlySupply;
    }

    public void setMonthlySupply(BigDecimal monthlySupply) {
        this.monthlySupply = monthlySupply;
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

	public BigDecimal getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ByStages [id=" + id + ", buyingId=" + buyingId + ", totalPeriod=" + totalPeriod + ", monthlySupply="
				+ monthlySupply + ", createTime=" + createTime + ", loanAmount=" + loanAmount + ", buyingCustomer="
				+ buyingCustomer + ", type=" + type + "]";
	}


}