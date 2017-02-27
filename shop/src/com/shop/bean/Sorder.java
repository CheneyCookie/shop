package com.shop.bean;

import java.io.Serializable;

//购物项，订单项
public class Sorder implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	//单价
	private Float price;
	//数量
	private Integer number;
	//所属购物车
	private Forder forder;
	//商品列表
	private Product product;

	public Sorder() {
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

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Forder getForder() {
		return forder;
	}

	public void setForder(Forder forder) {
		this.forder = forder;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Sorder [id=" + id + ", name=" + name + ", price=" + price
				+ ", number=" + number + ", product=" + product + "]";
	}


}
