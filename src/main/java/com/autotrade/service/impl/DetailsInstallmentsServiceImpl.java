package com.autotrade.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.autotrade.dao.DetailsInstallmentsDao;
import com.autotrade.entity.ByStages;
import com.autotrade.entity.DetailsInstallments;
import com.autotrade.service.DetailsInstallmentsService;
import com.autotrade.utils.JsonUtil;
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
	
	/**
	 * 删除
	 */
	@Override
	public int deleteById(Long id) {
		
		return detailsInstallmentsDao.deleteById(id);
	}

	/**
	 * 插入分期详情表所有数据
	 */
	@Override
	public String insertAll(DetailsInstallments detailsInstallments) {
		int code = 1;
		String msg = "插入成功";
		int count = 0;
		
		try {
			detailsInstallmentsDao.insertAll(detailsInstallments);
		} catch (Exception e) {
			e.printStackTrace();
			code = 1;
			msg = "插入失败";
		}
		
		return JsonUtil.getResponseJson(code, msg, count, null);
	}

	/**
	 * 插入分期详情表指定数据
	 */
	@Override
	public int insertSelective(DetailsInstallments detailsInstallments) {
		
		return detailsInstallmentsDao.insertSelective(detailsInstallments);
	}

	/**
	 * 通过id查询
	 */
	@Override
	public DetailsInstallments selectById(Long id) {
		
		return detailsInstallmentsDao.selectById(id);
	}

	/**
	 * 修改指定字段数据
	 */
	@Override
	public int updateByIdSelective(DetailsInstallments detailsInstallments) {
		
		return detailsInstallmentsDao.updateByIdSelective(detailsInstallments);
	}

	/**
	 * 修改所有字段数据
	 */
	@Override
	public int updateAllById(DetailsInstallments detailsInstallments) {
		
		return detailsInstallmentsDao.updateAllById(detailsInstallments);
	}

	/**
	 * 查询分期详情
	 */
	@Override
	public List<DetailsInstallments> selectDetailsInstallments(Map<String, Object> map) throws Exception{
		
		return detailsInstallmentsDao.selectDetailsInstallments(map);
	}

	/**
	 * 获取总条数
	 */
	@Override
	public int getCount(Map<String, Object> map) {
		
		return detailsInstallmentsDao.getCount(map);
	}

	
}