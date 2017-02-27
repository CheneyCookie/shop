package com.shop.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/*
 * 容器的关闭并不会导致session的销毁。
 * 当对象存储在硬盘的时候，就需要实现序列化接口，序列化的功能就是添加了一个唯一的ID（类主键）
 * 这样在反序列化的时候就可以成功找到相应的对象
 * */
//购物车
public class Forder implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	//电话
	private String phone;
	//时间
	private Date date;
	//简单描述
	private String remark;
	//总价
	private Double total;
	//邮编
	private String post;
	//收货地址
	private String address;
	//订单状态
	private Status status;
	//用户
	private User user;
	//订单项
	private List<Sorder> sorderList =new ArrayList<Sorder>();

	public Forder() {
		super();
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}


	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Sorder> getSorderList() {
		return sorderList;
	}

	public void setSorderList(List<Sorder> sorderList) {
		this.sorderList = sorderList;
	}


	@Override
	public String toString() {
		return "Forder [id=" + id + ", name=" + name + ", phone=" + phone
				+ ", date=" + date + ", remark=" + remark + ", total=" + total
				+ ", post=" + post + ", address=" + address + ", status="
				+ status + ", user=" + user + ", sorderList=" + sorderList + "]";
	}

}
