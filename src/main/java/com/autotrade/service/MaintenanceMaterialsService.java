package com.autotrade.service;

import java.util.List;

import com.autotrade.entity.MaintenanceMaterials;

public interface MaintenanceMaterialsService {
	
	/**
	 * 删除项目对应的材料
	*@author lichangchun
	* @param id
	* @return
	*@return String
	*@date 2019年2月23日    
	*
	 */
	 String deleteByPrimaryKey(Long id);

	
	 /**
		 * 设置项目对应的财力的材料
		*@author lichangchun
		* @param record
		* @return
		*@return String
		*@date 2019年2月23日    
		*
		 */
		 String insertSelective(MaintenanceMaterials record);
		 /**
		  * 查询项目对应的材料
		 *@author lichangchun
		 * @param id
		 * @return
		 *@return String
		 *@date 2019年2月23日    
		 *
		  */

		 String selectByPrimaryKey(Long id);
		 /**
		  * 修改项目对应的材料
		 *@author lichangchun
		 * @param record
		 * @return
		 *@return String
		 *@date 2019年2月23日    
		 *
		  */

		    String updateByPrimaryKeySelective(MaintenanceMaterials record);

	/**
	 * 通过指定条件获取材料信息
	 *
	 * @Title: selectBySelective
	
	 * @description 
	 *
	 * @param maintenanceMaterials
	 * @return 
	   
	 * List<MaintenanceMaterials>
	 *
	 * @author lujinpeng
	 * @createDate 2019年2月26日-下午4:51:37
	 */
	List<MaintenanceMaterials> selectBySelective (MaintenanceMaterials maintenanceMaterials);

}
