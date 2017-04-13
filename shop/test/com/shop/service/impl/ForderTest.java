package com.shop.service.impl;



import net.sf.json.JSONSerializer;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shop.service.SorderService;

public class ForderTest {
	
	private ApplicationContext ctx;
	private SorderService sorderService;
	
	{
		ctx=new ClassPathXmlApplicationContext("applicationContext*.xml");
		sorderService=ctx.getBean(SorderService.class);
	}

	@Test
	public void testSave() {
		Float a=(float) 1.01;
		double b;
		float c=(float) 3.1;
		int d=4;
		b=(double) (c*d);
		System.out.println(a*2);
		System.out.println("b:"+b);
		System.out.println(c);
		System.out.println(d);
	}
	
	@Test
	public void testSorderSale(){
		JSONSerializer.toJSON(sorderService.querySale(5));
		for(Object temp:sorderService.querySale(5)){
			System.out.println(temp);
		}
	}
}
