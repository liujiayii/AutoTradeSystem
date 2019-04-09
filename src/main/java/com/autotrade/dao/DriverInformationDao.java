package com.autotrade.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.autotrade.entity.DriverInformation;

public interface DriverInformationDao {
	
	
	/**
	  * @Title: insertDriver
	  * @description 添加驾驶员信息
	  * @param @param driverInformation 驾驶员信息对象
	  * @return Integer 生效行数   
	  * @author ZhaoSong
	  * @createDate 2019年2月20日
	 */
	Integer insertDriver(DriverInformation driverInformation);
	
	/**
	  * @Title: findAllBylimit
	  * @description 分页查询驾驶员信息
	  * @param @param page 页数
	  * @param @param limit 每页显示条数
	  * @return List<DriverInformation> 返回驾驶员信息集合   
	  * @author ZhaoSong
	  * @createDate 2019年2月24日
	 */
	List<DriverInformation> findAllBylimit(@Param("page")Integer page,@Param("limit")Integer limit);
	
	/**
	  * @Title: findAllCount
	  * @description 查询驾驶员信息总条数
	  * @return Integer  返回条数  
	  * @author ZhaoSong
	  * @createDate 2019年2月24日
	 */
	Integer findAllCount();
	
	
	/**
	  * @Title: findLimitByKeyWord
	  * @description 根据关键字分页查询
	  * @param @param page 页数
	  * @param @param limit 每页显示条数
	  * @param @param keyWord 关键字
	  * @return List<DriverInformation> 返回驾驶员档案信息    
	  * @author ZhaoSong
	  * @createDate 2019年2月24日
	 */
	List<DriverInformation> findLimitByKeyWord(@Param("page")Integer page,@Param("limit")Integer limit,@Param("keyWord")String keyWord);
	
	
	/**
	  * @Title: findKeyWordCount
	  * @description 根据关键字查询数量
	  * @param @param keyWord 关键字
	  * @return Integer 符合条件的数量   
	  * @author ZhaoSong
	  * @createDate 2019年2月24日
	 */
	Integer findKeyWordCount(String keyWord);
	
	
	/**
	  * @Title: updateDriver
	  * @description 修改驾驶员档案信息
	  * @param @param driver 驾驶员对象
	  * @return Integer 生效行数   
	  * @author ZhaoSong
	  * @createDate 2019年2月24日
	 */
	Integer updateDriver(DriverInformation driver);
	
	
	/**
	  * @Title: findDriverByPhone
	  * @description 根据电话号码查询驾驶员信息
	  * @param @param phone 电话号码
	  * @return DriverInformation  驾驶员对象  
	  * @author ZhaoSong
	  * @createDate 2019年2月25日
	 */
	DriverInformation findDriverByPhone(String phone);
    
	/**
	 * 
	*
	 * @Title: deleteDerverInformationByid
	
	 * @description 删除驾驶员信息
	*
	 * @param @param driver_id
	 * @param @return 
	   
	 * @return Integer    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年4月3日
	 */
	Integer deleteDerverInformationByid(Long driver_id);
	

}
