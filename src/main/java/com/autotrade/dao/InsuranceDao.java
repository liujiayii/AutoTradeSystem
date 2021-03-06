package com.autotrade.dao;

import java.util.List;
import java.util.Map;

import com.autotrade.entity.BuyingCustomer;
import com.autotrade.entity.Insurance;
/**
 * 保险表持久层
 *
 * @ClassName: InsuranceDao

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年1月4日-下午2:10:14
 */
public interface InsuranceDao {
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
    
    /**
     * 分页查询保险表所有信息
     *
     * @Title: selectInsuranceByLimit
    
     * @description 
     *
     * @param map
     * @return 
       
     * List<Insurance>
     *
     * @author lujinpeng
     * @createDate 2019年2月11日-上午10:58:12
     */
    List<Insurance> selectInsuranceByLimit(Map<String, Object> map) throws Exception;
    
    /**
     * 查询总条数
     *
     * @Title: getCount
    
     * @description 
     *
     * @param map
     * @return
     * @throws Exception 
       
     * int
     *
     * @author lujinpeng
     * @createDate 2019年2月11日-上午11:16:57
     */
    int getCount(Map<String, Object> map) throws Exception;
    
    /**
     * 查询保险表对应买车客户信息
     *
     * @Title: selectBuyingCustomer
    
     * @description 
     *
     * @param id
     * @return 
       
     * BuyingCustomer
     *
     * @author lujinpeng
     * @createDate 2019年1月30日-下午4:58:15
     */
    BuyingCustomer selectBuyingCustomer(Long id) throws Exception;
}