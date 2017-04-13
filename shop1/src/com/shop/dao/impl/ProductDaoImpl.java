package com.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shop.bean.Product;
import com.shop.dao.ProductDao;
@Repository("productDao")
@SuppressWarnings("unchecked")
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao{

	@Override
	public List<Product> queryJoinCategory(String name, int page, int size) {
//		String hql="from Product p left join fetch p.category where p.name like ?";
		String hql="from Product";
		return getSession().createQuery(hql)
				//.setString(0,"%" +name+"%")
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
