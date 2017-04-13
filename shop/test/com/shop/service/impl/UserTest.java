package com.shop.service.impl;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shop.bean.User;
import com.shop.dao.UserDao;
import com.shop.service.UserService;

public class UserTest {
	
	private ApplicationContext ctx;
	private UserDao userDao;
	private UserService userService;
	{
		ctx=new ClassPathXmlApplicationContext("applicationContext*.xml");
		userDao=ctx.getBean(UserDao.class);
		userService=ctx.getBean(UserService.class);
		
	}
	
	@Test
	public void testcheck() {
		User user=userService.queryByName(new User("ch"));
		System.out.println(user);
	}

}
