<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- use EL-Expression-->
<%@ page isELIgnored="false" %>
<!-- use JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>华新管理系统主界面</title>
    <!-- 引入CSS -->
    <link rel="stylesheet" type="text/css" href="easyui/css/default.css"/>
    <link rel="stylesheet" type="text/css"
          href="easyui/themes/metro/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css"/>
    <!-- 引入JS -->
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src='easyui/js/outlook2.js'></script>

    <!-- 页面事件 -->
    <script type="text/javascript">
        //设置系统功能菜单栏
        var _menus = {
            "menus": [
                {
                    "menuid": "1", "icon": "", "menuname": "用户信息管理",
                    "menus": [
                        {
                            "menuid": "21",
                            "menuname": "用户列表",
                            "icon": "icon-settings",
                            "url": "${pageContext.request.contextPath}/user/goSysUserListView"
                        }
                    ]
                }
            ]
        };

    </script>
</head>

<body class="easyui-layout" style="overflow-y: hidden" scroll="no">

<!-- 页面顶部 -->
<div region="north" split="true" border="false" style="overflow: hidden; height: 30px;
        line-height: 20px;color: #fff; font-family: Verdana, 微软雅黑,黑体,'Lucida Console',serif">
        
    <span style="padding-left:10px; font-size: 20px; color:darkgrey;font-weight: bold">华新管理系统主界面</span>
</div>

<!-- 页面底部-->
<div region="south" split="true" style="height: 30px;">
    <div class="footer">
        Copyright @ 2019 华新. All rights reserved | 版权所有<a href="http://www.huaxin.com">www.huaxin.com</a>
    </div>
</div>

<!-- 导航菜单内容 -->
<div region="west" hide="true" split="true" title="[ 导航菜单 ]" style="width:180px;" id="west">
    <div id="nav" class="easyui-accordion" fit="true">
        <!-- ······ -->
    </div>
</div>
</body>
</html>