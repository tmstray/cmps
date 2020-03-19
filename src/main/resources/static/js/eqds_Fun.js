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

//数据上传失败
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


//ajax数据请求 上一页下一页 请求数据：
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
            if (response.resCode == 200) {
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

