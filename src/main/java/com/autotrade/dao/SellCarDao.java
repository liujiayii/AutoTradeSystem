package com.autotrade.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.autotrade.entity.BuyingCustomer;
import com.autotrade.entity.Vehichle;
import com.autotrade.entityVo.SellCarVo;
import com.autotrade.entityVo.ShowCarVo;

public interface SellCarDao {

	/**
	 * @Title: findByLimit
	 * @description 分页查询售车信息
	 * @param @param
	 *            page 页数
	 * @param @param
	 *            limit 每页显示的条数
	 * @return List<SellCar> 返回售车信息集合
	 * @author ZhaoSong
	 * @createDate 2019年1月29日
	 */
	List<SellCarVo> findByLimit(@Param("page") Integer page, @Param("limit") Integer limit);

	/**
	 * @Title: findAllCount
	 * @description 查询售车信息总数量
	 * @return Integer 返回总数量
	 * @author ZhaoSong
	 * @createDate 2019年1月29日
	 */
	Integer findAllCount();

	/**
	 * @Title: findById
	 * @description 通过售车订单Id查询订单信息以及此订单所属用户信息
	 * @param @param
	 *            id 售车订单id
	 * @return ShowCarVo 售车订单对象
	 * @author ZhaoSong
	 * @createDate 2019年1月30日
	 */
	ShowCarVo findById(Integer id);

	/**
	  * @Title: updateSellCar
	  * @description 修改售车订单，根据id
	  * @param @param showCar 售车订单对象
	  * @return Integer  生效行数
	  * @author ZhaoSong
	  * @createDate 2019年1月30日
	 */
	Integer updateSellCar(ShowCarVo showCarVo);
	
	
	
	/**
	  * @Title: findByKeyWord
	  * @description 根据关键字分页查询
	  * @param @param keyWord 关键字
	  * @param @param page 页数
	  * @param @param limit 每页显示的条数
	  * @return List<SellCarVo>  符合查询条件的订单信息
	  * @author ZhaoSong
	  * @createDate 2019年1月30日
	 */
	List<SellCarVo> findByKeyWord(@Param("keyWord")String keyWord,@Param("page")Integer page,@Param("limit")Integer limit);
	
	
	/**
	  * @Title: findClientByPhone
	  * @description 根据买车客户电话查询其信息
	  * @param @param phone 电话号码
	  * @return BuyingCustomer 返回符合查询条件的用户   
	  * @author ZhaoSong
	  * @createDate 2019年1月30日
	 */
	BuyingCustomer findClientByPhone(String phone);
	
	
	
	/**
	  * @Title: findCarByNumber
	  * @description 根据入库编号查询车辆信息
	  * @param @param vehile_number 入库编号
	  * @return Vehichle 返回车辆信息   
	  * @author ZhaoSong
	  * @createDate 2019年2月2日
	 */
	Vehichle findCarByNumber(String vehile_number);
	
	
	/**
	  * @Title: addCarOrder
	  * @description 添加售车订单
	  * @param @param showCarVo 辅助类
	  * @return Integer 生效行数   
	  * @author ZhaoSong
	  * @createDate 2019年2月2日
	 */
	Integer addCarOrder(ShowCarVo showCarVo);
	
	
	/**
	  * @Title: updateCarStatus
	  * @description 根据id修改车辆状态(已售，未售)
	  * @param @param status 状态值
	  * @param @param id 车辆信息id
	  * @return Integer 受影响行数  
	  * @author ZhaoSong
	  * @createDate 2019年2月2日
	 */
	Integer updateCarStatus(@Param("status")Integer status,@Param("id")Long id);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
