package com.autotrade.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.autotrade.dao.PurchaseDao;
import com.autotrade.entity.Purchase;
import com.autotrade.service.PurchaseService;
/**
 * 采购表业务层
 *
 * @ClassName: PurchaseDao

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年1月4日-下午2:38:43
 */
@Service
public class PurchaseServiceImpl implements PurchaseService {

	@Resource
	private PurchaseDao purchaseDao;
	
	/**
	 * 通过id删除
	 */
	@Override
	public int deleteById(Long id) {
		
		return purchaseDao.deleteById(id);
	}

	/**
	 * 插入所有字段数据
	 */
	@Override
	public int insertAll(Purchase purchase) {
		
		return purchaseDao.insertAll(purchase);
	}

	/**
	 * 插入指定字段数据
	 */
	@Override
	public int insertSelective(Purchase purchase) {
		
		return purchaseDao.insertSelective(purchase);
	}

	/**
	 * 通过id查询
	 */
	@Override
	public Purchase selectById(Long id) {
		
		return purchaseDao.selectById(id);
	}

	/**
	 * 修改指定字段数据
	 */
	@Override
	public int updateByIdSelective(Purchase purchase) {
		
		return purchaseDao.updateByIdSelective(purchase);
	}

	/**
	 * 修改所有字段数据
	 */
	@Override
	public int updateAllById(Purchase purchase) {
		
		return purchaseDao.updateAllById(purchase);
	}

	/**
	 * 查询采购表信息
	 */
	@Override
	public List<Purchase> selectAllPurchase(Map<String, Object> map) throws Exception {
		
		return purchaseDao.selectAllPurchase(map);
	}

	/**
	 * 查询总条数
	 */
	@Override
	public int getCount(Map<String, Object> map) throws Exception {
		
		return purchaseDao.getCount(map);
	}

	/**
	 * 根据指定条件查询
	 */
	@Override
	public List<Purchase> selectBySelective(Map<String, Object> map) throws Exception {

		return purchaseDao.selectBySelective(map);
	}

	/**
	 * 通过关键字模糊查询字段数据中包含关键字的数据
	 */
	@Override
	public List<Purchase> searchByLike(Map<String, Object> map) throws Exception {
		
		return purchaseDao.searchByLike(map);
	}

	/**
	 * 通过关键字模糊查询字段数据中包含关键字的数据总条数
	 */
	@Override
	public int getCountByLike(Map<String, Object> map) throws Exception {

		return purchaseDao.getCountByLike(map);
	}
	
	
}