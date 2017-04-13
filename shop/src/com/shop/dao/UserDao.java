package com.shop.dao;

import com.shop.bean.User;

public interface UserDao extends BaseDao<User>{
	public User login(User user);
	
	public User queryByName(User user);
}
