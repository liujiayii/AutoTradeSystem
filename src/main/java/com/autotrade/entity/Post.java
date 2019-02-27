package com.autotrade.entity;

import java.util.Date;

/**
 * 职位表实体类
 *
 * @ClassName: Post

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年2月20日-下午4:29:06
 */
public class Post {

	// 主键
	private Long id;
	// 职位
	private String post;
	// 创建时间
	private Date create_time;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	
	@Override
	public String toString() {
		return "Post [id=" + id + ", post=" + post + ", create_time=" + create_time + "]";
	}
	
	
}
