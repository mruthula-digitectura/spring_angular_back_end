package com.example.springangular.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_table")
public class User_details_table implements Serializable {

	private static final long serialVersionUID = 6L;
	@Id
	@GeneratedValue
	private int user_id;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private Integer userType;
	
	
    
   
	
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
	@Override
	public String toString() {
		return "User_details_table [user_id=" + user_id + ", firstname=" + firstName + ", lastname=" + lastName
				+ ", userName=" + userName + ", password=" + password + "]";
	}
//	public User_details_table(int user_id, String firstName, String lastName, String userName, String password) {
//		super();
//		this.user_id = user_id;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.userName = userName;
//		this.password = password;
//	}
//	
	
	public User_details_table() {
		
	}
	
	
	
	

	// Generate Getters and Setters...
	
	
}