package com.autotrade.entity;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 
 *
 * @ClassName: Repair

 * @description 维修工单实体
 *
 * @author lishaozhang
 * @createDate 2019年2月20日
 */
public class Repair {
	/**主键*/
    private Long id;
    /**车辆档案id*/
    private Long vehicleId;
    /**备注*/
    private String remark;
    /**进场时间*/
    private Date enterTime;
    /**'预约进厂时间'*/
    private Date appointmentTime;
    /**预约完工时间*/
    private Date makespanTime;
    /**结算日期*/
    private Date settlement;
    /***结账日期*/
    private Date closingDate;
    /**结账金额*/
    private BigDecimal money;
    /***结账方式*/
    private String type;
    /**登记人*/
    private String entryPerson;
    /**状态*/
    private int state;
    /***/
    private String vehicle_number;
    
    /**形式里程*/
    private String roadHaul;
    
    public String getVehicle_number() {
		return vehicle_number;
	}

	public void setVehicle_number(String vehicle_number) {
		this.vehicle_number = vehicle_number;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Date enterTime) {
        this.enterTime = enterTime;
    }

    public Date getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Date appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Date getMakespanTime() {
        return makespanTime;
    }

    public void setMakespanTime(Date makespanTime) {
        this.makespanTime = makespanTime;
    }

    public Date getSettlement() {
        return settlement;
    }

    public void setSettlement(Date settlement) {
        this.settlement = settlement;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    

    public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getEntryPerson() {
        return entryPerson;
    }

    public void setEntryPerson(String entryPerson) {
        this.entryPerson = entryPerson == null ? null : entryPerson.trim();
    }
    

	public String getRoadHaul() {
		return roadHaul;
	}

	public void setRoadHaul(String roadHaul) {
		this.roadHaul = roadHaul;
	}

	@Override
	public String toString() {
		return "Repair [id=" + id + ", vehicleId=" + vehicleId + ", remark=" + remark + ", enterTime=" + enterTime
				+ ", appointmentTime=" + appointmentTime + ", makespanTime=" + makespanTime + ", settlement="
				+ settlement + ", closingDate=" + closingDate + ", money=" + money + ", type=" + type + ", entryPerson="
				+ entryPerson + ", state=" + state + ", vehicle_number=" + vehicle_number + ", roadHaul=" + roadHaul
				+ "]";
	}

	

    
}