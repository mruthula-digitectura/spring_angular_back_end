package com.example.springangular.pojo;

public class UserDisplayRequest {
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private Integer userType;
	private Integer groupId;
	private Integer lightId;
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Integer getUserType() {
		return userType;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public Integer getLightId() {
		return lightId;
	}
	public UserDisplayRequest(String userName, String password, String firstName, String lastName, Integer userType,
			Integer groupId, Integer lightId) {
		
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userType = userType;
		this.groupId = groupId;
		this.lightId = lightId;
	}
	
	
}
