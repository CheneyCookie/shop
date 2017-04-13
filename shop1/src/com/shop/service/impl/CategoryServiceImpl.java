package com.shop.service.impl;


import java.util.List;

import com.shop.bean.Category;
import com.shop.service.CategoryService;

public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService{

	@Override
	public List<Category> queryJoinAccount(String type,int page,int size) {
		return categoryDao.queryJoinAccount(type, page, size);
	}

	@Override
	public Long getCount(String type) {
		return categoryDao.getCount(type);
	}

	@Override
	public void deleteByIds(String ids) {
		categoryDao.deleteByIds(ids);
	}

	@Override
	public List<Category> queryByHot(boolean hot) {
		return categoryDao.queryByHot(hot);
	}
	
}
