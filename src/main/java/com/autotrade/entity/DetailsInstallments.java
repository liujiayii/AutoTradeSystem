package com.autotrade.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.experimental.theories.FromDataPoints;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 分期详情表实体类
 *
 * @ClassName: DetailsInstallments

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年1月4日-下午1:56:02
 */
public class DetailsInstallments {
	/** 主键 */
    private Long id;
    /** 买车客户id */
    private Long buyingId;
    /** 当前期数 */
    private Integer nowStage;
    /** 还款日 */
    private Date repaymentDate;
    /** 状态（0，还款中，1，已还，2，逾期， 默认0） */
    private Integer beOverdue;
    /** 创建时间 */
    private Date createTime;
    /** 分期表对象 */
    private ByStages byStages;

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

    public Integer getNowStage() {
        return nowStage;
    }

    public void setNowStage(Integer nowStage) {
        this.nowStage = nowStage;
    }

    public Date getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(Date repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public Integer getBeOverdue() {
        return beOverdue;
    }

    public void setBeOverdue(Integer beOverdue) {
        this.beOverdue = beOverdue;
    }

	public ByStages getByStages() {
		return byStages;
	}

	public void setByStages(ByStages byStages) {
		this.byStages = byStages;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "DetailsInstallments [id=" + id + ", buyingId=" + buyingId + ", nowStage=" + nowStage
				+ ", repaymentDate=" + repaymentDate + ", beOverdue=" + beOverdue + ", createTime=" + createTime
				+ ", byStages=" + byStages + "]";
	}


}