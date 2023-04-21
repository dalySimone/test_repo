package com.zx.xml01.jdbc02;

import com.zx.xml01.jdbcutils.JDBCUtils;
import org.junit.Test;

import java.sql.*;

public class TestDQL {

    /**
     * 查询数据
     */
    @Test
    public void testSelect() throws SQLException {

        // 1.建立连接
        Connection connection = JDBCUtils.getConnection();

        // 2.获取Statement对象
        Statement statement = connection.createStatement();

        // 3.编写查询语句
        String sql = "select * from jdbc_user where username = '李四' ";

        // 4.执行sql
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){

            // 获取id
            int id = resultSet.getInt("id");

            // 获取username
            String username = resultSet.getString("username");

            // 获取password
            String password = resultSet.getString("password");

            // 获取birthday
            Date birthday = resultSet.getDate("birthday");

            // 输出数据
            System.out.println(id+" : "+username+" : "+password+" : "+birthday);
        }

        // 5.关闭流并释放资源
        JDBCUtils.close(connection, statement, resultSet);
    }
}
