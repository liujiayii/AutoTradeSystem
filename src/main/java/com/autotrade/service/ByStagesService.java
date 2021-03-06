package com.autotrade.service;

import java.util.List;
import java.util.Map;

import com.autotrade.entity.ByStages;

/**
 * 分期表业务层
 *
 * @ClassName: ByStagesDao

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年1月4日-下午1:41:18
 */
public interface ByStagesService {

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
	 * @createDate 2019年1月4日-下午2:21:29
	 */
    int deleteById(Long id);

    /**
     * 插入所有字段数据
     *
     * @Title: insertAll
    
     * @description 
     *
     * @param byStages
     * @return int 
     *
     * @author lujinpeng
     * @createDate 2019年1月4日-下午2:21:47
     */
    String insertAll(ByStages byStages);

    /**
     * 插入指定字段数据
     *
     * @Title: insertSelective
    
     * @description 
     *
     * @param byStages
     * @return int 
     *
     * @author lujinpeng
     * @createDate 2019年1月4日-下午2:22:05
     */
    int insertSelective(ByStages byStages);

    /**
     * 通过id查询
     *
     * @Title: selectById
    
     * @description 
     *
     * @param id
     * @return ByStages 
     *
     * @author lujinpeng
     * @createDate 2019年1月4日-下午2:22:52
     */
    ByStages selectById(Long id);

    /**
     * 修改非空字段数据
     *
     * @Title: updateByIdSelective
    
     * @description 
     *
     * @param byStages
     * @return int
     *
     * @author lujinpeng
     * @createDate 2019年1月4日-下午2:24:30
     */
    int updateByIdSelective(ByStages byStages);

    /**
     * 修改所有字段数据
     *
     * @Title: updateAllById
    
     * @description 
     *
     * @param byStages
     * @return int
     *
     * @author lujinpeng
     * @createDate 2019年1月4日-下午2:24:59
     */
    int updateAllById(ByStages byStages);
    
    /**
     * 查询分期表所有信息
     *
     * @Title: selectByLimit
    
     * @description 
     *
     * @return 
       
     * String
     *
     * @author lujinpeng
     * @throws Exception 
     * @createDate 2019年1月29日-上午10:32:55
     */
    String selectByLimit(Map<String, Object> map);
    
    /**
     * 查询分期数据对应买车客户信息
     *
     * @Title: selectBuyingCustomer
    
     * @description 
     *
     * @param id 分期表主键id
     * @return 
       
     * String
     *
     * @author lujinpeng
     * @createDate 2019年1月30日-下午4:59:36
     */
    String selectBuyingCustomer(Long id);
    
    /**
     * 搜索接口
     *
     * @Title: selectBySearchField
    
     * @description 
     *
     * @param map
     * @return 
       
     * String
     *
     * @author lujinpeng
     * @createDate 2019年1月31日-上午10:34:41
     */
    String selectBySearchField(Map<String, Object> map);
    
    /**
     * 通过指定条件查询
     *
     * @Title: selectBySelective
    
     * @description 
     *
     * @return
     * @throws Exception 
       
     * List<ByStages>
     *
     * @author lujinpeng
     * @createDate 2019年2月15日-下午5:23:16
     */
    List<ByStages> selectBySelective(ByStages byStages) throws Exception;
    
    
}