package com.autotrade.entity;

import java.io.Serializable;
import java.util.Date;

/**
  * @ClassName: User
  * @description 用户表实体类
  * @author ZhaoSong
  * @createDate 2019年1月4日
 */
public class User implements Serializable{

	/**  序列化ID */
	private static final long serialVersionUID = -6599381368815886262L;
	
	/**
	 * 用户id主键
	 */
	private Long id;
	/**
	 * 功能表id
	 */
	private Long pId;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 职务
	 */
	private String post;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 账号
	 */
	private String userName;
	/**
	 * 密码
	 */
	private String passWord;
	/**
	 * 用户状态
	 */
	private Integer status;
	/**
	 * Shiro配置文件使用字段
	 */
	private String keyWord;
	/**
	 * 所在公司地址id
	 */
	private String address;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getpId() {
		return pId;
	}
	public void setpId(Long pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", pId=" + pId + ", name=" + name + ", post=" + post + ", phone=" + phone
				+ ", userName=" + userName + ", passWord=" + passWord + ", status=" + status + ", keyWord=" + keyWord
				+ ", address=" + address + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}
}
