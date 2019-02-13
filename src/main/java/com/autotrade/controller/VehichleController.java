package com.autotrade.controller;
/**
 * 汽车管理控制器
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
/***
 * 
 *
 * @ClassName: VehichleController

 * @description 车辆管理控制器
 *
 * @author lishaozhang
 * @createDate 2019年1月10日
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.autotrade.entity.Vehichle;
import com.autotrade.service.VehichleService;

@Controller
@RequestMapping("Vehichle")
public class VehichleController {

	@Autowired
	private VehichleService vehichleService;
	
     /***
      * 
     *
      * @Title: insert
     
      * @description 添加
     *
      * @param @param vehichle
      * @param @return 
        
      * @return String    
     
      *
      * @author lishaozhang
      * @createDate 2019年1月10日
      */
	@RequestMapping("insert")
	@ResponseBody
	public String insert (@RequestBody Vehichle vehichle) {		
		
		return vehichleService.insert(vehichle);

	}
	
	/***
	 * 
	*
	 * @Title: deleteByPrimaryKey
	
	 * @description 根据主键删除
	*
	 * @param @param id
	 * @param @return 
	   
	 * @return String    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年1月10日
	 */
	@RequestMapping("deleteByPrimaryKey")
	public String deleteByPrimaryKey (Long id) {		
		
		return vehichleService.deleteByPrimaryKey(id);

	}
	/**
	 * 
	*
	 * @Title: deleteByBrand
	
	 * @description 根据车牌号删除
	*
	 * @param @param brand
	 * @param @return 
	   
	 * @return String    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年1月10日
	 */
	@RequestMapping("deleteByBrand")
	public String deleteByBrand (String brand) {		
		
		return vehichleService.deleteByBrand(brand);

	}
	/**
	 * 
	*
	 * @Title: updateByPrimaryKey
	
	 * @description 修改
	*
	 * @param @param vehichle
	 * @param @return 
	   
	 * @return String    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年1月10日
	 */
	@RequestMapping("updateByPrimaryKey")
	public String updateByPrimaryKey (Vehichle vehichle) {		
		
		return vehichleService.updateByPrimaryKey(vehichle);

	}
	/**
	 * 
	*
	 * @Title: selectByPrimaryKey
	
	 * @description 根据主键查询
	*
	 * @param @param id
	 * @param @return 
	   
	 * @return String    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年1月10日
	 */
	@RequestMapping("selectByPrimaryKey")
	public String selectByPrimaryKey (Long id) {		
		
		return vehichleService.selectByPrimaryKey(id);

	}
	
	@RequestMapping("selectAll")
	@ResponseBody
	public String selectAll (Integer page,Integer limit) {		
		Integer star =(page - 1) * limit;
		return vehichleService.selectAll(star,limit);

	}
	
	
}
