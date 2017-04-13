package com.shop.dao.impl;


import org.springframework.stereotype.Repository;

import com.shop.bean.Account;
import com.shop.dao.AccountDao;
@Repository("accountDao")
public class AccountDaoImpl extends BaseDaoImpl<Account> implements AccountDao{
	
}
