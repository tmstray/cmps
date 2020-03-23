package com.hx.utils.page.object;

public class BaseConditionVO {
    private int pageNum; //当前页码
    private int pageSize; //当前页码列表行数

    public BaseConditionVO(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
