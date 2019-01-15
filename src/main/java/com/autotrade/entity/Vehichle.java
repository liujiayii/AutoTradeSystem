package com.autotrade.entity;

import java.util.Date;
/**
 * 
 *
 * @ClassName: Vehichle

 * @description 汽车管理实体类
 *
 * @author lishaozhang
 * @createDate 2019年1月10日
 */
public class Vehichle {
	/**主键 id*/
    private Long id;
    /**车型*/
    private String vehicleType;
    /**车牌*/
    private String brand;
    /**车类 1 代表新车 2代表旧车*/
    private Integer type;
    /**创建时间*/
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType == null ? null : vehicleType.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	@Override
	public String toString() {
		return "Vehichle [id=" + id + ", vehicleType=" + vehicleType + ", brand=" + brand + ", type=" + type
				+ ", createTime=" + createTime + "]";
	}
    
}