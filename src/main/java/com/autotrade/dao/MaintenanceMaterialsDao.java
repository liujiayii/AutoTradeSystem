package com.autotrade.dao;

import java.util.List;

import com.autotrade.entity.MaintenanceMaterials;

public interface MaintenanceMaterialsDao {
    
	/**
	 * 删除项目对应的材料
	*@author lichangchun
	* @param id
	* @return
	*@return String
	*@date 2019年2月23日    
	*
	 */
	 int deleteByPrimaryKey(Long id);
	 
	 int deleteByPid(Long id);
	/**
	 * 材料设置
	*@author lichangchun
	* @param record
	* @return
	*@return int
	*@date 2019年2月23日    
	*
	 */
    int insertSelective(MaintenanceMaterials record);
   
    /**
     * 查询该项目对应的材料
    *@author lichangchun
    * @param id
    * @return
    *@return MaintenanceMaterials
    *@date 2019年2月23日    
    *
     */
    List<MaintenanceMaterials> selectByPrimaryKey(Long id);
  
   /**
    * 修改材料设置
   *@author lichangchun
   * @param record
   * @return
   *@return int
   *@date 2019年2月23日    
   *
    */
    int updateByPrimaryKeySelective(MaintenanceMaterials record);

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