package com.autotrade.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.autotrade.entity.Vehichle;
/**
 * 
 *
 * @ClassName: VehichleDao

 * @description 汽车管理Dao
 *
 * @author lishaozhang
 * @createDate 2019年1月10日
 */
public interface VehichleDao {
  
    /**
     * 通过主键删除
     * */
    Integer deleteByPrimaryKey(Long id);
    /**
     * 添加
     * */
    Integer insert(Vehichle vehichle);
    /**
     * 通过车牌号删除
     * */
    Integer deleteByBrand(String brand);
    /**
     * 修改
     * */
    Integer updateByPrimaryKeySelective(Vehichle vehichle);    
    /**
     * 修改方式2
     * */
    Integer updateByPrimaryKey(Vehichle vehichle);
    /**
     * 根据主键查询
     * @param id 
     * */
    Vehichle selectByPrimaryKey(Long id);
    /**
     * 查询所有
     * */
    List<Vehichle> selectAll(@Param("star") Integer star, @Param("limit") Integer limit);
    /**
     * 查询所有数据数量
     * */
    Integer selectAllCount();
    /**
     * 多属性模糊查询
     * **/
    /*分页查询所有车辆信息*/
    
    List<Vehichle> hybridSelect(@Param("s") String s, @Param("star") Integer star, @Param("limit") Integer limit);


    /*
     * 多属性模糊查询数量
     * **/

	Integer hybridSelectCount(String s);
	/**
	 * 查询某个属性值的数量
	 * **/
	Integer selectByProperty(@Param("value")String value);
    
}