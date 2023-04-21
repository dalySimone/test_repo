package com.zx.xml01.jdbc03;

import com.zx.xml01.jdbcutils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest03 {

    public static void main(String[] args) throws SQLException {

        // 获取连接
        Connection connection = JDBCUtils.getConnection();

        // 获取Statement对象
        Statement statement = connection.createStatement();

        // 执行sql
        // 每插入一条语句数据库就需要编译一次
        statement.executeUpdate("insert into jdbc_user values(null, '小明', '123', '1999/12/21')");
        statement.executeUpdate("insert into jdbc_user values(null, '小红', '456', '1998/12/21')");

        // 获取预处理对象
        // 只需要对这条插入语句预编译一次，后面每插入一条语句直接设置参数填充即可
        PreparedStatement ps = connection.prepareStatement("insert into jdbc_user values(?, ?, ?, ?)");

        // 设置预处理参数
        ps.setObject(1,null);
        ps.setString(2,"小斌");
        ps.setString(3,"789");
        ps.setString(4,"1997/2/3");
        // 执行语句
        ps.executeUpdate();

        // 插入第二条语句
        ps.setObject(1,null);
        ps.setString(2,"小华");
        ps.setString(3,"123");
        ps.setString(4,"1999/10/23");
        // 执行语句
        ps.executeUpdate();

        ps.close();
        statement.close();
        connection.close();
    }
}
