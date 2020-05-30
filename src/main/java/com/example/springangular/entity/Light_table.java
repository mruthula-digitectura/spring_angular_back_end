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
@Table(name = "light_table")
public class Light_table implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int light_id;
	private String lightName;


	protected Light_table() {
		
	}


	public Light_table(int light_id, String lightName) {
		
		this.light_id = light_id;
		this.lightName = lightName;
		
	}
    
	

	


	@Override
	public String toString() {
		return "Light_table [light_id=" + light_id + ", lightName=" + lightName + "]";
	}


	public int getLight_id() {
		return light_id;
	}


	public void setLight_id(int light_id) {
		this.light_id = light_id;
	}


	public String getLightName() {
		return lightName;
	}


	public void setLightName(String lightName) {
		this.lightName = lightName;
	}
	

	// Generate Getters and Setters...
	
	
}