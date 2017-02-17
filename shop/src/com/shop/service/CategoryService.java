package com.shop.service;

import java.util.List;

import com.shop.bean.Category;


public interface CategoryService extends BaseService<Category>{
	//查询类别信息，级联管理员
	public List<Category> queryJoinAccount(String type,int page,int size);
}
