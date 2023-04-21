package com.zx.xml01.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class C3P0Utils {

    // 1.获取连接池对象，C3P0对DataSource的实现，并且使用自定义的连接池
    public static ComboPooledDataSource dataSource = new ComboPooledDataSource("mysql");

    // 2.获取连接
    public static Connection getConnection() throws SQLException {

        return dataSource.getConnection();
    }

    // 3.释放资源
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
