package com.shop.util;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.shop.bean.Category;
import com.shop.bean.Product;
import com.shop.service.CategoryService;
import com.shop.service.ProductService;


//设置任务：run方法中用来加载首页商品信息数据
@Component("productTimerTask")
public class ProductTimerTask extends TimerTask{
	
	@Autowired
	private ProductService productService=null;
	@Autowired
	private CategoryService categoryService=null;
	
	private ServletContext application=null;
	
	public void setApplication(ServletContext application) {
		this.application = application;
	}
	
	@Override
	public void run() {
		List<List<Product>> bigList=new ArrayList<List<Product>>();
    	//查询热点类别
    	for(Category category:categoryService.queryByHot(true)){
    		//根据热点类别id获取推荐商品信息
    		bigList.add(productService.queryByCid(category.getId()));
    	}
    	//把查询的bigList交给application内置对象
    	application.setAttribute("bigList", bigList);		
	}
	
}
