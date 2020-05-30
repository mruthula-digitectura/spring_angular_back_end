package com.example.springangular.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import com.example.springangular.entity.Light_table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name = "group_table")
public class Group_table implements Serializable {

	private static final long serialVersionUID = 1681261145191719509L;
	
	@Id
	@GeneratedValue
	private int group_id;
	
	private String groupName;
	
//	protected Group_table() {
//		
//	}
//
//
//	public Group_table(int group_id, String groupName) {
//	
//		this.group_id = group_id;
//		this.groupName = groupName;
//		
//	}
//

	public Group_table() {
		// TODO Auto-generated constructor stub
	}


	public int getGroup_id() {
		return group_id;
	}


	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}


	public String getGroupName() {
		return groupName;
	}


	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}


	@Override
	public String toString() {
		return "Group_table [group_id=" + group_id + ", groupName=" + groupName + "]";
	}
    
	

	
	

	// Generate Getters and Setters...
	
	
}