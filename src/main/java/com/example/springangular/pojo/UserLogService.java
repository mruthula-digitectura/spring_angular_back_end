package com.example.springangular.pojo;

public class UserLogService {

	private String userName;
	private String password;
	private String userType;
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public String getUserType() {
		return userType;
	}
	public UserLogService(String userName, String password, String userType) {
		
		this.userName = userName;
		this.password = password;
		this.userType = userType;
	}
	
	
}
