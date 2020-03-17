package com.hx.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @program: eqds-ms
 * @description:
 * @author: yangyue
 * @create: 2019/12/21 14:19
 */
public class DbUtil {

    public static Connection getConnection(String dbpath, String password) {
        Connection conn = null;
        try {
            Properties prop = new Properties();
            prop.put("charSet", "UTF-8");
            prop.put("password", password);
            Class.forName("com.hxtt.sql.access.AccessDriver");
            conn = (Connection) DriverManager.getConnection("jdbc:Access:///" + dbpath, prop); // 连接数据库
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
