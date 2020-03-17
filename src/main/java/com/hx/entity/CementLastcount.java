package com.hx.entity;

import org.springframework.stereotype.Component;

@Component
public class CementLastcount {
    private Integer id;

    private Integer cementcount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCementcount() {
        return cementcount;
    }

    public void setCementcount(Integer cementcount) {
        this.cementcount = cementcount;
    }

    public CementLastcount() {
    }

    public CementLastcount(Integer id, Integer cementcount) {
        this.id = id;
        this.cementcount = cementcount;
    }

    public CementLastcount(Integer cementcount) {
        this.cementcount = cementcount;
    }
}