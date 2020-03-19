<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<script type="text/javascript" src="/scripts/jquery/jquery-1.7.1.js"></script>
	<link href="/style/authority/basic_layout.css" rel="stylesheet" type="text/css">
	<link href="/style/authority/common_style.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="/scripts/authority/commonAll.js"></script>
	<script type="text/javascript" src="/scripts/fancybox/jquery.fancybox-1.3.4.js"></script>
	<script type="text/javascript" src="/scripts/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
	<link rel="stylesheet" type="text/css" href="/style/authority/jquery.fancybox-1.3.4.css" media="screen"></link>
	<script type="text/javascript" src="/scripts/artDialog/artDialog.js?skin=default"></script>
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
		/** 用户角色   **/
		var userRole = '';

		/** 模糊查询 **/
		function search() {
			var status = $("#fyStatus").val();
			var condition = $("#condition").val().trim();
			var pageSize = $("#pageSize").val().trim();
			//queryData(null,status,condition);
			// queryData(page,pageSize,status,condition);
			// alert(status);
			$.ajax({
				type: "GET",
				url: "user/getByUse",
				data:{
					pageNum:1,
					pageSize:pageSize,
					status:status,
					condition:condition
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
			var status = $("#fyStatus").val();
			var condition = $("#condition").val().trim();
			var pageSize = $("#pageSize").val().trim();
			//   var msg = status +"==" + condition + "==" + page +"===" + pageSize;
			//  art.dialog({time: 3, content: msg});
			queryData(page,pageSize,status,condition);
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
						//window.location.href = "/getByPage?pageNum=" + pageNum;
					});
				}else{
					//$("#submitForm").attr("action", "house_list.html?page=" + pageNum).submit();
					//window.location.href = "/getByPage?pageNum=" + pageNum;
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
	</script>
	<style>
		.alt td {
			background: black !important;
		}
	</style>
</head>
<body>
<form id="submitForm" name="submitForm" action="" method="post">
	<input type="hidden" name="allIDCheck" value="" id="allIDCheck"/>
	<input type="hidden" name="fangyuanEntity.fyXqName" value="" id="fyXqName"/>
	<input type="hidden" id="pageSize"  name="pageSize" value="${pageInfo.pageSize}">
	<div id="container">
		<div class="ui_content">
			<div class="ui_text_indent">
				<div id="box_border">
					
					<div id="box_center">
						数据状态
						<select name="status" id="fyStatus" class="ui_select01">
							<option value="">--请选择--</option>
							<option value="1">未上传</option>
							<option value="2">已上传</option>
							<option value="0">异常</option>
						</select>
						样品编号<input type="text" name="sampleNo" id="condition" value="${requestModel.condition}" class="ui_input_txt02"/>
						<input type="button" value="查询" class="ui_input_btn01" onclick="search();"/>
					</div>
					<div id="box_bottom">
						<input type="button" id="synchronizeBtn" value="同步数据" class="ui_input_btn01" onclick="dataSynchronize();"/>
						<input type="button" value="数据上传" class="ui_input_btn01" onclick="dataUpload();"/>
					</div>
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
</form>
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
