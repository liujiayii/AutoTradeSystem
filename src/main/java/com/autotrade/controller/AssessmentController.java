package com.autotrade.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.autotrade.entity.Assessment;
import com.autotrade.service.AssessmentService;

/**
 * 
 *
 * @ClassName: AssessmentController
 * 
 * @description 评估表控制器
 *
 * @author lishaozhang
 * @createDate 2019年1月4日
 */
@Controller
@RequestMapping("Assessment")
public class AssessmentController {
	@Autowired
	private AssessmentService assessmentService;

	/**
	 * 
	 *
	 * @Title: insertinsertAssessment
	 * 
	 * @description 添加评估信息
	 *
	 * @param @param
	 *            assessment
	 * @param @return
	 * 
	 * @return String
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年1月4日
	 */
	@RequestMapping("insertAssessment")
	@ResponseBody
	public String insertAssessment(@RequestBody Assessment assessment) {
		assessment.setCreateTime(new Date());

		String string = assessmentService.insertinsertAssessment(assessment);
		return string;

	}

	/**
	 * 
	 *
	 * @Title: deleteByPrimaryKey
	 * 
	 * @description 根据主键id删除评估记录
	 *
	 * @param @param
	 *            id
	 * @param @return
	 * 
	 * @return String
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年1月4日
	 */
	@RequestMapping("deleteByPrimaryKey")
	@ResponseBody
	public String deleteByPrimaryKey(Long id) {

		String string = assessmentService.deleteByPrimaryKey(id);
		return string;

	}

	/**
	 * 
	 *
	 * @Title: deleteByBrand
	 * 
	 * @description 根据车牌号删除评估记录
	 *
	 * @param @param
	 *            brand
	 * @param @return
	 * 
	 * @return String
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年1月4日
	 */
	@RequestMapping("deleteByBrand")
	@ResponseBody
	public String deleteByBrand(String brand) {

		String string = assessmentService.deleteByBrand(brand);
		return string;

	}

	/**
	 * 
	 *
	 * @Title: updateByPrimaryKey
	 * 
	 * @description 修改评估记录
	 *
	 * @param @param
	 *            assessmen
	 * @param @return
	 * 
	 * @return String
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年1月4日
	 */
	@RequestMapping("updateByPrimaryKey")
	@ResponseBody
	public String updateByPrimaryKey(@RequestBody Assessment assessmen) {
		String string = assessmentService.updateByPrimaryKey(assessmen);
		return string;

	}

	/**
	 * 
	 *
	 * @Title: selectAllAssessment
	 * 
	 * @description 分页查询所有评估信息
	 *
	 * @param @param
	 *            page
	 * @param @param
	 *            limit
	 * @param @return
	 * 
	 * @return String
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年1月4日
	 */
	@RequestMapping("selectAllAssessment")
	@ResponseBody
	public String selectAllAssessment(Integer page, Integer limit) {

		String string = assessmentService.selectAllAssessment(page, limit);
		return string;

	}

	/**
	 * 
	 *
	 * @Title: selectAssessmentById
	 * 
	 * @description 根据id查询车辆信息
	 *
	 * @param @param
	 *            id
	 * @param @return
	 * 
	 * @return String
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年1月4日
	 */
	@RequestMapping("selectAssessmentById")
	@ResponseBody
	public String selectAssessmentById(Long id) {

		String string = assessmentService.selectAssessmentById(id);
		return string;
	}

	/**
	 * 
	 *
	 * @Title: selectAssessmentByBrand
	 * 
	 * @description 根据车牌号查询评估信息
	 *
	 * @param @param
	 *            brand
	 * @param @return
	 * 
	 * @return String
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年1月4日
	 */
	@RequestMapping("selectAssessmentByBrand")
	@ResponseBody
	public String selectAssessmentByBrand(String brand) {

		String string = assessmentService.selectAssessmentByBrand(brand);
		return string;
	}

	/***
	 * 
	 *
	 * @Title: selectAssessmentByIntention
	 * 
	 * @description 根据类型分页查询
	 *
	 * @param @param
	 *            intention
	 * @param @param
	 *            star
	 * @param @param
	 *            limit
	 * @param @return
	 * 
	 * @return String
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年1月4日
	 */
	@RequestMapping("selectAssessmentByIntention")
	@ResponseBody
	public String selectAssessmentByIntention(String intention, Integer page, Integer limit) {
		Integer star = (page - 1) * limit;
		String string = assessmentService.selectAssessmentByIntention(intention, star, limit);
		return string;
	}

	/**
	 * *
	 * 
	 * @Title: selectAssessmentByassessment_name
	 * 
	 * @description
	 *
	 * @param @param
	 *            assessment_name
	 * @param @param
	 *            star
	 * @param @param
	 *            limit
	 * @param @return
	 * 
	 * @return String
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年1月7日
	 */
	@RequestMapping("selectAssessmentByassessment_name")
	@ResponseBody
	public String selectAssessmentByassessment_name(String assessment_name, Integer page, Integer limit) {
		Integer star = (page - 1) * limit;
		String string = assessmentService.selectAssessmentByassessment_name(assessment_name, star, limit);
		return string;
	}

	/**
	 * 
	 *
	 * @Title: Allselect
	 * 
	 * @description 混合查询
	 *
	 * @param @param
	 *            assessment_name
	 * @param @param
	 *            page
	 * @param @param
	 *            limit
	 * @param @return
	 * 
	 * @return String
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年1月30日
	 */
	@RequestMapping("Allselect")
	@ResponseBody
	public String Allselect(String assessment_name, Integer page, Integer limit) {
		Integer star = (page - 1) * limit;
		String string = assessmentService.Allselect(assessment_name, star, limit);
		return string;
	}

}
