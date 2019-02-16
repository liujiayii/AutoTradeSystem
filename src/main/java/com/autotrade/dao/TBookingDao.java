package com.autotrade.dao;



import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.autotrade.entity.TBooking;
import com.autotrade.entity.VehichileDetailed;
import com.autotrade.entityVo.bookingVo;

public interface TBookingDao {
  
   /*删除订单*/
    int deleteByPrimaryKey(Long id);
    /*增加订单*/
    int insert(TBooking record);
    /*增加订单*/
    int insertSelective(TBooking record);

   
   /*查询订单*/
    TBooking selectByPrimaryKey(Long id);

  
    /*修改订单*/
    int updateByPrimaryKeySelective(TBooking record);
    /*修改订单*/
    int updateByPrimaryKey(TBooking record);
    /*根据分页查询全部*/
	List<bookingVo> selectAllbook(@Param("page") Integer page, @Param("limit") Integer limit);
	/*根据id查询单条信息*/
	bookingVo selectAllbookbyId(long c_id);
	/*查询页数*/
	Integer countbook();
	/*模糊查询*/
	List<bookingVo> selectAllbyfield(@Param("s") String s, @Param("star") Integer star, @Param("limit") Integer limit);
	/*模糊查询条数*/
	Integer SelectCountbyfield(String s);
	
}