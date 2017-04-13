package com.shop.action;

import com.shop.bean.Account;

/*
 * ModelDriven:此接口必须要实现getModel()方法，此方法会把返回的对象，压到栈顶中
 * */
public class AccountAction extends BaseAction<Account> {

	private static final long serialVersionUID = 1L;
	
	public String query(){
		
		jsonList=accountService.query();
		return "jsonList";
	}
}
