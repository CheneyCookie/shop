<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<!-- 举例，无用 -->
	
	<%@ include file="/public/head.jspf"%>
	
	<!-- pragma：设置页面是否缓存，用于HTTP1.0协议
		cache-control：设置页面是否缓存，用于HTTP1.1协议
		expires：如果支持缓存，则有效期
		并不是所有容器都支持meta，例如tomcat就不解析，所以设置无效
		no-cache:仅仅支持IE不支持火狐和google浏览器	no-store支持所有浏览器，但是google浏览器get方式不支持
		当访问缓存页面的请求为post请求时，返回时出现页面过期，但是get方式返回时，直接到服务器加载页面，而不会提示页面过期
	 -->
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0	">
</head>
<body>
	
</body>
</html>