package com.shop.bean;

import java.io.Serializable;

public class Account implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	private String login;
	private String name;
	private String password;
	
	
	
	public Account() {
		super();
	}
	
	
	
	public Account(String login, String name, String password) {
		super();
		this.login = login;
		this.name = name;
		this.password = password;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "Account [id=" + id + ", login=" + login + ", name=" + name
				+ ", password=" + password + "]";
	}
	
}
