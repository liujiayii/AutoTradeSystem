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
    /**采购人*/
    private String name;
   
    /**采购金额*/
    private BigDecimal purchaseMoney;
    /**时间*/
    private Date createTime;
    /** 型号 */
    private String type;
    /*品牌*/
    private String brand;
    /**商品名称*/
    private String purchase;
    /*配件编号*/
    private String commodityNumber;
    /** 制单人 */
    private String singName;
    /** 备注 */
    private String remark;
  
    /** 采购数量 */
    private Integer quantity;
    /*单价*/
    private Integer priace;
    /*是否入库*/
    private Integer library;
    
    
    public Integer getLibrary() {
		return library;
	}

	public void setLibrary(Integer library) {
		this.library = library;
	}

	public Integer getPriace() {
		return priace;
	}

	public void setPriace(Integer priace) {
		this.priace = priace;
	}

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

	public String getCommodityNumber() {
		return commodityNumber;
	}

	public void setCommodityNumber(String commodityNumber) {
		this.commodityNumber = commodityNumber;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Purchase [id=" + id + ", name=" + name + ", purchase=" + purchase + ", purchaseMoney=" + purchaseMoney
				+ ", createTime=" + createTime + ", type=" + type + ", brand=" + brand + ", singName=" + singName
				+ ", remark=" + remark + ", commodityNumber=" + commodityNumber + ", quantity=" + quantity + ", priace="
				+ priace + ", library=" + library + "]";
	}
}