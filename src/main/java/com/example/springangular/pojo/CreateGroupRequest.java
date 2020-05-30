package com.example.springangular.pojo;

import java.util.List;

public class CreateGroupRequest {

	private Integer groupId;
	private String groupName;
	

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	private List<Integer> lightIdList;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<Integer> getLightIdList() {
		return lightIdList;
	}

	public void setLightIdList(List<Integer> lightIdList) {
		this.lightIdList = lightIdList;
	}

}
