package com.shop.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.shop.dao.AccountDao;
import com.shop.dao.BaseDao;
import com.shop.dao.CategoryDao;
import com.shop.dao.ForderDao;
import com.shop.dao.ProductDao;
import com.shop.dao.SorderDao;
import com.shop.dao.UserDao;
import com.shop.service.BaseService;

@SuppressWarnings("unchecked")
@Service("baseService")
@Lazy(true)
public class BaseServiceImpl<T> implements BaseService<T> {

//	@Autowired
//	private SessionFactory sessionFactory;
	//clazz中存储了当前操作的类型
	protected BaseDao baseDao;//如果当前T是account,则baseDao里面是accountDao,category则baseDao就是categoryDao
	@Autowired
	protected AccountDao accountDao;
	@Autowired
	protected CategoryDao categoryDao;
	@Autowired
	protected ForderDao forderDao;
	@Autowired
	protected ProductDao productDao;
	@Autowired
	protected SorderDao sorderDao;
	@Autowired
	protected UserDao userDao;
	
	
	private Class clazz;
	
	public BaseServiceImpl(){
		System.out.println("this代表当前构造方法的对象："+this);
		System.out.println("获取当前对象的父类信息是："+this.getClass().getSuperclass());
		System.out.println("获取当前对象的父类信息是(也包括泛型信息)："+this.getClass().getGenericSuperclass());
		ParameterizedType type=(ParameterizedType) this.getClass().getGenericSuperclass();
		clazz=(Class) type.getActualTypeArguments()[0];
	}
	
	@PostConstruct
	public void init(){
		String clazzName=clazz.getSimpleName();
		String clazzDao=clazzName.substring(0,1)
				.toLowerCase()+clazzName
				.substring(1)+"Dao";// Account ==>accountDao
		try {
			Field clazzField=this.getClass().getSuperclass().getDeclaredField(clazzDao);
			Field baseField=this.getClass().getSuperclass().getDeclaredField("baseDao");
			baseField.set(this, clazzField.get(this));
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void save(T t) {
		baseDao.save(t);
	}

	@Override
	public void update(T t) {
		baseDao.update(t);
	}

	@Override
	public void delete(int id) {
		baseDao.delete(id);
	}

	@Override
	public T get(int id) {
		return (T) baseDao.get(id);
	}

	
	@Override
	public List<T> query() {
		return baseDao.query();
	}


}
