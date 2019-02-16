package com.autotrade.dao;

import java.util.List;
import java.util.Map;

import com.autotrade.entity.Purchase;
/**
 * 采购表持久层
 *
 * @ClassName: PurchaseDao

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年1月4日-下午2:38:43
 */
public interface PurchaseDao {
	
	/**
	 * 通过id删除
	 *
	 * @Title: deleteById
	
	 * @description 
	 *
	 * @param id
	 * @return int
	 *
	 * @author lujinpeng
	 * @createDate 2019年1月4日-下午2:46:48
	 */
    int deleteById(Long id);

    /**
     * 插入所有字段数据
     *
     * @Title: insertAll
    
     * @description 
     *
     * @param purchase
     * @return int
     *
     * @author lujinpeng
     * @createDate 2019年1月4日-下午2:47:06
     */
    int insertAll(Purchase purchase);

    /**
     * 插入指定字段数据
     *
     * @Title: insertSelective
    
     * @description 
     *
     * @param purchase
     * @return int
     *
     * @author lujinpeng
     * @createDate 2019年1月4日-下午2:47:24
     */
    int insertSelective(Purchase purchase);

    /**
     * 通过id查询
     *
     * @Title: selectById
    
     * @description 
     *
     * @param id
     * @return Purchase
     *
     * @author lujinpeng
     * @createDate 2019年1月4日-下午2:48:07
     */
    Purchase selectById(Long id);

    /**
     * 修改指定字段数据
     *
     * @Title: updateByIdSelective
    
     * @description 
     *
     * @param purchase
     * @return int
     *
     * @author lujinpeng
     * @createDate 2019年1月4日-下午2:48:22
     */
    int updateByIdSelective(Purchase purchase);

    /**
     * 修改所有字段数据
     *
     * @Title: updateAllById
    
     * @description 
     *
     * @param purchase
     * @return int
     *
     * @author lujinpeng
     * @createDate 2019年1月4日-下午2:48:42
     */
    int updateAllById(Purchase purchase);
    
    /**
     * 查询采购表所有信息
     *
     * @Title: selectAllPurchase
    
     * @description 
     *
     * @param map
     * @return 
       
     * List<Purchase>
     *
     * @author lujinpeng
     * @createDate 2019年2月13日-上午9:06:50
     */
    List<Purchase> selectAllPurchase(Map<String, Object> map) throws Exception;
    
    /**
     * 查询总条数
     *
     * @Title: getCount
    
     * @description 
     *
     * @param map
     * @return int
     * @throws Exception 
  
     * @author lujinpeng
     * @createDate 2019年2月13日-上午9:25:23
     */
    int getCount(Map<String, Object> map) throws Exception;
    
    /**
     * 查询指定条件的数据
     *
     * @Title: selectBySelective
    
     * @description 
     *
     * @param map
     * @return
     * @throws Exception 
       
     * List<Purchase>
     *
     * @author lujinpeng
     * @createDate 2019年2月13日-下午3:02:00
     */
    List<Purchase> selectBySelective(Map<String, Object> map) throws Exception;
    
    /**
     * 通过关键字模糊查询字段数据中包含关键字的数据
     *
     * @Title: searchByLike
    
     * @description 
     *
     * @param s 搜索关键字
     * @return
     * @throws Exception 
       
     * List<Purchase>
     *
     * @author lujinpeng
     * @createDate 2019年2月15日-上午11:00:50
     */
    List<Purchase> searchByLike(Map<String, Object> map) throws Exception;
    
    /**
     * 通过关键字模糊查询字段数据中包含关键字的数据总条数
     *
     * @Title: getCountByLike
    
     * @description 
     *
     * @return
     * @throws Exception 
       
     * int
     *
     * @author lujinpeng
     * @createDate 2019年2月15日-上午11:10:24
     */
    int getCountByLike(Map<String, Object> map) throws Exception;
}