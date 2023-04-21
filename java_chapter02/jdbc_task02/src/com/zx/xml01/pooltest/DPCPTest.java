package com.zx.xml01.pooltest;

import com.zx.xml01.utils.DPCPUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DPCPTest {

    public static void main(String[] args) throws Exception {

        // 1.获取连接
        Connection connection = DPCPUtils.getConnection();

        // 2.获取Statement对象
        Statement statement = connection.createStatement();

        // 3.执行sql语句
        String sql = "select ename from employee";
        ResultSet resultSet = statement.executeQuery(sql);

        // 4.处理结果集
        while (resultSet.next()){

            String ename = resultSet.getString("ename");
            System.out.println("员工的姓名是："+ename);
        }
        // 5.关闭流,返回连接到连接池
        DPCPUtils.close(connection, statement, resultSet);
    }
}
