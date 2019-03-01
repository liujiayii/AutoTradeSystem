package com.autotrade.entityVo;

/***
 * 
 *
 * @ClassName: RepairSelect
 * 
 * @description 查询条件类
 *
 * @author lishaozhang
 * @createDate 2019年2月20日
 */
public class RepairSelect {

	/** 登记人 */
	private String entryPerson;
	/** 车牌号码 */
	private String vehicleNumber;
	/** 车型 */
	private String vehicleType;
	/** 发动机号 **/
	private String engineNumber;
	/** 维修类别 */
	private String category;
	/** vin号 */
	private String vin;
	/** 预约进场时间 */
	private String appointmentTime;
	/*** 进场时间 */
	private String enterTime;
	/*** 状态 */
	private String state;
	/*** 预约完工时间 */
	private String makespanTime;

	/*** 客户姓名 */
	private String customerName;
	/*** 客户电话 */
	private String phoneNumber;
	/** 车辆颜色 */
	private String color;
	/** 为了分页 */
	private Integer page;
	private Integer star;
	private Integer limit;

	public String getEntryPerson() {
		return entryPerson;
	}

	public void setEntryPerson(String entryPerson) {
		this.entryPerson = entryPerson;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getEngineNumber() {
		return engineNumber;
	}

	public void setEngineNumber(String engineNumber) {
		this.engineNumber = engineNumber;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public String getEnterTime() {
		return enterTime;
	}

	public void setEnterTime(String enterTime) {
		this.enterTime = enterTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMakespanTime() {
		return makespanTime;
	}

	public void setMakespanTime(String makespanTime) {
		this.makespanTime = makespanTime;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getStar() {
		return star;
	}

	public void setStar(Integer star) {
		this.star = star;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "RepairSelect [entryPerson=" + entryPerson + ", vehicleNumber=" + vehicleNumber + ", vehicleType="
				+ vehicleType + ", engineNumber=" + engineNumber + ", category=" + category + ", vin=" + vin
				+ ", appointmentTime=" + appointmentTime + ", enterTime=" + enterTime + ", state=" + state
				+ ", makespanTime=" + makespanTime + ", page=" + page + ", star=" + star + ", limit=" + limit + "]";
	}

}
