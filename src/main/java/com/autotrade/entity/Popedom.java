package com.autotrade.entity;

import java.io.Serializable;
import java.util.Date;

/**
  * @ClassName: Popedom
  * @description 权限表实体类
  * @author ZhaoSong
  * @createDate 2019年1月4日
 */
public class Popedom implements Serializable{

	/**  序列化id*/
	private static final long serialVersionUID = -3740164800228681785L;
	/**
	 * 功能表id主键
	 */
	private Integer id;
	/**
	 * 权限名称
	 */
	private String popedomName;
	/**
	 * 权限id
	 */
	private Long pId;
	/**
	 * 功能路径
	 */
	private String popedomUrl;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPopedomName() {
		return popedomName;
	}
	public void setPopedomName(String popedomName) {
		this.popedomName = popedomName;
	}
	public Long getpId() {
		return pId;
	}
	public void setpId(Long pId) {
		this.pId = pId;
	}
	public String getPopedomUrl() {
		return popedomUrl;
	}
	public void setPopedomUrl(String popedomUrl) {
		this.popedomUrl = popedomUrl;
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
		return "Popedom [id=" + id + ", popedomName=" + popedomName + ", pId=" + pId + ", popedomUrl=" + popedomUrl
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}
	
}
