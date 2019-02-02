package com.autotrade.service;

import com.autotrade.entity.Insurance;
/**
 * 保险表业务层
 *
 * @ClassName: InsuranceDao

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年1月4日-下午2:10:14
 */
public interface InsuranceService {
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
	 * @createDate 2019年1月4日-下午2:15:33
	 */
    int deleteById(Long id);

    /**
     * 插入所有字段数据
     *
     * @Title: insertAll
    
     * @description 
     *
     * @param insurance
     * @return int 
     *
     * @author lujinpeng
     * @createDate 2019年1月4日-下午2:16:15
     */
    int insertAll(Insurance insurance);

    /**
     * 插入指定字段数据
     *
     * @Title: insertSelective
    
     * @description 
     *
     * @param insurance
     * @return int 
     *
     * @author lujinpeng
     * @createDate 2019年1月4日-下午2:16:41
     */
    int insertSelective(Insurance insurance);

    /**
     * 通过id查询
     *
     * @Title: selectById
    
     * @description 
     *
     * @param id
     * @return Insurance 
     *
     * @author lujinpeng
     * @createDate 2019年1月4日-下午2:17:17
     */
    Insurance selectById(Long id);

    /**
     * 修改指定字段数据
     *
     * @Title: updateByIdSelective
    
     * @description 
     *
     * @param insurance
     * @return int 
     *
     * @author lujinpeng
     * @createDate 2019年1月4日-下午2:17:40
     */
    int updateByIdSelective(Insurance insurance);

    /**
     * 修改所有字段数据
     *
     * @Title: updateAllById
    
     * @description 
     *
     * @param insurance
     * @return int 
     *
     * @author lujinpeng
     * @createDate 2019年1月4日-下午2:18:13
     */
    int updateAllById(Insurance insurance);
}