package com.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.shop.bean.User;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User>{

	private static final long serialVersionUID = 1L;
	
	public String login(){
		//进行登陆判断
		model=userService.login(model);
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
}
