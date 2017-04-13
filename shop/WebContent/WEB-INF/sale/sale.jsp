<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/public/head.jspf"%>
	<script type="text/javascript" src="jquery.min.js"></script>
	<script type="text/javascript" src="jscharts.js"></script>
	<script type="text/javascript">
	$(function(){
		//发送ajax请求
		
		$("#submit").click(function(){
			$.post($("#sale").val(),{number:$("#number").val()},function(data){
			var myChart = new JSChart('chart_cantainer', $("#type").val());
			var colors = ['#7979DB', '#7952E9', '#792BC8', '#792BA1', '#792BA1','#7979DB', '#7952E9', '#792BC8', '#792BA1', '#792BA1'];
			myChart.setDataArray(data);
			//myChart.colorizeBars(colors.slice(0,data.length));
			myChart.setAxisColor('#ABABAB');
			myChart.setAxisWidth(1);
			myChart.setAxisValuesColor('#858585');
			myChart.setAxisPaddingLeft(50);
			myChart.setAxisPaddingBottom(40);
			myChart.setAxisNameColor('#858585');
			myChart.setAxisNameX('商品名称',false);
			myChart.setAxisNameY('销量',false);
			myChart.setBarBorderColor('#bbb');
			myChart.setBarOpacity(1);
			myChart.setBarSpacingRatio(45);
			myChart.setBarValues(false);
			myChart.setBarBorderWidth(0);
			myChart.setTitleColor('#928888');
			myChart.setTitleFontSize(10);
			myChart.setGridColor('#ABABAB');
			myChart.setGridOpacity(0.8);
			myChart.setSize(100*$("#number").val(),400);
			myChart.set3D(true);
			myChart.draw();
			},"json");
		});
	});
	
	</script>
</head>
<body>
	请选择报表的类型：
	<select id="sale">
		<option value="sorder_querySale">年度销售报表</option>
	</select>
	查询的数量：
	<select id="number">
		<option value="5">5</option>
		<option value="7">7</option>
		<option value="10">10</option>
	</select>
	报表类型：
	<select id="type">
		<option value="bar">柱状图</option>
		<option value="line">线形图</option>
		<option value="pie">饼状图</option>
	</select>
	<input type="button" id="submit" value="查询">
	<div id="chart_cantainer"></div>
</body>
</html>