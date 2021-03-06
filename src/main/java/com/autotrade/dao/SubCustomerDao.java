package com.autotrade.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.autotrade.entity.BuyingCustomer;
import com.autotrade.entity.SubCustomer;

/**
 * @ClassName: SubCustomerDao
 * @description dao 接口
 * @author xiaoyuchao
 * @createDate 2019年1月7日
 */
public interface SubCustomerDao {
	/**
	  * @Title: selectAll
	  * @description 分页查询所有置换客户
	  * @param @return 
	  * @return List<SubCustomer>    
	  * @author xiaoyuchao
	  * @createDate 2019年1月7日
	  */
	 List<SubCustomer> selectAll(@Param("star")Integer star,@Param("limit")Integer limit);
	 /**
	     * 根据主键id查询
	     * @Title: selectById
	     * @description 
	     * @param id
	     * @return SubCustomer
	     * @author xiaoyuchao
	     * @createDate 2019年1月7日
	     */
	 SubCustomer selectById(Long id);
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
	     * @param SubCustomer
	     * @return int
	     *
	     * @author xiaoyuchao
	     * @createDate 2019年1月7日
	     */
	 int insertAll(SubCustomer subCustomer);
	 /**
	     * 插入指定字段数据
	     *
	     * @Title: insertSelective
	    
	     * @description 
	     *
	     * @param SubCustomer
	     * @return int
	     *
	     * @author xiaoyuchao
	     * @createDate 2019年1月7日
	     */
	  int insertSelective(SubCustomer subCustomer);
	  /**
	     * 修改所有字段数据
	     *
	     * @Title: updateAllById
	    
	     * @description 
	     *
	     * @param SubCustomer
	     * @return int
	     *
	     * @author xiaoyuchao
	     * @createDate 2019年1月7日
	     */
	  int updateAllById(SubCustomer subCustomer);
	  /**
	     * 修改指定字段数据
	     *
	     * @Title: updateByIdSelective
	    
	     * @description 
	     *
	     * @param SubCustomer
	     * @return int
	     *
	     * @author xiaoyuchao
	     * @createDate 2019年1月7日
	     */
	   int updateByIdSelective(SubCustomer subCustomer);
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
	   List<SubCustomer> selectByCustomer(@Param("s")String str,@Param("star")Integer star,@Param("limit")Integer limit);
}
