package com.hx.model;

import com.github.pagehelper.PageInfo;

public class Response {
    private Integer resCode;
    private String resMessage;
    private PageInfo<?> pageInfo;
    private MainDataModel model;
    private SysLogDataModel logModel;

    public Response() {
    }

    public Response(Integer resCode, String resMessage, PageInfo<?> pageInfo, MainDataModel model) {
        this.resCode = resCode;
        this.resMessage = resMessage;
        this.pageInfo = pageInfo;
        this.model = model;
    }

    public Response(Integer resCode, String resMessage, PageInfo<?> pageInfo, SysLogDataModel logModel) {
        this.resCode = resCode;
        this.resMessage = resMessage;
        this.pageInfo = pageInfo;
        this.logModel = logModel;
    }

    public Response(Integer resCode, String resMessage) {
        this.resCode = resCode;
        this.resMessage = resMessage;
    }

    public Integer getResCode() {
        return resCode;
    }

    public void setResCode(Integer resCode) {
        this.resCode = resCode;
    }

    public String getResMessage() {
        return resMessage;
    }

    public void setResMessage(String resMessage) {
        this.resMessage = resMessage;
    }

    public PageInfo<?> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<?> pageInfo) {
        this.pageInfo = pageInfo;
    }

    public MainDataModel getModel() {
        return model;
    }

    public void setModel(MainDataModel model) {
        this.model = model;
    }

    public SysLogDataModel getLogModel() {
        return logModel;
    }

    public void setLogModel(SysLogDataModel logModel) {
        this.logModel = logModel;
    }
}
