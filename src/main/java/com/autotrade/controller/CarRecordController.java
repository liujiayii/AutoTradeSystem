package com.autotrade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.autotrade.entity.CustomerArchives;
import com.autotrade.entity.DriverInformation;
import com.autotrade.entity.MaintenanceParts;
import com.autotrade.entity.ModelDefinition;
import com.autotrade.entity.VehicleArchives;
import com.autotrade.entity.VehicleArchivesVo;
import com.autotrade.entity.VehicleClassification;
import com.autotrade.service.CustomerArchivesService;
import com.autotrade.service.DriverInformationService;
import com.autotrade.service.MaintenancePartsService;
import com.autotrade.service.ModelDefinitionService;
import com.autotrade.service.VehichleClassificationService;
import com.autotrade.service.VehichleService;
import com.autotrade.service.VehicleArchivesService;
import com.autotrade.utils.JsonUtil;

/**
 * @ClassName: CarRecordController
 * @description 车辆档案，客户档案,驾驶员档案
 * @author ZhaoSong
 * @createDate 2019年2月19日
 */

@Controller
@RequestMapping("/carRecord")
public class CarRecordController {

	@Autowired
	private CustomerArchivesService customerArchivesService;

	@Autowired
	private DriverInformationService driverInformationService;

	@Autowired
	private VehichleClassificationService vehichleClassificationService;

	@Autowired
	private ModelDefinitionService modelDefinitionService;

	@Autowired
	private MaintenancePartsService maintenancaePartsService;
	
	@Autowired
	private VehicleArchivesService vehicleArchliesService;
	/**
	 * @Title: insertCustomerArchives
	 * @description 添加维修用户档案
	 * @param @param
	 *            customerArchives 用户档案信息
	 * @return String 添加结果
	 * @author ZhaoSong
	 * @createDate 2019年2月20日
	 */
	@RequestMapping("insertCustomer")
	@ResponseBody
	public String insertCustomerArchives(CustomerArchives customerArchives) {
		System.out.println(customerArchives.toString());
		String str = null;
		Integer row = customerArchivesService.insertCustomerArchives(customerArchives);
		if (row == 1) {
			str = JsonUtil.getResponseJson(1, "添加成功", null, null);
		} else {
			str = JsonUtil.getResponseJson(-1, "添加失败", null, null);
		}
		return str;
	}
	
	
	/**
	  * @Title: findCustomerByLimit
	  * @description 分页查询、分页模糊查询用户档案
 	  * @param @param page 页数
	  * @param @param limit 每页显示条数
	  * @param @param keyWord 关键字
	  * @return String  Json字符串，返回用户档案集合  
	  * @author ZhaoSong
	  * @createDate 2019年2月25日
	 */
	@RequestMapping("findCustomer")
	@ResponseBody
	public String findCustomerByLimit(Integer page,Integer limit,String keyWord){
		if (page <= 0) {
			page = 1;
		}
		page = (page - 1) * limit;
		String str;
		keyWord="%"+keyWord+"%";
		str = customerArchivesService.findByLimit(page, limit, keyWord);
		return str;
	}
	
	
	/**
	  * @Title: updateCustomer
	  * @description 修改用户档案信息
	  * @param @param customer 用户档案信息
	  * @return String 返回处理结果  
	  * @author ZhaoSong
	  * @createDate 2019年2月25日
	 */
	@RequestMapping("updateCustomer")
	@ResponseBody
	public String updateCustomer(CustomerArchives customerArchives){
		String str;
		if(customerArchives!=null){
			str = customerArchivesService.updateCustomer(customerArchives);
		}else{
			str = JsonUtil.getResponseJson(-1,"数据接收异常", null, null);
		}
		
		return str;
	}
	
	
	
	

	/**
	 * @Title: insertDriver
	 * @description 增加驾驶员档案
	 * @param @param
	 *            driverInformation 驾驶员档案信息
	 * @return String 返回处理结果
	 * @author ZhaoSong
	 * @createDate 2019年2月20日
	 */
	@RequestMapping("insertDriver")
	@ResponseBody
	public String insertDriver(@RequestBody DriverInformation driverInformation) {
		String str = null;
		Integer row = driverInformationService.insertDriver(driverInformation);
		if (row >= 1) {
			str = JsonUtil.getResponseJson(1, "添加成功", null, null);
		} else if(row==-1){
			str = JsonUtil.getResponseJson(-1, "添加失败", null, null);
		}else{
			str =JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
		return str;
	}
	
	/**
	  * @Title: updateDriver
	  * @description 修改驾驶员档案信息
	  * @param @param driver 驾驶员档案对象
	  * @return String  处理结果  
	  * @author ZhaoSong
	  * @createDate 2019年2月24日
	 */
	@RequestMapping("updateDriver")
	@ResponseBody
	public String updateDriver(@RequestBody DriverInformation driver){
		String str = driverInformationService.updateDriver(driver);
		return str ;
	}
	
	
	/**
	  * @Title: findDriverByLimit
	  * @description 分页查询、分页模糊查询驾驶员档案信息
	  * @param @param page 页数 
	  * @param @param limit 每页显示条数
	  * @param @param keyWord 关键字
	  * @return String Json字符串，查询到的信息   
	  * @author ZhaoSong
	  * @createDate 2019年2月24日
	 */
	@RequestMapping("findDriverByLimit")
	@ResponseBody
	public String findDriverByLimit(Integer page,Integer limit,String keyWord){
		if (page <= 0) {
			page = 1;
		}
		page = (page - 1) * limit;
		String str;
		keyWord="%"+keyWord+"%";
		if(page!=null && limit !=null&&keyWord!=null){
			str = driverInformationService.findByLimit(page, limit, keyWord);
		}else{
			str = JsonUtil.getResponseJson(-1,"请输入有效数据", null, null);
		}
		return str;
	}

	
	
	/**
	 * @Title: findCarType
	 * @description 查询所有车型。（如SUV,A级轿车。。。）
	 * @param @return
	 * @return String
	 * @author ZhaoSong
	 * @createDate 2019年2月20日
	 */
	@RequestMapping("findCarType")
	@ResponseBody
	public String findCarType() {
		String str = null;
		List<VehicleClassification> lists = vehichleClassificationService.findCarType();
		if (lists.size() >= 1) {
			str = JsonUtil.getResponseJson(1, "查询成功", lists.size(), lists);
		} else {
			str = JsonUtil.getResponseJson(-1, "查询失败", null, lists);
		}
		return str;
	}
	
	
	/**
	  * @Title: findCarNameByid
	  * @description 根据车型id查车名
	  * @param @param id 车型id
	  * @return String  车型信息  
	  * @author ZhaoSong
	  * @createDate 2019年2月26日
	 */
	@RequestMapping("findCarNameByid")
	@ResponseBody
	public String findCarNameByid(Long id){
		String str = modelDefinitionService.findCarNameByid(id);
		return str;
	}

	/**
	 * @Title: insertCarType
	 * @description 添加车型信息
	 * @param @param
	 *            carType 车辆类型+id
	 * @param @param
	 *            range_rover 车名
	 * @param @param
	 *            brand 汽车厂商
	 * @return String 处理结果
	 * @author ZhaoSong
	 * @createDate 2019年2月20日
	 */
	@RequestMapping("insertCarType")
	@ResponseBody
	public String insertCarType(Long vehicle_classification_id, String vehicle_classification, String range_rover, String brand) {
		String str = null;
		if (vehicle_classification_id == null || range_rover.equals(null) || brand.equals(null) || vehicle_classification.equals(null)) {
			str = JsonUtil.getResponseJson(-1, "请输入有效数据", null, null);
		} else {
			ModelDefinition modelDefinition = new ModelDefinition();
			modelDefinition.setRange_rover(range_rover);
			modelDefinition.setBrand(brand);
			modelDefinition.setVehicle_classification_id(vehicle_classification_id);
			modelDefinition.setVehicle_type(vehicle_classification);
			Integer row = modelDefinitionService.insertModelDefinition(modelDefinition);
			if (row >= 1) {
				str = JsonUtil.getResponseJson(1, "添加车型成功", null, null);
			}else if(row == -1){
				str = JsonUtil.getResponseJson(-1, "添加失败", null, null);
			}else if(row == -2){
				str = JsonUtil.getResponseJson(-1, "您期望添加的车型已存在", null, null);
			}
		}
		return str;
	}

	/**
	  * @Title: findCarTypeByLimit
	  * @description 分页查询车型分类信息
	  * @param @param page 页数
	  * @param @param limit 每页显示条数
	  * @return String JSON字符串，查询结果   
	  * @author ZhaoSong
	  * @createDate 2019年2月21日
	 */
	@RequestMapping("CarTypeLimit")
	@ResponseBody
	public String findCarTypeByLimit(Integer page,Integer limit,String keyWord){
		String json=null;
		if (page <= 0) {
			page = 1;
		}
		page = (page - 1) * limit;
		if(keyWord==null||keyWord.equals("")){
			json = modelDefinitionService.findCarTypeByLimit(page,limit,null);
		}else{
			keyWord="%"+keyWord+"%";
			json = modelDefinitionService.findCarTypeByLimit(page, limit, keyWord);
		}
		return json;
	}
	
	/**
	  * @Title: updateCarType
	  * @description 修改车型信息
	  * @param @param id 车型信息id
	  * @param @param c_id 车型定义表id
	  * @param @param vehicle_type 车型
	  * @param @param range_rover 车名
	  * @param @param brand 汽车厂商（车牌）
	  * @param @return   
	  * @return String    
	  * @author ZhaoSong
	  * @createDate 2019年2月21日
	 */
	@RequestMapping("updateCarType")
	@ResponseBody
	public String updateCarType(Long model_definition_id ,Long vehicle_classification_id,String vehicle_classification,String range_rover,String brand){
		ModelDefinition modelDefinition = new ModelDefinition();
		modelDefinition.setBrand(brand);
		modelDefinition.setVehicle_type(vehicle_classification);
		modelDefinition.setVehicle_classification_id(vehicle_classification_id);
		modelDefinition.setRange_rover(range_rover);
		modelDefinition.setModel_definition_id(model_definition_id);
		String str = modelDefinitionService.updateCarType(modelDefinition);
		if(str!=null){
			return str;
		}else{
			return JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
	}
	
	
	/**
	  * @Title: findClientType
	  * @description 查询客户类型
	  * @return String 返回结果信息
	  * @author ZhaoSong
	  * @createDate 2019年2月25日
	 */
	@RequestMapping("findClientType")
	@ResponseBody
	public String findClientType(){
		String str = maintenancaePartsService.selectAll();
		return str;
	}
	
	
	
	/**
	  * @Title: findCarArchives
	  * @description 查询，模糊查询车辆档案
	  * @param @param page 页数
	  * @param @param limit 每页显示条数
	  * @param @param keyWord 关键字
	  * @return String  返回车辆档案辅助类  
	  * @author ZhaoSong
	  * @createDate 2019年2月25日
	 */
	@RequestMapping("findCarArchives")
	@ResponseBody
	public String findCarArchives(Integer page,Integer limit,String keyWord){
		String str;
		if(page<=0){
			page =  1;
		}
		page = (page-1)*limit;
		if(keyWord.equals("")||keyWord==null){
			str=vehicleArchliesService.findByLimit(page, limit, ""); 
		}else{
			keyWord="%"+keyWord+"%";
			str=vehicleArchliesService.findByLimit(page, limit, keyWord);
		}
		return str;
	}
	
	
	
	/**
	  * @Title: findCarArchivesById
	  * @description 根据id查询车辆档案信息
	  * @param @param id 车辆档案id
	  * @return String  查询结果  
	  * @author ZhaoSong
	  * @createDate 2019年2月25日
	 */
	@RequestMapping("findCarArchivesById")
	@ResponseBody
	public String findCarArchivesById(Long id){
		return vehicleArchliesService.findCarArchivesById(id);
	}
	

	/**
	  * @Title: updateCarArchives
	  * @description 修改车辆档案信息
	  * @param @param vehicleArchivesVo 车辆档案信息辅助类
	  * @return String 处理结果   
	  * @author ZhaoSong
	  * @createDate 2019年2月25日
	 */
	@RequestMapping("updateCarArchives")
	@ResponseBody
	public String updateCarArchives(@RequestBody VehicleArchives vehicleArchives){
		String str =vehicleArchliesService.updateCarArchives(vehicleArchives);
		return str;
	}
	
	
	
	/**
	  * @Title: insertCarArchives
	  * @description 添加车辆档案
	  * @param @param vehicleArchives 车辆档案对象信息
	  * @return String 返回添加结果  
	  * @author ZhaoSong
	  * @createDate 2019年2月26日
	 */
	@RequestMapping("insertCarArchives")
	@ResponseBody
	public String insertCarArchives(@RequestBody VehicleArchives vehicleArchives){
		String str;
		String vehicle_number=vehicleArchives.getVehicle_number();
		
		if(vehicleArchliesService.findVehicleArchivesByVehicleNumber(vehicle_number)!=null){//存在
			str = JsonUtil.getResponseJson(-1,"您所填写的车牌号已存在", null,null);
		}else{//不存在
			str = vehicleArchliesService.insertCarArchives(vehicleArchives);
		}
		
		return str;
	}
	
	
	
	/**
	  * @Title: findClientByPhone
	  * @description 通过电话号码查询用户信息
	  * @param @param phone 电话号码
	  * @return String  JSON字符串,用户信息  
	  * @author ZhaoSong
	  * @createDate 2019年2月25日
	 */
	@RequestMapping("findClientByPhone")
	@ResponseBody
	public String findClientByPhone(String phone){
		String str = customerArchivesService.findClientByPhone(phone);
		return str;
	}
	
	/**
	  * @Title: findDriverByPhone
	  * @description 通过电话号码查询驾驶员信息
	  * @param @param phone 电话号码
	  * @return String JSON字符串,驾驶员信息   
	  * @author ZhaoSong
	  * @createDate 2019年2月25日
	 */
	@RequestMapping("findDriverByPhone")
	@ResponseBody
	public String findDriverByPhone(String phone){
		return driverInformationService.findDriverByPhone(phone);
	}
	
	
	
	
	
	
}
