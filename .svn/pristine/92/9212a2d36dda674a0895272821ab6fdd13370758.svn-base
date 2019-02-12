package com.autotrade.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.autotrade.entity.VehichileDetailed;

/**
 * 
 *
 * @ClassName: VehichileDetailedDao

 * @description 车型代码信息dao
 *
 * @author lishaozhang
 * @createDate 2019年2月11日
 */
public interface VehichileDetailedDao {
   
    /**
     * 通过主键删除
     * */
    int deleteByPrimaryKey(Long id);
    /**
     * 添加
     * */
    int insert(VehichileDetailed record);
    /***
     * 添加
     * */
    int insertSelective(VehichileDetailed record);
    /**
     * 通过id查询
     * */
    VehichileDetailed selectByPrimaryKey(Long id);
    /**
     * 通过主键修改
     * **/
    int updateByPrimaryKeySelective(VehichileDetailed record);
    /**
     * 通过主键修改
     * */
    int updateByPrimaryKey(VehichileDetailed record);
    /**
     * 查询有没有该车辆代码
     * */
	Integer selectByVehicle_codeCount(String vehicleCode);
	/**
	 * 查询所有
	 * */
	List<VehichileDetailed> selectAll(@Param("star")Integer star, @Param("limit")Integer limit);
	/**
	 * 查询数量
	 * */
	Integer selectAllCount();

}