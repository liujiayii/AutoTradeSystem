package com.autotrade.dao;

import com.autotrade.entity.CarInformation;


import java.util.List;
import org.apache.ibatis.annotations.Param;
/**
 * 
 *
 * @ClassName: CarInformationDao

 * @description dao接口
 *
 * @author lishaozhang
 * @createDate 2019年1月4日
 */
public interface CarInformationDao {
	
	/**
	 * 
	*
	 * @Title: insertCarInformation
	
	 * @description 添加
	*
	 * @param @param record
	 * @param @return 
	   
	 * @return int    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年1月4日
	 */
	Integer insertCarInformation(CarInformation record);
   /***
    * 
   *
    * @Title: insertSelective
   
    * @description 添加
   *
    * @param @param record
    * @param @return 
      
    * @return int    
   
    *
    * @author lishaozhang
    * @createDate 2019年1月4日
    */
	Integer insertSelective(CarInformation record);
	
	
	/**
	 * 
	*
	 * @Title: deleteByPrimaryKey
	
	 * @description 通过主键删除
	 *
	 * @param @param id
	 * @param @return 
	   
	 * @return int    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年1月4日
	 */
	Integer deleteByPrimaryKey(Long id);
    /**
     * 
    *
     * @Title: deleteByBuying_id
    
     * @description 通过买车客户id删除
    *
     * @param @param id
     * @param @return 
       
     * @return Integer    
    
     *
     * @author lishaozhang
     * @createDate 2019年1月4日
     */
    Integer deleteByBuying_id(Long id);
    
    
    
    /**
     * 
    *
     * @Title: updateCarInformation
    
     * @description 修改（空参将替换为空）
    *
     * @param @param record
     * @param @return 
       
     * @return Integer    
    
     *
     * @author lishaozhang
     * @createDate 2019年1月4日
     */
    Integer updateCarInformation(CarInformation record);
    
	/**
	 * 
	*
	 * @Title: updateByPrimaryKey
	
	 * @description 修改（空参维持原状）
	*
	 * @param @param record
	 * @param @return 
	   
	 * @return Integer    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年1月4日
	 */
	 Integer updateByPrimaryKey(CarInformation record);
    
	 /**
	  * 
	 *
	  * @Title: selectAllCarInformation
	 
	  * @description 分页查询所有售车信息
	 *
	  * @param @return 
	    
	  * @return List<CarInformation>    
	 
	  *
	  * @author lishaozhang
	  * @createDate 2019年1月4日
	  */
     List<CarInformation> selectAllCarInformation();
     /**
      * 
     *
      * @Title: selectAllCarInformationCount
     
      * @description 查询所有信息数量
     *
      * @param @return 
        
      * @return Integer    
     
      *
      * @author lishaozhang
      * @createDate 2019年1月4日
      */
     Integer selectAllCarInformationCount();
     
     /**
      * 
     *
      * @Title: selectCarInformationByBuying_id
     
      * @description 通过购买人id分页查询
     *
      * @param @param buying_id
      * @param @param star
      * @param @param limit
      * @param @return 
        
      * @return List<CarInformation>    
     
      *
      * @author lishaozhang
      * @createDate 2019年1月4日
      */
     List<CarInformation> selectCarInformationByBuying_id(@Param("buying_id") Long buying_id,@Param("star") Integer star,@Param("limit") Integer limit);
    
     /**
      * 
     *
      * @Title: selectCarInformationCountByBuying_id
     
      * @description 查询所有购买人所有买车信息的数量
     *
      * @param @param buying_id
      * @param @return 
        
      * @return Integer    
     
      *
      * @author xiaoyuchao
      * @createDate 2019年1月8日
      */
     Integer selectCarInformationCountByBuying_id(Long buying_id);
}