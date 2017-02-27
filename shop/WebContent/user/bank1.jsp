<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/public/head.jspf" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="width: 700px;">
		<c:forEach items="${applicationScope.bankList }" var="bankImage">
		
			<span>
				<input type="radio" name="" value="${fn:substring(bankImage,0,fn:indexOf(bankImage,'.'))}" />
				<img src="${shop }/image/bank/${bankImage}" />
			</span>
		</c:forEach>
	</div>
</body>
</html>