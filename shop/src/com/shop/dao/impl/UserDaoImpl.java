package com.shop.dao.impl;

import org.springframework.stereotype.Repository;

import com.shop.bean.User;
import com.shop.dao.UserDao;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	@Override
	public User login(User user) {
		String hql="from User u where u.login=?	and u.password=?";
		User dbuser=(User)getSession().createQuery(hql)
		.setString(0, user.getLogin())
		.setString(1, user.getPassword())
		.uniqueResult();
		System.out.println("login:dbuser"+dbuser);
		return dbuser;
	}

	@Override
	public User queryByName(User user) {
		String hql="from User u where u.login=?";
		User dbuser=(User) getSession().createQuery(hql).setString(0, user.getLogin()).uniqueResult();
		return dbuser;
	}
	
	
	
}
