<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/public/head.jspf"%>
	<script type="text/javascript">
		$(function(){
			$('#dg').datagrid({
				//请求数据的URL地址
			    url:'datagrid_data.json', 
			    //配置dg的列字段 field:列字段的名称，与json的key捆绑
			    columns:[[    
			        {field:'code',title:'编号',width:100},    
			        {field:'productname',title:'产品的名称',width:100},    
			        {field:'unitcost',title:'Price',width:100,align:'right'}    
			    ]]    
			});
		})
	</script>
</head>
<body>
	<table id="dg"></table> 
	
</body>
</html>