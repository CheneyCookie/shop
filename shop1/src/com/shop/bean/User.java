package com.shop.bean;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	//登陆名
	private String login;
	//姓名
	private String name;
	//密码
	private String password;
	//性别
	private String sex;
	//电话
	private String phone;
	//电子邮件
	private String email;

	public User() {
		super();
	}
	
	

	public User(String login) {
		super();
		this.login = login;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", name=" + name
				+ ", password=" + password + ", sex=" + sex + ", phone="
				+ phone + ", email=" + email + "]";
	}

	
}
