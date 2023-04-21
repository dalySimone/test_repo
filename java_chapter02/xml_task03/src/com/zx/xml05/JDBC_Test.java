package com.zx.xml05;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Test {

    public static void main(String[] args) throws SQLException {

        // 1.获取连接
        Connection connection = JDBCUtils.getConnection();

        // 2.获取statement平台
        Statement statement = connection.createStatement();

        // 3.执行语句
        ResultSet resultSet = statement.executeQuery("select * from employee");

        while(resultSet.next()){

            String ename = resultSet.getString("ename");
            System.out.println(ename);
        }

    }
}
