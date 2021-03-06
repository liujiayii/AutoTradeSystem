package com.autotrade.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.autotrade.dao.ByStagesDao;
import com.autotrade.entity.BuyingCustomer;
import com.autotrade.entity.ByStages;
import com.autotrade.service.ByStagesService;
import com.autotrade.utils.JsonUtil;

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

		return byStagesDao.deleteById(id);
	}

	/**
	 * 插入所有字段数据
	 */
	@Override
	public String insertAll(ByStages byStages) {
		int code = 1;
		String msg = "插入成功";
		int count = 0;
		byStages.setCreateTime(new Date());
		
		try {
			byStagesDao.insertAll(byStages);
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "插入失败";
		}
		
		return JsonUtil.getResponseJson(code, msg, count, null);
	}

	/**
	 * 插入指定数据
	 */
	@Override
	public int insertSelective(ByStages byStages) {
		
		return byStagesDao.insertSelective(byStages);
	}

	/**
	 * 通过id查询
	 */
	@Override
	public ByStages selectById(Long id) {
		
		return byStagesDao.selectById(id);
	}

	/**
	 * 修改指定字段数据
	 */
	@Override
	public int updateByIdSelective(ByStages byStages) {
		
		return byStagesDao.updateByIdSelective(byStages);
	}

	/**
	 * 修改所有字段数据
	 */
	@Override
	public int updateAllById(ByStages byStages) {
		
		return byStagesDao.updateAllById(byStages);
	}

	/**
	 * 查询分期表所有信息
	 */
	@Override
	public String selectByLimit(Map<String, Object> map) {
		int code = 1;
		String msg = "查询成功";
		int count = 0;
		List<ByStages> byStagesList = null;
		
		try {
			byStagesList = byStagesDao.selectByLimit(map);
			count = byStagesDao.getCount(null);
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "查询失败";
		}
		
		return JsonUtil.getResponseJson(code, msg, count, byStagesList);
	}

	/**
	 * 查询分期数据对应买车客户信息
	 */
	@Override
	public String selectBuyingCustomer(Long id) {
		int code = 1;
		String msg = "查询成功";
		int count = 0;
		BuyingCustomer buyingCustomer = null;
		
		try {
			buyingCustomer = byStagesDao.selectBuyingCustomer(id);
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "查询失败";
		}
		
		return JsonUtil.getResponseJson(code, msg, count, buyingCustomer);
	}

	/**
	 * 搜索接口实现
	 */
	@Override
	public String selectBySearchField(Map<String, Object> map) {
		int code = 1;
		String msg = "查询成功";
		int count = 0;
		List<ByStages> byStagesList = null;
		
		try {
			byStagesList = byStagesDao.selectByLimit(map);
			count = byStagesDao.getCount(map);
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "查询失败";
		}
		
		return JsonUtil.getResponseJson(code, msg, count, byStagesList);
	}

	/**
	 * 通过指定条件查询
	 */
	@Override
	public List<ByStages> selectBySelective(ByStages byStages) throws Exception {
		
		return byStagesDao.selectBySelective(byStages);
	}

	
}