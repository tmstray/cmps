package com.hx.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "access")
public class AccessConfig {
    // 水泥强度数据库参数配置；
    private String driver;
    private String charSet;
    private String password;
    private String path;
    private String sql;
    private String filePath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public AccessConfig(String driver, String charSet, String password, String path, String sql) {
        this.driver = driver;
        this.charSet = charSet;
        this.password = password;
        this.path = path;
        this.sql = sql;
    }

    public AccessConfig() {
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getCharSet() {
        return charSet;
    }

    public void setCharSet(String charSet) {
        this.charSet = charSet;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }


    // 增加另外项目的配置:eqds:
    private String gpath;
    private String gpassword;
    private String ypath;
    private String ypassword;
    private String lpath;
    private String lpassword;
    private String gfilePath;


    public String getGpath() {
        return gpath;
    }
    public void setGpath(String gpath) {
        this.gpath = gpath;
    }

    public String getGpassword() {
        return gpassword;
    }

    public void setGpassword(String gpassword) {
        this.gpassword = gpassword;
    }

    public String getYpath() {
        return ypath;
    }

    public void setYpath(String ypath) {
        this.ypath = ypath;
    }

    public String getYpassword() {
        return ypassword;
    }

    public void setYpassword(String ypassword) {
        this.ypassword = ypassword;
    }

    public String getLpath() {
        return lpath;
    }

    public void setLpath(String lpath) {
        this.lpath = lpath;
    }

    public String getLpassword() {
        return lpassword;
    }

    public void setLpassword(String lpassword) {
        this.lpassword = lpassword;
    }

    public String getGfilePath() {
        return gfilePath;
    }
    public void setGfilePath(String gfilePath) {
        this.gfilePath = gfilePath;
    }

}
