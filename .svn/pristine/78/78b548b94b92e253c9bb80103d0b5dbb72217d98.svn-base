package com.autotrade.dao;



import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.autotrade.entity.TBooking;
import com.autotrade.entityVo.bookingVo;

public interface TBookingDao {
  

    int deleteByPrimaryKey(Long id);

    int insert(TBooking record);

    int insertSelective(TBooking record);

   

    TBooking selectByPrimaryKey(Long id);

  

    int updateByPrimaryKeySelective(TBooking record);

    int updateByPrimaryKey(TBooking record);

	List<bookingVo> selectAllbook(@Param("page") Integer page, @Param("limit") Integer limit);
	Integer countbook();
}