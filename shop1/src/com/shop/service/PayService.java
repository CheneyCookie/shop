package com.shop.service;

import java.util.Map;

import com.shop.bean.BackData;
import com.shop.bean.SendData;

public interface PayService {

	// 把加密后的信息存储到requestap中
	//	@Override
	public abstract Map<String, Object> saveDataToRequest(
			Map<String, Object> request, SendData sendData);

	public abstract boolean checkBackData(BackData backData);
}