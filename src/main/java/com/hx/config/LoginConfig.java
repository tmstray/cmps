package com.hx.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @program: eqds-ms
 * @description:
 * @author: yangyue
 * @create: 2019/12/25 08:54
 */
@Component
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "user")
public class LoginConfig {

    private String username;

    private String password;

    private boolean simpled;

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
