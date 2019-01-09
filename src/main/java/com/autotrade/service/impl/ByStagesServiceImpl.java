package com.autotrade.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.autotrade.dao.ByStagesDao;
import com.autotrade.entity.ByStages;
import com.autotrade.service.ByStagesService;

/**
 * 分期表业务层
 *
 * @ClassName: ByStagesDao

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年1月4日-下午1:41:18
 */
@Service
public class ByStagesServiceImpl implements ByStagesService {
	
	@Resource
	private ByStagesDao byStagesDao;

	/**
	 * 通过id删除
	 */
	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 插入所有字段数据
	 */
	@Override
	public int insertAll(ByStages record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(ByStages record) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 通过id查询
	 */
	@Override
	public ByStages selectById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 修改指定字段数据
	 */
	@Override
	public int updateByIdSelective(ByStages record) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 修改所有字段数据
	 */
	@Override
	public int updateAllById(ByStages record) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}