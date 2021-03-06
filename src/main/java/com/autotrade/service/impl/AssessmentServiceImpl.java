package com.autotrade.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autotrade.dao.AssessmentDao;
import com.autotrade.entity.Assessment;
import com.autotrade.service.AssessmentService;
import com.autotrade.utils.JsonUtil;

@Service
public class AssessmentServiceImpl implements AssessmentService {
	@Autowired
	private AssessmentDao assessmentDao;

	@Override
	public String insertinsertAssessment(Assessment assessment) {
		String string;
		try {
			// 评估提交的时间
			assessment.setCreateTime(new Date());

			Integer result = assessmentDao.insertAssessment(assessment);
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
	public String deleteByPrimaryKey(Long id) {

		String string;

		try {

			Integer deleteByPrimaryKey = assessmentDao.deleteByPrimaryKey(id);

			if (deleteByPrimaryKey >= 1) {
				string = JsonUtil.getResponseJson(1, "删除成功", null, null);
			} else {
				string = JsonUtil.getResponseJson(1, "记录不存在", null, null);
			}

			return string;
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
	}

	@Override
	public String deleteByBrand(String brand) {

		String string;

		try {

			Integer deleteByBrand = assessmentDao.deleteByBrand(brand);

			if (deleteByBrand >= 1) {
				string = JsonUtil.getResponseJson(1, "删除成功", null, null);
			} else {
				string = JsonUtil.getResponseJson(1, "记录不存在", null, null);
			}

			return string;
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
	}

	@Override
	public String updateByPrimaryKey(Assessment assessmen) {
		String string;

		try {

			Integer updateByPrimaryKey = assessmentDao.updateByPrimaryKey(assessmen);

			if (updateByPrimaryKey >= 1) {
				string = JsonUtil.getResponseJson(1, "修改成功", null, null);
			} else {
				string = JsonUtil.getResponseJson(1, "记录不存在", null, null);
			}

			return string;
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
	}

	@Override
	public String selectAllAssessment(Integer page, Integer limit) {
		String string;
		Integer star = (page - 1) * limit;
		try {

			List<Assessment> AssessmentList = assessmentDao.selectAll(star, limit);
			// 未查到数据
			if (AssessmentList.size() <= 0) {
				string = JsonUtil.getResponseJson(1, "", null, AssessmentList);
			} else {
				// 查询到数据返回总数及当前页数据
				//System.out.println("返回的数据为"+assessmentDao.selectAllCount()+"      "+AssessmentList);
				string = JsonUtil.getResponseJson(1, "查询成功", assessmentDao.selectAllCount(), AssessmentList);
			}

		} catch (Exception e) {
			// 异常
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}

		return string;
	}

	@Override
	public String selectAssessmentById(Long id) {
		String string;

		try {

			Assessment selectAssessmentById = assessmentDao.selectAssessmentById(id);

			string = JsonUtil.getResponseJson(1, "查询成功", 1, selectAssessmentById);

			return string;
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
	}

	@Override
	public String selectAssessmentByBrand(String brand) {
		String string;

		try {

			List<Assessment> selectAssessmentById = assessmentDao.selectAssessmentByBrand(brand, 1, 1);

			string = JsonUtil.getResponseJson(1, "查询成功", 1, selectAssessmentById);

			return string;
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
	}

	@Override
	public String selectAssessmentByIntention(String intention, Integer star, Integer limit) {

		String string;
		try {
			List<Assessment> selectAssessmentByIntention = assessmentDao.selectAssessmentByIntention(intention, star,
					limit);

			if (selectAssessmentByIntention.size() >= 1) {
				string = JsonUtil.getResponseJson(1, "查询成功", assessmentDao.selectAssessmentCountByIntention(intention),
						selectAssessmentByIntention);
			} else {
				string = JsonUtil.getResponseJson(1, "", null, selectAssessmentByIntention);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}

		return string;
	}

	@Override
	public String selectAssessmentByassessment_name(String assessment_name, Integer star, Integer limit) {
		String string;
		try {
			List<Assessment> selectAssessmentByassessment_name = assessmentDao
					.selectAssessmentByassessment_name(assessment_name, star, limit);

			if (selectAssessmentByassessment_name.size() >= 1) {
				string = JsonUtil.getResponseJson(1, "查询成功",
						assessmentDao.selectAssessmentCountByassessment_name(assessment_name),
						selectAssessmentByassessment_name);
			} else {
				string = JsonUtil.getResponseJson(1, "", null, selectAssessmentByassessment_name);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}

		return string;
	}

	@Override
	public String Allselect(String assessment_name, Integer star, Integer limit) {
		try {
			List<Assessment> selectAllselect = assessmentDao.selectAllselect(assessment_name, star, limit);

			Integer selectAllselectCount = assessmentDao.selectAllselectCount(assessment_name);

			if (selectAllselectCount == 0) {
				return JsonUtil.getResponseJson(1, "", null, selectAllselect);
			}

			return JsonUtil.getResponseJson(1, "查询成功", selectAllselectCount, selectAllselect);
		} catch (Exception e) {
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}

	}

}
