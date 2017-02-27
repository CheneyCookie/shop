package com.shop.action;

import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.bean.FileImage;
import com.shop.service.AccountService;
import com.shop.service.CategoryService;
import com.shop.service.ForderService;
import com.shop.service.PayService;
import com.shop.service.ProductService;
import com.shop.service.SorderService;
import com.shop.service.UserService;
import com.shop.util.FileUpload;
import com.shop.util.EmailUtil;
import com.shop.util.MessageUtil;

/*
 * Struts执行流程：先创建Action，再调用拦截器，拦截器访问成功再调用Action的方法
 * 
 * 在项目启动的时候Struts过滤器，已经把相应的内置对象对应的Map存储到了ActionContext和值栈中
 * 如果实现了相应的**Aware接口，就会从ActionContext中获取相应的Map进行传入，实现的拦截器为：servletConfig
 * */
@Controller
@Scope("prototype")
@SuppressWarnings("unchecked")
public class BaseAction<T> extends ActionSupport implements RequestAware,SessionAware,ApplicationAware,ModelDriven<T>{

	private static final long serialVersionUID = 1L;
	
	protected Map<String, Object> request;
	protected Map<String, Object> session;
	protected Map<String, Object> application;
	protected T model;
	protected Integer page;
	protected Integer rows;
	protected FileImage fileImage;
	protected List<T> jsonList=null;
	protected Map<String, Object> pageMap=null;
	@Autowired
	protected CategoryService categoryService;
	@Autowired
	protected AccountService accountService;
	@Autowired
	protected ProductService productService;
	@Autowired
	protected FileUpload fileUpload;
	@Autowired
	protected ForderService forderService;
	@Autowired
	protected SorderService sorderService;
	@Autowired
	protected UserService userService;
	@Autowired
	protected PayService payService;
	@Autowired
	protected EmailUtil emailUtil;
	@Autowired
	protected MessageUtil messageUtil;
	//获取要删除的id
	protected String ids;
	protected InputStream inputStream;
	
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

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}
	
	public List<T> getJsonList() {
		return jsonList;
	}
	
	public Map<String, Object> getPageMap() {
		return pageMap;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	
	public InputStream getInputStream() {
		return inputStream;
	}

	public FileImage getFileImage() {
		return fileImage;
	}

	public void setFileImage(FileImage fileImage) {
		this.fileImage = fileImage;
	}
	
	
}
