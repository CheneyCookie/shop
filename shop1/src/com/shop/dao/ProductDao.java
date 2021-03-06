package com.shop.dao;

import java.util.List;

import com.shop.bean.Product;

public interface ProductDao extends BaseDao<Product>{
	//查询产品信息，级联类别
	public List<Product> queryJoinCategory(String name,int page,int size);
	//根据关键字查询总记录数
	public Long getCount(String name);
	
	public void deleteByIds(String ids);
	
	//根据热点类别，查询当前类别的商品（仅仅查询前4个）
	public List<Product> queryByCid(int cid);
}
