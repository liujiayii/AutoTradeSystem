package com.autotrade.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.autotrade.dao.InsuranceDao;
import com.autotrade.entity.Insurance;
import com.autotrade.service.InsuranceService;
/**
 * 保险表业务层
 *
 * @ClassName: InsuranceDao

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年1月4日-下午2:10:14
 */
@Service
public class InsuranceServiceImpl implements InsuranceService {

	@Resource
	private InsuranceDao insuranceDao;
	
	/*
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
	public int insertAll(Insurance record) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 插入指定字段数据
	 */
	@Override
	public int insertSelective(Insurance record) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 通过id查询
	 */
	@Override
	public Insurance selectById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 修改指定字段数据
	 */
	@Override
	public int updateByIdSelective(Insurance record) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 修改所有字段数据
	 */
	@Override
	public int updateAllById(Insurance record) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}