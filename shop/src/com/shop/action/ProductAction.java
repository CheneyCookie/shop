package com.shop.action;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.shop.bean.Product;

@Controller
@Scope("prototype")
public class ProductAction extends BaseAction<Product>{

	private static final long serialVersionUID = 1L;
	
	public String queryJoinProduct(){
		//存储分页数据
		pageMap=new HashMap<String, Object>();
		//根据关键字和分页的参数查询相应的数据
		List<Product> productList=productService.queryJoinCategory(model.getName(), page, rows);
		pageMap.put("rows", productList);
		//根据关键字查询总记录数
		pageMap.put("total",productService.getCount(model.getName()));
		System.out.println(productList);
		return "jsonMap";
	}
	
	public void save(){
		//实现文件上传功能
		String pic=fileUpload.uploadFile(fileImage);
		model.setPicture(pic);
		productService.save(model);
	}
	
	public String deleteByIds(){
		productService.deleteByIds(ids);
		inputStream=new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	
	public void update(){
		System.out.println(model+"1");
		String pic=fileUpload.uploadFile(fileImage);
		System.out.println(model+"2");
		model.setPicture(pic);
		System.out.println(model+"3");
		productService.update(model);
		System.out.println(model+"4");
	}
	
	public String get(){
		request.put("product", productService.get(model.getId()));
		return "detail";
	}
	
}
