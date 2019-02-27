package com.autotrade.entity;

import java.util.Date;

/**
  * @ClassName: DriverInformation
  * @description 驾驶员信息表
  * @author ZhaoSong
  * @createDate 2019年2月19日
 */
public class DriverInformation {
	
	/**
	 * 主键id
	 */
	private Long id;
	/**
	 * 驾驶员姓名
	 */
	private String driver_name;
	/**
	 * 性别
	 */
	private Integer gender;
	/**
	 * 职务
	 */
	private String duty;
	/**
	 * 出生日期
	 */
	private Date brithday;
	/**
	 * 身份证号
	 */
	private String id_number;
	/**
	 * 手机号码
	 */
	private String move_number;
	/**
	 * 住宅电话号码
	 */
	private String phone_number;
	/**
	 * 驾驶证号
	 */
	private String driver_license_number;
	/**
	 * 准驾车型
	 */
	private String quasi_driving_type;
	/**
	 * 发证日期
	 */
	private Date opening_date;
	/**
	 * 失效日期
	 */
	private Date expiry_date;
	/**
	 * 电子邮箱
	 */
	private String e_mail;
	/**
	 * 办公室电话
	 */
	private String office_telephone;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDriver_name() {
		return driver_name;
	}
	public void setDriver_name(String driver_name) {
		this.driver_name = driver_name;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public Date getBrithday() {
		return brithday;
	}
	public void setBrithday(Date brithday) {
		this.brithday = brithday;
	}
	public String getId_number() {
		return id_number;
	}
	public void setId_number(String id_number) {
		this.id_number = id_number;
	}
	public String getMove_number() {
		return move_number;
	}
	public void setMove_number(String move_number) {
		this.move_number = move_number;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getDriver_license_number() {
		return driver_license_number;
	}
	public void setDriver_license_number(String driver_license_number) {
		this.driver_license_number = driver_license_number;
	}
	public String getQuasi_driving_type() {
		return quasi_driving_type;
	}
	public void setQuasi_driving_type(String quasi_driving_type) {
		this.quasi_driving_type = quasi_driving_type;
	}
	public Date getOpening_date() {
		return opening_date;
	}
	public void setOpening_date(Date opening_date) {
		this.opening_date = opening_date;
	}
	public Date getExpiry_date() {
		return expiry_date;
	}
	public void setExpiry_date(Date expiry_date) {
		this.expiry_date = expiry_date;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	public String getOffice_telephone() {
		return office_telephone;
	}
	public void setOffice_telephone(String office_telephone) {
		this.office_telephone = office_telephone;
	}
	@Override
	public String toString() {
		return "DriverInformation [id=" + id + ", driver_name=" + driver_name + ", gender=" + gender + ", duty=" + duty
				+ ", brithday=" + brithday + ", id_number=" + id_number + ", move_number=" + move_number
				+ ", phone_number=" + phone_number + ", driver_license_number=" + driver_license_number
				+ ", quasi_driving_type=" + quasi_driving_type + ", opening_date=" + opening_date + ", expiry_date="
				+ expiry_date + ", e_mail=" + e_mail + ", office_telephone=" + office_telephone + "]";
	}
}
