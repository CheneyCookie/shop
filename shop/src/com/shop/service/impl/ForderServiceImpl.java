package com.shop.service.impl;

import org.springframework.stereotype.Service;

import com.shop.bean.Forder;
import com.shop.bean.Sorder;
import com.shop.service.ForderService;

@Service("forderService")
public class ForderServiceImpl extends BaseServiceImpl<Forder> implements ForderService{

	@Override
	public double cluTotal(Forder forder) {
		double total=0.0;
		for(Sorder temp:forder.getSorderList()){
			total+=temp.getNumber()*temp.getPrice();
		}
		return total;
	}

	@Override
	public void updateStatusById(int id, int sid) {
		String hql="update Forder f set f.status.id=? where f.id=?";
		getSession().createQuery(hql).setInteger(0, sid)
		.setInteger(2, id).executeUpdate();
	}
	
}
