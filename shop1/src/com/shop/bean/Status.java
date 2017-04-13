package com.shop.bean;

import java.io.Serializable;

public class Status implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	//订单状态
	private String status;
	
	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Status(Integer id) {
		super();
		this.id = id;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
