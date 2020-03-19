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
						//$("#dg").datagrid("reload");
					}
				}
			}).serialize();
		}
		
		function closeStudentDialog(){
			$("#dlg").dialog("close");
		}
		
	</script>
	<style>
		.alt td {
			background: black !important;
		}
	</style>
</head>
<body>
	<div id="container">
		<div class="ui_content">
			<div class="ui_text_indent">
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
				
			</div>
		</div>
		<div class="ui_content">
			<div class="ui_tb">
				<table id="datatable" class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
					<tr>
						<th width="30"><input type="checkbox" id="all" onclick="selectOrClearAllCheckbox(this);"/>
						</th>
						<th>用户ID</th>
						<th>用户账号</th>
						<th>用户昵称</th>
						<th>手机号码</th>
						<th>帐号状态</th>
						<th>创建者</th>
						<th>创建时间 </th>
					</tr>
					<c:forEach var="item" items="${pageInfo.list}">
						<tr>
							<td><input type="checkbox" name="IDCheck" value="${item.userId}" status="${item.status}"
									   class="acb"/></td>
							<td>${item.userId}</td>
							<td>${item.userName}</td>
							<td>${item.nickName}</td>
							<td>${item.phoneNumber}</td>
							<td>${item.status}</td>
							<td>${item.createBy}</td>
							<td>${item.createTime}</td>
						</tr>
					</c:forEach>

				</table>
			</div>
		</div>
	</div>
	
	
	<!---暂存程序模式变量--->
	<input type="hidden" id="simpled" value="${USER_SESSION.simpled}">
<script>
	//表格重绘
	function refreshTable(response) {
		var hrhead = "<tr>" +
				"<th width=\"30\"><input type=\"checkbox\" onclick=\"selectOrClearAllCheckbox(this);\"/>" +
				"</th>" +
				"<th>用户ID</th>" +
				"<th>用户账户</th>" +
				"<th>用户昵称</th>" +
				"<th>手机号码</th>" +
				"<th>账号状态</th>" +
				"<th>创建者</th>" +
				"<th>创建时间 </th>" +
				"</tr>";

		var bodyStr = "";
		for(i in response.pageInfo.list){
			var item = response.pageInfo.list[i];
			bodyStr += "<tr><td><input type=\"checkbox\" name=\"IDCheck\" value=" + item.userId
					+" qbad="+" class=\"acb\"/></td>";
			bodyStr += "<td>"+item.userId+"</td>";
			bodyStr += "<td>"+item.userName+"</td>";
			bodyStr += "<td>"+item.nickName+"</td>";
			bodyStr += "<td>"+item.phoneNumber+"</td>";
			bodyStr += "<td>"+item.status+"</td>";
			bodyStr += "<td>"+item.createBy+"</td>";
			bodyStr += "<td>"+item.createTime+"</td>";
			bodyStr += "</tr>"
		}
		return hrhead + bodyStr;
	}
</script>
</body>
</html>
