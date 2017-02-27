package com.shop.action;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;

import com.shop.bean.Category;

/*
 * ModelDriven:此接口必须要实现getModel()方法，此方法会把返回的对象，压到栈顶中
 * */
public class CategoryAction extends BaseAction<Category> {

	private static final long serialVersionUID = 1L;
	
	public String queryJoinAccount(){
		//用来存储分页的数据
		pageMap=new HashMap<String, Object>();
		//根据关键字和分页的参数查询相应的数据
		List<Category> categoryList=categoryService.queryJoinAccount(model.getType(), page, rows);
		pageMap.put("rows", categoryList);
		//根据关键字查询总记录数
		Long total=categoryService.getCount(model.getType());
		pageMap.put("total", total);
		
		return "jsonMap";
	}
	
	public String deleteByIds(){
		categoryService.deleteByIds(ids);
		inputStream=new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	
	public void save(){
		categoryService.save(model);
	}
	
	public void update(){
		System.out.println(model+"cate");
		categoryService.update(model);
	}
	
	public String query(){
		jsonList=categoryService.query();
		return "jsonList";
	}

}
