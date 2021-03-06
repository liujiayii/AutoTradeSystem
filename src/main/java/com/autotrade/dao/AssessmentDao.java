package com.autotrade.dao;

import com.autotrade.entity.Assessment;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameters;

public interface AssessmentDao {

	/**
	 * 
	 *
	 * @Title: insertAssessment
	 * 
	 * @description 添加评估信息
	 *
	 * @param @param
	 *            record
	 * @param @return
	 * 
	 * @return int
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年1月4日
	 */
	Integer insertAssessment(Assessment record);

	/**
	 * 
	 *
	 * @Title: deleteByPrimaryKey
	 * 
	 * @description 根据主键删除记录
	 *
	 * @param @param
	 *            id
	 * @param @return
	 * 
	 * @return Integer
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年1月4日
	 */
	Integer deleteByPrimaryKey(Long id);

	/**
	 * 
	 *
	 * @Title: deleteByBrand
	 * 
	 * @description 根据车牌号删除信息记录
	 *
	 * @param @param
	 *            brand
	 * @param @return
	 * 
	 * @return Integer
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年1月4日
	 */
	Integer deleteByBrand(String brand);

	/**
	 * 
	 *
	 * @Title: updateByPrimaryKey
	 * 
	 * @description 修改评估信息
	 *
	 * @param @param
	 *            record
	 * @param @return
	 * 
	 * @return Integer
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年1月4日
	 */
	Integer updateByPrimaryKey(Assessment record);

	/**
	 * 
	 *
	 * @Title: selectAll
	 * 
	 * @description 分页查询所有评估信息
	 *
	 * @param @return
	 * 
	 * @return List<Assessment>
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年1月4日
	 */
	List<Assessment> selectAll(@Param("star") Integer star, @Param("limit") Integer limit);

	/**
	 * 
	 *
	 * @Title: selectAllCount
	 * 
	 * @description 所有评估信息数量
	 *
	 * @param @return
	 * 
	 * @return Integer
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年1月4日
	 */
	Integer selectAllCount();

	/**
	 * 
	 *
	 * @Title: selectAssessmentById
	 * 
	 * @description 根据id查询资产评估信息
	 *
	 * @param @return
	 * 
	 * @return Assessment
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年1月4日
	 */
	Assessment selectAssessmentById(Long id);

	/***
	 * 
	 *
	 * @Title: selectAssessmentByBrand
	 * 
	 * @description 根据车牌号查询资产评估信息
	 *
	 * @param @return
	 * 
	 * @return Assessment
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年1月4日
	 */
	List<Assessment> selectAssessmentByBrand(@Param("brand")String brand,@Param("star") Integer star,
			@Param("limit") Integer limit);

	/**
	 * 
	 *
	 * @Title: selectAssessmentByIntention
	 * 
	 * @description 根据车型分页查询评估信息
	 *
	 * @param @param
	 *            intention
	 * @param @param
	 *            star
	 * @param @param
	 *            limit
	 * @param @return
	 * 
	 * @return List<Assessment>
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年1月4日
	 */
	List<Assessment> selectAssessmentByIntention(@Param("intention") String intention, @Param("star") Integer star,
			@Param("limit") Integer limit);

	/**
	 * 
	 *
	 * @Title: selectAssessmentCountByIntention
	 * 
	 * @description 查询某种车型数据的总数
	 *
	 * @param @param
	 *            intention
	 * @param @return
	 * 
	 * @return Integer
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年1月4日
	 */
	Integer selectAssessmentCountByIntention(String intention);

	/**
	 * 
	 *
	 * @Title: selectAssessmentByassessment_name
	 * 
	 * @description 根据 评估人姓名分页查询评估信息
	 *
	 * @param @param
	 *            assessment_name
	 * @param @param
	 *            star
	 * @param @param
	 *            limit
	 * @param @return
	 * 
	 * @return List<Assessment>
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年1月4日
	 */
	List<Assessment> selectAssessmentByassessment_name(@Param("assessment_name") String assessment_name,
			@Param("star") Integer star, @Param("limit") Integer limit);

	/**
	 * 
	 *
	 * @Title: selectAssessmentCountByassessment_name
	 * 
	 * @description 根据评估人姓名查询他、（评估人）办理业务的数量
	 *
	 * @param @param
	 *            assessment_name
	 * @param @return
	 * 
	 * @return Integer
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年1月4日
	 */
	Integer selectAssessmentCountByassessment_name(String assessment_name);
	/**
	 * 
	*
	 * @Title: selectAssessmentCountByBrand
	
	 * @description 
	*
	 * @param @param brand
	 * @param @return 
	   
	 * @return Integer    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年1月30日
	 */
	Integer selectAssessmentCountByBrand(String brand);
	
	/**
	 * 
	*
	 * @Title: selectAllselect
	
	 * @description 混合查询
	*
	 * @param @param assessment_name
	 * @param @param star
	 * @param @param limit
	 * @param @return 
	   
	 * @return List<Assessment>    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年1月30日
	 */
	List<Assessment> selectAllselect(@Param("assessment_name") String assessment_name,
			@Param("star") Integer star, @Param("limit") Integer limit);
	/**
	 * 
	*
	 * @Title: selectAllselectCount
	
	 * @description 混合查询数量
	*
	 * @param @param assessment_name
	 * @param @return 
	   
	 * @return Integer    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年1月30日
	 */
	Integer selectAllselectCount(@Param("assessment_name") String assessment_name);

}