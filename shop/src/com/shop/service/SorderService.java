package com.shop.service;

import com.shop.bean.Forder;
import com.shop.bean.Product;
import com.shop.bean.Sorder;

public interface SorderService extends BaseService<Sorder>{
	
	public Forder addSorder(Forder forder,Product product);
	//把商品数据转化Sorder
	public Sorder productToSorder(Product product);
}
