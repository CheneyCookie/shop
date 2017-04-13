package com.shop.service.impl;



import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shop.bean.Product;
import com.shop.service.ProductService;

public class ProductServiceImplTest {
	
	private ApplicationContext ctx;
	private ProductService productService;
	
	{
		ctx=new ClassPathXmlApplicationContext("applicationContext*.xml");
		productService=ctx.getBean(ProductService.class);
	}
	
	@Test
	public void queryJoinCategory(){
		for(Product product:productService.queryJoinCategory("",1,5)){
			System.out.println(product);
		}
	}
	
	@Test
	public void deleteByIds(){
		productService.deleteByIds("23,24");
	}
	@Test
	public void update(){
	}
	
	@Test
	public void queryByCid(){
		for(Product product:productService.queryByCid(1)){
			System.out.println(product);
		}
	}
	
}
