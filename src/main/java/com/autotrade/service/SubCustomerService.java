package com.autotrade.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.autotrade.entity.SubCustomer;

/**
 *  置换客户业务层
 * @ClassName: SubCustomerService
 * @description 
 * @author xiaoyuchao
 * @createDate 2019年1月7日
 */
public interface SubCustomerService {
	/**
	 * 分页查询全部
	 */
	List<SubCustomer> selectAll(Integer star,Integer limit);
	/**
	 * 根据主键id查询
	 */
	SubCustomer selectById(Long id);
	/**
	 * 根据主键id删除
	 */
	int deleteById(Long id);
	/**
	 * 插入全部字段数据
	 */
	int insertAll(SubCustomer subCustomer);
	/**
	 * 插入指定字段数据
	 */
	int insertSelective(SubCustomer subCustomer);
	/**
	 * 修改全部字段
	 */
	int updateAllById(SubCustomer subCustomer);
	/**
	 * 修改指定字段
	 */
	int updateByIdSelective(SubCustomer subCustomer);
	/**
	 * 查询总数量
	 */
	int selectAllCount();
	
	 /**
	    * 根据 姓名，电话，地址，车型，车牌，模糊查询总数量
	   *@author lichangchun
	   * @param str
	   * @return
	   *@return int
	   *@date 2019年1月30日    
	   *
	    */
	   int selectCountByCustomer(String str);
	   /**
	    * 根据 姓名，电话，地址，车型，车牌，模糊查询
	   *@author lichangchun
	   * @param str
	   * @param star
	   * @param limit
	   * @return
	   *@return List<SubCustomer>
	   *@date 2019年1月30日    
	   *
	    */
	   List<SubCustomer> selectByCustomer(String str,Integer star,Integer limit);
}
