package com.hx.model;

/**
 * @program: cementstrength :水泥强度
 * @description:
 * @author: yangyue
 * @create: 2019/12/23 16:12
 */
public class MainDataModel extends BaseModel{
    //数据状态
    private Integer status;
    //查询条件
    private String condition;

    @Override
    public String toString() {
        return "MainDataModel{" +
                "status=" + status +
                ", condition='" + condition + '\'' +
                '}';
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
