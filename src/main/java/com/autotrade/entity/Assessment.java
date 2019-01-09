package com.autotrade.entity;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 
 *
 * @ClassName: Assessment

 * @description 评估实体类
 *
 * @author lishaozhang
 * @createDate 2019年1月4日
 */
public class Assessment {
	/**主键id*/
    private Long id;
    /**车型*/
    private String intention;
    /**车牌*/
    private String brand;
    /**评估金额*/
    private BigDecimal assessmentMoney;
    /**评估人*/
    private String assessmentName;
    /**时间*/
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIntention() {
        return intention;
    }

    public void setIntention(String intention) {
        this.intention = intention == null ? null : intention.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public BigDecimal getAssessmentMoney() {
        return assessmentMoney;
    }

    public void setAssessmentMoney(BigDecimal assessmentMoney) {
        this.assessmentMoney = assessmentMoney;
    }

    public String getAssessmentName() {
        return assessmentName;
    }

    public void setAssessmentName(String assessmentName) {
        this.assessmentName = assessmentName == null ? null : assessmentName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	@Override
	public String toString() {
		return "Assessment [id=" + id + ", intention=" + intention + ", brand=" + brand + ", assessmentMoney="
				+ assessmentMoney + ", assessmentName=" + assessmentName + ", createTime=" + createTime + "]";
	}
    
}