package com.autotrade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autotrade.dao.CustomerArchivesDao;
import com.autotrade.entity.CustomerArchives;
import com.autotrade.service.CustomerArchivesService;
import com.autotrade.utils.JsonUtil;

@Service
public class CustomerArchivesServiceImpl implements CustomerArchivesService {

	@Autowired
	private CustomerArchivesDao customerArchiverDao;

	// 添加新的维修用户档案
	@Override
	public Integer insertCustomerArchives(CustomerArchives customerArchives) {
		customerArchives.setCustomer_id(findLast());
		Integer row = customerArchiverDao.insertCustomerArchives(customerArchives);
		return row;
	}

	// 查找并生成维修用户档案编号
	@Override
	public String findLast() {
		String number = customerArchiverDao.findLast();
		Integer id = Integer.parseInt(number.substring(2));
		String n = id.toString().format("%05d", id + 1);
		number = number.substring(0, 2) + n;
		return number;
	}

	@Override
	public String findByLimit(Integer page, Integer limit, String keyWord) {
		List<CustomerArchives> lists;
		String str;
		try {
			if (keyWord != "") {
				lists = customerArchiverDao.findLimitByKeyWord(page, limit, keyWord);
				if (lists.size() > 0) {
					str = JsonUtil.getResponseJson(1, "查询成功", customerArchiverDao.findCountByKeyWord(keyWord), lists);
				} else {
					str = JsonUtil.getResponseJson(1, "暂无数据", lists.size(), lists);
				}
			} else {
				lists = customerArchiverDao.findByLimit(page, limit);
				if (lists.size() > 0) {
					str = JsonUtil.getResponseJson(1, "查询成功", customerArchiverDao.findAllCustomerCount(), lists);
				} else {
					str = JsonUtil.getResponseJson(1, "暂无数据", customerArchiverDao.findAllCustomerCount(), lists);
				}
			}
		} catch (Exception e) {
			str = JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}

		return str;
	}

	@Override
	public String updateCustomer(CustomerArchives customerArvchives) {
		Integer row = customerArchiverDao.updateCustomer(customerArvchives);
		String str;
		try {
			if (row > 0) {
				str = JsonUtil.getResponseJson(1, "修改成功", null, null);
			} else {
				str = JsonUtil.getResponseJson(-1, "修改失败", null, null);
			}
		} catch (Exception e) {
			str = JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
		return str;
	}

	@Override
	public String findClientByPhone(String phone) {
		String str;
		try {
			CustomerArchives customerArchives = customerArchiverDao.findClientByPhone(phone);
			if (customerArchives != null) {
				str = JsonUtil.getResponseJson(1, "查询成功", null, customerArchives);
			} else {
				str = JsonUtil.getResponseJson(-1, "暂无数据", null, null);
			}
		} catch (Exception e) {
			str = JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}

		return str;
	}

}
