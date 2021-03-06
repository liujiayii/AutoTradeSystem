package com.autotrade.entityVo;

import java.math.BigDecimal;
import java.util.Date;

import com.autotrade.entity.SellCar;

/**
  * @ClassName: SellCarVo
  * @description 售车页面展示
  * @author ZhaoSong
  * @createDate 2019年1月29日
 */
public class SellCarVo extends SellCar{

	
	/*姓名*/
	private String name;
	/*电话*/
	private String phone;
	/*地址*/
	private String address;
	/*所购车型*/
	private String vehicle_type;
	/*首付款*/
	private BigDecimal first_payment;
	/*创建时间*/
	private Date create_time;
	/*此订单关联用户的id*/
	private Long id;
	/*此售车订单的id*/
	private Long c_id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getVehicle_type() {
		return vehicle_type;
	}
	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}
	public BigDecimal getFirst_payment() {
		return first_payment;
	}
	public void setFirst_payment(BigDecimal first_payment) {
		this.first_payment = first_payment;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getC_id() {
		return c_id;
	}
	public void setC_id(Long c_id) {
		this.c_id = c_id;
	}
	@Override
	public String toString() {
		return "SellCarVo [name=" + name + ", phone=" + phone + ", address=" + address + ", vehicle_type="
				+ vehicle_type + ", first_payment=" + first_payment + ", create_time=" + create_time + ", id=" + id
				+ ", c_id=" + c_id + "]";
	}
	
}
