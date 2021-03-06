<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>华新管理系统主界面</title>
<%
	// 权限验证
	if(session.getAttribute("USER_SESSION")==null){
		response.sendRedirect("login.jsp");
		return;
	}
%>
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function(){
		// 数据
		var treeData=[{
			text:"华新水泥",
			children:[
				<c:forEach items="${USER_SESSION.menuId}" varStatus="status" var="item">
	                <c:if test="${'1'==item}">
					{
                        text:"水泥强度",
                        attributes:{
                            url:"cement/getByPage"
                        }
				    },
				    </c:if>
                    <c:if test="${'2'==item}">
                        {
                            text:"煤炭热值",
                            attributes:{
                                url:"eqds/getByPage"
                            }
                        },
                    </c:if>
                    <c:if test="${'3'==item}">
                        {
                            text:"操作日志",
                            attributes:{
                                url:"sysLog/getSysLog"
                            }
                        },
                    </c:if>
                    <c:if test="${'4'==item}">
                        {
                            text:"用户管理",
                            attributes:{
                                url:"user/getByUser"
                            }
                        }
                    </c:if>
                </c:forEach>
			]
		}];

		// 实例化树菜单
		$("#tree").tree({
			data:treeData,
			lines:true,
			onClick:function(node){
				if(node.attributes){
					openTab(node.text,node.attributes.url);
				}
			}
		});

		// 新增Tab
		function openTab(text,url){
			if($("#tabs").tabs('exists',text)){
				$("#tabs").tabs('select',text);
			}else{
				var content="<iframe frameborder='0' scrolling='auto' style='width:100%;height:100%' src="+url+"></iframe>";
				$("#tabs").tabs('add',{
					title:text,
					closable:true,
					content:content
				});
			}
		}
	});
</script>
</head>
<body class="easyui-layout">
	<div region="north" style="height: 60px;background-color: #E0EDFF">
		<div id="box_top" style="text-align: right;padding-right: 60px;paddingpadding-bottom:60px;">
            <font color="red" >欢迎您:${USER_SESSION.userName}</font>   &nbsp;&nbsp;&nbsp;
		    <a href="${pageContext.request.contextPath}/logout"><span style="color: black">退出</span></a>
        </div>
	</div>
	<div region="center">
		<div class="easyui-tabs" fit="true" border="false" id="tabs">
			<div title="首页" >
				<div align="center" style="padding-top: 100px;"><font color="red" size="10">欢迎使用</font></div>
			</div>
		</div>
	</div>
	<div region="west" style="width: 150px;" title="导航菜单" split="true">
		<ul id="tree"></ul>
	</div>
	<div region="south" style="height: 25px;" align="center">版权所有<a href="http://www.huaxin.com">www.huaxin.com</a></div>
</body>
</html>
