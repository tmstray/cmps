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

//ajax数据请求
function queryData(page,pageSize,status,condition) {
    $.ajax({
        type: "POST",
        url: "${pageContext.request.contextPath}/sysLog/getDataByPage",
        data:{
            pageNum:page,
            pageSize:pageSize,
            businessType:businessType,
            businessModule:businessModule
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
                //  art.dialog({time: 3, content: "数据上传失败!"});
                console.log("fail...");
            }
        },error: function(data){
            art.dialog({time: 3, content: "出错啦!!!"});
        }
    });
}
