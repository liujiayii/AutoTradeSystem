package com.autotrade.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.autotrade.entity.VehicleArchives;
import com.autotrade.entity.VehicleArchivesVo;

public interface VehicleArchivesDao {

	/**
	  * @Title: findByLimit
	  * @description 分页查询车辆档案信息
	  * @param @param page 页数
	  * @param @param limit 每页显示条数
	  * @return List<VehicleArchivesVo> 返回车辆档案辅助类集合   
	  * @author ZhaoSong
	  * @createDate 2019年2月25日
	 */
	List<VehicleArchivesVo> findByLimit(@Param("page")Integer page,@Param("limit")Integer limit);
	
	/**
	  * @Title: findAllCount
	  * @description 查询车辆档案总条数
	  * @return Integer 返回总条数   
	  * @author ZhaoSong
	  * @createDate 2019年2月25日
	 */
	Integer findAllCount();
	
	
	
	
	/**
	  * @Title: findCarArchivesById
	  * @description 根据车辆档案id查询相关信息
	  * @param @param id 车辆档案id
	  * @return VehicleArchives 返回车辆档案信息    
	  * @author ZhaoSong
	  * @createDate 2019年2月25日
	 */
	VehicleArchivesVo findCarArchivesById(Long id);
	
	
	/**
	  * @Title: updateCarArchives
	  * @description 修改车辆档案信息
	  * @param @param vehicleArchivesVo 车辆档案信息辅助类
	  * @return Integer 生效行数   
	  * @author ZhaoSong
	  * @createDate 2019年2月25日
	 */
	Integer updateCarArchives(VehicleArchives vehicleArchives);
	
	
	/**
	  * @Title: insertCarArchives
	  * @description 增加车辆档案
	  * @param @param vehicleArchives 车辆档案信息
	  * @return Integer 生效行数   
	  * @author ZhaoSong
	  * @createDate 2019年2月26日
	 */
	Integer insertCarArchives(VehicleArchives vehicleArchives);
	
	
	/**
	  * @Title: findKeyWordByLimit
	  * @description 根据关键字分页查询
	  * @param @param page 页数
	  * @param @param limit 每页显示条数
	  * @param @param keyWord 关键字
	  * @return List<VehicleArchivesVo> 符合关键字条数车辆档案信息集合    
	  * @author ZhaoSong
	  * @createDate 2019年2月26日
	 */
	List<VehicleArchivesVo> findKeyWordByLimit(@Param("page")Integer page,@Param("limit")Integer limit,@Param("keyWord")String keyWord);
	
	/**
	  * @Title: findKeyWordCount
	  * @description 根据关键字查询车型条数
	  * @param @param keyWord 关键字
	  * @return Integer  返回条数  
	  * @author ZhaoSong
	  * @createDate 2019年2月26日
	 */
	Integer findKeyWordCount(String keyWord);
	
	
	
	
	/**
	  * @Title: findVehicleArchivesByVehicleNumber
	  * @description 根据车牌号查询车辆档案
	  * @param @param vehicle_number 车牌号码
	  * @return VehicleArchives  返回车辆档案信息  
	  * @author ZhaoSong
	  * @createDate 2019年2月26日
	 */
	VehicleArchives findVehicleArchivesByVehicleNumber(String vehicle_number);
	
	
	
	
	
	
	
	
	
	
}
