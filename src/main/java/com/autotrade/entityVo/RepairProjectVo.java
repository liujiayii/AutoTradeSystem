package com.autotrade.entityVo;

import com.autotrade.entity.MaintenanceParts;
import com.autotrade.entity.MaintenanceType;
import com.autotrade.entity.Project;
import com.autotrade.entity.Relation;
import com.autotrade.entity.Repair;
import com.autotrade.entity.RepairProject;
import com.autotrade.entity.VehicleClassification;

/**
 * 维修修理单表扩展类
 *
 * @ClassName: RepairProjectVo

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年2月20日-下午5:43:20
 */
public class RepairProjectVo extends RepairProject {
	// 维修工单对象引用
	private Repair repair;
	// 车型，维修项目、维修类别关联表
	private Relation relation;
	// 维修车型分类表
	private VehicleClassification vehicleClassification;
	// 客户类型表
	private MaintenanceParts maintenanceParts;
	// 维修项目表
	private Project project;
	// 维修类型表
	private MaintenanceType maintenanceType;
	
	public Relation getRelation() {
		return relation;
	}

	public void setRelation(Relation relation) {
		this.relation = relation;
	}

	public VehicleClassification getVehicleClassification() {
		return vehicleClassification;
	}

	public void setVehicleClassification(VehicleClassification vehicleClassification) {
		this.vehicleClassification = vehicleClassification;
	}

	public Repair getRepair() {
		return repair;
	}

	public void setRepair(Repair repair) {
		this.repair = repair;
	}

	public MaintenanceParts getMaintenanceParts() {
		return maintenanceParts;
	}

	public void setMaintenanceParts(MaintenanceParts maintenanceParts) {
		this.maintenanceParts = maintenanceParts;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public MaintenanceType getMaintenanceType() {
		return maintenanceType;
	}

	public void setMaintenanceType(MaintenanceType maintenanceType) {
		this.maintenanceType = maintenanceType;
	}

	@Override
	public String toString() {
		return "RepairProjectVo [repair=" + repair + ", relation=" + relation + ", vehicleClassification="
				+ vehicleClassification + ", maintenanceParts=" + maintenanceParts + ", project=" + project
				+ ", maintenanceType=" + maintenanceType + "]";
	}

	

}
