package com.shop.util;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sun.mail.util.MailSSLSocketFactory;

/*
 * 用来完成邮件发送
 * */
@Component("emailUtil")
public class EmailUtilImpl implements EmailUtil {
	@Value("#{prop.myEmail}")
	private String myEmail;
	@Value("#{prop.sendEmail}")
	private String sendEmail;
	@Value("#{prop.smtp}")
	private String smtp;
	@Value("#{prop.key}")
	private String key;
	/* (non-Javadoc)
	 * @see com.shop.util.MessageUtil#sendEmail(java.lang.String, java.lang.String)
	 */
	@Override
	public void sendEmail(String address,String id){
		Properties prop=new Properties();
		Session session=null;
		Message message=null;
		Transport transport=null;
		MailSSLSocketFactory sf=null;
		try{
			prop=new Properties();
			sf=new MailSSLSocketFactory();
			sf.setTrustAllHosts(true);
			prop.put("mail.smtp.ssl.enable","true");
			prop.put("mail.smtp.ssl.socketFactory",sf);
			prop.setProperty("mail.debug", "true");
			prop.setProperty("mail.smtp.auth", "true");
			prop.setProperty("mail.host", "smtp.qq.com");
			prop.setProperty("mail.transport.protocol", "smtp");
			//创建了session会话
			session=Session.getDefaultInstance(prop);
			//设置debug模式，调试发送信息
//			session.setDebug(true);
			//创建一封邮件对象
			message=new MimeMessage(session);
			//写信
			message.setSubject("订单支付成功邮件");
			//正文内容
			message.setContent("订单123456789"+id+"已经支付成功","text/html;charset=utf-8");
			//发件人地址
			message.setFrom(new InternetAddress(myEmail));
			transport=session.getTransport();
			//连接邮件服务器的认证信息
			transport.connect(smtp,myEmail,key);
			//设置收件人地址,并发送邮件
			transport.sendMessage(message, new Address[]{new InternetAddress(sendEmail)});
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			try {
				transport.close();
			} catch (Exception e) {
				throw new RuntimeException("邮件发送失败!");
			}
		}
		
	}	
	//登陆邮件客户端（创建会话session）
//	public static void main(String[] args) throws Exception {
//		Properties prop=new Properties();
//		MailSSLSocketFactory sf=new MailSSLSocketFactory();
//		sf.setTrustAllHosts(true);
//		prop.put("mail.smtp.ssl.enable","true");
//		prop.put("mail.smtp.ssl.socketFactory",sf);
//		prop.setProperty("mail.debug", "true");
//		prop.setProperty("mail.smtp.auth", "true");
//		prop.setProperty("mail.host", "smtp.qq.com");
//		prop.setProperty("mail.transport.protocol", "smtp");
//		//创建了session会话
//		Session session=Session.getDefaultInstance(prop);
//		//设置debug模式，调试发送信息
////		session.setDebug(true);
//		//创建一封邮件对象
//		Message message=new MimeMessage(session);
//		//写信
//		message.setSubject("订单支付成功邮件");
//		//正文内容
//		message.setContent("订单123456789已经支付成功","text/html;charset=utf-8");
//		//发件人地址
//		message.setFrom(new InternetAddress("1124932314@qq.com"));
//		Transport transport=session.getTransport();
//		//连接邮件服务器的认证信息
//		transport.connect("smtp.qq.com","1124932314@qq.com","szuicptnirqvieha");
//		//设置收件人地址,并发送邮件
//		transport.sendMessage(message, new InternetAddress[]{new InternetAddress("576255013@qq.com")});
//		transport.close();
//	}
}
