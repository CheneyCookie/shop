<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/public/head.jspf"%>
</head>
<!-- 框架集，里面包含了3+1个页面 -->
<frameset border="5" rows="150,*">
	<frame src="send_main_top" />
	<frameset border="5" cols="150,*">
		<frame src="send_main_left" />
		<frame src="send_main_right" />
	</frameset>
</frameset>
	
</html>