package com.autotrade.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.autotrade.entity.TBooking;
import com.autotrade.entityVo.bookingVo;

public interface TBookingService {

	
	 int deleteByPrimaryKey(Long id);

	 String insert(TBooking record);

	    int insertSelective(bookingVo record);

	   

	    TBooking selectByPrimaryKey(Long id);

	    String selectAll( Integer page,Integer limit);
	    
	   

	    String updateByPrimaryKeySelective(TBooking record);
	    
	   
	    String selectAllbookbyId(long c_id);
	    String updateByPrimaryKey(TBooking record);
	    
	    /*模糊查询*/
	    String selectAllbyfield( String s,  Integer star, Integer limit);
		
}
