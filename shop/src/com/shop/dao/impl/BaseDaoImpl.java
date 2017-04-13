package com.shop.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.shop.dao.BaseDao;

@SuppressWarnings("unchecked")
@Repository("baseDao")
@Lazy(true)
public class BaseDaoImpl<T> implements BaseDao<T> {

	@Autowired
	private SessionFactory sessionFactory;
	//clazz中存储了当前操作的类型
	private Class clazz;
	
	public BaseDaoImpl(){
		ParameterizedType type=(ParameterizedType) this.getClass().getGenericSuperclass();
		clazz=(Class) type.getActualTypeArguments()[0];
	}
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public void save(T t) {
		getSession().save(t);
	}

	@Override
	public void update(T t) {
		getSession().update(t);
	}

	@Override
	public void delete(int id) {
		String hql="delete "+clazz.getSimpleName()+" where id=?";
		getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}

	@Override
	public T get(int id) {
		return (T) getSession().get(clazz, id);
	}

	
	@Override
	public List<T> query() {
		String hql="from "+clazz.getSimpleName();
		return getSession().createQuery(hql).list();
	}


}
