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
import java.util.Date;
public class Expenditure {
    private Long id;
   /**支出项目*/
    private String expenditure;
    /**支出摘要*/
    private String detailedExpenditure;
     /**部门*/
    private String departmentId;
    /**支出金额*/
    private BigDecimal expenditureMoney;
    /**填写人姓名*/
    private String name;
    /**日期 前台给*/
    private Date data;    
    /**创建时间 自动生成*/
    private Date createTime;
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

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
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
		return "Expenditure [id=" + id + ", expenditure=" + expenditure + ", detailedExpenditure=" + detailedExpenditure
				+ ", departmentId=" + departmentId + ", expenditureMoney=" + expenditureMoney + ", name=" + name
				+ ", data=" + data + ", createTime=" + createTime + "]";
	}

	
    
    
}