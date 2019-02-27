package com.autotrade.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autotrade.dao.RepairProjectDao;
import com.autotrade.entity.RepairProject;
import com.autotrade.entityVo.RepairProjectVo;
import com.autotrade.service.RepairProjectService;

/**
 * 维修修理单表service层实现类
 *
 * @ClassName: RepairProjectServiceImpl

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年2月20日-下午5:26:50
 */
@Service
public class RepairProjectServiceImpl implements RepairProjectService {

	@Autowired
	private RepairProjectDao repairProjectDao;
	
	/**
	 * 修改指定数据
	 */
	@Override
	public int updateBySelective(RepairProject repairProject) {
		
		return repairProjectDao.updateBySelective(repairProject);
	}

	/**
	 * 查询维修修理单表详情
	 */
	@Override
	public List<RepairProjectVo> selectDetailsRepairProject(Map<String, Object> map) throws Exception {
		
		return repairProjectDao.selectDetailsRepairProject(map);
	}

	/**
	 * 查询总条数
	 */
	@Override
	public int getCount(Map<String, Object> map) {

		return repairProjectDao.getCount(map);
	}

	/**
	 * 插入指定数据
	 */
	@Override
	public int insertSelective(RepairProject repairProject) {
		
		return repairProjectDao.insertSelective(repairProject);
	}

	/**
	 * 通过指定条件查询
	 */
	@Override
	public List<RepairProject> selectBySelective(RepairProject repairProject) {
		
		return repairProjectDao.selectBySelective(repairProject);
	}

}
