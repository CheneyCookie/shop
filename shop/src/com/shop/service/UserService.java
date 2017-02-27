package com.shop.service;

import com.shop.bean.User;

public interface UserService extends BaseService<User>{
	public User login(User user);
}
