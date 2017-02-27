package com.shop.service.impl;

import org.springframework.stereotype.Service;

import com.shop.bean.User;
import com.shop.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{

	@Override
	public User login(User user) {
		String hql="from User u where u.login=?	and u.password=?";
		return (User)getSession().createQuery(hql)
		.setString(0, user.getLogin())
		.setString(1, user.getPassword())
		.uniqueResult();
	}
	
}
