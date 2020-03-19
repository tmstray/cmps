package com.hx.model;

/**
 * 日志查询条件封装
 */

public class SysLogDataModel extends BaseModel{
    private String businessModule;
    private String businessType;

    public String getBusinessModule() {
        return businessModule;
    }

    public void setBusinessModule(String businessModule) {
        this.businessModule = businessModule;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    @Override
    public String toString() {
        return "SysLogDataModel{" +
                "businessModule=" + businessModule +
                ", businessType='" + businessType + '\'' +
                '}';
    }

}
