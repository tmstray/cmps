//ajax数据请求
function queryData(page,pageSize,businessModule,businessType) {
    $.ajax({
        type: "POST",
        url: "/sysLog/getDataByPage",
        data:{
            pageNum:page,
            pageSize:pageSize,
            businessModule:businessModule,
            businessType:businessType
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
