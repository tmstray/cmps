package com.hx.entity;

/**
 * @program: eqds-ms
 * @description:
 * @author: yangyue
 * @create: 2019/12/20 16:03
 */
public class LastCount {

    private Integer id;
    private Integer gcount;
    private Integer ycount;
    private Integer lcount;

    public LastCount() {
    }

    public LastCount(Integer gcount, Integer ycount, Integer lcount) {
        this.gcount = gcount;
        this.ycount = ycount;
        this.lcount = lcount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGcount() {
        return gcount;
    }

    public void setGcount(Integer gcount) {
        this.gcount = gcount;
    }

    public Integer getYcount() {
        return ycount;
    }

    public void setYcount(Integer ycount) {
        this.ycount = ycount;
    }

    public Integer getLcount() {
        return lcount;
    }

    public void setLcount(Integer lcount) {
        this.lcount = lcount;
    }
}
