package com.shop.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	//商品价格
	private BigDecimal price;
	//商品图片
	private String picture;
	//商品简单介绍
	private String remark;
	//商品详细介绍
	private String xremark;
	//商品生产日期
	private Date date;
	//是否为推荐商品，推荐商品才有可能显示在商城首页
	private Boolean commend;
	//是否为有效商品
	private Boolean open;
	//商品所在的类别编号
	private Category category;
	
	
	
	public Product() {
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
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getXremark() {
		return xremark;
	}
	public void setXremark(String xremark) {
		this.xremark = xremark;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Boolean getCommend() {
		return commend;
	}
	public void setCommend(Boolean commend) {
		this.commend = commend;
	}
	public Boolean getOpen() {
		return open;
	}
	public void setOpen(Boolean open) {
		this.open = open;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Product(Integer id, String name, BigDecimal price, String picture,
			String remark, String xremark, Boolean commend,
			Boolean open) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.picture = picture;
		this.remark = remark;
		this.xremark = xremark;
		this.commend = commend;
		this.open = open;
	}
	public Product(int id, String name, BigDecimal price, String picture,
			String remark, String xremark, boolean commend, boolean open) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.picture = picture;
		this.remark = remark;
		this.xremark = xremark;
		this.commend = commend;
		this.open = open;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price
				+ ", picture=" + picture + ", remark=" + remark + ", xremark="
				+ xremark + ", date=" + date + ", commend=" + commend
				+ ", open=" + open + "]";
	}
	
	
}
