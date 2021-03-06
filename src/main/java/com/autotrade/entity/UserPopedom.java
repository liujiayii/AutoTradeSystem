package com.autotrade.entity;

import java.io.Serializable;
import java.util.Date;

/**
  * @ClassName: UserPopedom
  * @description 用户权限表实体类
  * @author ZhaoSong
  * @createDate 2019年1月4日
 */
public class UserPopedom implements Serializable{

	/**  序列化id */
	private static final long serialVersionUID = 8632581979058773293L;
	
	/**
	 * 主键id
	 */
	private Long id;
	/**
	 * 功能id(权限表id)
	 */
	private Integer pId;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "UserPopedom [id=" + id + ", pId=" + pId + ", userId=" + userId + ", updateTime=" + updateTime + "]";
	}
	
}
