package com.autotrade.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.autotrade.dao.InsuranceDao;
import com.autotrade.entity.BuyingCustomer;
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
		
		return insuranceDao.deleteById(id);
	}

	/**
	 * 插入所有字段数据
	 */
	@Override
	public int insertAll(Insurance insurance) {
		
		return insuranceDao.insertAll(insurance);
	}

	/**
	 * 插入指定字段数据
	 */
	@Override
	public int insertSelective(Insurance insurance) {
		
		return insuranceDao.insertSelective(insurance);
	}

	/**
	 * 通过id查询
	 */
	@Override
	public Insurance selectById(Long id) throws Exception {
		
		return insuranceDao.selectById(id);
	}

	/**
	 * 修改指定字段数据
	 */
	@Override
	public int updateByIdSelective(Insurance insurance) {
		
		return insuranceDao.updateByIdSelective(insurance);
	}

	/**
	 * 修改所有字段数据
	 */
	@Override
	public int updateAllById(Insurance insurance) {
		
		return insuranceDao.updateAllById(insurance);
	}

	/**
	 * 分页 查询保险表所有信息
	 * @throws Exception 
	 */
	@Override
	public List<Insurance> selectInsuranceByLimit(Map<String, Object> map) throws Exception {
		
		return insuranceDao.selectInsuranceByLimit(map);
	}

	/**
	 * 查询总条数
	 */
	@Override
	public int getCount(Map<String, Object> map) throws Exception {
		
		return insuranceDao.getCount(map);
	}

	/**
	 * 查询保险表对应客户信息表数据
	 */
	@Override
	public BuyingCustomer selectBuyingCustomer(Long id) throws Exception {
		
		return insuranceDao.selectBuyingCustomer(id);
	}
	
}