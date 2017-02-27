package com.shop.action;

import java.util.ArrayList;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.shop.bean.Forder;
import com.shop.bean.Sorder;
import com.shop.bean.Status;
import com.shop.bean.User;

@Controller
@Scope("prototype")
public class ForderAction extends BaseAction<Forder>{

	private static final long serialVersionUID = 1L;
	
	//此方式在此处不安全      掉了一段视频，不清楚，改来改去感觉被戏耍
	@Override 
	public Forder getModel() {
		//session中已经存储了购物项集合，然后把信息注入到model中，即可入库
		model=(Forder) session.get("forder");
		return model;
	}
	
	//实现购物车（订单）与购物项（订单项）级联入库功能
	public String save(){
		//把session中的购物项交给当前的model对象
		
		
		
		
//		Forder forder=(Forder) session.get("forder");
		//model.setSorderSet(forder.getSorderSet());
//		forder.setAddress(model.getAddress());
//		forder.setName(model.getName());
//		forder.setPhone(model.getPhone());
//		forder.setRemark(model.getRemark());
		model.setUser((User) session.get("user"));
		model.setStatus(new Status(1));
//		forder.setPost(model.getPost());
		//级联入库(需在xml中配置)，需要sorder关联forder,在SorderServiceImpl业务逻辑中，追加sorder.setForder(forder)
		System.out.println(model);
		forderService.save(model);
		System.out.println("----测试----");
		System.out.println(model);
//		forderService.save(forder);
		session.put("oldForder", session.remove("forder"));
		//购物车已经入库，那么原来session中的购物车应该清空
//		session.put("forder", new Forder());
		
		return "bank";
		}
}
