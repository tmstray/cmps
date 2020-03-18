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
				url: "sysLog/getSysLog",
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
					<div id="box_top" style="text-align: right;padding-right: 20px;">欢迎您:${USER_SESSION.userName}
						<a href="${pageContext.request.contextPath}/logout"><span style="color: black">退出</span></a></div>
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
						<th>ID</th>
						<th>业务模块名称</th>
						<th>业务类型</th>
						<th>操作方法</th>
						<th>IP地址</th>
						<th>请求方式</th>
						<th>操作状态</th>
						<th>操作人</th>
						<th>创建时间</th>
					</tr>
					<c:forEach var="item" items="${pageInfo.list}">
						<tr>
							<td><input type="checkbox" name="IDCheck" value="${item.id}" status="${item.status}"
									   class="acb"/></td>
							<td>${item.id}</td>
							<td>${item.businessModule}</td>
							<td>
								<c:choose>
									<c:when test="${item.businessType==0}">
										<span>其他</span>
									</c:when>
									<c:when test="${item.businessType==1}">
										<span>新增</span>
									</c:when>
									<c:when test="${item.businessType==2}">
										<span>修改</span>
									</c:when>
									<c:when test="${item.businessType==3}">
										<span>删除</span>
									</c:when>
									<c:when test="${item.businessType==4}">
										<span>同步数据</span>
									</c:when>
									<c:when test="${item.businessType==5}">
										<span>上传数据</span>
									</c:when>
									<c:when test="${item.businessType==6}">
										<span>登录</span>
									</c:when>
									<c:when test="${item.businessType==7}">
										<span>退出</span>
									</c:when>
								</c:choose>
							</td>
							<td>${item.method}</td>
							<td>${item.ip}</td>
							<td>${item.requestMethod}</td>
							<td>${item.status}</td>
							<td>${item.createBy}</td>
							<td>
								<fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
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
</form>
<script>
	//表格重绘
	function refreshTable(response) {
		var hrhead = "<tr>" +
				"<th width=\"30\"><input type=\"checkbox\" onclick=\"selectOrClearAllCheckbox(this);\"/>" +
				"</th>" +
				"<th>ID</th>" +
				"<th>业务模块名称</th>" +
				"<th>业务类型</th>" +
				"<th>操作方法</th>" +
				"<th>IP地址</th>" +
				"<th>请求方式</th>" +
				"<th>操作状态</th>" +
				"<th>操作人</th>" +
				"<th>创建时间</th>" +
				"</tr>";

		var bodyStr = "";
		for(i in response.pageInfo.list){
			var item = response.pageInfo.list[i];
			bodyStr += "<tr><td><input type=\"checkbox\" name=\"IDCheck\" value=" + item.id
					+" qbad="+" class=\"acb\"/></td>";
			bodyStr += "<td>"+item.id+"</td>";
			bodyStr += "<td>"+item.businessModule+"</td>";
			bodyStr += "<td>";
			if(item.businessType==0){
				bodyStr += "<span>其他</span>";
			}else if(item.businessType==1){
				bodyStr += "<span class='readyd'>新增</span>";
			}else if(item.businessType==2){
				bodyStr += "<span class='succeed'>修改</span>";
			}else if(item.businessType==3){
				bodyStr += "<span class='succeed'>删除</span>";
			}else if(item.businessType==4){
				bodyStr += "<span class='succeed'>同步数</span>";
			}else if(item.businessType==5){
				bodyStr += "<span class='succeed'>数据上传</span>";
			}else if(item.businessType==6){
				bodyStr += "<span class='succeed'>登录</span>";
			}else if(item.businessType==7){
				bodyStr += "<span class='succeed'>退出</span>";
			}
			bodyStr += "</td>";
			bodyStr += "<td>"+item.method+"</td>";
			bodyStr += "<td>"+item.ip+"</td>";
			bodyStr += "<td>"+item.requestMethod+"</td>";
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
