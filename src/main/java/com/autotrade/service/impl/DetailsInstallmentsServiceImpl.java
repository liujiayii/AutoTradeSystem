package com.autotrade.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.autotrade.dao.DetailsInstallmentsDao;
import com.autotrade.entity.DetailsInstallments;
import com.autotrade.service.DetailsInstallmentsService;
/**
 * 分期详情表业务层
 *
 * @ClassName: DetailsInstallmentsDao

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年1月4日-下午1:54:55
 */
@Service
public class DetailsInstallmentsServiceImpl implements DetailsInstallmentsService {

	@Resource
	private DetailsInstallmentsDao detailsInstallmentsDao;
	
	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertAll(DetailsInstallments record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(DetailsInstallments record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DetailsInstallments selectById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByIdSelective(DetailsInstallments record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateAllById(DetailsInstallments record) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}