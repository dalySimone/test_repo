package com.zx.utils;

import com.sun.java.util.jar.pack.DriverResource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtils {

    public static String DRIVER_CLASS;
    public static String URL;
    public static String USERNAME;
    public static String PASSWORD;

    static{

        try {
            // 1.导入properties资源
            InputStream inputStream = DBUtils.class.getClassLoader().getResourceAsStream("db.properties");

            // 2.创建properties对象
            Properties properties = new Properties();

            // 3.加载文件
            properties.load(inputStream);

            // 4.把配置文件信息赋值给成员变量
            DRIVER_CLASS = properties.getProperty("driverClassName");
            URL = properties.getProperty("url");
            USERNAME = properties.getProperty("username");
            PASSWORD = properties.getProperty("password");

            // 5.注册驱动
            Class.forName(DRIVER_CLASS);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回连接
     */
    public Connection getConnection() throws SQLException {

        return DriverManager.getConnection(URL);
    }

    /**
     * 关闭资源
     */
    public void close(Connection connection, Statement statement){

        if (null != connection && null !=statement){
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 关闭资源
     */
    public void close(Connection connection, Statement statement, ResultSet resultSet){

        if (null != resultSet && null !=statement && null != connection){

            try {

                resultSet.close();
                statement.close();
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
