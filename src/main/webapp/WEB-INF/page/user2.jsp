<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<link rel="stylesheet" type="text/css" href="/jquery-easyui-1.3.3/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="/jquery-easyui-1.3.3/themes/icon.css">
	<script type="text/javascript" src="/jquery-easyui-1.3.3/jquery.min.js"></script>
	<script type="text/javascript" src="/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
	
	<script type="text/javascript" src="/layer/layer.js"></script>
	
	<!-- <script type="text/javascript" src="/scripts/jquery/jquery-1.7.1.js"></script> -->
	<link href="/style/authority/basic_layout.css" rel="stylesheet" type="text/css">
	<link href="/style/authority/common_style.css" rel="stylesheet" type="text/css">
	<!-- <script type="text/javascript" src="/scripts/authority/commonAll.js"></script>
	<script type="text/javascript" src="/scripts/fancybox/jquery.fancybox-1.3.4.js"></script>
	<script type="text/javascript" src="/scripts/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
	<link rel="stylesheet" type="text/css" href="/style/authority/jquery.fancybox-1.3.4.css" media="screen"></link>
	<script type="text/javascript" src="/scripts/artDialog/artDialog.js?skin=default"></script> -->
	<script type="text/javascript" src="/js/log.js"></script>
	
	<style>
		#datatable th{
			text-transform:none;
		}
		#datatable .succeed{
			color: #00B83F;
		}
		#datatable .readyd{
			color: #1677D2;
		}
		#datatable .errord{
			color: red;
		}
	</style>
	<title></title>
	<!-- Favicon  -->
	<link rel="icon" href="/images/favicon.png">
	<script type="text/javascript">

		var url;

		function openStudentAddDialog(){
			$("#dlg").dialog("open").dialog("setTitle","添加用户信息");
			url="${pageContext.request.contextPath}/user/addUser";
		}

		function saveStudent(){
			$("#fm").form("submit",{
				url:url,
				onSubmit:function(){
					return $(this).form("validate");
				},
				success:function(result){
					if(result.errorMsg){
						$.messager.alert("系统提示",result.errorMsg);
						return;
					}else{
						$.messager.alert("系统提示","保存成功");
						
						$("#dlg").dialog("close");
						location.replace(location.href);
					}
				}
			}).serialize();
		}
		
		function closeStudentDialog(){
			$("#dlg").dialog("close");
		}

		function openStudentModifyDialog(){
			var selectedRows=$("#dg").datagrid('getSelections');
			if(selectedRows.length!=1){
				$.messager.alert("系统提示","请选择一条要编辑的数据！");
				return;
			}
			var row=selectedRows[0];
			$("#dlg").dialog("open").dialog("setTitle","编辑用户信息");
			$("#fm").form("load",row);
			url="${pageContext.request.contextPath}/user/updateUser?userId="+row.userId;
		}



		function deleteStudent(){
			var selectedRows=$("#dg").datagrid('getSelections');
			if(selectedRows.length==0){
				$.messager.alert("系统提示","请选择要删除的数据！");
				return;
			}
			var strIds=[];
			for(var i=0;i<selectedRows.length;i++){
				strIds.push(selectedRows[i].stuId);
			}
			var ids=strIds.join(",");
			$.messager.confirm("系统提示","您确认要删掉这<font color=red>"+selectedRows.length+"</font>条数据吗？",function(r){
				if(r){
					$.post("studentDelete",{delIds:ids},function(result){
						if(result.success){
							$.messager.alert("系统提示","您已成功删除<font color=red>"+result.delNums+"</font>条数据！");
							$("#dg").datagrid("reload");
						}else{
							$.messager.alert('系统提示',result.errorMsg);
						}
					},"json");
				}
			});
		}
	</script>
</head>
<body style="margin: 5px;">
	<table id="dg" title="用户信息" class="easyui-datagrid" fitColumns="true"
	 pagination="true" rownumbers="true" url="${pageContext.request.contextPath}/user/getByUser" fit="true" toolbar="#tb" >
		<thead>
			<tr>
				<th field="cb" checkbox="true"></th>
				<th field="userId" width="50" align="center">用户ID</th>
				<th field="userName" width="100" align="center">用户账号</th>
				<th field="nickName" width="100" align="center">用户昵称</th>
				<th field="phoneNumber" width="100" align="center">手机号码</th>
				<th field="status" width="100" align="center">帐号状态</th>
				<th field="createBy" width="100" align="center">创建者</th>
				<th field="createTime" width="100" align="center">创建时间</th>
			</tr>
		</thead>
	</table>
	
	<div id="tb">
		<div>
			<a href="javascript:openStudentAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
			<a href="javascript:openStudentModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
			<a href="javascript:deleteStudent()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
		</div>
	</div>
	
	<div id="dlg" class="easyui-dialog" style="width: 570px;height: 350px;padding: 10px 20px"
		closed="true" buttons="#dlg-buttons">
		<form id="fm" method="post">
			<table cellspacing="5px;">
					<tr>
					<td>用户名：</td>
					<td><input type="text" name="userName" id="userName" class="easyui-validatebox" required="true"/></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>密码：</td>
					<td><input type="text" name="password" id="password" class="easyui-validatebox" required="true"/></td>
				</tr>
			</table>
		</form>
	</div>
	
	<div id="dlg-buttons">
		<a href="javascript:saveStudent()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closeStudentDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
</body>
</body>
</html>
