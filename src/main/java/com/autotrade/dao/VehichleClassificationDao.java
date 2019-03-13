package com.autotrade.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.autotrade.entity.VehicleClassification;

public interface VehichleClassificationDao {

	/**
	 * @Title: findCarType
	 * @description 查询所有车型
	 * @return List<VehicleClassification> 所有车型信息
	 * @author ZhaoSong
	 * @createDate 2019年2月20日
	 */
	List<VehicleClassification> findCarType();

	/**
	 * 
	 *
	 * @Title: deleteByPrimaryKey
	 * 
	 * @description
	 *
	 * @param @param
	 *            id
	 * @param @return
	 * 
	 * @return int
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年3月7日
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * 
	 *
	 * @Title: insert
	 * 
	 * @description
	 *
	 * @param @param
	 *            record
	 * @param @return
	 * 
	 * @return int
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年3月7日
	 */
	int insert(VehicleClassification record);

	/**
	 * 
	 *
	 * @Title: selectByPrimaryKey
	 * 
	 * @description
	 *
	 * @param @param
	 *            id
	 * @param @return
	 * 
	 * @return VehicleClassification
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年3月7日
	 */
	VehicleClassification selectByPrimaryKey(Long id);

	/**
	 * 
	 *
	 * @Title: updateByPrimaryKey
	 * 
	 * @description
	 *
	 * @param @param
	 *            record
	 * @param @return
	 * 
	 * @return int
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年3月7日
	 */
	int updateByPrimaryKey(VehicleClassification record);

	List<VehicleClassification> selectAll(@Param("star")Integer star,@Param("limit") Integer limit);

	Integer selectAllCount();
}
