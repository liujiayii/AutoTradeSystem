package com.autotrade.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.autotrade.dao.MaintenancePartsDao;
import com.autotrade.dao.ProjectDao;
import com.autotrade.dao.RelationDao;
import com.autotrade.dao.VehichleClassificationDao;
import com.autotrade.entity.MaintenanceParts;
import com.autotrade.entity.Project;
import com.autotrade.entity.Relation;
import com.autotrade.entity.VehicleClassification;
import com.autotrade.entityVo.ProjectVo;
import com.autotrade.service.ProjectService;
import com.autotrade.utils.JsonUtil;

/**
 * 维修项目表service层实现类
 *
 * @ClassName: ProjectServiceImpl
 * 
 * @description
 *
 * @author lujinpeng
 * @createDate 2019年2月20日-上午11:14:22
 */
@Service
public class ProjectServiceImpl implements ProjectService {
	String astring;
	String bstring;

	@Autowired
	private ProjectDao projectDao;

	@Autowired
	private VehichleClassificationDao vehichleClassificationDao;

	@Autowired
	private MaintenancePartsDao maintenancePartsDao;
	@Autowired
	private RelationDao relationDao;

	private Object arga;

	private Object argb;

	/**
	 * 插入全部
	 */
	@Override
	public int insertAll(Project project) {

		return projectDao.insertAll(project);
	}

	/**
	 * 插入指定数据
	 */
	@Override
	public int insertSelective(Project project) {

		return projectDao.insertSelective(project);
	}

	@Override
	public String selectAll(Integer page, Integer limit) {
		String string;
		Integer star = (page - 1) * limit;
		/* try { */
		System.out.println("------" + star + "++++" + limit);
		List<ProjectVo> projectList = projectDao.selectAll(star, limit);
		System.out.println("heheh");
		// 未查到数据
		if (projectList.size() <= 0) {
			System.out.println("shibai");
			string = JsonUtil.getResponseJson(1, "暂无数据", null, null);
		} else {
			System.out.println("chneggong");

			// 查询到数据返回总数及当前页数据
			string = JsonUtil.getResponseJson(1, "查询成功", projectDao.countAll(), projectList);
		}

		/* } */ /*
				 * catch (Exception e) { // 异常 return
				 * JsonUtil.getResponseJson(-1, "系统异常", null, null); }
				 */

		return string;
	}

	/**
	 * 通过指定条件查询
	 */
	@Override
	public List<ProjectVo> selectBySelective(Map<String, Object> map) {

		return projectDao.selectBySelective(map);
	}

	/**
	 * 通过指定条件查询获取数据总条数
	 */
	@Override
	public int getCount(Map<String, Object> map) {

		return projectDao.getCount(map);
	}

	@Override
	public List<ProjectVo> selectAllbytype(String s, Integer star, Integer limit) {

		return projectDao.selectAllbytype(s, star, limit);
	}

	@Override
	public Integer countAllbytype(String s) {

		return projectDao.countAllbytype(s);
	}

	@Override
	public String AddRelation(@RequestBody JSONObject obj) {

		String string = null;
		Integer number = 0;

		try {
			String data = obj.toJSONString();
			// 解析json数据
			JSONObject json = JSON.parseObject(data);
			List<VehicleClassification> Vehiclelist = vehichleClassificationDao.findCarType();
			List<MaintenanceParts> Partslist = maintenancePartsDao.selectAll();
			String xmid = json.getString("id");

			long xid = Long.parseLong(xmid);

			for (int b = 0; b < Partslist.size(); b++) {
				String PartsId = json.toJSONString(Partslist.get(b).getId());// 客户类型id

				long kid = Long.parseLong(PartsId);
				String pid = json.getString(PartsId);
				JSONObject jsonObject = (JSONObject) JSON.parse(pid);

				for (int a = 0; a < Vehiclelist.size(); a++) {
					String VehicleId = json.toJSONString(Vehiclelist.get(a).getId());// 车型id
					long cid = Long.parseLong(VehicleId);
					String mid = jsonObject.getString(VehicleId);
					JSONObject jsonObjectone = (JSONObject) JSON.parse(mid);
					Integer time = Integer.valueOf(jsonObjectone.getString("houser"));
					String price = jsonObjectone.getString("price");
					BigDecimal bd = new BigDecimal(price);
					Relation r = new Relation();
					r.setHouser(time);
					r.setPrice(bd);
					r.setMaintenance_parts_id(kid);
					r.setVehicle_classification_id(cid);
					r.setProject_id(xid);
					r.setCreate_time(new Date());
					System.out.println("佛主" + r);
					Integer result = projectDao.AddRelation(r);
					number = number + result;
				}
			}

			if (number >= Vehiclelist.size() * Partslist.size()) {

				string = JsonUtil.getResponseJson(1, "添加成功", null, null);
			} else {
				string = JsonUtil.getResponseJson(1, "添加失败", null, null);
			}

		} catch (Exception e) {
			// 程序异常
			e.printStackTrace();
			string = JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
		return string;
	}

	/*
	 * @Override public String selcectByproject(Long id) {
	 * 
	 * String str; JSONObject obj=new JSONObject(); JSONObject objone=new
	 * JSONObject(); JSONObject objtwo=new JSONObject();
	 * 
	 * List<Relation> list=relationDao.selcectByproject(id); List<Relation>
	 * listmpid=relationDao.selcectByMpid(id);
	 * 
	 * 
	 * Map<Object,Object> mapListtwo=new HashMap(); Map<Object,Object>
	 * mapList=new HashMap(); Map<String,Object> map=new HashMap();
	 * mapList.put("id", id); for(int b=0;b<listmpid.size();b++){ List<Relation>
	 * listmpidList=relationDao.selcectByMpidList(id,
	 * listmpid.get(b).getMaintenance_parts_id()); for(int
	 * c=0;c<listmpidList.size();c++){
	 * 
	 * // List<Relation> Listvid=relationDao.selcectByvehicle(id,
	 * listmpid.get(b).getMaintenance_parts_id(),
	 * listmpidList.get(c).getVehicle_classification_id());
	 * 
	 * 
	 * 
	 * mapListtwo.put("houser",listmpidList.get(c).getHouser());
	 * mapListtwo.put("price", listmpidList.get(c).getPrice());
	 * 
	 * String
	 * s="{houser:"+listmpidList.get(c).getHouser()+",price:"+listmpidList.get(c
	 * ).getPrice()+"}"; String
	 * l=String.valueOf(listmpidList.get(c).getVehicle_classification_id());
	 * System.out.println(l); map.put(l, s); System.out.println("map"+map); }
	 * System.out.println("客户"+listmpid.get(b).getMaintenance_parts_id().
	 * toString()+"值"+map);
	 * astring=listmpid.get(b).getMaintenance_parts_id().toString();
	 * System.out.println("map"+map); bstring=map.toString().replace("=", ":");
	 * System.out.println("string"+bstring); mapList.put(astring, bstring); }
	 * 
	 * JSONObject jsonObject = new JSONObject(); jsonObject.put("data",
	 * mapList); str=FastJsonUtil.getResponseJson(1, "成功", mapList);
	 * 
	 * System.out.println(str);
	 * 
	 * 
	 * // System.out.println(FastJsonUtil.getResponseJson(1, "成功", mapList));
	 * return str; }
	 */

	@Override
	public String selcectByproject(Long id) {

		String str;

		try {
			List<Relation> listmpid = relationDao.selcectByproject(id);
			str = JsonUtil.getResponseJson(1, "查询成功", null, listmpid);

		} catch (Exception e) {
			str = JsonUtil.getResponseJson(-1, "查询失败", null, null);
		}

		return str;
	}

	@Override
	public int hashCode() {
		return Objects.hash(astring, bstring);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ProjectServiceImpl)) {
			return false;
		}
		ProjectServiceImpl p = (ProjectServiceImpl) obj;
		if (this.astring.equals(p.astring) && this.bstring.equals(p.bstring)) {
			return true;
		} else {
			return false;
		}

	}

}
