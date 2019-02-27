package com.autotrade.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autotrade.dao.AssessmentDao;
import com.autotrade.dao.TBookingDao;
import com.autotrade.entity.Assessment;
import com.autotrade.entity.TBooking;
import com.autotrade.entity.VehichileDetailed;
import com.autotrade.entity.Vehichle;
import com.autotrade.entityVo.bookingVo;
import com.autotrade.service.TBookingService;
import com.autotrade.utils.JsonUtil;
@Service
public class TBookingServiceImpl implements TBookingService{
	
	@Autowired
	private TBookingDao tBookingDao;

	@Override
	public int deleteByPrimaryKey(Long id) {
		
		return 0;
	}

	@Override
	public String insert(TBooking record) {
		String string;
		try {
			
			record.setCreateTime(new Date());
			System.out.println("record"+record);
			Integer result = tBookingDao.insert(record);
			// 返回值 >= 1 代表添加成功
			if (result >= 1) {

				string = JsonUtil.getResponseJson(1, "添加成功", null, null);
			} else {
				string = JsonUtil.getResponseJson(1, "添加失败", null, null);
			}

			return string;

		} catch (Exception e) {
			// 程序异常
			e.printStackTrace();
			return string = JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}

	}


	@Override
	public int insertSelective(bookingVo record) {
		
		return 0;
	}

	@Override
	public TBooking selectByPrimaryKey(Long id) {
		
		return null;
	}

	@Override
	public String selectAll( Integer page, Integer limit) {
		String string;
		Integer star = (page - 1) * limit;
		try {
             System.out.println("------"+star+"++++"+limit);
			List<bookingVo> AssessmentList = tBookingDao.selectAllbook(star, limit);
			System.out.println("heheh");
			// 未查到数据
			if (AssessmentList.size() <= 0) {
				System.out.println("shibai");
				string = JsonUtil.getResponseJson(1, "暂无数据", null, null);
			} else {
				System.out.println("chneggong");
				
				// 查询到数据返回总数及当前页数据
				string = JsonUtil.getResponseJson(1, "查询成功", tBookingDao.countbook(), AssessmentList);
			}

		}catch (Exception e) {
			
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}

		return string;
	}

	@Override
	public String updateByPrimaryKeySelective(TBooking record) {
		
		try {
		int deleteByPrimaryKey = tBookingDao.updateByPrimaryKeySelective(record);

		if (deleteByPrimaryKey >= 1) {

			return JsonUtil.getResponseJson(1, "修改成功", null, null);

		} else {

			return JsonUtil.getResponseJson(1, "修改失败", null, null);
		}

	} catch (Exception e) {
		return JsonUtil.getResponseJson(-1, "系统异常", null, null);
	}
	}

	@Override
	public String updateByPrimaryKey(TBooking record) {

		return null;
	}

	@Override
	public String selectAllbookbyId(long c_id) {
		
		try {

			bookingVo reualt = tBookingDao.selectAllbookbyId(c_id);
            System.out.println("reualt"+reualt);
			if (null != reualt || !"".equals(reualt)) {

				return JsonUtil.getResponseJson(1, "查询成功", 1, reualt);

			} else {

				return JsonUtil.getResponseJson(1, "查询失败", null, null);
			}

		} catch (Exception e) {
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
	}

	@Override
	public String selectAllbyfield(String s, Integer page, Integer limit) {
		
			Integer star = (page - 1) * limit;
			System.out.println("s"+s);
			
			List<bookingVo> list = tBookingDao.selectAllbyfield(s, star, limit);
			System.out.println("list"+list);
			Integer count = tBookingDao.SelectCountbyfield(s);
			return JsonUtil.getResponseJson(1, "查询成功", count, list);
		
	}
	

	

	

}
