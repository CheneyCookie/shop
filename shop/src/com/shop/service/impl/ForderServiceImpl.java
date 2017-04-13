package com.shop.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.bean.Forder;
import com.shop.bean.Sorder;
import com.shop.service.ForderService;

@Service("forderService")
public class ForderServiceImpl extends BaseServiceImpl<Forder> implements ForderService{

	@Override
	public BigDecimal cluTotal(Forder forder) {
		BigDecimal total=new BigDecimal(0.00);
		for(Sorder temp:forder.getSorderList()){
			total=total.add(temp.getPrice().multiply(new BigDecimal(temp.getNumber())));
		}
		return total;
	}

	@Override
	public void updateStatusById(int id, int sid) {
		forderDao.updateStatusById(id, sid);
	}

	@Override
	public Integer updateNumber(Forder forder) {
		List<Sorder> sorders=forder.getSorderList();
		Integer num=0;
		for(Sorder sorder:sorders){
			num+=sorder.getNumber();
		}
		return num;
	}
	
}
