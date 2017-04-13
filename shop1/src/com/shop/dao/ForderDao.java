package com.shop.dao;


import com.shop.bean.Forder;

public interface ForderDao extends BaseDao<Forder>{
	//根据订单编号更新订单状态
	public void updateStatusById(int id,int sid);
	
}
