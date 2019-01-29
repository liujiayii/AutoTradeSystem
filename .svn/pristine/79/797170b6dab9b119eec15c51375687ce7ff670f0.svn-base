package com.autotrade.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.autotrade.entity.SellCar;
import com.autotrade.entityVo.SellCarVo;

public interface SellCarDao {

	
	/**
	  * @Title: findByLimit
	  * @description 分页查询售车信息
	  * @param @param page 页数
	  * @param @param limit 每页显示的条数 
	  * @return List<SellCar> 返回售车信息集合   
	  * @author ZhaoSong
	  * @createDate 2019年1月29日
	 */
	List<SellCarVo> findByLimit(@Param("page")Integer page, @Param("limit") Integer limit);
	
	/**
	  * @Title: findAllCount
	  * @description 查询售车信息总数量
	  * @return Integer 返回总数量   
	  * @author ZhaoSong
	  * @createDate 2019年1月29日
	 */
	Integer findAllCount();
	
}
