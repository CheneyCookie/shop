<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@include file="/public/head.jspf"%>
	<script type="text/javascript" src="jquery.min.js"></script>
	<script type="text/javascript" src="jquery.validate.js"></script>
	<style type="text/css">
		#dd div{
			padding: 5px;
		}
		table tr{
			height: 35px;
		}
		
		form label{
		color: red;
		background-image: url("image/false.jpg");
		background-repeat: no-repeat;
		padding-left: 23px;
	}
	.ok{
		background-image: url("image/right.jpg");
		background-repeat: no-repeat;
		padding-left: 23px;
	}
	
	</style>
	<script type="text/javascript">
	$(function(){
		//自定义方法，完成手机号码验证
		//name：自定义方法的名称，method：函数体， message：错误消息
		//$.validator.addMethod(name,method,message);
		$.validator.addMethod("phone",function(value,element,param){
			//value:被验证的值，element：当前验证的dom对象,param：参数，如果有多个则是数组
			//alert(value+","+$(element).val()+","+param[0]+","+param[1])
			return new RegExp("^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$").test(value);
		},"手机号码不正确");
		
		//让当前表单调用validate方法，实现表单验证功能
		$("#ff").validate({
			//debug:true,		//调试模式，即使验证成功，也不会跳转到目标页面
			event:"keyup" || "blur",
			//onkeyup:true,	//当丢失焦点的时候才出发验证请求
			errorElement:"label",
			success:"ok",	//成功的样式
			errorPlacement:function(error,element){      //定义错误消息存放的位置
				$(element).parent().next().html(error);
			},
			rules:{		//配置验证规则 key是验证的dom对象（文本框）,value：调用的验证方法
				name:{
					required:true, 	//如果验证方法不需要参数，则配置为true
					rangelength:[2,20],
				},
				login:{
					required:true, 	//如果验证方法不需要参数，则配置为true
					rangelength:[4,20],
					remote:{
						url:'user_check',
						type:"post"
					}
				},
				password:{
					required:true,
					rangelength:[8,20]
				},
				repassword:{
					required:true,
					equalTo:"#spass"
				},
				sex:{
					required:true,
				},
				email:{
					required:true,
					email:true
				},
				phone:{
					required:true,
					phone:true
				}
			},
			messages:{
				name:{
					required:"请输入真实姓名", 	//如果验证方法不需要参数，则配置为true
					rangelength:"请输入真实姓名"
				},
				login:{
					required:"请填写用户名", 	//如果验证方法不需要参数，则配置为true
					rangelength:"用户名长度为4~20个字符",
					remote:"用户名已被占用"
				},
				password:{
					required:"请填写密码",
					rangelength:$.validator.format("密码长度为{0}~{1}个字符")
				},
				repassword:{
					required:"请再次输入密码",
					equalTo:"两次密码不一致"
				},
				email:{
					required:"请填写邮箱",
					email:"请输入正确的邮箱地址"
				},
				phone:{
					required:"请填写手机号码",
				},
			},
		});
	});
	</script>
<body>
	<div class="wrapper">
		<div class="header">
			<div class="header_container">
				<!--头部开始-->
				<div class="top_bar clear">
					<!--头部小导航-->
					<div class="welcom fl">欢迎光临LEISUPET SHOP!</div>
					<ul class="top_links fr">
						<li class="highlight"><a href="index.jsp">首页</a></li>
						<li><a href="#">我的账户</a></li>
						<li><a href="showCar.jsp">购物车</a></li>
						<li><a href="uregister.jsp">注册</a></li>
						<li><a href="ulogin.jsp">登录</a></li>
					</ul>
					<!--头部小导航结束-->
					<!-- logo -->
					<h1 class="logo clear fl">
						<a href="index.html"> <img src="images/logo.png" /> </a>
					</h1>
					<!-- 小购物车 -->
					<div class="minicart">
						
					</div>
					<!-- 小购物车结束 -->
					<!-- 搜索框 -->
					<div class="header_search">
						<div class="form-search ">
							<input value="请输入商品名称" class="input-text" type="text" />
							<button type="submit" title="Search"></button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- 头部结束 -->
		<!-- 导航栏 -->
		<div class="navigation_container">
			<!---->
			<div class="nav">
				<ul class="primary_nav">
					<li class="active highlight"><a href="#">女装</a> <!--二级菜单-->
						<ul class="sub_menu">
							<li><a href="#">裙装</a>
								<ul>
									<li><a href="#">短裙</a></li>
									<li><a href="#">短裤</a></li>
									<li><a href="#">裤子</a></li>
									<li><a href="#">卡其裤</a></li>
									<li><a href="#">休闲裤</a></li>
									<li><a href="#">牛仔裤</a></li>
									<li><a href="#">风衣  运动夹克</a></li>
								</ul></li>
							<li><a href="#">装饰品</a>
								<ul>
									<li><a href="#">太阳镜</a></li>
									<li><a href="#">围巾</a></li>
									<li><a href="#">发饰品</a></li>
									<li><a href="#">帽子和手套</a></li>
									<li><a href="#">生活时尚</a></li>
									<li><a href="#">牛仔系列</a></li>
									<li><a href="#">风衣  西服</a></li>
								</ul></li>
						</ul></li>
					<!--二级菜单结束-->
					<li><a href="#">男装</a> <!--二级菜单-->
						<ul class="sub_menu">
							<li><a href="#">男士夏装</a>
								<ul>
									<li><a href="#">裤子</a></li>
									<li><a href="#">休闲裤</a></li>
									<li><a href="#">卡其裤</a></li>
									<li><a href="#">牛仔裤</a></li>
									<li><a href="#">风衣  运动夹克</a></li>
								</ul></li>
							<li><a href="#">装饰品</a>
								<ul>
									<li><a href="#">太阳镜</a></li>
									<li><a href="#">围巾</a></li>
									<li><a href="#">发饰品</a></li>
									<li><a href="#">帽子和手套</a></li>
									<li><a href="#">生活时尚</a></li>
									<li><a href="#">牛仔系列</a></li>
									<li><a href="#">风衣  西服</a></li>
								</ul></li>
						</ul> <!--二级菜单结束--></li>
					<li><a href="#">儿童</a></li>
					<li><a href="#">时尚</a></li>
					<li><a href="#">装饰品</a></li>
				</ul>
			</div>
		</div>
		<!--导航栏结束-->
		<div class="section_container">
			<!-- 购物车 -->
			<div id="dd" class="action_buttonbar" style="text-align:center;">
			<form id="ff" action="user_register" method="post">
				<table cellspacing="0" width="600">
					<tr>
						<td width="80">登陆名：</td>
						<td width="150" align="center"><input type="text" name="login" /></td>
						<td width="270"></td>
					</tr>
					<tr>
						<td>密码：</td>
						<td align="center"><input id="spass" type="password" name="password" /></td>
						<td></td>
					</tr>
					<tr>
						<td>确认密码：</td>
						<td align="center"><input type="password" name="repassword" /></td>
						<td></td>
					</tr>
					<tr>
						<td>真实姓名：</td>
						<td align="center">
							<input type="text" name="name" />
						</td>
						<td></td>
					</tr>
					<tr>
						<td>性别：</td>
						<td align="center">
							<input type="radio" name="sex" value="男">男
							<input type="radio" name="sex" value="女">女
							<input type="radio" name="sex" value="保密" checked="checked">保密
						</td>
						<td></td>
					</tr>
					<tr>
						<td>手机号码：</td>
						<td align="center"><input type="text" name="phone"></td>
						<td></td>
					</tr>
					<tr>
						<td>邮箱：</td>
						<td align="center"><input type="text" name="email" /></td>
						<td></td>
					</tr>
					
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="提交">
						</td>
					</tr>
				</table>
			</form>
			   <div style="clear:both"></div>
			</div>
		</div>
			<!-- 导航栏结束 -->
			<div class="footer_container">
				<div class="footer">
					<ul class="footer_links">
						<li><span>收藏本店</span>
							<ul>
								<li><a href="#">服装</a></li>
								<li><a href="#">鞋子</a></li>
								<li><a href="#">包包</a></li>
								<li><a href="#">装饰品</a></li>
								<li><a href="#">channel</a></li>
								<li><a href="#">prada</a></li>
								<li><a href="#">LV</a></li>
							</ul></li>
						<li class="seperator"><span>出售的品牌</span>
							<ul>
								<li><a href="#">Elle</a></li>
								<li><a href="#">Reallxe</a></li>
								<li><a href="#">Fabric</a></li>
								<li><a href="#">Mayflower</a></li>
								<li><a href="#">Levis Strauss</a></li>
								<li><a href="#">Anzonica</a></li>
								<li><a href="#">Reallxe</a></li>
								<li><a href="#">Fabric</a></li>
							</ul></li>
						<li><span>客户服务</span>
							<ul>
								<li><a href="#">帮助</a></li>
								<li><a href="#">速递</a></li>
								<li><a href="#">退换货</a></li>
								<li><a href="#">付款方式</a></li>
								<li><a href="#">订单跟踪</a></li>
								<li><a href="#">礼物包选项</a></li>
								<li><a href="#">国际服务</a></li>
								<li><a href="#">退运险</a></li>
							</ul></li>
						<li><span>个人账户</span>
							<ul>
								<li><a href="#">个人账户信息</a></li>
								<li><a href="#">用户密码</a></li>
								<li><a href="#">订单历史</a></li>
								<li><a href="#">付款方式</a></li>
								<li><a href="#">我的收货地址</a></li>
								<li><a href="#">我的通知</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</div>
</body>
</html>
