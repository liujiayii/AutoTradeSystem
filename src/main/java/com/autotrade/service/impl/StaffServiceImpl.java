package com.autotrade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.autotrade.dao.StaffDao;
import com.autotrade.entity.Staff;
import com.autotrade.entityVo.StaffVo;
import com.autotrade.service.StaffService;
import com.autotrade.utils.JsonUtil;
/**
 * 
 *
 * @ClassName: StaffServiceImpl

 * @description 员工实现层
 *
 * @author lishaozhang
 * @createDate 2019年2月13日
 */
@Service
public class StaffServiceImpl implements StaffService{
	
	@Autowired
	private StaffDao staffDao;

	@Override
	public String insert(Staff staff) {
		try {
			int insert = staffDao.insert(staff);
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

			int deleteByPrimaryKey = staffDao.deleteByPrimaryKey(id);

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
		

			Integer star = (page - 1) * limit;
			List<StaffVo> list = staffDao.selectAll(star, limit);
			Integer count = staffDao.selectAllCount();
			if (list.size() <= 0) {
				return JsonUtil.getResponseJson(1, "查询成功", count, list);
			} else {
				return JsonUtil.getResponseJson(1, "", count, list);
			}

		
	}

	@Override
	public String update(Staff staff) {
		try {

			int result = staffDao.updateByPrimaryKey(staff);

			if (result >= 1) {

				return JsonUtil.getResponseJson(1, "修改成功", null, null);

			} else {

				return JsonUtil.getResponseJson(1, "修改失败", null, null);
			}

		} catch (Exception e) {
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
	}

	@Override
	public String selectById(Long id) {
		try {

			Staff reualt = staffDao.selectByPrimaryKey(id);

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
	public String hybridSelect(String s, Integer page, Integer limit) {
		try {
			Integer star = (page - 1) * limit;
			List<StaffVo> list = staffDao.hybridSelect(s, star, limit);
			Integer count = staffDao.hybridSelectCount(s);
			return JsonUtil.getResponseJson(1, "查询成功", count, list);
		} catch (Exception e) {
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
	}

	/**
	 * 通过职位查询所有员工
	 */
	@Override
	public List<Staff> selectAllStaff(String post) {
		
		return staffDao.selectAllStaff(post);
	}
}
