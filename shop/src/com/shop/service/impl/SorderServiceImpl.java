package com.shop.service.impl;

import org.springframework.stereotype.Service;

import com.shop.bean.Forder;
import com.shop.bean.Product;
import com.shop.bean.Sorder;
import com.shop.service.SorderService;

@Service("sorderService")
public class SorderServiceImpl extends BaseServiceImpl<Sorder> implements SorderService{

	@Override
	public Forder addSorder(Forder forder,Product product) {
		boolean isHave=false;
		Sorder sorder=productToSorder(product);
		//判断当前购物项是否重复，如果重复则添加数量即可
		for(Sorder old:forder.getSorderList()){
			if(old.getProduct().getId().equals(sorder.getProduct().getId())){
				//购物项重复，添加数量即可
				old.setNumber(old.getNumber()+sorder.getNumber());
				isHave=true;
				break;
			}
		}
		//说明当前购物项在购物车中不存在，新添加即可
		if(!isHave){
			//建立项目与购物车的关联，此时forder.id为null,但是在入库的时候是先入库购物车，再入库购物项,那时forder就有主键
			sorder.setForder(forder);
			forder.getSorderList().add(sorder);
		}
		return forder;
	}

	@Override
	public Sorder productToSorder(Product product) {
		Sorder sorder=new Sorder();
		sorder.setName(product.getName());
		sorder.setNumber(1);
		sorder.setPrice(product.getPrice());
		sorder.setProduct(product);
		return sorder;
	}
	
}
