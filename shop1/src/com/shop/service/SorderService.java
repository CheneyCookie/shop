package com.shop.service;

import java.util.List;

import com.shop.bean.Forder;
import com.shop.bean.Product;
import com.shop.bean.Sorder;

public interface SorderService extends BaseService<Sorder>{
	
	public Forder addSorder(Forder forder,Product product);
	//把商品数据转化Sorder
	public Sorder productToSorder(Product product);
	//根据商品编号更新商品数量
	public Forder updateSorder(Forder forder,Sorder sorder);
	//查询热点商品的销售量
	public List<Object> querySale(int number);
}
