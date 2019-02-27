package com.autotrade.service.impl;

import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autotrade.dao.PartsDao;
import com.autotrade.dao.RepairDao;
import com.autotrade.entity.Parts;
import com.autotrade.entity.Repair;
import com.autotrade.service.PartsService;
import com.autotrade.utils.JsonUtil;

/**
 * 
 *
 * @ClassName: PartsServiceImpl
 * 
 * @description 领料表实现层
 *
 * @author lishaozhang
 * @createDate 2019年2月22日
 */
@Service
public class PartsServiceImpl implements PartsService {

	@Autowired
	private PartsDao partsDao;
	@Autowired
	private RepairDao repair;

	@Override
	public String insert(Parts parts) {
		try {
			parts.setCreate_time(new Date());
			partsDao.insert(parts);
			Repair rep = repair.selectByPrimaryKey(parts.getRepair_id());
			System.out.println(parts.getRepair_id());
			if (rep.getState() >= 2) {
				return JsonUtil.getResponseJson(1, "已完成维修不可再添加材料", null, null);
			}

			return JsonUtil.getResponseJson(1, "保存成功", null, null);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
	}

	@Override
	public String delete(Long id) {
		try {
			Parts parts = partsDao.selectById(id);
			Repair rep = repair.selectByPrimaryKey(parts.getRepair_id());
			if (rep.getState() >= 2) {
				return JsonUtil.getResponseJson(1, "已完成维修不可再删除材料", null, null);
			}

			Integer result = partsDao.deleteById(id);

			if (result >= 1) {
				return JsonUtil.getResponseJson(1, "删除成功", null, null);
			} else {
				return JsonUtil.getResponseJson(1, "删除失败", null, null);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
	}

	@Override
	public String selectAll(Integer page, Integer limit) {

		try {

			List<Parts> list = partsDao.selectAll();
			Integer count = partsDao.selectAllCount();
			return JsonUtil.getResponseJson(1, "查询成功", count, list);
		} catch (Exception e) {
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}

	}

	@Override
	public String update(Parts parts) {
		try {

			Repair rep = repair.selectByPrimaryKey(parts.getRepair_id());
			if (rep.getState() >= 2) {
				return JsonUtil.getResponseJson(1, "已完成维修不可再修改材料", null, null);
			}

			Integer result = partsDao.updateByid(parts);

			if (result >= 1) {
				return JsonUtil.getResponseJson(1, "修改成功", null, null);
			} else {
				return JsonUtil.getResponseJson(1, "修改失败", null, null);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
	}

	@Override
	public String selectPartsShow(Long repair_id, Integer page, Integer limit) {
		try {
			Integer star = (page - 1) * limit;
			List<Parts> result = partsDao.selectPartsShow(repair_id, star, limit);
			Integer count = partsDao.selectPartsShowCount(repair_id);
			if (result.size() >= 1) {
				return JsonUtil.getResponseJson(1, "查询成功", count, result);
			} else {
				return JsonUtil.getResponseJson(1, "查询失败", count, result);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
	}

}
