package com.hx.model;

/**
 * @program: eqds-ms
 * @description:
 * @author: yangyue
 * @create: 2019/12/24 08:57
 */
public class BaseModel {
    private Integer pageNum;
    private Integer pageSize;

    public Integer getPageNum() {
        return pageNum == null ? 1 : pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize == null ? 10 : pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
