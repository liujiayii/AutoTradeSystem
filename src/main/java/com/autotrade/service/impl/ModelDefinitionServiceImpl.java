package com.autotrade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autotrade.dao.ModelDefinitionDao;
import com.autotrade.entity.ModelDefinition;
import com.autotrade.service.ModelDefinitionService;
import com.autotrade.utils.JsonUtil;

@Service
public class ModelDefinitionServiceImpl implements ModelDefinitionService {

	@Autowired
	private ModelDefinitionDao modelDefinitionDao;

	@Override
	public Integer insertModelDefinition(ModelDefinition modelDefinition) {
		ModelDefinition m = findByRangeRover(modelDefinition.getRange_rover());
		if(m==null){
			Integer row = modelDefinitionDao.insertModelDefinition(modelDefinition);
			if (row >= 1) {
				return row;
			} else {
				return -1;
			}
		}else{
			return -2;
		}
	}

	@Override
	public ModelDefinition findByRangeRover(String range_rover) {
		ModelDefinition modelDefinition = modelDefinitionDao.findByRangeRover(range_rover);
		return modelDefinition;
	}

	@Override
	public String findCarTypeByLimit(Integer page, Integer limit,String keyWord) {
		String str = null;
		List<ModelDefinition> lists;
		if(keyWord==null||keyWord.equals("")){
			lists = modelDefinitionDao.findCarTypeByLimit(page, limit);
			if(lists.size()==0||lists==null){
				str = JsonUtil.getResponseJson(-1,"暂无信息", null, null);
			}else{
				str = JsonUtil.getResponseJson(1, "查询成功", modelDefinitionDao.findCarTypeSum(), lists);
			}
		}else{
			lists = modelDefinitionDao.findCarTypeByKeyWord(page, limit, keyWord);
			if(lists.size()==0||lists==null){
				str = JsonUtil.getResponseJson(-1, "暂无信息",null, null);
			}else{
				str = JsonUtil.getResponseJson(1, "查询成功", modelDefinitionDao.findCountByLimit(keyWord), lists);
			}
					
		}
 		return str;
	}

	
	@Override
	public String  updateCarType(ModelDefinition modelDefinition) {
		String str=null;
		Integer row = modelDefinitionDao.updateCarType(modelDefinition);
		if(row>=1){
			str = JsonUtil.getResponseJson(1, "修改车型成功", null, null);
		}else{
			str = JsonUtil.getResponseJson(-1, "修改成型失败", null, null);
		}
		return str;
	}

	@Override
	public String findCarNameByid(Long id) {
		String str;
		List<ModelDefinition> modelDefinition;
		try {
			 modelDefinition = modelDefinitionDao.findCarNameByid(id);
			if(modelDefinition.size()>0){
				str = JsonUtil.getResponseJson(1,"查询成功",null, modelDefinition);
			}else{
				str = JsonUtil.getResponseJson(1, "无",null, modelDefinition);
}
		} catch (Exception e) {
			str = JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
		return str;
	}
     
}
