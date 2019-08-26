package com.autotrade.entityVo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.autotrade.entity.Purchase;

public class PurchaseList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 /**采购人*/
    private String name;
    /**采购金额*/
    private BigDecimal purchaseMoney;
    /**时间*/
    private Date createTime;
    /** 制单人 */
    private String singName;
    /** 备注 */
    private String remark;
    /*是否入库*/
    private Integer library;
	private List<Purchase> purchases;
	
	public PurchaseList() {
		super();
	}
	public PurchaseList(String name, BigDecimal purchaseMoney, Date createTime, String singName, String remark,
			Integer library, List<Purchase> purchases) {
		super();
		this.name = name;
		this.purchaseMoney = purchaseMoney;
		this.createTime = createTime;
		this.singName = singName;
		this.remark = remark;
		this.library = library;
		this.purchases = purchases;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Integer getLibrary() {
		return library;
	}
	public void setLibrary(Integer library) {
		this.library = library;
	}
	public List<Purchase> getPurchases() {
		return purchases;
	}
	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((library == null) ? 0 : library.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((purchaseMoney == null) ? 0 : purchaseMoney.hashCode());
		result = prime * result + ((purchases == null) ? 0 : purchases.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((singName == null) ? 0 : singName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PurchaseList other = (PurchaseList) obj;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (library == null) {
			if (other.library != null)
				return false;
		} else if (!library.equals(other.library))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (purchaseMoney == null) {
			if (other.purchaseMoney != null)
				return false;
		} else if (!purchaseMoney.equals(other.purchaseMoney))
			return false;
		if (purchases == null) {
			if (other.purchases != null)
				return false;
		} else if (!purchases.equals(other.purchases))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (singName == null) {
			if (other.singName != null)
				return false;
		} else if (!singName.equals(other.singName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PurchaseList [name=" + name + ", purchaseMoney=" + purchaseMoney + ", createTime=" + createTime
				+ ", singName=" + singName + ", remark=" + remark + ", library=" + library + ", purchases=" + purchases
				+ "]";
	}
	

}
