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

	var url;

	function deleteStudent(){
		var selectedRows=$("input[name='IDCheck']:checked");
		if (selectedRows.size() <= 0) {
			$.messager.alert("系统提示","请选择要删除的数据！");
			return;
	    }
		var userid =selectedRows.val();
		$.messager.confirm("系统提示","您确认要删掉这<font color=red>"+selectedRows.size()+"</font>条数据吗？",function(r){
			if(r){
				$.post("${pageContext.request.contextPath}/user/userIds",{userIds:userid},function(result){
					if(result.resCode==200){
						$.messager.alert("系统提示","删除成功");
						search();
					}else{
						$.messager.alert("删除失败");
					}
				},"json");
			}
		});
	}

		function openStudentAddDialog(){
			resetValue();
			$("#dlg").dialog("open").dialog("setTitle","添加用户信息");
			url="${pageContext.request.contextPath}/user/addUser";
		}

		function saveStudent(){
			var menuIdSelect=$("input[name='menuId']:checked");
			if(menuIdSelect.val()=='' || menuIdSelect.val()==undefined){
				layer.msg('未勾选菜单权限不能保存！', {
					icon: 1,
					time: 2000 //2秒关闭（如果不配置，默认是3秒）
				}, function(){
				});
				return ;
			}
			$("#fm").form("submit",{
				url:url,
				onSubmit:function(){
					return $(this).form("validate");
				},
				success:function(result){
					var response =JSON.parse(result);
					if(response.resCode==200){
						layer.msg('保存成功', {
							icon: 1,
							time: 2000 //2秒关闭（如果不配置，默认是3秒）
						}, function(){
						});
						$("#dlg").dialog("close");
						search();

					}else{
						layer.msg("系统提示"+response.resMessage,{
							icon: 1,
							time: 2000 //2秒关闭（如果不配置，默认是3秒）
						}, function(){
						});
						return;
					}
				}
			}).serialize();
		}

	function openModifyDialog(){
		var selectedRows=$("input[name='IDCheck']:checked");
		if (selectedRows.size() <= 0) {
			$.messager.alert("系统提示","请选择要修改的数据！");
			return;
		}
		var row=selectedRows.val().split(",");


		$("#dlg").dialog("open").dialog("setTitle","编辑用户信息");
		$("#userName").val(row[1]);
		$("#nickName").val(row[2]);
		$("#phoneNumber").val(row[2]);

		$("#menuId1").attr("checked",false);
		$("#menuId2").attr("checked",false);
		$("#menuId3").attr("checked",false);
		$("#menuId4").attr("checked",false);

		$("#fm").form("submit",{
			url:url,
			onSubmit:function(){
				return $(this).form("validate");
			},
			success:function(result){
				var response =JSON.parse(result);
				if(response.resCode==200){
					layer.msg('保存成功', {
						icon: 1,
						time: 2000 //2秒关闭（如果不配置，默认是3秒）
					}, function(){
					});
					$("#dlg").dialog("close");
					search();

				}else{
					layer.msg("系统提示"+response.resMessage,{
						icon: 1,
						time: 2000 //2秒关闭（如果不配置，默认是3秒）
					}, function(){
					});
					return;
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

	function resetValue(){
		$("#userName").val("");
		$("#password").val("");
		$("#nickName").val("");
		$("#phoneNumber").val("");

		$("#menuId1").attr("checked",false);
		$("#menuId2").attr("checked",false);
		$("#menuId3").attr("checked",false);
		$("#menuId4").attr("checked",false);
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
						<a href="javascript:openModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
						<a href="javascript:deleteStudent()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
					</div>
				</div>
				<div id="dlg" class="easyui-dialog" style="width: 750px;height: 550px;padding: 10px 20px"
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
					<tr>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td>用户昵称：</td>
						<td><input type="text" name="nickName" id="nickName" class="easyui-validatebox" maxlength="25"/></td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td>手机号码：</td>
						<td><input type="text" name="phoneNumber" id="phoneNumber" class="easyui-validatebox" maxlength="11"/></td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td>菜单权限：</td>
						<td colspan="4">
							<input type="checkbox" name="menuId" id="menuId1" value="1" />水泥强度&nbsp;&nbsp;
							<input type="checkbox" name="menuId" id="menuId2" value="2" />煤炭热值&nbsp;&nbsp;
							<input type="checkbox" name="menuId" id="menuId3" value="3" />操作日志&nbsp;&nbsp;
							<input type="checkbox" name="menuId" id="menuId4" value="4" />用户管理&nbsp;&nbsp;
						</td>
					</tr>
				</table>
		</form>
	</div>

				<div id="dlg-buttons" align="center">
					<a href="javascript:saveStudent()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
					<a href="javascript:closeStudentDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
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
				if(item.status==0){
					bodyStr += "<span>启用</span>";
				}else if(item.status==1){
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

<script type="text/javascript">
$(function () {
    // 设置地市多选下拉框内容
    setCityData();
});

/**
 * 获取选中的值
 */
function getSearchParams() {
    var cityIn = $('#ttt').combobox('getValues');
    if (cityIn[0] === '') { // 去除首位空格
        cityIn.splice(0, 1);
    }
    console.log(cityIn);
    alert(cityIn);
}

/**
 * 设置地市多选内容
 */
function setCityData() {
    var tttData = [
        {id: '', text: '全选'},
        {id: '1', text: '选项1'},
        {id: '2', text: '选项2'},
        {id: '3', text: '选项3'},
        {id: '4', text: '选项4'},
        {id: '5', text: '选项5'},
        {id: '6', text: '选项6'},
    ];
    combobox_checkbox('ttt', tttData, 'auto');
}

/**
 * 带有复选框的easyui下拉框
 * @param _id input标签的id
 * @param optionsJson json字符串，定义选项的内容，
 * 例子：
 * [
 * {id: '对应于option标签的value', text: '页面显示文本'}
 * ]
 * @param hight 下拉框高度
 */
function combobox_checkbox(_id, optionsJson, hight) {
    $('#'+_id).combobox({
        data: optionsJson,
        valueField:'id',
        textField:'text',
        panelHeight:hight,
        multiple:true,
        editable:false,
        formatter: function (row) { // formatter方法就是实现了在每个下拉选项前面增加checkbox框的方法
            var opts = $(this).combobox('options');
            return '<input type="checkbox" class="combobox-checkbox">' + row[opts.textField]
        },
        onLoadSuccess: function () { // 下拉框数据加载成功调用
            // 正常情况下是默认选中“所有”，但我想实现点击所有全选功能，这这样会冲突，暂时默认都不选
            $("#"+_id).combobox('clear'); //清空
        },
        onSelect: function (row) { // 选中一个选项时调用
            var opts = $(this).combobox('options');
            //当点击所有时，则勾中所有的选项
            if (row.text === "全选") {
                var data = $("#"+_id).combobox('getData');
                for (var i = 0; i < data.length; i++) {
                    $('#'+data[i].domId + ' input[type="checkbox"]').prop("checked", true);
                }
                var list = [];
                $.map(opts.data, function (opt) {
                    list.push(opt.id);
                });
                $("#"+_id).combobox('setValues', list); // combobox全选
            } else {
                //设置选中选项所对应的复选框为选中状态
                $('#'+row.domId + ' input[type="checkbox"]').prop("checked", true);
            }
        },
        onUnselect: function (row) { // 取消选中一个选项时调用
            var opts = $(this).combobox('options');
            // 当取消全选勾中时，则取消所有的勾选
            if (row.text === "全选") {
                var a = $("#"+_id).combobox('getData');
                for (var i = 0; i < a.length; i++) {
                    $('#'+a[i].domId + ' input[type="checkbox"]').prop("checked", false);
                }
                $("#"+_id).combobox('clear');//清空选中项
            } else {
                //设置选中选项所对应的复选框为非选中状态
                $('#'+row.domId + ' input[type="checkbox"]').prop("checked", false);
                var selectedList = $("#"+_id).combobox('getValues');
                // 如果“所有”是选中状态,则将其取消选中
                if (selectedList[0] === "") {
                    // 将“所有”选项移出数组，并且将该项的复选框设为非选中
                    selectedList.splice(0, 1);
                    $('#'+opts.data[0].domId + ' input[type="checkbox"]').prop("checked", false);
                }
                $("#"+_id).combobox('clear');//清空

                $("#"+_id).combobox('setValues', selectedList); // 重新复制选中项

            }
        }
    });
}
</script>
</body>
</html>
