package com.shop.service.impl;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shop.bean.Category;
import com.shop.service.CategoryService;

public class CategoryServiceImplTest {
	
	private ApplicationContext ctx;
	private CategoryService categoryService;
	
	{
		ctx=new ClassPathXmlApplicationContext("applicationContext*.xml");
		categoryService=ctx.getBean(CategoryService.class);
	}
	@Test
	public void testSave() {
		categoryService.save(new Category("测试",true));
	}
	
	@Test
	public void queryJoinAccount(){
		for(Category category:categoryService.queryJoinAccount("",2,3)){
			System.out.println(category);
			System.out.println(category.getAccount());
		}
	}

}
