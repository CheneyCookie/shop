package com.shop.service;

import java.math.BigDecimal;

import com.shop.bean.Forder;

public interface ForderService extends BaseService<Forder>{
	//计算购物总价格
	public BigDecimal cluTotal(Forder forder);
	//根据订单编号更新订单状态
	public void updateStatusById(int id,int sid);
	
	public Integer updateNumber(Forder forder);
}
