package com.shop.action;

import com.shop.bean.Account;

/*
 * ModelDriven:此接口必须要实现getModel()方法，此方法会把返回的对象，压到栈顶中
 * */
public class AccountAction extends BaseAction<Account> {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String save(){
		System.out.println(model);
		return SUCCESS;
	}

}
