package com.example.springangular.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "group_light_table")
public class GroupLight implements Serializable {

	private static final long serialVersionUID = 10L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int group_id;
	
	private Integer light_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	public Integer getLight_id() {
		return light_id;
	}

	public void setLight_id(Integer light_id) {
		this.light_id = light_id;
	}
	
	

//	public int getId() {
//		return id;
//	}
//
////	public GroupLight(int id, int group_id, Integer light_id) {
////		super();
////		this.id = id;
////		this.group_id = group_id;
////		this.light_id = light_id;
////	}
//
////	public List<GroupLight> getLight_id() {
////		return light_id;
////	}
////
////	public void setLight_id(List<GroupLight> light_id) {
////		this.light_id = light_id;
////	}
//
//	public int getGroup_id() {
//		return group_id;
//	}
//
//	public Integer getLight_id() {
//		return light_id;
//	}
//
//	public void setLight_id(Integer light_id) {
//		this.light_id = light_id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public void setGroup_id(int group_id) {
//		this.group_id = group_id;
//	}
//
////	public GroupLight() {
////
////		// TODO Auto-generated constructor stub
////	}
//
//	@Override
//	public String toString() {
//		return "GroupLight [group_id=" + group_id + ", light_id=" + light_id + "]";
//	}
//
//	// Generate Getters and Setters...

}