<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
 	<meta charset="UTF-8" content="#">
    <title>用户管理页面</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	
	<!-- 引入CSS -->
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/css/demo.css">
    <!-- 引入JS -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/easyui/themes/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/easyui/js/validateExtends.js"></script>

<script type="text/javascript">
        //DOM加载完成后执行的回调函数
        $(function () {
            var table;
            //初始化datagrid
            $('#dataList').datagrid({
                iconCls: 'icon-more',//图标
                border: true,
                collapsible: false,//是否可折叠
                fit: false,//自动大小
                method: "post",
                url: "${pageContext.request.contextPath}/user/getUserList?t" + new Date().getTime(),
                idField: 'userId',
                singleSelect: false,//是否单选
                rownumbers: true,//行号
                pagination: true,//分页控件
                sortName: 'userId',
                sortOrder: 'DESC',
                remoteSort: false,
                columns: [[
                    {field: 'chk', checkbox: true, width: 50},
                    {field: 'userId', title: 'ID', width: 50, sortable: true},
                    {field: 'userName', title: '用户名', width: 150},
                    {field: 'nickName', title: '用户昵称', width: 150},
                    {field: 'phoneNumber', title: '手机号码', width: 50},
                    {field: 'createBy', title: '创建者', width: 150},
                    {field: 'createTime', title: '创建时间', width: 150}
                ]],
                toolbar: "#toolbar"//工具栏
            });

            //设置分页控件
            var p = $('#dataList').datagrid('getPager');
            $(p).pagination({
                pageSize: 10,//设置每页显示的记录条数,默认为10
                pageList: [10, 20, 30, 50, 100],//设置每页记录的条数
                beforePageText: '第',
                afterPageText: '页    共 {pages} 页',
                displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',
            });

            //信息添加按钮事件
            $("#add").click(function () {
                table = $("#addTable");
                $("#addTable").form("clear");//清空表单数据
                $("#addDialog").dialog("open");//打开添加窗口
            });

            //信息修改按钮事件
            $("#edit").click(function () {
                table = $("#editTable");
                var selectRows = $("#dataList").datagrid("getSelections");
                if (selectRows.length !== 1) {
                    $.messager.alert("消息提醒", "请单条选择想要修改的数据哟!", "warning");
                } else {
                    $("#editDialog").dialog("open");
                }
            });

            //信息删除按钮事件
            $("#delete").click(function () {
                var selectRows = $("#dataList").datagrid("getSelections");//返回所有选中的行,当没有选中的记录时,将返回空数组
                var selectLength = selectRows.length;
                if (selectLength === 0) {
                    $.messager.alert("消息提醒", "请选择想要删除的数据哟!", "warning");
                } else {
                    var ids = [];
                    $(selectRows).each(function (i, row) {
                        ids[i] = row.id;//将预删除行的id存储到数组中
                    });
                    $.messager.confirm("消息提醒", "删除后将无法恢复该用户信息! 确定继续?", function (r) {
                        if (r) {
                            $.ajax({
                                type: "post",
                                url: "${pageContext.request.contextPath}/user/deleteSysUser?t" + new Date().getTime(),
                                data: {ids: ids},
                                dataType: 'json',
                                success: function (data) {
                                    if (data.success) {
                                        $.messager.alert("消息提醒", "删除成功啦!", "info");
                                        $("#dataList").datagrid("reload");//刷新表格
                                        $("#dataList").datagrid("uncheckAll");//取消勾选当前页所有的行
                                    } else {
                                        $.messager.alert("消息提醒", "服务器端发生异常! 删除失败!", "warning");
                                    }
                                }
                            });
                        }
                    });
                }
            });

            //设置添加用户信息窗口
            $("#addDialog").dialog({
                title: "添加用户信息窗口",
                width: 660,
                height: 530,
                iconCls: "icon-house",
                modal: true,
                collapsible: false,
                minimizable: false,
                maximizable: false,
                draggable: true,
                closed: true,
                buttons: [
                    {
                        text: '添加',
                        plain: true,
                        iconCls: 'icon-add',
                        handler: function () {
                            var validate = $("#addForm").form("validate");
                            if (!validate) {
                                $.messager.alert("消息提醒", "请检查你输入的数据哟!", "warning");
                            } else {
                                var data = $("#addForm").serialize();//序列化表单信息
                                $.ajax({
                                    type: "post",
                                    url: "${pageContext.request.contextPath}/user/addSysUser?t" + new Date().getTime(),
                                    data: data,
                                    dataType: 'json',
                                    success: function (data) {
                                        if (data.success) {
                                            $("#addDialog").dialog("close"); //关闭窗口
                                            $('#dataList').datagrid("reload");//重新刷新页面数据
                                            $.messager.alert("消息提醒", "添加成功啦!", "info");
                                        } else {
                                            $.messager.alert("消息提醒", data.msg, "warning");
                                        }
                                    }
                                });
                            }
                        }
                    },
                    {
                        text: '重置',
                        plain: true,
                        iconCls: 'icon-reload',
                        handler: function () {
                            $("#add_name").textbox('setValue', "");
                            $("#add_password").textbox('setValue', "");
                            $("#add_telephone").textbox('setValue', "");
                        }
                    }
                ]
            });

            //设置编辑用户信息窗口
            $("#editDialog").dialog({
                title: "修改用户信息窗口",
                width: 660,
                height: 400,
                iconCls: "icon-house",
                modal: true,
                collapsible: false,
                minimizable: false,
                maximizable: false,
                draggable: true,
                closed: true,
                buttons: [
                    {
                        text: '提交',
                        plain: true,
                        iconCls: 'icon-edit',
                        handler: function () {
                            var validate = $("#editForm").form("validate");
                            if (!validate) {
                                $.messager.alert("消息提醒", "请检查你输入的数据哟!", "warning");
                            } else {
                                var data = $("#editForm").serialize();//序列化表单信息
                                $.ajax({
                                    type: "post",
                                    url: "${pageContext.request.contextPath}/user/editSysUser?t=" + new Date().getTime(),
                                    data: data,
                                    dataType: 'json',
                                    success: function (data) {
                                        if (data.success) {
                                            //关闭窗口
                                            $("#editDialog").dialog("close");
                                            //重新刷新页面数据
                                            $('#dataList').datagrid("reload");
                                            $('#dataList').datagrid("uncheckAll");
                                            //用户提示
                                            $.messager.alert("消息提醒", "修改成功啦!", "info");
                                        } else {
                                            $.messager.alert("消息提醒", data.msg, "warning");
                                        }
                                    }
                                });
                            }
                        }
                    },
                    {
                        text: '重置',
                        plain: true,
                        iconCls: 'icon-reload',
                        handler: function () {
                            $("#edit_userName").textbox('setValue', "");
                            $("#edit_password").textbox('setValue', "");
                        }
                    }
                ],
                //打开窗口前先初始化表单数据(表单回显)
                onBeforeOpen: function () {
                    var selectRow = $("#dataList").datagrid("getSelected");
                    $("#edit_id").val(selectRow.userId);//初始化id值,需根据id更新用户信息
                    $("#edit_userName").textbox('setValue', selectRow.userName);
                    $("#edit_password").textbox('setValue', selectRow.password);
                }
            });

        });

    </script>
</head>
<body>

<!-- 用户列表信息 -->
<table id="dataList" cellspacing="0" cellpadding="0"></table>

<!-- 工具栏 -->
<div id="toolbar">
    <div style="float: left;"><a id="add" href="javascript:" class="easyui-linkbutton"
                                 data-options="iconCls:'icon-add',plain:true">添加</a></div>
    <div style="float: left;" class="datagrid-btn-separator"></div>
        <div style="float: left;"><a id="edit" href="javascript:" class="easyui-linkbutton"
                                     data-options="iconCls:'icon-edit',plain:true">修改</a></div>
        <div style="float: left;" class="datagrid-btn-separator"></div>
        <div style="float: left;"><a id="delete" href="javascript:" class="easyui-linkbutton"
                                     data-options="iconCls:'icon-some-delete',plain:true">删除</a></div>

</div>

<!-- 添加信息窗口 -->
<div id="addDialog" style="padding: 15px 0 0 55px;">
    <!-- 用户信息表单 -->
    <form id="addForm" method="post" action="#">
        <table id="addTable" style="border-collapse:separate; border-spacing:0 3px;" cellpadding="6">
            <tr>
                <td>姓名</td>
                <td colspan="1">
                    <input id="add_name" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="name" data-options="required:true, missingMessage:'请填写姓名哟~'"/>
                </td>
            </tr>
            <tr>
                <td>学号</td>
                <td colspan="1">
                    <input id="add_sno" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="sno" data-options="required:true, missingMessage:'请填写学号哟~'"/>
                </td>
            </tr>
            <tr>
                <td>密码</td>
                <td colspan="1">
                    <input id="add_password" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="password" name="password" data-options="required:true, missingMessage:'请填写自定义密码哟~'"/>
                </td>
            </tr>
            <tr>
                <td>邮箱</td>
                <td colspan="1"><input id="add_email" style="width: 200px; height: 30px;" class="easyui-textbox"
                                       type="text" name="email" validType="email"
                                       data-options="required:true, missingMessage:'请填写邮箱地址哟~'"/>
                </td>
            </tr>
            <tr>
                <td>电话</td>
                <td colspan="4"><input id="add_telephone" style="width: 200px; height: 30px;" class="easyui-textbox"
                                       type="text" name="telephone" validType="mobile"
                                       data-options="required:true, missingMessage:'请填写联系方式哟~'"/>
                </td>
            </tr>
            <tr>
                <td>住址</td>
                <td colspan="1"><input id="add_address" style="width: 200px; height: 30px;" class="easyui-textbox"
                                       type="text" name="address"
                                       data-options="required:true, missingMessage:'请填写家庭住址哟~'"/>
                </td>
            </tr>
        </table>
    </form>
</div>


<!-- 修改信息窗口 -->
<div id="editDialog" style="padding: 20px 0 0 65px">
    <!-- 用户信息表单 -->
    <form id="editForm" method="post" action="#">
        <!-- 获取被修改信息的用户id -->
        <input type="hidden" id="edit_id" name="userId"/>
        <table id="editTable" style="border-collapse:separate; border-spacing:0 3px;" cellpadding="6">
            <tr>
                <td>用户名</td>
                <td colspan="1">
                    <input id="edit_userName" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="userName" data-options="required:true, missingMessage:'请填写用户名哟~'"/>
                </td>
            </tr>
            <tr>
                <td>密码</td>
                <td colspan="1"><input id="edit_password" style="width: 200px; height: 30px;" class="easyui-textbox"
                                       type="text" name="password" 
                                       data-options="required:true, missingMessage:'请填写密码哟~'"/>
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
