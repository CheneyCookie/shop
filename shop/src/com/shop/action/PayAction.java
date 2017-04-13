package com.shop.action;

import java.util.Map;

import org.apache.struts2.interceptor.ParameterAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.shop.bean.BackData;
import com.shop.bean.Forder;
import com.shop.bean.SendData;
import com.shop.bean.User;

/*
 * struts处理流程：获取请求后，先创建Action代理，在创建Action代理时顺
 * 便创建了Action,执行18个拦截器，拦截器执行成功则调用Action的方法。
 * 
 * Action方法执行完毕后，再返回调用拦截器
 * 
 * 创建Action----->执行拦截器------>modelDriven
 * */
@Controller
@Scope("prototype")
public class PayAction extends BaseAction<Object> implements ParameterAware{

	private static final long serialVersionUID = 1L;

	private Map<String, String[]> parameters;
	
	@Override
	public Object getModel() {
		if(parameters.get("pd_FrpId")!=null){
			model=new SendData();
		}
		else{
			model=new BackData();
		}
		return model;
	}
	
	@Override
	public void setParameters(Map<String, String[]> parameters) {
		this.parameters=parameters;
	}
	
	public String goBank(){
		SendData sendData=(SendData)model;
		//1：补全参数p2 p3 pd pa需要从session中获取
		Forder forder=(Forder) session.get("oldForder");
		User user=(User) session.get("user");
		sendData.setP2_Order(forder.getId().toString());
		sendData.setP3_Amt(forder.getTotal().toString());
		sendData.setPa_MP(user.getEmail()+","+user.getPhone());
		//2.对参数进行追加
		//3.加密获取签名
		//4.存储到request域中
		payService.saveDataToRequest(request, sendData);
		//5.跳转到支付页面
		//下一步无法进行，所以在此支付成功，发送邮件提示
		emailUtil.sendEmail("", forder.getId().toString());
		messageUtil.sendMessage(forder.getId().toString(),"");
		return "pay";
	}

	public void backBank(){
		BackData backData=(BackData)model;
		boolean isOk=payService.checkBackData(backData);
		if(isOk){
			//1.更新订单状态
			forderService.updateStatusById(Integer.parseInt(backData.getR6_Order()), 2);
			//2.根据user的邮箱地址，发送邮件
			String address=backData.getR8_MP().split(",")[0];
			emailUtil.sendEmail(address, backData.getR6_Order());
			//3.发送手机短信
			String number=backData.getR8_MP().split(",")[1];
			messageUtil.sendMessage(number, backData.getR6_Order());
			System.out.println("---success");
		}else{
			System.out.println("---fail");
		}
	}
	
}
