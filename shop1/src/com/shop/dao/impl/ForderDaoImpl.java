package com.shop.dao.impl;


import org.springframework.stereotype.Repository;

import com.shop.bean.Forder;
import com.shop.dao.ForderDao;

@Repository("forderDao")
public class ForderDaoImpl extends BaseDaoImpl<Forder> implements ForderDao{


	@Override
	public void updateStatusById(int id, int sid) {
		String hql="update Forder f set f.status.id=? where f.id=?";
		getSession().createQuery(hql).setInteger(0, sid)
		.setInteger(2, id).executeUpdate();
	}

	
}
