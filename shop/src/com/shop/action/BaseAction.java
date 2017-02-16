package com.shop.action;

import java.lang.reflect.ParameterizedType;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.service.AccountService;
import com.shop.service.CategoryService;

/*
 * Struts执行流程：先创建Action，再调用拦截器，拦截器访问成功再调用Action的方法
 * 
 * 在项目启动的时候Struts过滤器，已经把相应的内置对象对应的Map存储到了ActionContext和值栈中
 * 如果实现了相应的**Aware接口，就会从ActionContext中获取相应的Map进行传入，实现的拦截器为：servletConfig
 * */
@Controller
@Scope("prototype")

public class BaseAction<T> extends ActionSupport implements RequestAware,SessionAware,ApplicationAware,ModelDriven<T>{

	private static final long serialVersionUID = 1L;
	
	protected Map<String, Object> request;
	protected Map<String, Object> session;
	protected Map<String, Object> application;
	protected T model;
	@Autowired
	protected CategoryService categoryService;
	@Autowired
	protected AccountService accountService;
	
//	public void setAccountService(AccountService accountService) {
//		this.accountService = accountService;
//	}
//	
//	public void setCategoryService(CategoryService categoryService) {
//		this.categoryService = categoryService;
//	}
	
	@Override
	public void setApplication(Map<String, Object> arg0) {
		this.application=arg0;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session=arg0;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request=arg0;
	}

	@Override
	public T getModel() {
		ParameterizedType type=(ParameterizedType) this.getClass().getGenericSuperclass();
		Class clazz=(Class)type.getActualTypeArguments()[0];
		try {
			model=(T)clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return model;
	}

}
