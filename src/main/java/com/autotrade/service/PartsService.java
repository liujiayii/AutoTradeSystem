package com.autotrade.service;

import com.autotrade.entity.Parts;

/**
 * 
 * 
 *
 * @ClassName: PartsService

 * @description 用一句话描述这个类的作用
 *
 * @author lishaozhang
 * @createDate 2019年2月22日
 */
public interface PartsService {

	String insert(Parts parts);

	String delete(Long id);

	String selectAll(Integer page, Integer limit);

	String update(Parts parts);

	String selectPartsShow(Long repair_id, Integer page, Integer limit);


}
