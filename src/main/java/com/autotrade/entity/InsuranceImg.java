package com.autotrade.entity;

import java.util.Date;

/**
 * 保险图片表实体
 *
 * @ClassName: InsuranceImg

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年3月4日-下午4:00:40
 */
public class InsuranceImg {

	// 主键
	private Long id;
	// 保险单id
	private Long insurance_id;
	// 图片地址
	private String url;
	// 创建时间
	private Date create_time;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getInsurance_id() {
		return insurance_id;
	}
	public void setInsurance_id(Long insurance_id) {
		this.insurance_id = insurance_id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	
	@Override
	public String toString() {
		return "InsuranceImg [id=" + id + ", insurance_id=" + insurance_id + ", url=" + url + ", create_time="
				+ create_time + "]";
	}
	
	
	
}
