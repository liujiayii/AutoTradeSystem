package com.autotrade.dao;

import com.autotrade.entityVo.Closebills;

/**
 * 
 *
 * @ClassName: BillDao

 * @description 结算单Dao
 *
 * @author lishaozhang
 * @createDate 2019年3月4日
 */
public interface BillDao {

	/***
	 * 
	*
	 * @Title: creatBill
	
	 * @description 查询账单所需部分信息
	*
	 * @param @param repair_id
	
	 * @author lishaozhang
	 * @createDate 2019年3月4日
	 */
  Closebills creatBill(Long repair_id);
}
