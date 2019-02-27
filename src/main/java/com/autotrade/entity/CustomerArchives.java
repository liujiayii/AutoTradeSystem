package com.autotrade.entity;

/**
  * @ClassName: CustomerArchives
  * @description 修车客户档案表
  * @author ZhaoSong
  * @createDate 2019年2月19日
 */
public class CustomerArchives {
	
	/**
	 * 主键id 
	 */
	private Long id;
	/**
	 * 客户编号
	 */
	private String customer_id;
	/**
	 * 客户类型
	 */
	private String customer_type;
	/**
	 * 区域
	 */
	private String area;
	/**
	 * 客户姓名
	 */
	private String customer_name;
	/**
	 * 邮编
	 */
	private String postcode;
	/**
	 * 电话号码
	 */
	private String phone_number;
	/**
	 * 省份
	 */
	private String province;
	/**
	 * 地区
	 */
	private String region;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 传真
	 */
	private String fax;
	/**
	 * 公司名称
	 */
	private String company;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_type() {
		return customer_type;
	}
	public void setCustomer_type(String customer_type) {
		this.customer_type = customer_type;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "CustomerArchives [id=" + id + ", customer_id=" + customer_id + ", customer_type=" + customer_type
				+ ", area=" + area + ", customer_name=" + customer_name + ", postcode=" + postcode + ", phone_number="
				+ phone_number + ", province=" + province + ", region=" + region + ", address=" + address + ", fax="
				+ fax + ", company=" + company + "]";
	}
	
}

