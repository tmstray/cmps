//同步数据
function dataSynchronize() {
    //按钮点击后禁用按钮点击事件,等待同步完成后取消
    $("#synchronizeBtn").attr('disabled',true);
    $.ajax({
        type: "POST",
        url: "/cement/synchronize",
        data: {},
        success: function (response) {
            if (response.resCode == 200) {
                art.dialog({time: 3, content: "数据同步成功!"});
                var page = getCurrentPage();
                var status = $("#fyStatus").val();
                var condition = $("#condition").val().trim();
                var pageSize = $("#pageSize").val().trim();
                queryData(page,pageSize,status,condition);
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
            ids.push($(domEle).val());
        }else{
            //ids.push($(domEle).val());
            console.log("data error...")
        }
    });
    if(ids.length == 0){
        art.dialog({icon: 'error', title: '友情提示', drag: false, resize: false, content: '请选择有效数据!', ok: true,});
        return;
    }

    $.ajax({
        type: "POST",
        url: "/cement/upload?ids=" + ids,
        success: function (response) {
            if (response.resCode == 200) {
                var page = getCurrentPage();
                var status = $("#fyStatus").val();
                var condition = $("#condition").val().trim();
                var pageSize = $("#pageSize").val().trim();
                art.dialog({time: 3, content: "数据上传成功!"});
                queryData(page,pageSize,status,condition);
            } else {
                art.dialog({time: 3, content: "数据上传失败!"});
            }
        },error: function(data){
            art.dialog({time: 3, content: "数据上传失败!"});
        }
    });
}

//ajax数据请求
function queryData(page,pageSize,status,condition) {
    $.ajax({
        type: "POST",
        url: "/cement/getDataByPage",
        data:{
            pageNum:page,
            pageSize:pageSize,
            status:status,
            condition:condition
        },
        success: function (response) {
            //console.log("response==>",response)
            if (response.resCode == 200) {
                //    art.dialog({time: 3, content: "数据上传成功!"});
                //console.log("success");
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
