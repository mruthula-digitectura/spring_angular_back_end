package com.example.springangular.pojo;
import javax.persistence.*;

//@SqlResultSetMapping(name = "GroupMapping", 
//classes = @ConstructorResult(
//		targetClass = DisplayGroupRequest.class, 
//		columns = {@ColumnResult(name = "group_name"),
//			   @ColumnResult(name = "light_id")}
//		)
//)
public class DisplayGroupRequest {
	
	private String group_name;
	private Integer light_id;
	public String getGroup_name() {
		return group_name;
	}
	public Integer getLight_id() {
		return light_id;
	}
	public DisplayGroupRequest(String group_name, Integer light_id) {
		
		this.group_name = group_name;
		this.light_id = light_id;
	}
	
	
	
	
	
	

}
