package com.autotrade.service;

import java.util.List;
import java.util.Map;

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
     * @param detailsInstallments
     * @return int 
     *
     * @author lujinpeng
     * @createDate 2019年1月4日-下午2:19:03
     */
    String insertAll(DetailsInstallments detailsInstallments);
    
    /**
     * 插入指定字段数据
     *
     * @Title: insertSelective
    
     * @description 
     *
     * @param detailsInstallments
     * @return int 
     *
     * @author lujinpeng
     * @createDate 2019年1月4日-下午2:19:24
     */
    int insertSelective(DetailsInstallments detailsInstallments);
    
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
     * @param detailsInstallments
     * @return int 
     *
     * @author lujinpeng
     * @createDate 2019年1月4日-下午2:20:26
     */
    int updateByIdSelective(DetailsInstallments detailsInstallments);
    
    /** 
     * 修改所有字段数据
     *
     * @Title: updateAllById
    
     * @description 
     *
     * @param detailsInstallments
     * @return int 
     *
     * @author lujinpeng
     * @createDate 2019年1月4日-下午2:20:47
     */
    int updateAllById(DetailsInstallments detailsInstallments);
    
    /**
     * 查询分期详情
     *
     * @Title: selectDetailsInstallments
    
     * @description 
     *
     * @param id
     * @return 
     * List<DetailsInstallments>
     *
     * @author lujinpeng
     * @createDate 2019年1月30日-下午3:25:24
     */
    List<DetailsInstallments> selectDetailsInstallments(Map<String, Object> map) throws Exception;
    
    /**
     * 查询详情总条数
     *
     * @Title: getCount
    
     * @description 
     *
     * @return 
       
     * int
     *
     * @author lujinpeng
     * @createDate 2019年1月30日-下午4:21:32
     */
    int getCount(Map<String, Object> map);
    
}