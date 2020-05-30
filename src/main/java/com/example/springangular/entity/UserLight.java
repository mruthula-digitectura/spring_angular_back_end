package com.example.springangular.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_light_table")
public class UserLight  implements Serializable {

	private static final long serialVersionUID = 40L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int user_id;
	private int light_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getLight_id() {
		return light_id;
	}
	public void setLight_id(int light_id) {
		this.light_id = light_id;
	}
	
	
	
	
	
	
//	public UserLight() {
//		
//		// TODO Auto-generated constructor stub
//	}
//	public UserLight(int id, int user_id, int light_id) {
//		super();
//		this.id = id;
//		this.user_id = user_id;
//		this.light_id = light_id;
//	}
//	
	

	
	

	// Generate Getters and Setters...
	
	
}