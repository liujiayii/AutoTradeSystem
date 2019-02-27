package com.autotrade.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.autotrade.entity.ModelDefinition;
import com.sun.org.glassfish.gmbal.ParameterNames;

public interface ModelDefinitionDao {

	
	/**
	  * @Title: insertModelDefinition
	  * @description 添加车辆类型信息
	  * @param @param modelDefinition 车辆类型对象
	  * @return Integer 受影响行数
	  * @author ZhaoSong
	  * @createDate 2019年2月20日
	 */
	Integer insertModelDefinition(ModelDefinition modelDefinition);
	
	/**
	  * @Title: findByRangeRover
	  * @description 通过车名查询车辆类型
	  * @param @param range_rover 车名
	  * @return ModelDefinition 车辆类型对象  
	  * @author ZhaoSong
	  * @createDate 2019年2月21日
	 */
	ModelDefinition findByRangeRover(String range_rover);
	
	/**
	  * @Title: findCarTypeByLimit
	  * @description 分页查询车型信息
	  * @param @param page 页数
	  * @param @param limit 每页显示条数
	  * @return List<ModelDefinition> 返回车型信息集合   
	  * @author ZhaoSong
	  * @createDate 2019年2月21日
	 */
	List<ModelDefinition> findCarTypeByLimit(@Param("page")Integer page,@Param("limit")Integer limit);
	
	/**
	  * @Title: findCarTypeSum
	  * @description 查询车型分类信息条数
	  * @return Integer  符合条件的条数  
	  * @author ZhaoSong
	  * @createDate 2019年2月21日
	 */
	Integer findCarTypeSum();
	
	/**
	  * @Title: findCarTypeByKeyWord
	  * @description 根据关键字分页查询车型信息
	  * @param @param page 页数
	  * @param @param limit 每页显示条数
	  * @param @param keyWord 关键字
	  * @return List<ModelDefinition> 符合天剑的车型信息集合    
	  * @author ZhaoSong
	  * @createDate 2019年2月21日
	 */
	List<ModelDefinition> findCarTypeByKeyWord(@Param("page")Integer page,@Param("limit")Integer limit,@Param("keyWord")String keyWord);
	
	/**
	  * @Title: findCountByLimit
	  * @description 查询符合关键字条件的车型信息条数
	  * @param @param page 页数
	  * @return Integer  返回条数  
	  * @author ZhaoSong
	  * @createDate 2019年2月21日
	 */
	Integer findCountByLimit(@Param("keyWord")String keyWord);
	
	
	/**
	  * @Title: updateCarType
	  * @description 修改车型信息
	  * @param @param modelDefinition 车型信息
	  * @return Integer 生效行数   
	  * @author ZhaoSong
	  * @createDate 2019年2月21日
	 */
	Integer updateCarType(ModelDefinition modelDefinition);
	
	/**
	  * @Title: findCarType
	  * @description 查询车型
	  * @param @param vehicle_classification_id 维修车型分类表Id
	  * @param @param range_rover 车名
	  * @return ModelDefinition 返回车辆信息   
	  * @author ZhaoSong
	  * @createDate 2019年2月26日
	 */
	ModelDefinition findCarType(@Param("vehicle_classification_id")Long vehicle_classification_id,@Param("range_rover")String range_rover);
	
	
	
	/**
	  * @Title: findCarNameByid
	  * @description 根据车型id查车名
	  * @param @param id 车型id
	  * @return ModelDefinition 车型信息    
	  * @author ZhaoSong
	  * @createDate 2019年2月26日
	 */
	List<ModelDefinition> findCarNameByid(Long id);
	
	
	
	
	
	
	
	
	
}
