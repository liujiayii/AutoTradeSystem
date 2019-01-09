package com.autotrade.entity;

import java.math.BigDecimal;
/**
 * 
 *
 * @ClassName: Income

 * @description 收入表
 *
 * @author lishaozhang
 * @createDate 2019年1月4日
 */
public class Income {
    private Long id;
    /**部门id*/
    private Long departmentId;
    /**收入项目*/
    private String income;
    /**收入金额*/
    private BigDecimal incomeMoney;
    /**收入摘要*/
    private String incomeDetailed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income == null ? null : income.trim();
    }

    public BigDecimal getIncomeMoney() {
        return incomeMoney;
    }

    public void setIncomeMoney(BigDecimal incomeMoney) {
        this.incomeMoney = incomeMoney;
    }

    public String getIncomeDetailed() {
        return incomeDetailed;
    }

    public void setIncomeDetailed(String incomeDetailed) {
        this.incomeDetailed = incomeDetailed == null ? null : incomeDetailed.trim();
    }

	@Override
	public String toString() {
		return "TIncome [id=" + id + ", departmentId=" + departmentId + ", income=" + income + ", incomeMoney="
				+ incomeMoney + ", incomeDetailed=" + incomeDetailed + "]";
	}
    
}