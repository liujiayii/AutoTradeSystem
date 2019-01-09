package com.autotrade.entity;

import java.math.BigDecimal;
/**
 * 
 *
 * @ClassName: Expenditure

 * @description 支出表
 *
 * @author lishaozhang
 * @createDate 2019年1月4日
 */
public class Expenditure {
    private Long id;
   /**支出项目*/
    private String expenditure;
    /**支出摘要*/
    private String detailedExpenditure;
     /**部门id*/
    private Long departmentId;
    /**支出金额*/
    private BigDecimal expenditureMoney;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExpenditure() {
        return expenditure;
    }

    public void setExpenditure(String expenditure) {
        this.expenditure = expenditure == null ? null : expenditure.trim();
    }

    public String getDetailedExpenditure() {
        return detailedExpenditure;
    }

    public void setDetailedExpenditure(String detailedExpenditure) {
        this.detailedExpenditure = detailedExpenditure == null ? null : detailedExpenditure.trim();
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public BigDecimal getExpenditureMoney() {
        return expenditureMoney;
    }

    public void setExpenditureMoney(BigDecimal expenditureMoney) {
        this.expenditureMoney = expenditureMoney;
    }

	@Override
	public String toString() {
		return "TExpenditure [id=" + id + ", expenditure=" + expenditure + ", detailedExpenditure="
				+ detailedExpenditure + ", departmentId=" + departmentId + ", expenditureMoney=" + expenditureMoney
				+ "]";
	}
    
    
}