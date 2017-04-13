<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/public/head.jspf"%>
	<style type="text/css">
		form div{
			margin: 5px;
		}
	</style>
	<script type="text/javascript">
		$(function(){
			//iframe的的dg对象
			var dg=parent.$("iframe[title='类别管理']").get(0).contentWindow.$("#dg");
			$(function(){
				//对管理员的下拉列表框进行远程加载
				$('#cc').combobox({    
				    url:'acco_query',    
				    valueField:'id',    
				    textField:'login', 
				    panelHeight:'auto',
				    panelWidth:120,
				    width:120,
				    editable:false
				});  
				//完成数据回显
				var rows=dg.datagrid("getSelections");
				if(rows[0].account!=null){
				$('#ff').form('load',{
					id:rows[0].id,
					type:rows[0].type,
					hot:rows[0].hot,
					'account.id':rows[0].account.id
				});
				//开始未设置登录方法，故录入时无管理员
				}else{
					$('#ff').form('load',{
						id:rows[0].id,
						type:rows[0].type,
						hot:rows[0].hot
					});
				}
			});
			
			
			$("input[name=type]").validatebox({
				required:true,
				missingMessage:'请输入类别名称'
			});
			//窗体弹出时默认禁用验证
			$("#ff").form("disableValidation");
			//注册button的事件
			$("#btn").click(function(){
				//开启验证
				$("#ff").form("enableValidation");
				//如果验证成功则提交数据
				if($("#ff").form("validate")){
					//提交数据
					$('#ff').form('submit', {
						url: 'cate_update',
						success: function(){
							//关闭当前窗体
							parent.$("#win").window("close");
							//刷新页面 获取aindex--->iframe--->dg   不兼容向下强转 dom--->jquery--->easyui
							//parent.$("iframe[title='类别管理']").contents().find("#dg").datagrid("reload");
							dg.datagrid("reload");
						}
					});
				}
			});
		});
	</script>
</head>
<body>

	<form id="ff" method="post">   
	    <div>   
	        <label for="type">类别名称:</label>   
	        <input type="text" name="type" />   
	    </div>   
	    <div>   
	        <label for="hot">热点:</label>  
	       	  <input type="radio" name="hot" value="true">热点
	      	  <input type="radio" name="hot" value="false" checked="checked">非热点
	    </div>
	    <div>   
	        <label for="cc">所属管理员:</label>  
	        <!-- 基于html代码的方式
	        <select id="cc" class="easyui-combobox" name="dept" style="width:200px;">   
    			<option value="aa">aitem1</option>   
    			<option>bitem2</option>   
    			<option>bitem3</option>   
    			<option>ditem4</option>   
    			<option>eitem5</option>   
			</select>
	         -->
	         <!-- 远程加载管理员数据 -->
	         <input id="cc" name="account.id" />
	    </div>
	    <div>
	    	<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">更新</a>
	    	<input type="hidden" name="id" />
	    </div>
	</form>  
</body>
</html>