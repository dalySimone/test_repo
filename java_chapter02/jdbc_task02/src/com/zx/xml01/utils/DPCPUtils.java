package com.zx.xml01.utils;


import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DPCPUtils {

    // 1.设置连接池参数
    public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/db6?characterEncoding=UTF-8";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "123456";

    // 2.创建连接池对象
    public static BasicDataSource  basicDataSource = new BasicDataSource();

    // 3.创建连接池
    static{
        basicDataSource.setDriverClassName(DRIVER_NAME);
        basicDataSource.setUrl(URL);
        basicDataSource.setUsername(USERNAME);
        basicDataSource.setPassword(PASSWORD);
    }
    // 获取连接
    public static Connection getConnection(){

        Connection connection = null;
        try {
            connection = basicDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // 关闭连接
    public static void close(Connection connection, Statement statement){

        if (null != connection && null != statement){
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet){

        if (null != connection && null != statement && null != resultSet){
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
