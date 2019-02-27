package com.autotrade.dao;

import java.util.List;
import java.util.Map;

import com.autotrade.entity.RepairProject;
import com.autotrade.entityVo.RepairProjectVo;

/**
 * 维修修理单表dao层
 *
 * @ClassName: RepairProjectDao

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年2月20日-下午5:07:16
 */

public interface RepairProjectDao {

	/**
	 * 修改指定数据
	 *
	 * @Title: updateBySelective
	
	 * @description 
	 *
	 * @param repairProject
	 * @return 
	   
	 * int
	 *
	 * @author lujinpeng
	 * @createDate 2019年2月20日-下午5:24:54
	 */
	int updateBySelective(RepairProject repairProject);
	
	/**
	 * 查询维修修理单表详情
	 *
	 * @Title: selectDetailsRepairProject
	
	 * @description 
	 *
	 * @param map
	 * @return 
	   
	 * List<RepairProjectVo>
	 *
	 * @author lujinpeng
	 * @createDate 2019年2月20日-下午5:58:36
	 */
	List<RepairProjectVo> selectDetailsRepairProject(Map<String, Object> map);
	
	/**
	 * 查询总条数
	 *
	 * @Title: getCount
	
	 * @description 
	 *
	 * @param map
	 * @return 
	   
	 * int
	 *
	 * @author lujinpeng
	 * @createDate 2019年2月20日-下午5:59:12
	 */
	int getCount(Map<String, Object> map);
	
	/**
	 * 插入指定数据
	 *
	 * @Title: insertSelective
	
	 * @description 
	 *
	 * @param repairProject
	 * @return 
	   
	 * int
	 *
	 * @author lujinpeng
	 * @createDate 2019年2月21日-下午4:47:22
	 */
	int insertSelective(RepairProject repairProject);
	
	/**
	 * 通过指定条件查询
	 *
	 * @Title: selectBySelective
	
	 * @description 
	 *
	 * @param repairProject
	 * @return 
	   
	 * List<RepairProject>
	 *
	 * @author lujinpeng
	 * @createDate 2019年2月25日-下午5:12:30
	 */
	List<RepairProject> selectBySelective(RepairProject repairProject);
	
}
