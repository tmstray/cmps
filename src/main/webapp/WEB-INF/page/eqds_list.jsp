<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <script type="text/javascript" src="/js/eqds_Fun.js"></script>
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
        $(document).ready(function () {
            /** 新增   **/
            $("#addBtn").fancybox({
                'href': 'house_edit.html',
                'width': 733,
                'height': 530,
                'type': 'iframe',
                'hideOnOverlayClick': false,
                'showCloseButton': false,
                'onClosed': function () {
                    window.location.href = 'house_list.html';
                }
            });

            /** 导入  **/
            $("#importBtn").fancybox({
                'href': '/xngzf/archives/importFangyuan.action',
                'width': 633,
                'height': 260,
                'type': 'iframe',
                'hideOnOverlayClick': false,
                'showCloseButton': false,
                'onClosed': function () {
                    window.location.href = 'house_list.html';
                }
            });

            /**编辑   **/
            $("a.edit").fancybox({
                'width': 733,
                'height': 530,
                'type': 'iframe',
                'hideOnOverlayClick': false,
                'showCloseButton': false,
                'onClosed': function () {
                    window.location.href = 'house_list.html';
                }
            });
        });
        /** 用户角色   **/
        var userRole = '';

        /** 模糊查询 **/
        function search() {
            var status = $("#fyStatus").val();
            var condition = $("#condition").val().trim();
            //queryData(null,status,condition);
            $.ajax({
                type: "GET",
                url: "${pageContext.request.contextPath}/eqds/getByPage",
                data:{
                    status:status,
                    condition:condition
                },
                success: function (response) {
                    console.log("response==>",response)
                    if (response.resCode == 200) {
                        //art.dialog({time: 3, content: "数据上传成功!"});
                        console.log("success");
                        var dataHtml = refreshTable(response);
                        $("#datatable").html(dataHtml);
                        //更改分页数据信息
                        $("#total").text(response.pageInfo.total);
                        $("#pageInfo").text(response.pageInfo.pageNum + " / "
                            + response.pageInfo.pages);
                    } else {
                        //art.dialog({time: 3, content: "数据上传失败!"});
                        console.log("fail...");
                    }
                },error: function(data){
                    art.dialog({time: 3, content: "出错啦!!!"});
                }
            });
        }

        /** 新增   **/
        function add() {
            $("#submitForm").attr("action", "/xngzf/archives/luruFangyuan.action").submit();
        }

        /** Excel导出  **/
        function exportExcel() {
            if (confirm('您确定要导出吗？')) {
                var fyXqCode = $("#fyXq").val();
                var fyXqName = $('#fyXq option:selected').text();
//	 		alert(fyXqCode);
                if (fyXqCode == "" || fyXqCode == null) {
                    $("#fyXqName").val("");
                } else {
//	 			alert(fyXqCode);
                    $("#fyXqName").val(fyXqName);
                }
                $("#submitForm").attr("action", "/xngzf/archives/exportExcelFangyuan.action").submit();
            }
        }

        /** 删除 **/
        function del(fyID) {
            // 非空判断
            if (fyID == '') return;
            if (confirm("您确定要删除吗？")) {
                $("#submitForm").attr("action", "/xngzf/archives/delFangyuan.action?fyID=" + fyID).submit();
            }
        }

        /** 批量删除 **/
        function batchDel() {
            if ($("input[name='IDCheck']:checked").size() <= 0) {
                art.dialog({icon: 'error', title: '友情提示', drag: false, resize: false, content: '至少选择一条', ok: true,});
                return;
            }
            // 1）取出用户选中的checkbox放入字符串传给后台,form提交
            var allIDCheck = "";
            $("input[name='IDCheck']:checked").each(function (index, domEle) {
                bjText = $(domEle).parent("td").parent("tr").last().children("td").last().prev().text();
// 			alert(bjText);
                // 用户选择的checkbox, 过滤掉“已审核”的，记住哦
                if ($.trim(bjText) == "已审核") {
// 				$(domEle).removeAttr("checked");
                    $(domEle).parent("td").parent("tr").css({color: "red"});
                    $("#resultInfo").html("已审核的是不允许您删除的，请联系管理员删除！！！");
// 				return;
                } else {
                    allIDCheck += $(domEle).val() + ",";
                }
            });
            // 截掉最后一个","
            if (allIDCheck.length > 0) {
                allIDCheck = allIDCheck.substring(0, allIDCheck.length - 1);
                // 赋给隐藏域
                $("#allIDCheck").val(allIDCheck);
                if (confirm("您确定要批量删除这些记录吗？")) {
                    // 提交form
                    $("#submitForm").attr("action", "/xngzf/archives/batchDelFangyuan.action").submit();
                }
            }
        }

        /** 普通跳转 **/
        function jumpNormalPage(page) {
            if(page == 0 || page > getTotalPage() || getCurrentPage() == page){
                console.log("page===>",page);
                return;
            }
            var status = $("#fyStatus").val();
            var condition = $("#condition").val().trim();
            queryData(page,status,condition);
            /*$.ajax({
                type: "POST",
                url: "/getDataByPage",
                data:{
                    pageNum:page,
                    status:status,
                    condition:condition
                },
                success: function (response) {
                    console.log("response==>",response)
                    if (response.resCode == 200) {
                        //art.dialog({time: 3, content: "数据上传成功!"});
                        console.log("success");
                        var dataHtml = refreshTable(response);
                        $("#datatable").html(dataHtml);
                        //更改分页数据信息
                        $("#total").text(response.pageInfo.total);
                        $("#pageInfo").text(response.pageInfo.pageNum + " / "
                            + response.pageInfo.pages);
                    } else {
                        //art.dialog({time: 3, content: "数据上传失败!"});
                        console.log("fail...");
                    }
                },error: function(data){
                    art.dialog({time: 3, content: "出错啦!!!"});
                }
            });*/
            //window.location.href = "/getByPage?pageNum=" + page;
            //$("#submitForm").attr("action", "/getByPage?pageNum=" + page).submit();
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
                //$("#submitForm").attr("action", "house_list.html?page=" + 1).submit();
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
    <div id="container">
        <div class="ui_content">
            <div class="ui_text_indent">
                <div id="box_border">
                    <div id="box_center">
                        数据状态
                        <select id="fyStatus" class="ui_select01">
                            <option value="">--请选择--</option>
                            <option value="1">未上传</option>
                            <option value="2">已上传</option>
                            <option value="0">异常</option>
                        </select>
                        样品编号<input type="text" id="condition" value="${requestModel.condition}" class="ui_input_txt02"/>
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
                        <th>样品编号</th>
                        <c:if test="${USER_SESSION.simpled == true}">
                            <th>煤种</th>
                        </c:if>
                        <th>Mar(%)</th>
                        <th>Mad(%)</th>
                        <th>Vad(%)</th>
                        <th>Aad(%)</th>
                        <c:if test="${USER_SESSION.simpled == false}">
                            <th>Had(%)</th>
                        </c:if>
                        <th>Fcad(%)</th>
                        <th>焦渣特性</th>
                        <c:if test="${USER_SESSION.simpled == false}">
                            <th>Qbad(%)</th>
                        </c:if>
                        <th>Qnet,ad<br>(kcal/kg)</th>
                        <th>Qnet,ar<br>(kcal/kg)</th>
                        <th>Stad(%)</th>
                        <c:if test="${USER_SESSION.simpled == false}">
                            <th>Qgrd(%)</th>
                        </c:if>
                        <c:if test="${USER_SESSION.simpled == true}">
                            <th>分析日期</th>
                        </c:if>
                        <th>状态</th>
                    </tr>

                    <c:forEach var="item" items="${pageInfo.list}">

                        <tr>
                            <td><input type="checkbox" name="IDCheck" value="${item.id}" status="${item.status}"
                                       qbad="${item.qbad}" keed="${item.keed}" class="acb"/></td>
                            <td>
                                <c:choose>
                                    <c:when test="${item.samplenog!=null}">
                                        ${item.samplenog}
                                    </c:when>
                                    <c:when test="${item.samplenoy!=null}">
                                        ${item.samplenoy}
                                    </c:when>
                                    <c:otherwise>
                                        ${item.samplenol}
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <c:if test="${USER_SESSION.simpled == true}">
                                <c:choose>
                                    <c:when test="${item.keed==0}">
                                        <td>烟煤</td>
                                    </c:when>
                                    <c:when test="${item.keed==1}">
                                        <td>无烟煤</td>
                                    </c:when>
                                    <c:when test="${item.keed==2}">
                                        <td>褐煤</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td></td>
                                    </c:otherwise>
                                </c:choose>
                            </c:if>
                            <td>${item.mar}</td>
                            <td>${item.mad}</td>
                            <td>${item.vad}</td>
                            <td>${item.aad}</td>
                            <c:if test="${USER_SESSION.simpled == false}">
                                <td>${item.had}</td>
                            </c:if>
                            <td>${item.fcad}</td>
                            <td>${item.drags}</td>
                            <c:if test="${USER_SESSION.simpled == false}">
                                <td>${item.qbad}</td>
                            </c:if>
                            <td>${item.qnetad}</td>
                            <td>${item.qnetar}</td>
                            <td>${item.stad}</td>
                            <c:if test="${USER_SESSION.simpled == false}">
                                <td>${item.qgrd}</td>
                            </c:if>
                            <c:if test="${USER_SESSION.simpled == true}">
                                <td>${item.createtimeg}</td>
                            </c:if>
                            <td>
                                <c:choose>
                                    <c:when test="${item.status==0}">
                                        <span class="errord">异常</span>
                                    </c:when>
                                    <c:when test="${item.status==1}">
                                        <span class="readyd">未上传</span>
                                    </c:when>
                                    <c:when test="${item.status==2}">
                                        <span class="succeed">已上传</span>
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
</form>
<script>
    //表格重绘
    function refreshTable(response) {

        var hrhead = "<tr>" +
            "<th width=\"30\"><input type=\"checkbox\" onclick=\"selectOrClearAllCheckbox(this);\"/>" +
            "</th>" +
            "<th>样品编号</th>" +
            <c:if test="${USER_SESSION.simpled == true}">
            "<th>煤种</th>" +
            </c:if>
            "<th>Mar(%)</th>" +
            "<th>Mad(%)</th>" +
            "<th>Vad(%)</th>" +
            "<th>Aad(%)</th>" +
            <c:if test="${USER_SESSION.simpled == false}">
            "<th>Had(%)</th>" +
            </c:if>
            "<th>Fcad(%)</th>" +
            "<th>焦渣特性</th>" +
            <c:if test="${USER_SESSION.simpled == false}">
            "<th>Qbad(%)</th>" +
            </c:if>
            "<th>Qnet,ad<br>(kcal/kg)</th>" +
            "<th>Qnet,ar<br>(kcal/kg)</th>" +
            "<th>Stad(%)</th>" +
            <c:if test="${USER_SESSION.simpled == false}">
            "<th>Qgrd(%)</th>" +
            </c:if>
            <c:if test="${USER_SESSION.simpled == true}">
            "<th>分析日期</th>" +
            </c:if>
            "<th>状态</th>" +
            "</tr>";

        var bodyStr = "";
        for(i in response.pageInfo.list){
            var item = response.pageInfo.list[i];
            bodyStr += "<tr><td><input type=\"checkbox\" name=\"IDCheck\" value=" + item.id
                +" status="+item.status+" qbad=" + item.qbad +" keed=" + item.keed +" class=\"acb\"/></td>";
            bodyStr += "<td>";
            if(item.samplenog!=null){
                bodyStr += item.samplenog;
            }else if(item.samplenoy!=null){
                bodyStr += item.samplenoy;
            }else if(item.samplenol!=null){
                bodyStr += item.samplenol;
            }
            bodyStr += "</td>";
            <%--<c:if test="${USER_SESSION.simpled == true}">
                <c:choose>
                    <c:when test="${item.keed=='0'}">
                        bodyStr += "<td>烟煤</td>";
                    </c:when>
                    <c:when test="${item.keed==1}">
                        bodyStr += "<td>无烟煤</td>";
                    </c:when>
                    <c:when test="${item.keed==2}">
                        bodyStr += "<td>褐煤</td>";
                    </c:when>
                    <c:otherwise>
                        bodyStr += "<td>1</td>";
                    </c:otherwise>
                </c:choose>
            </c:if>--%>
            <%--bodyStr += ${USER_SESSION.simpled == true?(item.keed==0?"<td>烟煤</td>":(item.keed==1?"<td>无烟煤</td>":(item.keed==2?"<td>褐煤</td>":""))):""};--%>
            if($("#simpled").val() == "true"){
                bodyStr += "<td>"+(item.keed==0?"烟煤":(item.keed==1?"无烟煤":(item.keed==2?"褐煤":"")))+"</td>";
            }
            bodyStr += "<td>"+(item.mar==null?"":item.mar)+"</td>";
            bodyStr += "<td>"+(item.mad==null?"":item.mad)+"</td>";
            bodyStr += "<td>"+(item.vad==null?"":item.vad)+"</td>";
            bodyStr += "<td>"+(item.aad==null?"":item.aad)+"</td>";
            <c:if test="${USER_SESSION.simpled == false}">
            bodyStr += "<td>"+(item.had==null?"":item.had)+"</td>";
            </c:if>
            bodyStr += "<td>"+(item.fcad==null?"":item.fcad)+"</td>";
            bodyStr += "<td>"+(item.drags==null?"":item.drags)+"</td>";
            <c:if test="${USER_SESSION.simpled == false}">
            bodyStr += "<td>"+(item.qbad==null?"":item.qbad)+"</td>";
            </c:if>
            bodyStr += "<td>"+(item.qnetad==null?"":item.qnetad)+"</td>";
            bodyStr += "<td>"+(item.qnetar==null?"":item.qnetar)+"</td>";
            bodyStr += "<td>"+(item.stad==null?"":item.stad)+"</td>";
            <c:if test="${USER_SESSION.simpled == false}">
            bodyStr += "<td>"+(item.qgrd==null?"":item.qgrd)+"</td>";
            </c:if>
            <c:if test="${USER_SESSION.simpled == true}">
            bodyStr += "<td>"+(item.createtimeg==null?"":item.createtimeg)+"</td>";
            </c:if>
            bodyStr += "<td>";
            if(item.status==0){
                bodyStr += "<span class='errord'>异常</span>";
            }else if(item.status==1){
                bodyStr += "<span class='readyd'>未上传</span>";
            }else if(item.status==2){
                bodyStr += "<span class='succeed'>已上传</span>";
            }
            bodyStr += "</td>";
            bodyStr += "</tr>"
        }
        return hrhead + bodyStr;
    }
</script>
</body>
</html>
