package com.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shop.bean.Sorder;
import com.shop.dao.SorderDao;

@Repository("sorderDao")
@SuppressWarnings("unchecked")
public class SorderDaoImpl extends BaseDaoImpl<Sorder> implements SorderDao{




	
	@Override
	public List<Object> querySale(int number) {
		String hql="select s.name,sum(s.number) from Sorder s join s.product group by s.product.id";
		return getSession().createQuery(hql)
		.setFirstResult(0).setMaxResults(number)
		.list();
	}
	
}
