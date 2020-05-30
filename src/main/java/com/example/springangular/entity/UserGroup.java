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
@Table(name = "user_group_table")
public class UserGroup  implements Serializable {

	private static final long serialVersionUID = 11L;
	
	private int user_id;
	private int group_id;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
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
	
	public UserGroup() {
		
	}
//	public UserGroup(int user_id, int group_id, int id) {
//		super();
//		this.user_id = user_id;
//		this.group_id = group_id;
//		this.id = id;
//	}
	
	

	
	
	

	// Generate Getters and Setters...
	
	
}