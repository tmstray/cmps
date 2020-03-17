package com.hx.entity;

/**
 * @program: eqds-ms
 * @description:
 * @author: yangyue
 * @create: 2019/12/19 17:06
 */
public class User {
    private String id;

    private String username;

    private String password;

    private boolean simpled;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", simpled='" + simpled + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSimpled() {
        return simpled;
    }

    public void setSimpled(boolean simpled) {
        this.simpled = simpled;
    }
}
