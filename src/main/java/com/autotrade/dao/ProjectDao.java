package com.autotrade.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.autotrade.entity.Project;
import com.autotrade.entity.Relation;
import com.autotrade.entityVo.ProjectVo;

/**
 * 维修项目表dao层
 *
 * @ClassName: ProjectDao

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年2月20日-上午9:45:10
 */
public interface ProjectDao {

	/**
	 * 插入全部
	 *
	 * @Title: insertAll
	
	 * @description 
	 *
	 * @param project
	 * @return 
	   
	 * int
	 *
	 * @author lujinpeng
	 * @createDate 2019年2月20日-上午11:03:43
	 */
	public int insertAll(Project project);
	
	/**
	 * 插入指定数据
	 *
	 * @Title: insertSelective
	
	 * @description 
	 *
	 * @param project
	 * @return 
	   
	 * int
	 *
	 * @author lujinpeng
	 * @createDate 2019年2月20日-上午11:04:20
	 */
	public int insertSelective(Project project);
	/**
	 * 查询全部
	*@author lichangchun
	* @param star
	* @param limit
	* @return
	*@return List<Project>
	*@date 2019年2月21日    
	*
	 */
	List<ProjectVo> selectAll(@Param("star")Integer star,@Param("limit")Integer limit);
	
	/**
	 * 查询总数量
	*@author lichangchun
	* @return
	*@return Integer
	*@date 2019年2月21日    
	*
	 */
	  Integer countAll();
	
	 /**
	  * 通过指定条件查询
	  *
	  * @Title: selectBySelective
	 
	  * @description 
	  *
	  * @param map
	  * @return 
	    
	  * List<ProjectVo>
	  *
	  * @author lujinpeng
	  * @createDate 2019年2月21日-下午5:26:14
	  */
	 List<ProjectVo> selectBySelective(Map<String, Object> map);
	 
	 /**
	  * 指定条件查询获取数据总条数
	  *
	  * @Title: getCount
	 
	  * @description 
	  *
	  * @param map
	  * @return 
	    
	  * int
	  *
	  * @author lujinpeng
	  * @createDate 2019年2月21日-下午5:27:08
	  */
	 int getCount(Map<String, Object> map);
	 /**
	  * 
	 *@author lichangchun
	 * @param s
	 * @param star
	 * @param limit
	 * @return
	 *@return List<Project>
	 *@date 2019年2月22日    
	 *
	  */
	 List<ProjectVo> selectAllbytype(@Param("s")String s,@Param("star")Integer star,@Param("limit")Integer limit);
	 /**
	  * 
	 *@author lichangchun
	 * @param s
	 * @return
	 *@return Integer
	 *@date 2019年2月22日    
	 *
	  */
	 Integer countAllbytype(@Param("s")String s);
	 /**
	  * 设置工时
	 *@author lichangchun
	 * @param Relation
	 * @return
	 *@return int
	 *@date 2019年2月23日    
	 *
	  */
	 int AddRelation(Relation Relation);
	 
	 
	
}
