package com.shop.listener;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.shop.util.FileUpload;
import com.shop.util.ProductTimerTask;


//用于项目启动的时候数据初始化
@WebListener
public class InitDataListener implements ServletContextListener {

	private ApplicationContext ctx=null;

	private ProductTimerTask productTimerTask=null;
	
	private FileUpload fileUpload=null;
	
    public InitDataListener() {
    }

    public void contextInitialized(ServletContextEvent event)  {
    	//解决方案1：不可取的，会把Spring配置文件加载两次
//    	ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext*.xml");
//    	productService=ctx.getBean(ProductService.class);
//    	System.out.println(productService);
    	//2：项目在启动的时候把Spring配置文件通过监听器加载，存储了servletContext,只需获取即可
//    	WebApplicationContextUtils
    	//解决方案2：直接到ServletContext中获取Spring配置文件
//    	ApplicationContext ctx=(ApplicationContext) event.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
//    	productService=ctx.getBean(ProductService.class);
//    	System.out.println("productService:"+productService);
    	//解决方案3：通过工具类加载即可
    	ctx=WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
    	productTimerTask=ctx.getBean(ProductTimerTask.class);
    	fileUpload=ctx.getBean(FileUpload.class);
    	//把内置对象交给productTimerTask
    	//通过设置定时器，让首页数据每隔一小时同步一次(要配置为守护线程)
    	productTimerTask.setApplication(event.getServletContext());
    	new Timer(true).schedule(productTimerTask, 0, 1000*60*60);
    	//项目启动时要加载银行图标
    	System.out.println(fileUpload.getBankImage());
    	event.getServletContext().setAttribute("bankList", fileUpload.getBankImage());
    }

    public void contextDestroyed(ServletContextEvent event)  {
    	//1：获取业务逻辑查询商品信息
    }
	
}
