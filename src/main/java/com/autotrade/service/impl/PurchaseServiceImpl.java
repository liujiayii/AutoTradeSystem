package com.autotrade.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.autotrade.dao.PurchaseDao;
import com.autotrade.dao.StockDao;
import com.autotrade.entity.Purchase;
import com.autotrade.entity.Stock;
import com.autotrade.service.PurchaseService;
import com.autotrade.service.ex.DataNotExistsException;

/**
 * 采购表业务层
 *
 * @ClassName: PurchaseDao
 * 
 * @description
 *
 * @author lujinpeng
 * @createDate 2019年1月4日-下午2:38:43
 */
@Service
public class PurchaseServiceImpl implements PurchaseService {

	@Resource
	private PurchaseDao purchaseDao;
	@Resource
	private StockDao stockDao;

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
	@Transactional
	public int insertSelective(String name, BigDecimal purchaseMoney, Date createTime, String[] type, String[] brand,
			String[] purchase, String[] commodityNumber, String[] quantity, String[] priace, Integer library,
			String remark, String singName) {
		Integer row = 0;
		Purchase p = new Purchase();

		for (int i = 0; i < purchase.length; i++) {

			p.setPurchase(purchase[i]);
			p.setName(name);
			p.setSingName(singName);
			p.setPurchaseMoney(purchaseMoney);
			p.setCreateTime(createTime);
			p.setType(type[i]);
			p.setBrand(brand[i]);
			p.setCommodityNumber(commodityNumber[i]);
			p.setQuantity(Integer.parseInt(quantity[i]));
			p.setPriace(Integer.parseInt(priace[i]));
			p.setLibrary(library);
			p.setRemark(remark);
			row = purchaseDao.insertSelective(p);
			if (row != 0) {
				if (p.getLibrary() != null && p.getLibrary() == 0) {
					// 判断该采购商品库存中是否已存在
					Stock s = stockDao.selectById(p.getCommodityNumber());
					if (s != null) {
						// 已存在
						s.setNumber(s.getNumber() + p.getQuantity());
						row = stockDao.updateByPrimaryKeySelective(s);
						if (row == 0) {
							throw new DataNotExistsException("添加失败，请联系管理员");
						}
					} else {
						s = new Stock();
						s.setCommodity_number(p.getCommodityNumber());
						s.setNumber(p.getQuantity());
						row = stockDao.insertSelective(s);
						if (row == 0) {
							throw new DataNotExistsException("添加失败，请联系管理员");
						}
					}
				}
			}
		}

		return row;
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
	@Transactional
	public int updateByIdSelective(Purchase purchase) {

		Integer row = purchaseDao.updateByIdSelective(purchase);

		return row;
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