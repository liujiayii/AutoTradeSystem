package com.autotrade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autotrade.dao.InsuranceImgDao;
import com.autotrade.entity.InsuranceImg;
import com.autotrade.service.InsuranceImgService;

/**
 * 保险图片表业务实现类
 *
 * @ClassName: InsuranceImgServiceImpl

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年3月4日-下午4:22:03
 */
@Service
public class InsuranceImgServiceImpl implements InsuranceImgService {

	@Autowired
	private InsuranceImgDao insuranceImgDao;
	
	/**
	 * 通过保险表id查询
	 */
	@Override
	public List<InsuranceImg> selectByInsuranceId(Long id) {
		
		return insuranceImgDao.selectByInsuranceId(id);
	}

	/**
	 * 插入所有字段数据
	 */
	@Override
	public int insertAll(InsuranceImg insuranceImg) {
		
		return insuranceImgDao.insertAll(insuranceImg);
	}

	/**
	 * 插入指定字段数据
	 */
	@Override
	public int insertSelective(InsuranceImg insuranceImg) {
		
		return insuranceImgDao.insertSelective(insuranceImg);
	}

}
