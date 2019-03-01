package com.autotrade.service;

import java.util.List;
import java.util.Map;

import com.autotrade.entity.MaintenanceType;

/**
 * 维修类型表service层
 *
 * @ClassName: MaintenanceTypeService

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年2月20日-上午11:17:39
 */
public interface MaintenanceTypeService {

	/**
	 * 通过id查询
	 *
	 * @Title: selectById
	
	 * @description 
	 *
	 * @return 
	   
	 * MaintenanceType
	 *
	 * @author lujinpeng
	 * @createDate 2019年2月20日-上午11:07:39
	 */
	public MaintenanceType selectById(Long id);
	
	/**
	 * 通过指定条件查询
	 *
	 * @Title: selectBySelective
	
	 * @description 
	 *
	 * @param map
	 * @return 
	   
	 * List<MaintenanceType>
	 *
	 * @author lujinpeng
	 * @createDate 2019年2月20日-上午11:08:57
	 */
	public List<MaintenanceType> selectBySelective(Map<String, Object> map);
	
	/**
	 * 插入全部
	 *
	 * @Title: insertAll
	
	 * @description 
	 *
	 * @param maintenanceType
	 * @return 
	   
	 * int
	 *
	 * @author lujinpeng
	 * @createDate 2019年2月20日-上午11:10:05
	 */
	public int insertAll(MaintenanceType maintenanceType);
	
	/**
	 * 插入指定数据
	 *
	 * @Title: insertSelective
	
	 * @description 
	 *
	 * @param maintenanceType
	 * @return 
	   
	 * int
	 *
	 * @author lujinpeng
	 * @createDate 2019年2月20日-上午11:10:43
	 */
	public int insertSelective(MaintenanceType maintenanceType);
	/**
	 * 获取所有的维修类型
	*@author lichangchun
	* @return
	*@return String
	*@date 2019年2月28日    
	*
	 */
	
	
	String selectAll();
	/**
	 * 获取所有的维修类型（只查名字）
	*@author lichangchun
	* @return
	*@return String
	*@date 2019年2月28日    
	*
	 */
	
	String selectAllByString();
	/**
	 * 根据具体类型的名字获取id
	*@author lichangchun
	* @param name
	* @return
	*@return MaintenanceType
	*@date 2019年2月28日    
	*
	 */
	public MaintenanceType selectByName(String name);
	
}
