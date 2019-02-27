package com.autotrade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autotrade.dao.DriverInformationDao;
import com.autotrade.entity.DriverInformation;
import com.autotrade.service.DriverInformationService;
import com.autotrade.utils.JsonUtil;

@Service
public class DriverInformationServiceImpl implements DriverInformationService {

	@Autowired
	private DriverInformationDao driverInformationDao;

	@Override
	public Integer insertDriver(DriverInformation driverInformation) {

		try {
			Integer row = driverInformationDao.insertDriver(driverInformation);
			if (row >= 1) {
				return row;
			} else {
				return -1;
			}
		} catch (Exception e) {
			return -2;
		}

	}

	@Override
	public String findByLimit(Integer page, Integer limit, String keyWord) {
		String str;
		List<DriverInformation> lists;
		if (keyWord == null || keyWord.equals("")) {// 纯分页
			try {
				lists = driverInformationDao.findAllBylimit(page, limit);
				System.out.println(lists.toString());
				if (lists.size() > 0) {
					str = JsonUtil.getResponseJson(1, "查询成功", driverInformationDao.findAllCount(), lists);
				} else {
					str = JsonUtil.getResponseJson(1, "暂无数据", lists.size(), null);
				}
			} catch (Exception e) {
				str = JsonUtil.getResponseJson(-1, "系统异常", null, null);
			}
		} else {// 关键字分页
			try {
				lists = driverInformationDao.findLimitByKeyWord(page, limit, keyWord);
				if (lists.size() > 0) {
					str = JsonUtil.getResponseJson(1, "查询成功", driverInformationDao.findKeyWordCount(keyWord), lists);
				} else {
					str = JsonUtil.getResponseJson(1, "暂无数据", lists.size(), null);
				}
			} catch (Exception e) {
				str = JsonUtil.getResponseJson(-1, "系统异常", null, null);
			}
		}
		return str;
	}

	@Override
	public String updateDriver(DriverInformation driver) {
		String str;
		try {
			Integer row = driverInformationDao.updateDriver(driver);
			if (row > 0) {
				str = JsonUtil.getResponseJson(1, "修改驾驶员档案成功", null, null);
			} else {
				str = JsonUtil.getResponseJson(-1, "修改驾驶员档案失败", null, null);
			}
		} catch (Exception e) {
			str = JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}

		return str;
	}

	@Override
	public String findDriverByPhone(String phone) {
		String str;
		try {
			DriverInformation deiverInformation = driverInformationDao.findDriverByPhone(phone);
			if (deiverInformation != null) {
				str = JsonUtil.getResponseJson(1, "查询成功", null, deiverInformation);
			} else {
				str = JsonUtil.getResponseJson(-1, "暂无数据", null, null);
			}
		} catch (Exception e) {
			str = JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}

		return str;
	}

}
