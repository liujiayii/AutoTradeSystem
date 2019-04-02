package com.autotrade.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.autotrade.entity.MaintenanceParts;
import com.autotrade.entity.Relation;

/**
 * 车型，维修项目、维修类别关联表实体类
 *
 * @ClassName: RelationDao

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年2月20日-下午2:37:00
 */
public interface RelationDao {

	/**
	 * 通过关联关系id查询
	 *
	 * @Title: selectByRelationId
	
	 * @description 
	 *
	 * @param map
	 * @return 
	   
	 * Relation
	 *
	 * @author lujinpeng
	 * @createDate 2019年2月23日-下午2:20:08
	 */
	Relation selectByRelationId(Map<String, Object> map);
	
	/**
	 * 通过维修客户电话查询维修客户类型信息
	 *
	 * @Title: selectMaintenancePartsId
	
	 * @description 
	 *
	 * @param phone
	 * @return 
	   
	 * MaintenanceParts
	 *
	 * @author lujinpeng
	 * @createDate 2019年2月23日-下午2:40:21
	 */
	MaintenanceParts selectMaintenancePartsId(@Param("phone_number") String phone_number, @Param("customer_name") String customer_name);
	
	/**
	 * 根据项目查询设置的工时
	*@author lichangchun
	* @param id
	* @return
	*@return List<Relation>
	*@date 2019年2月25日    
	*
	 */
	List<Relation> selcectByproject(Long id);
	
	/**
	 * 根据项目查询客户类型并去重
	*@author lichangchun
	* @param id
	* @return
	*@return List<Relation>
	*@date 2019年2月25日    
	*
	 */
	List<Relation> selcectByMpid(Long id);
	
	List<Relation> selcectByMpidList(@Param("id")Long id,@Param("mpid")Long mpid);
	
	List<Relation> selcectByvehicle(@Param("id")Long id,@Param("mpid")Long mpid,@Param("vid")Long vid);
	
	
}
