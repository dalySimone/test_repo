package com.zx.xml01.pooltest;

import com.zx.xml01.utils.DruidUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DruidTest {

    public static void main(String[] args) throws SQLException {

        // 1.创建连接
        Connection connection = DruidUtils.getConnection();

        // 2.获取执行平台
        Statement statement = connection.createStatement();

        // 3.执行sql
        String sql = "select ename from employee where salary between 3000 and 5000";
        ResultSet resultSet = statement.executeQuery(sql);

        // 4.处理结果集
        while(resultSet.next()){

            String ename = resultSet.getString("ename");
            System.out.println(ename);
        }
        DruidUtils.close(connection, statement, resultSet);

    }
}
