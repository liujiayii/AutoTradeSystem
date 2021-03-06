package com.autotrade.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.autotrade.entity.SellingCustomer;

/**
 * @ClassName: SellingCustomerDao
 * @description dao 接口
 * @author xiaoyuchao
 * @createDate 2019年1月7日
 */
public interface SellingCustomerDao {
	/**
	  * @Title: selectAll
	  * @description 分页查询所有卖车客户
	  * @param @return 
	  * @return List<SellingCustomer>    
	  * @author xiaoyuchao
	  * @createDate 2019年1月7日
	  */
	 List<SellingCustomer> selectAll(@Param("star")Integer star,@Param("limit")Integer limit);
	 /**
	     * 根据主键id查询
	     * @Title: selectById
	     * @description 
	     * @param id
	     * @return SellingCustomer
	     * @author xiaoyuchao
	     * @createDate 2019年1月7日
	     */
	 SellingCustomer selectById(Long id);
	 /**
	  * 
	   * @Title: selectByName
	   * @description 根据姓名查询
	   * @param @param name
	   * @param @return   
	   * @return SellingCustomer    
	   * @author XiaoYuChao
	   * @createDate 2019年1月11日
	  */
	 SellingCustomer selectByName(String name);
	 /**
	  * 
	   * @Title: selectByPhone
	   * @description 根据电话查询
	   * @param @param phone
	   * @param @return   
	   * @return List<SellingCustomer>    
	   * @author XiaoYuChao
	   * @createDate 2019年1月11日
	  */
	 List<SellingCustomer> selectByPhone(String phone);
	 /**
		 * 通过主键id删除
		 * @Title: deleteById
		 * @description 
		 *
		 * @param id
		 * @return int
		 *
		 * @author xiaoyuchao
		 * @createDate 2019年1月7日
		 */
	 int deleteById(Long id);
	 /**
	     * 插入所有字段数据
	     *
	     * @Title: insertAll
	    
	     * @description 
	     *
	     * @param sellingCustomer
	     * @return int
	     *
	     * @author xiaoyuchao
	     * @createDate 2019年1月7日
	     */
	 int insertAll(SellingCustomer sellingCustomer);
	 /**
	     * 插入指定字段数据
	     *
	     * @Title: insertSelective
	    
	     * @description 
	     *
	     * @param sellingCustomer
	     * @return int
	     *
	     * @author xiaoyuchao
	     * @createDate 2019年1月7日
	     */
	  int insertSelective(SellingCustomer sellingCustomer);
	  /**
	     * 修改所有字段数据
	     *
	     * @Title: updateAllById
	    
	     * @description 
	     *
	     * @param sellingCustomer
	     * @return int
	     *
	     * @author xiaoyuchao
	     * @createDate 2019年1月7日
	     */
	  int updateAllById(SellingCustomer sellingCustomer);
	  /**
	     * 修改指定字段数据
	     *
	     * @Title: updateByIdSelective
	    
	     * @description 
	     *
	     * @param sellingCustomer
	     * @return int
	     *
	     * @author xiaoyuchao
	     * @createDate 2019年1月7日
	     */
	   int updateByIdSelective(SellingCustomer sellingCustomer);
	   /**
	    * 
	     * @Title: selectAllCount
	     * @description 查询总数量
	     * @param @return   
	     * @return int    
	     * @author XiaoYuChao
	     * @createDate 2019年1月24日-下午5:15:33
	    */
	   int selectAllCount();
	   
	   /**
	    * 根据 姓名，电话，地址，车型，车牌，模糊查询
	   *@author lichangchun
	   * @param sellingCustomer
	   * @return
	   *@return List<SellingCustomer>
	   *@date 2019年1月30日    
	   *
	    */
	   List<SellingCustomer> selectByCustomer(@Param("s")String str,@Param("star")Integer star,@Param("limit")Integer limit);
	   
	  /**
	   * 根据 姓名，电话，地址，车型，车牌，模糊查询总数量
	  *@author lichangchun
	  * @param str
	  * @return
	  *@return int
	  *@date 2019年1月30日    
	  *
	   */
	   int selectCountByCustomer(@Param("s")String str);
}
