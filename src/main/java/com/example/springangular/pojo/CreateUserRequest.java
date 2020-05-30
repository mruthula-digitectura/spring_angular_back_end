package com.example.springangular.pojo;

import java.util.List;

public class CreateUserRequest {

	private Integer userId;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private Integer userType;
	private List<Integer> usergroupIdList;
	private List<Integer> userlightIdList;
	
	
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getUserId() {
		return userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	
	
	public List<Integer> getUsergroupIdList() {
		return usergroupIdList;
	}
	public void setUsergroupIdList(List<Integer> usergroupIdList) {
		this.usergroupIdList = usergroupIdList;
	}
	public List<Integer> getUserlightIdList() {
		return userlightIdList;
	}
	public void setUserlightIdList(List<Integer> userlightIdList) {
		this.userlightIdList = userlightIdList;
	}
	
	
	

	
}
