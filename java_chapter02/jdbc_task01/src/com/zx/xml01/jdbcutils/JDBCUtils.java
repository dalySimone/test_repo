package com.zx.xml01.jdbcutils;

import java.sql.*;

public class JDBCUtils {

    public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/db4?characterEncoding=UTF-8";
   // jdbc:mysql://localhost:3306/db4?characterEncoding=UTF-8
    public static final String USER = "root";
    public static final String PASSWORD = "123456";

    static{
        // 注册驱动
        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 连接数据库
    public static Connection getConnection(){

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // 关闭流并释放资源
    public static void close(Connection connection, Statement statement){

        if (statement != null && connection != null){
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(Connection connection, Statement statement, ResultSet resultSet){

        if (resultSet != null && statement != null && connection != null){
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
