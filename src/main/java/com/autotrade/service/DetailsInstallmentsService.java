package com.autotrade.service;

import com.autotrade.entity.DetailsInstallments;
/**
 * 分期详情表业务层
 *
 * @ClassName: DetailsInstallmentsDao

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年1月4日-下午1:54:55
 */
public interface DetailsInstallmentsService {
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
	 * @createDate 2019年1月4日-下午2:18:50
	 */
    int deleteById(Long id);
    
    /**
     * 插入所有字段数据
     *
     * @Title: insertAll
    
     * @description 
     *
     * @param record
     * @return int 
     *
     * @author lujinpeng
     * @createDate 2019年1月4日-下午2:19:03
     */
    int insertAll(DetailsInstallments record);
    
    /**
     * 插入指定字段数据
     *
     * @Title: insertSelective
    
     * @description 
     *
     * @param record
     * @return int 
     *
     * @author lujinpeng
     * @createDate 2019年1月4日-下午2:19:24
     */
    int insertSelective(DetailsInstallments record);
    
    /**
     * 通过id查询
     *
     * @Title: selectById
    
     * @description 
     *
     * @param id
     * @return DetailsInstallments 
     *
     * @author lujinpeng
     * @createDate 2019年1月4日-下午2:20:01
     */
    DetailsInstallments selectById(Long id);
    
    /**
     * 修改指定字段数据
     *
     * @Title: updateByIdSelective
    
     * @description 
     *
     * @param record
     * @return int 
     *
     * @author lujinpeng
     * @createDate 2019年1月4日-下午2:20:26
     */
    int updateByIdSelective(DetailsInstallments record);
    
    /** 
     * 修改所有字段数据
     *
     * @Title: updateAllById
    
     * @description 
     *
     * @param record
     * @return int 
     *
     * @author lujinpeng
     * @createDate 2019年1月4日-下午2:20:47
     */
    int updateAllById(DetailsInstallments record);
}