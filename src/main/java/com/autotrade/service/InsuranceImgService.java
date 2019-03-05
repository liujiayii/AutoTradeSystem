package com.autotrade.service;

import java.util.List;

import com.autotrade.entity.InsuranceImg;

/**
 * 保险图片表业务层
 *
 * @ClassName: InsuranceImgService

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年3月4日-下午4:21:02
 */
public interface InsuranceImgService {

	/**
	 * 通过保险表id查询
	 *
	 * @Title: selectByInsuranceId
	
	 * @description 
	 *
	 * @param id
	 * @return 
	   
	 * List<InsuranceImg>
	 *
	 * @author lujinpeng
	 * @createDate 2019年3月4日-下午4:18:24
	 */
	List<InsuranceImg> selectByInsuranceId(Long id);
	
	/**
	 * 插入所有数据
	 *
	 * @Title: insertAll
	
	 * @description 
	 *
	 * @param insuranceImg
	 * @return 
	   
	 * int
	 *
	 * @author lujinpeng
	 * @createDate 2019年3月4日-下午4:19:11
	 */
	int insertAll(InsuranceImg insuranceImg);
	
	/**
	 * 查询指定字段数据
	 *
	 * @Title: insertSelective
	
	 * @description 
	 *
	 * @param insuranceImg
	 * @return 
	   
	 * int
	 *
	 * @author lujinpeng
	 * @createDate 2019年3月4日-下午4:19:53
	 */
	int insertSelective(InsuranceImg insuranceImg);
	
}
