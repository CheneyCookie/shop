package com.shop.service.impl;


import java.util.List;

import com.shop.bean.Category;
import com.shop.service.CategoryService;

@SuppressWarnings("unchecked")
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService{

	@Override
	public List<Category> queryJoinAccount(String type,int page,int size) {
		String hql="from Category c left join fetch c.account where c.type like ?";
		return getSession().createQuery(hql)
		.setString(0, "%" +type +"%")
		.setFirstResult((page-1)*size)
		.setMaxResults(size)
		.list();
	}

	@Override
	public Long getCount(String type) {
		String hql="select count(c) from Category c where c.type like ?";
		return (Long)getSession().createQuery(hql)
		.setString(0, "%" +type +"%").uniqueResult();
	}

	@Override
	public void deleteByIds(String ids) {
		String hql="delete from Category where id in ("+ ids +")";
		getSession().createQuery(hql).executeUpdate();
	}

	@Override
	public List<Category> queryByHot(boolean hot) {
		String hql="from Category c where c.hot=?";
		return getSession().createQuery(hql)
				.setBoolean(0, hot).list();
	}
	
}
