package com.example.springangular.model;

import java.util.Date;

public class Response {

	// Generate Getters and Setters...
	
	private Object data;
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	private Date date;

	public Response(Object data, Date date) {
		super();
		this.data = data;
		this.date = date;
	}
}