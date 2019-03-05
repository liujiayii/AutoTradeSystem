package com.autotrade.entityVo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.autotrade.entity.Parts;
import com.autotrade.entity.RepairProject;

/**
 * 
 *
 * @ClassName: Closebills

 * @description 结账单据
 *
 * @author lishaozhang
 * @createDate 2019年3月1日
 */
public class Closebills {
	
	/**
	 * 工单号
	 * **/
	private Long repair_id;
	
	/**
	 * 订单号
	 */
	private String order_number;
	

	/**
	 * 车牌号
	 */
	private String vehicle_number;

	/**
	 * vin号，车辆识别码
	 */
	private String vin;
	
	/**
	 * 车身颜色
	 */
	private String color;
	
	
	
	
	/**
	 * 车辆备注
	 */
	private String vehicle_note;
	
	
	/**
	 * 车名
	 */
	private String range_rover;
	
	
	/**
	 * 区域
	 */
	private String area;
	/**
	 * 客户姓名
	 */
	private String customer_name;
	
	
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 传真
	 */
	private String fax;
	/**
	 * 公司名称
	 */
	private String company;
	/**送修人*/
	private String driver_name;
	
	/**
	 * 车辆备注
	 */
	private String remark;
	/**
	 * 进厂时间
	 * */
	private Date enter_time;
	
	/**登记人*/
	private String entry_person;
	
	/**结算日期*/
	private Date colse_date;
	
	/**工时费*/
	private BigDecimal hour_cost;
	
	/**材料费*/
	private BigDecimal materials;
	
	/**合计金额*/
	private BigDecimal count_money;
	
	/**大写合计金额*/
	private String big_count_money;
	
	/**结账维修用料*/
	private List<Parts> billParts;
	
	/**结账维修项目*/
	private List<RepairProject> billProject;
	
	/**里程数*/
	private String road_haul;
	
	/**结算日期（字符串）*/
	private String sColse_date;
	
	/**预约日期（字符串）*/
	private Date appointment_time;
	
	/**预约日期（字符串）*/
	private String appo_date;
	
	/**结算日期（数据库查询）*/
	private Date closing_date;
	
	/**结算方式（数据库查询）*/
	private String type;
	
	/**实收金额（数据库查询）*/
	private BigDecimal money;
	
	/**发动机号*/
	private String engine_number;
	
	/**状态*/
	private Integer state;
	/**状态*/
	private String stateChinese;
	/**电话号码*/
	private String move_number;
	
	public String getVehicle_number() {
		return vehicle_number;
	}
	public void setVehicle_number(String vehicle_number) {
		this.vehicle_number = vehicle_number;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getVehicle_note() {
		return vehicle_note;
	}
	public void setVehicle_note(String vehicle_note) {
		this.vehicle_note = vehicle_note;
	}
	public String getRange_rover() {
		return range_rover;
	}
	public void setRange_rover(String range_rover) {
		this.range_rover = range_rover;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDriver_name() {
		return driver_name;
	}
	public void setDriver_name(String driver_name) {
		this.driver_name = driver_name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getEnter_time() {
		return enter_time;
	}
	public void setEnter_time(Date enter_time) {
		this.enter_time = enter_time;
	}
	public String getEntry_person() {
		return entry_person;
	}
	public void setEntry_person(String entry_person) {
		this.entry_person = entry_person;
	}
	public Date getColse_date() {
		return colse_date;
	}
	public void setColse_date(Date colse_date) {
		this.colse_date = colse_date;
	}
	public BigDecimal getHour_cost() {
		return hour_cost;
	}
	public void setHour_cost(BigDecimal hour_cost) {
		this.hour_cost = hour_cost;
	}
	public BigDecimal getMaterials() {
		return materials;
	}
	public void setMaterials(BigDecimal materials) {
		this.materials = materials;
	}
	public BigDecimal getCount_money() {
		return count_money;
	}
	public void setCount_money(BigDecimal count_money) {
		this.count_money = count_money;
	}
	public String getBig_count_money() {
		return big_count_money;
	}
	public void setBig_count_money(String big_count_money) {
		this.big_count_money = big_count_money;
	}	
	public List<Parts> getBillParts() {
		return billParts;
	}
	public void setBillParts(List<Parts> billParts) {
		this.billParts = billParts;
	}
	public List<RepairProject> getBillProject() {
		return billProject;
	}
	public void setBillProject(List<RepairProject> billProject) {
		this.billProject = billProject;
	}
	
	public String getRoad_haul() {
		return road_haul;
	}
	public void setRoad_haul(String road_haul) {
		this.road_haul = road_haul;
	}
	
	public String getsColse_date() {
		return sColse_date;
	}
	public void setsColse_date(String sColse_date) {
		this.sColse_date = sColse_date;
	}
	public String getAppo_date() {
		return appo_date;
	}
	public void setAppo_date(String appo_date) {
		this.appo_date = appo_date;
	}
	
	public Date getClosing_date() {
		return closing_date;
	}
	public void setClosing_date(Date closing_date) {
		this.closing_date = closing_date;
	}
	
	public Date getAppointment_time() {
		return appointment_time;
	}
	public void setAppointment_time(Date appointment_time) {
		this.appointment_time = appointment_time;
	}
	
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	
	public String getOrder_number() {
		return order_number;
	}
	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}
	public String getEngine_number() {
		return engine_number;
	}
	public void setEngine_number(String engine_number) {
		this.engine_number = engine_number;
	}
	
	public Long getRepair_id() {
		return repair_id;
	}
	public void setRepair_id(Long repair_id) {
		this.repair_id = repair_id;
	}
	
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getStateChinese() {
		return stateChinese;
	}
	public void setStateChinese(String stateChinese) {
		this.stateChinese = stateChinese;
	}
	public String getMove_number() {
		return move_number;
	}
	public void setMove_number(String move_number) {
		this.move_number = move_number;
	}
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Closebills [vehicle_number=" + vehicle_number + ", vin=" + vin + ", color=" + color + ", vehicle_note="
				+ vehicle_note + ", range_rover=" + range_rover + ", area=" + area + ", customer_name=" + customer_name
				+ ", address=" + address + ", fax=" + fax + ", company=" + company + ", driver_name=" + driver_name
				+ ", remark=" + remark + ", enter_time=" + enter_time + ", entry_person=" + entry_person
				+ ", colse_date=" + colse_date + ", hour_cost=" + hour_cost + ", materials=" + materials
				+ ", count_money=" + count_money + ", big_count_money=" + big_count_money + ", billParts=" + billParts
				+ ", billProject=" + billProject + ", road_haul=" + road_haul +"]";
	}
	
	
	
}
