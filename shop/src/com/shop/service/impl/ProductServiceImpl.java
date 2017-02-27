package com.shop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.bean.Product;
import com.shop.service.ProductService;
@Service("productService")
@SuppressWarnings("unchecked")
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService{

	@Override
	public List<Product> queryJoinCategory(String name, int page, int size) {
		String hql="from Product p left join fetch p.category where p.name like ?";
		return getSession().createQuery(hql)
				.setString(0,"%" +name+"%")
				.setFirstResult((page-1)*size)
				.setMaxResults(size).list();
		
	}

	@Override
	public Long getCount(String name) {
		String hql="select count(p) from Product p where p.name like ?";
		return (Long) getSession().createQuery(hql)
				.setString(0, "%"+name+"%").uniqueResult();
	}

	@Override
	public void deleteByIds(String ids) {
		String hql="delete from Product where id in ("+ ids +")";
		getSession().createQuery(hql).executeUpdate();
	}

	@Override
	public List<Product> queryByCid(int cid) {
		String hql="from Product p join fetch p.category where p.commend=true and p.open=true and p.category.id=? order by p.date desc";
		return getSession().createQuery(hql)
		.setInteger(0, cid).setFirstResult(0)
		.setMaxResults(4).list();
		
	}

}
