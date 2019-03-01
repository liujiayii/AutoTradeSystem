package com.autotrade.dao;

import com.autotrade.entity.Repair;
import com.autotrade.entity.RepairExample;
import com.autotrade.entityVo.PartsShow;
import com.autotrade.entityVo.RepairDetails;
import com.autotrade.entityVo.RepairSelect;
import com.autotrade.entityVo.RepairShow;

import java.util.List;
import org.apache.ibatis.annotations.Param;
/**
 * 
 *
 * @ClassName: RepairDao

 * @description 工单dao
 *
 * @author lishaozhang
 * @createDate 2019年2月20日
 */
public interface RepairDao {
	/**
	 * 
	*
	 * @Title: countByExample
	
	 * @description 根据条件查询数量
	*
	 * @param @param example
	 * @param @return 
	   
	 * @return int    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年2月20日
	 */
    int countByExample(RepairExample example);
    /**
     * 
    *
     * @Title: deleteByExample
    
     * @description 根据条件删除
    *
     * @param @param example
     * @param @return 
       
     * @return int    
    
     *
     * @author lishaozhang
     * @createDate 2019年2月20日
     */
    int deleteByExample(RepairExample example);
    /**
     * 
    *
     * @Title: deleteByPrimaryKey
    
     * @description 根据主键删除
    *
     * @param @param id
     * @param @return 
       
     * @return int    
    
     *
     * @author lishaozhang
     * @createDate 2019年2月20日
     */
    int deleteByPrimaryKey(Long id);
    /**
     * 
    *
     * @Title: insert
    
     * @description 添加
    *
     * @param @param record
     * @param @return 
       
     * @return int    
    
     *
     * @author lishaozhang
     * @createDate 2019年2月20日
     */
    int insert(Repair record);
    /**
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
     * @createDate 2019年2月20日
     */
    int insertSelective(Repair record);
    /**
     * 
    *
     * @Title: selectByExample
    
     * @description 条件查询
    *
     * @param @param example
     * @param @return 
       
     * @return List<Repair>    
    
     *
     * @author lishaozhang
     * @createDate 2019年2月20日
     */
    List<Repair> selectByExample(RepairExample example);
    /***
     * 
    *
     * @Title: selectByPrimaryKey
    
     * @description 根据主键查询
    *
     * @param @param id
     * @param @return 
       
     * @return Repair    
    
     *
     * @author lishaozhang
     * @createDate 2019年2月20日
     */
    Repair selectByPrimaryKey(Long id);
    /**
     * 
    *
     * @Title: updateByExampleSelective
    
     * @description 修改数据属性有则修改没有则不变
    *
     * @param @param record
     * @param @param example
     * @param @return 
       
     * @return int    
    
     *
     * @author lishaozhang
     * @createDate 2019年2月20日
     */
    int updateByExampleSelective(@Param("record") Repair record, @Param("example") RepairExample example);
    /**
     * 
    *
     * @Title: updateByExample
    
     * @description 修改数据属性有则修改没有则不变
    *
     * @param @param record
     * @param @param example
     * @param @return 
       
     * @return int    
    
     *
     * @author lishaozhang
     * @createDate 2019年2月20日
     */
    int updateByExample(@Param("record") Repair record, @Param("example") RepairExample example);
    /**
     * 
    *
     * @Title: updateByPrimaryKeySelective
    
     * @description 根据主键修改有属性则修改没有不变
    *
     * @param @param record
     * @param @return 
       
     * @return int    
    
     *
     * @author lishaozhang
     * @createDate 2019年2月20日
     */
    int updateByPrimaryKeySelective(Repair record);
    /**
     * 
    *
     * @Title: updateByPrimaryKey
    
     * @description 根据主键修改没有则置为null
    *
     * @param @param record
     * @param @return 
       
     * @return int    
    
     *
     * @author lishaozhang
     * @createDate 2019年2月20日
     */
    int updateByPrimaryKey(Repair record);
    /**
     * 
    *
     * @Title: SelectRepairShow
    
     * @description 根据ID查询车辆档案展示
    *
     * @param @param in
     * @param @return 
       
     * @return List<RepairShow>    
    
     *
     * @author lishaozhang
     * @createDate 2019年2月20日
     */
    List<RepairShow> SelectRepairShow(@Param("in")String in,@Param("star")Integer star,@Param("limit")Integer limit);
    /**              
     * 
    *
     * @Title: SelectRepairShowCount
    
     * @description 根据ID查询车辆档案展示数量
    *
     * @param @param in
     * @param @return 
       
     * @return Integer    
    
     *
     * @author lishaozhang
     * @createDate 2019年2月20日
     */
    Integer SelectRepairShowCount(String in);
    /**
     * 
    *
     * @Title: hybridSelect
    
     * @description 工单信息条件粗略查询
    *
     * @param @param repairSelect
     * @param @return 
       
     * @return List<RepairShow>    
    
     *
     * @author lishaozhang
     * @createDate 2019年2月20日
     */
    List<RepairShow> hybridSelect(RepairSelect repairSelect);
    /**
     * 
    *
     * @Title: hybridSelectCount
    
     * @description 工单信息条件粗略查询数量
    *
     * @param @param repairSelect
     * @param @return 
       
     * @return Integer    
    
     *
     * @author lishaozhang
     * @createDate 2019年2月20日
     */
    Integer hybridSelectCount(RepairSelect repairSelect);
    /**
     * 
    *
     * @Title: SelectRepairShow
    
     * @description 工单详细信息查询
    *
     * @param @param id
     * @param @return 
       
     * @return RepairDetails    
    
     *
     * @author lishaozhang
     * @createDate 2019年2月20日
     */
    List<RepairDetails> SelectRepairShow(@Param("id")Long id,@Param("repair_id")Long repair_id);
    /**
     * 
    *
     * @Title: selectIdByVehicleNumber
    
     * @description 根据车牌从车辆档案中查询车辆档案id
    *
     * @param @param vehicleNumber
     * @param @return 
       
     * @return Integer    
    
     *
     * @author lishaozhang
     * @createDate 2019年2月21日
     */
	Long selectIdByVehicleNumber(String vehicleNumber);
	/**
	 * 
	*
	 * @Title: selectPartsShow
	
	 * @description 查询工单用料
	*
	 * @param @param repair_id
	 * @param @return 
	   
	 * @return List<PartsShow>    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年2月23日
	 */
	List<PartsShow> selectPartsShow(@Param("repair_id") Long repair_id,@Param("star") Integer star,@Param("limit") Integer limit);
   /**
    * 
   *
    * @Title: selectPartsShowCount
   
    * @description 查询某个工单使用材料数量
   *
    * @param @param repair_id
    * @param @return 
      
    * @return Integer    
   
    *
    * @author lishaozhang
    * @createDate 2019年2月23日
    */
	Integer selectPartsShowCount(Long repair_id);
	/**
	 * 
	*
	 * @Title: selectRepairDetailsByVehicleNumber
	
	 * @description 
	*
	 * @param @param vehicleNumber
	 * @param @return 
	   
	 * @return List<RepairDetails>    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年2月28日
	 */
     List<RepairDetails> selectRepairDetailsByVehicleNumber(String vehicleNumber);
	
	
}