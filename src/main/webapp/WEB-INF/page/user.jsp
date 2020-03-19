<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/><link rel="stylesheet" type="text/css" href="/jquery-easyui-1.3.3/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="/jquery-easyui-1.3.3/themes/icon.css">
	<script type="text/javascript" src="/jquery-easyui-1.3.3/jquery.min.js"></script>
	<script type="text/javascript" src="/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>

	<script type="text/javascript" src="/layer/layer.js"></script>
	<link href="/style/authority/basic_layout.css" rel="stylesheet" type="text/css">
	<link href="/style/authority/common_style.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="/js/user.js"></script>
	<script type="text/javascript" src="/js/page.js"></script>

	<title></title>
	<!-- Favicon  -->
	<link rel="icon" href="/images/favicon.png">
	<script type="text/javascript">

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


		/** 模糊查询 **/
		function search() {
			var pageSize = $("#pageSize").val().trim();
			$.ajax({
				type: "POST",
				url: "${pageContext.request.contextPath}/user/getDataByPage",
				data:{
					pageNum:1,
					pageSize:pageSize
				},
				success: function (response) {
					console.log("response==>",response)
					if (response.resCode == 200) {
						//  art.dialog({time: 3, content: "数据上传成功! 模糊查询"});
						console.log("success");
						var dataHtml = refreshTable(response);
						$("#datatable").html(dataHtml);
						//更改分页数据信息
						$("#total").text(response.pageInfo.total);
						$("#pageInfo").text(response.pageInfo.pageNum + " / "
								+ response.pageInfo.pages);
					} else {
						// art.dialog({time: 3, content: "数据上传失败! 模糊查询"});
						console.log("fail...");
					}
				},error: function(data){
					art.dialog({time: 3, content: "出错啦!!!"});
				}
			});
		}

		/** 普通跳转 **/
		function jumpNormalPage(page) {
			if(page == 0 || page > getTotalPage() || getCurrentPage() == page){
				console.log("page===>",page);
				return;
			}
			var pageSize = $("#pageSize").val().trim();
			//   var msg = status +"==" + condition + "==" + page +"===" + pageSize;
			//  art.dialog({time: 3, content: msg});
			queryData(page,pageSize);
		}

		/** 输入页跳转 **/
		function jumpInputPage(totalPage) {
			var inputNumStr = $("#jumpNumTxt").val();
			if(inputNumStr.trim() == '' || isNaN(inputNumStr)){
				art.dialog({
					icon: 'error',
					title: '友情提示',
					drag: false,
					resize: false,
					content: '请输入正确的页数!',
					ok: true,
					time: 2,
				});
				return;
			}
			// 如果“跳转页数”不为空
			if ($("#jumpNumTxt").val() != '') {
				var pageNum = parseInt($("#jumpNumTxt").val());
				// 如果跳转页数在不合理范围内，则置为1
				if (pageNum < 1 || pageNum > totalPage) {
					art.dialog({
						icon: 'error',
						title: '友情提示',
						drag: false,
						resize: false,
						content: '请输入合适的页数，\n自动为您跳到首页',
						ok: true,
						time: 3,
					},function(){
						jumpNormalPage(1);
					});
				}else{
					jumpNormalPage(pageNum);
				}
			} else {
				// “跳转页数”为空
				art.dialog({
					icon: 'error',
					title: '友情提示',
					drag: false,
					resize: false,
					content: '请输入合适的页数，\n自动为您跳到首页',
					ok: true,
				});
				jumpNormalPage(1);
			}
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
				<input type="hidden" id="pageSize"  name="pageSize" value="${pageInfo.pageSize}">

				<table cellspacing="5px;">
					<tr>
					<td>用户名：</td>
					<td><input type="text" name="userName" id="userName" class="easyui-validatebox" required="true"/></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>密码：</td>
					<td><input type="password" name="password" id="password" class="easyui-validatebox" required="true"/></td>
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
							<td>
								<c:choose>
									<c:when test="${item.status==0}">
										<span>启用</span>
									</c:when>
									<c:when test="${item.status==1}">
										<span>停用</span>
									</c:when>
								</c:choose>
							</td>
							<td>${item.createBy}</td>
							<td>
								<c:choose>
									<c:when test="${item.createTime==null}">
										<span></span>
									</c:when>
									<c:when test="${item.createTime !=null}">
										<span><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
									</c:when>
								</c:choose>
							</td>
						</tr>
					</c:forEach>

				</table>
			</div>
			<div class="ui_tb_h30">
				<div class="ui_flt" style="height: 30px; line-height: 30px;">
					共有
					<span class="ui_txt_bold04" id="total">${pageInfo.total}</span>
					条记录，当前第
					<span class="ui_txt_bold04" id="pageInfo">${pageInfo.pageNum}
						/
						${pageInfo.pages}</span>
					页
				</div>
				<div class="ui_frt">
					<!--    如果是第一页，则只显示下一页、尾页 -->
					<input type="button" value="首页" class="ui_input_btn01"
						   onclick="jumpNormalPage(1);"/>

					<input type="button" value="上一页" class="ui_input_btn01"
						   onclick="jumpNormalPage(getCurrentPage() - 1);"/>
					<input type="button" value="下一页" class="ui_input_btn01"
						   onclick="jumpNormalPage(getCurrentPage() + 1);"/>

					<input type="button" value="尾页" class="ui_input_btn01"
						   onclick="jumpNormalPage(getTotalPage());"/>

					<!--     如果是最后一页，则只显示首页、上一页 -->

					转到第<input type="text" id="jumpNumTxt" class="ui_input_txt01"/>页
					<input type="button" class="ui_input_btn01" value="跳转" onclick="jumpInputPage(${pageInfo.pages});"/>
				</div>
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
			bodyStr += "<td>"
				if(item.businessType==0){
					bodyStr += "<span>启用</span>";
				}else if(item.businessType==1){
					bodyStr += "<span>停用</span>";
				}
			bodyStr += "</td>";
			bodyStr += "<td>"+item.createBy+"</td>";
			bodyStr += "<td>"+item.createTime+"</td>";
			bodyStr += "</tr>"
		}
		return hrhead + bodyStr;
	}
</script>
</body>
</html>
