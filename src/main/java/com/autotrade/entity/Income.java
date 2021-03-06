package com.autotrade.entity;

import java.math.BigDecimal;
import java.util.Date;
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
    private String departmentId;
    /**收入项目*/
    private String income;
    /**收入金额*/
    private BigDecimal incomeMoney;
    /**收入摘要*/
    private String incomeDetailed;
    /**填写人姓名*/
    private String name;
    /**日期 前台给*/
    private Date data;    
    /**创建时间 自动生成*/
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date create_time) {
		this.createTime = create_time;
	}

	@Override
	public String toString() {
		return "Income [id=" + id + ", departmentId=" + departmentId + ", income=" + income + ", incomeMoney="
				+ incomeMoney + ", incomeDetailed=" + incomeDetailed + ", name=" + name + ", data=" + data
				+ ", createTime=" + createTime + "]";
	}

	
    
}