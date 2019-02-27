package com.autotrade.entityVo;

import com.autotrade.entity.Project;

public class ProjectVo extends Project{
	/*车的类型（大）*/
	private String names;

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	@Override
	public String toString() {
		return "ProjectVo [names=" + names + "]";
	}
	

}
