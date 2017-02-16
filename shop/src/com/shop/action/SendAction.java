package com.shop.action;

import com.opensymphony.xwork2.ActionSupport;

//此action用来完成web-inf中的jsp与jsp的请求转发功能，此action不处理任何逻辑
public class SendAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	public String execute(){
		return "send";
	}
}
