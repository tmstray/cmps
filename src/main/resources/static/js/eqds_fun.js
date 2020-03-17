//同步数据
function dataSynchronize() {
    //按钮点击后禁用按钮点击事件,等待同步完成后取消
    $("#synchronizeBtn").attr('disabled',true);
    $.ajax({
        type: "POST",
        url: "/eqds/synchronize",
        data: {},
        success: function (response) {
            if (response.resCode == 200) {
                art.dialog({time: 3, content: "数据同步成功!"});
                var page = getCurrentPage();
                var status = $("#fyStatus").val();
                var condition = $("#condition").val().trim();
                queryData(page,status,condition);
            } else {
                art.dialog({time: 3, content: "数据同步失败!"});
            }
            $("#synchronizeBtn").attr('disabled',false);
        }
    });
}

//手动上传
function dataUpload() {

    if ($("input[name='IDCheck']:checked").size() <= 0) {
        art.dialog({icon: 'error', title: '友情提示', drag: false, resize: false, content: '至少选择一条', ok: true,});
        return;
    }

    var ids = [];
    $("input[name='IDCheck']:checked").each(function (index, domEle) {
        //bjText = $(domEle).parent("td").parent("tr").last().children("td").last().prev().text();
// 			alert(bjText);
        // 用户选择的checkbox, 过滤掉“待上传”的
        /*if ($.trim(bjText) == "已审核") {
// 				$(domEle).removeAttr("checked");
            $(domEle).parent("td").parent("tr").css({color: "red"});
            $("#resultInfo").html("已审核的是不允许您删除的，请联系管理员删除！！！");
// 				return;
        } else {
            allIDCheck += $(domEle).val() + ",";
        }*/
        if($(domEle).attr("status") == 1){
            //待上传
            if(($("#simpled").val() == "false") && ($(domEle).attr("qbad") != "null")
                && ($(domEle).attr("qbad").trim() != "")){
                ids.push($(domEle).val());
            }else if(($("#simpled").val() == "true") && ($(domEle).attr("keed") != "null")
                && ($(domEle).attr("keed").trim() != "")){
                ids.push($(domEle).val());
            }else{
                //ids.push($(domEle).val());
                console.log("data error...")
            }
        }
    });
    if(ids.length == 0){
        art.dialog({icon: 'error', title: '友情提示', drag: false, resize: false, content: '请选择有效数据!', ok: true,});
        return;
    }

    $.ajax({
        type: "POST",
        url: "/eqds/upload?ids=" + ids,
        success: function (response) {
            if (response.resCode == 200) {
                var page = getCurrentPage();
                var status = $("#fyStatus").val();
                var condition = $("#condition").val().trim();
                art.dialog({time: 3, content: "数据上传成功!"});
                queryData(page,status,condition);
            } else {
                art.dialog({time: 3, content: "数据上传失败!"});
            }
        },error: function(data){
            art.dialog({time: 3, content: "数据上传失败!"});
        }
    });
}

/**
 * 获取当前页数
 */
function getCurrentPage(){
    var pageInfoText = $("#pageInfo").text();
    var currPageText = pageInfoText.split("/")[0];
    var currPage = parseInt(currPageText.trim());
    return currPage;
}

/**
 * 获取总页数
 */
function getTotalPage(){
    var pageInfoText = $("#pageInfo").text();
    var totalPageText = pageInfoText.split("/")[1];
    var totalPage = parseInt(totalPageText.trim());
    return totalPage;
}

//表格重绘
/**function refreshTable(response) {

    var hrhead = "<tr>" +
        "<th width=\"30\"><input type=\"checkbox\" onclick=\"selectOrClearAllCheckbox(this);\"/>" +
        "</th>" +
        "<th>样品编号</th>" +
        "<th>煤种</th>" +
        "<th>Drags</th>" +
        "<th>Mar</th>" +
        "<th>Mad</th>" +
        "<th>Vad</th>" +
        "<th>Aad</th>" +
        "<th>Had</th>" +
        "<th>Fcad</th>" +
        "<th>Stad</th>" +
        "<th>Qbad</th>" +
        "<th>Qnetar</th>" +
        "<th>Qnetad</th>" +
        "<th>Qgrd</th>" +
        "<th>分析日期</th>" +
        "<th>状态</th>" +
        "</tr>";

    var bodyStr = "";
    for(i in response.pageInfo.list){
        var item = response.pageInfo.list[i];
        bodyStr += "<tr><td><input type=\"checkbox\" name=\"IDCheck\" value=" + item.id +" status="+item.status+" class=\"acb\"/></td>";
        bodyStr += "<td>";
        if(item.samplenog!=null){
            bodyStr += item.samplenog;
        }else if(item.samplenoy!=null){
            bodyStr += item.samplenoy;
        }else if(item.samplenol!=null){
            bodyStr += item.samplenol;
        }
        bodyStr += "</td>";
        bodyStr += "<td>"+(item.keed==null?"":item.keed)+"</td>";
        bodyStr += "<td>"+(item.drags==null?"":item.drags)+"</td>";
        bodyStr += "<td>"+(item.mar==null?"":item.mar)+"</td>";
        bodyStr += "<td>"+(item.mad==null?"":item.mad)+"</td>";
        bodyStr += "<td>"+(item.vad==null?"":item.vad)+"</td>";
        bodyStr += "<td>"+(item.aad==null?"":item.aad)+"</td>";
        bodyStr += "<td>"+(item.had==null?"":item.had)+"</td>";
        bodyStr += "<td>"+(item.fcad==null?"":item.fcad)+"</td>";
        bodyStr += "<td>"+(item.stad==null?"":item.stad)+"</td>";
        bodyStr += "<td>"+(item.qbad==null?"":item.qbad)+"</td>";
        bodyStr += "<td>"+(item.qnetar==null?"":item.qnetar)+"</td>";
        bodyStr += "<td>"+(item.qnetad==null?"":item.qnetad)+"</td>";
        bodyStr += "<td>"+(item.qgrd==null?"":item.qgrd)+"</td>";
        bodyStr += "<td>"+(item.createtimeg==null?"":item.createtimeg)+"</td>";
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
}*/

//ajax数据请求
function queryData(page,status,condition) {
    $.ajax({
        type: "POST",
        url: "/eqds/getDataByPage",
        data:{
            pageNum:page,
            status:status,
            condition:condition
        },
        success: function (response) {
            //console.log("response==>",response)
            if (response.resCode == 200) {
                //art.dialog({time: 3, content: "数据上传成功!"});
                //console.log("success");
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

//表格重绘
function refreshTable_bak(response) {

    var hrhead = "<tr>" +
        "<th width=\"30\"><input type=\"checkbox\" onclick=\"selectOrClearAllCheckbox(this);\"/>" +
        "</th>" +
        "<th>样品编号</th>" +
        "<th>drags</th>" +
        "<th>mar</th>" +
        "<th>mad</th>" +
        "<th>vad</th>" +
        "<th>aad</th>" +
        "<th>had</th>" +
        "<th>stad</th>" +
        "<th>qbad</th>" +
        "<th>状态</th>" +
        "</tr>";

    var bodyStr = "<c:forEach var=\"item\" items=\"${response.pageInfo.list}\">" +
        "<tr>" +
        "<td><input type=\"checkbox\" name=\"IDCheck\" value=\"${item.id}\" status=\"${item.status}\" class=\"acb\"/></td>" +
        "<td><c:choose>" +
        "<c:when test=\"${item.samplenog!=null}\">${item.samplenog}</c:when>" +
        "<c:when test=\"${item.samplenoy!=null}\">${item.samplenoy}</c:when>" +
        "<c:otherwise>${item.samplenol}</c:otherwise>" +
        "</c:choose></td>" +
        "<td>${item.drags}</td>" +
        "<td>${item.mar}</td>" +
        "<td>${item.mad}</td>" +
        "<td>${item.vad}</td>" +
        "<td>${item.aad}</td>" +
        "<td>${item.had}</td>" +
        "<td>${item.stad}</td>" +
        "<td>${item.qbad}</td>" +
        "<td>${item.status}</td>" +
        "</tr>" +
        "</c:forEach>"
    return hrhead + bodyStr;
}
