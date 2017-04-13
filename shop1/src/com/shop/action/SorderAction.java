package com.shop.action;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.shop.bean.Forder;
import com.shop.bean.Product;
import com.shop.bean.Sorder;

@Controller
@Scope("prototype")
public class SorderAction extends BaseAction<Sorder>{
	
	private static final long serialVersionUID = 1L;
	//根据商品编号更新商品数量
	public String updateSorder(){
		Forder forder=(Forder) session.get("forder");
		forder=sorderService.updateSorder(forder, model);
		forder.setTotal(forderService.cluTotal(forder));
		session.put("forder",forder);
		//返回新的总价格
		inputStream=new ByteArrayInputStream(forder.getTotal().toString().getBytes());
		return "stream";
	}
	
	
	public String addSorder(){
		//1.根据product.id获取相应的商品数据
		Product product=productService.get(model.getProduct().getId());
		//2.判断当前session是否有购物车，如果没有则创建
		if(session.get("forder")==null){
			session.put("forder", new Forder());
		}
		Forder forder=(Forder) session.get("forder");
			//3.把商品信息转化为sorder,并且添加到购物车(判断商品购物项是否重复)
			sorderService.addSorder(forder, product);
			//4.计算商品购物总价
			forder.setTotal(forderService.cluTotal(forder));
			//5.把新的购物车存储到session中
			session.put("forder", forder);
			return "showCar";
	}
	
	public String querySale(){
		List<Object> jsonList=sorderService.querySale(model.getNumber());
		ActionContext.getContext().getValueStack().push(jsonList);
		return "jsonList";
	}
}
