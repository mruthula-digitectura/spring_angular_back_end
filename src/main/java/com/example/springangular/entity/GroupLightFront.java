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


public class GroupLightFront {

	
	
	private int light_id;
	private String group_name;
	public int getLight_id() {
		return light_id;
	}
	public void setLight_id(int light_id) {
		this.light_id = light_id;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public GroupLightFront(int light_id, String group_name) {
		super();
		this.light_id = light_id;
		this.group_name = group_name;
	}
	public GroupLightFront() {
		
		// TODO Auto-generated constructor stub
	}


	


	// Generate Getters and Setters...
	
	
}