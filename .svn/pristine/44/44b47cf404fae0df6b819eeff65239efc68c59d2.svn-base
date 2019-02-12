package com.autotrade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.autotrade.dao.VehichileDetailedDao;
import com.autotrade.entity.VehichileDetailed;
import com.autotrade.service.VehichileDetailedService;
import com.autotrade.utils.JsonUtil;

/**
 * 
 *
 * @ClassName: VehichileDetailedServiceImpl
 * 
 * @description shixian
 *
 * @author lishaozhang
 * @createDate 2019年2月12日
 */
@Service
public class VehichileDetailedServiceImpl implements VehichileDetailedService {

	@Autowired
	private VehichileDetailedDao vehichileDetailedDao;

	@Override
	public String insert(VehichileDetailed vehic) {
		try {

			Integer in = vehichileDetailedDao.selectByVehicle_codeCount(vehic.getVehicleCode());
			if (in >= 1) {
				return JsonUtil.getResponseJson(1, "该类型代码已经存在", null, null);
			}

			int insert = vehichileDetailedDao.insert(vehic);
			if (insert >= 1) {
				return JsonUtil.getResponseJson(1, "添加成功", null, null);
			} else {
				return JsonUtil.getResponseJson(1, "添加失败", null, null);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}

	}

	@Transactional
	@Override
	public String deleteByPrimaryKey(Long id) {
		try {

			int deleteByPrimaryKey = vehichileDetailedDao.deleteByPrimaryKey(id);

			if (deleteByPrimaryKey >= 1) {

				return JsonUtil.getResponseJson(1, "删除成功", null, null);

			} else {

				return JsonUtil.getResponseJson(1, "删除失败", null, null);
			}

		} catch (Exception e) {
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}

	}

	@Override
	public String selectAll(Integer page, Integer limit) {
		try {

			Integer star = (page - 1) * limit;
			List<VehichileDetailed> list = vehichileDetailedDao.selectAll(star, limit);
			Integer count = vehichileDetailedDao.selectAllCount();
			if (list.size() <= 0) {
				return JsonUtil.getResponseJson(1, "暂无信息", null, null);
			} else {
				return JsonUtil.getResponseJson(1, "暂无信息", count, list);
			}

		} catch (Exception e) {
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
	}

	@Override
	public String update(VehichileDetailed record) {
		try {

			int deleteByPrimaryKey = vehichileDetailedDao.updateByPrimaryKey(record);

			if (deleteByPrimaryKey >= 1) {

				return JsonUtil.getResponseJson(1, "修改成功", null, null);

			} else {

				return JsonUtil.getResponseJson(1, "修改失败", null, null);
			}

		} catch (Exception e) {
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
	}

}
