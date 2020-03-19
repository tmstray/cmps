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
