package com.zx.xml01.jdbc02;

import com.zx.xml01.jdbcutils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDML {

    /**
     * 插入数据
     */
    @Test
    public void testInsert() throws SQLException {

        // 1.建立连接
        Connection connection = JDBCUtils.getConnection();

        // 2.获取Statement对象
        Statement statement = connection.createStatement();

        // 3.编写sql语句
        String sql = "insert into jdbc_user values(null, '张三', '123', '2023/01/05')";
        String sql1 = "insert into jdbc_user values(null,'李四', '123', '2022/2/3')";
        String sql2 = "insert into jdbc_user values(null, 'tom', '123', '2021/2/3')";
        // 4.执行sql
        int i = statement.executeUpdate(sql1);
        System.out.println(i);

        // 5.关闭流
        JDBCUtils.close(connection, statement);
    }

    /**
     * 修改数据
     */
    @Test
    public void testUpdate() throws SQLException {

        // 1.连接数据库
        Connection connection = JDBCUtils.getConnection();

        // 2.获取Statement对象
        Statement statement = connection.createStatement();

        // 3.执行sql语句
        String sql = "update jdbc_user set username = '张三' where id = 1";
        int i = statement.executeUpdate(sql);
        System.out.println(i);

        // 4.关闭瑞
        JDBCUtils.close(connection, statement);
    }

    /**
     * 删除数据
     */
    @Test
    public void testDelete() throws SQLException {

        Connection connection = JDBCUtils.getConnection();

        Statement statement = connection.createStatement();

        String sql = "delete from jdbc_user where id in(1,2)";
        int i = statement.executeUpdate(sql);
        System.out.println(i);

        JDBCUtils.close(connection, statement);
    }
}
