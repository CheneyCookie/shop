package com.shop.util;



import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.stereotype.Component;

//实现短信发送功能
@Component("messageUtil")
public class MessageUtilImpl implements MessageUtil {
	
	/* (non-Javadoc)
	 * @see com.shop.util.MessageUtil#sendMessage(java.lang.String, java.lang.String)
	 */
	@Override
	public void sendMessage(String number,String id){
		//申请短信的网址
				String uri="http://utf8.sms.webchinese.cn/";
				//1.打开浏览器
				HttpClient client=new HttpClient();
				//2.创建请求的方式，get/post
				PostMethod post=new PostMethod(uri);
				//3.请求参数信息
				post.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
				post.setParameter("uid", "五分热度");//用户名
				post.setParameter("key", "a9b192a59fe6c5756ee7");//密钥
				post.setParameter("smsMob", "15079030106");//手机号码
				post.setParameter("smsText", "订单123456789"+id+"已经支付成功");
				//4.提交请求
				int code=0;
				String result=null;
				try {
					code = client.executeMethod(post);
					System.out.println("http返回的状态码"+code);		//5.获取
					//获取服务器端返回的数据信息
					result = post.getResponseBodyAsString();
					System.out.println("短信发送结果为"+result);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}finally{
					post.releaseConnection();
				}
	}
	
//	public static void main(String[] args) throws Exception{
//		//申请短信的网址
//		String uri="http://utf8.sms.webchinese.cn/";
//		//1.打开浏览器
//		HttpClient client=new HttpClient();
//		//2.创建请求的方式，get/post
//		PostMethod post=new PostMethod(uri);
//		//3.请求参数信息
//		post.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
//		post.setParameter("uid", "五分热度");//用户名
//		post.setParameter("key", "a9b192a59fe6c5756ee7");//密钥
//		post.setParameter("smsMob", "15079030106");//手机号码
//		post.setParameter("smsText", "订单123456789已经支付成功");
//		//4.提交请求
//		int code=client.executeMethod(post);
//		System.out.println("http返回的状态码"+code);		//5.获取
//		//获取服务器端返回的数据信息
//		String result=post.getResponseBodyAsString();
//		System.out.println("短信发送结果为"+result);
//	}
}
