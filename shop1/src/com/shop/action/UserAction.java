package com.shop.action;

import java.io.ByteArrayInputStream;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.shop.bean.User;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User>{

	private static final long serialVersionUID = 1L;
	
	public String login(){
		//进行登陆判断
		System.out.println("login1:"+model.getLogin());
		model=userService.login(model);
		System.out.println("login2:"+model.getLogin());
		if(model==null){
			session.put("error", "登陆失败");
			return "ulogin";
		}else{
			//登陆成功，先存储到session,则根据情况返回相应的页面
			session.put("user", model);
			//根据session中goURL是否有值而决定页面的跳转
			if(session.get("goURL")==null){
				return "index";
			}else{
				return "goURL";
			}
		}
	}
	
	public String register(){
		userService.save(model);
		return "register";
	}
	
	public String check(){
		System.out.println("check!"+model);
		System.out.println("check1:"+model.getLogin());
		model=userService.queryByName(model);
		if(model==null){
			inputStream=new ByteArrayInputStream("true".getBytes());
		}else{
			inputStream=new ByteArrayInputStream("false".getBytes());
		}
		return "stream";
	}
}
