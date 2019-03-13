package com.autotrade.dao;

import java.util.List;

import com.autotrade.entity.Post;

/**
 * 职位表dao层
 *
 * @ClassName: PostDao

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年2月20日-下午4:32:40
 */
public interface PostDao {

	/**
	 * 
	*
	 * @Title: selectAllPost
	
	 * @description 查询所有职位
	*
	 * @param @return 
	   
	 * @return List<Post>    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年3月6日
	 */
	List<Post> selectAllPost();
}
