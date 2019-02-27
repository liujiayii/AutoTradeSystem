package com.autotrade.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.autotrade.entity.Parts;

/**
 * 领料详情表dao层
 *
 * @ClassName: PartsDao

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年2月21日-上午10:00:21
 */
public interface PartsDao {
	/**
	 * 
	*
	 * @Title: insert
	
	 * @description 插入
	*
	 * @param @return 
	   
	 * @return Integer    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年2月22日
	 */
	Integer insert(Parts parts);
	/**
	 * 
	*
	 * @Title: deleteById
	
	 * @description 删除
	*
	 * @param @param id
	 * @param @return 
	   
	 * @return Integer    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年2月22日
	 */
	Integer deleteById(Long id);
	/**
	 * 
	*
	 * @Title: selectAll
	
	 * @description 分页查询
	*
	 * @param @return 
	   
	 * @return List<Parts>    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年2月22日
	 */
	List<Parts> selectAll();
	
	/***
	 * 
	*
	 * @Title: selectAllCount
	
	 * @description 查询所有数据数量
	 *
	 * @param @return 
	   
	 * @return Integer    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年2月22日
	 */
	Integer selectAllCount();
	/**
	 * 
	 * 
	*
	 * @Title: selectById
	
	 * @description 
	*
	 * @param @param id
	 * @param @return 
	   
	 * @return Parts    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年2月22日
	 */
	Parts selectById(Long id);
	/**
	 * 
	*
	 * @Title: updateByid
	
	 * @description 
	*
	 * @param @param parts
	 * @param @return 
	   
	 * @return Integer    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年2月22日
	 */
	Integer updateByid(Parts parts);
	/**
	 * 
	*
	 * @Title: selectPartsShow
	
	 * @description 
	*
	 * @param @param repair_id
	 * @param @param star
	 * @param @param limit
	 * @param @return 
	   
	 * @return List<Parts>    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年2月24日
	 */
	List<Parts> selectPartsShow(@Param("repair_id")Long repair_id,@Param("star") Integer star,@Param("limit") Integer limit);
	
	/**
	 * 
	*
	 * @Title: selectPartsShowCount
	
	 * @description 
	*
	 * @param @param repair_id
	 * @param @return 
	   
	 * @return Integer    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年2月24日
	 */
	Integer selectPartsShowCount(Long repair_id);
}
