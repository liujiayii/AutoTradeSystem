package com.autotrade.dao;

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
}