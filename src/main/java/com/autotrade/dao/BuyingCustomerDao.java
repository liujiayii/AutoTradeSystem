package com.autotrade.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.autotrade.entity.BuyingCustomer;
import com.autotrade.entity.SellingCustomer;

/**
 * @ClassName: BuyingCustomerDao
 * @description dao 接口
 * @author xiaoyuchao
 * @createDate 2019年1月4日
 */
public interface BuyingCustomerDao {
	/**
	  * @Title: selectAll
	  * @description 分页查询所有买车客户
	  * @param @return 
	  * @return List<BuyingCustomer>    
	  * @author xiaoyuchao
	  * @createDate 2019年1月7日
	  */
	 List<BuyingCustomer> selectAll(@Param("star")Integer star,@Param("limit")Integer limit);
	 /**
	     * 根据主键id查询
	     * @Title: selectById
	     * @description 
	     * @param id
	     * @return BuyingCustomer
	     * @author xiaoyuchao
	     * @createDate 2019年1月7日
	     */
	 BuyingCustomer selectById(Long id);
	 /**
	     * 根据姓名查询
	     * @Title: selectByName
	     * @description 
	     * @param name
	     * @return List<BuyingCustomer>
	     * @author xiaoyuchao
	     * @createDate 2019年1月10日
	     */
	 List<BuyingCustomer> selectByName(String name);
	 /**
	     * 根据电话查询
	     * @Title: selectByPhone
	     * @description 
	     * @param phone
	     * @return List<BuyingCustomer>
	     * @author xiaoyuchao
	     * @createDate 2019年1月10日
	     */
	 List<BuyingCustomer> selectByPhone(String phone);
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
	     * @param buyingCustomer
	     * @return int
	     *
	     * @author xiaoyuchao
	     * @createDate 2019年1月7日
	     */
	 int insertAll(BuyingCustomer buyingCustomer);	
	 /**
	     * 插入指定字段数据
	     *
	     * @Title: insertSelective
	    
	     * @description 
	     *
	     * @param buyingCustomer
	     * @return int
	     *
	     * @author xiaoyuchao
	     * @createDate 2019年1月7日
	     */
	  int insertSelective(BuyingCustomer buyingCustomer);
	  /**
	     * 修改所有字段数据
	     *
	     * @Title: updateAllById
	    
	     * @description 
	     *
	     * @param buyingCustomer
	     * @return int
	     *
	     * @author xiaoyuchao
	     * @createDate 2019年1月7日
	     */
	  int updateAllById(BuyingCustomer buyingCustomer);
	  /**
	     * 修改指定字段数据
	     *
	     * @Title: updateByIdSelective
	    
	     * @description 
	     *
	     * @param buyingCustomer
	     * @return int
	     *
	     * @author xiaoyuchao
	     * @createDate 2019年1月7日
	     */
	   int updateByIdSelective(BuyingCustomer buyingCustomer);
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
		   * 根据 姓名，电话，地址，车型，车牌，模糊查询总数量
		  *@author lichangchun
		  * @param str
		  * @return
		  *@return int
		  *@date 2019年1月30日    
		  *
		   */
		   int selectCountByCustomer(@Param("s")String str);
	   /**
	    * 模糊查询
	   *@author lichangchun
	   * @param str
	   * @param star
	   * @param limit
	   * @return
	   *@return List<BuyingCustomer>
	   *@date 2019年1月30日    
	   *
	    */
	   List<BuyingCustomer> selectByCustomer(@Param("s")String str,@Param("star")Integer star,@Param("limit")Integer limit);
}
