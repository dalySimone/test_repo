package com.zx.xml01.jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo01 {

    public static void main(String[] args) throws Exception {

        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //连接数据库
        String url = "jdbc:mysql://localhost:3306/db4?characterEncoding=UTF-8";
        Connection con = DriverManager.getConnection(url, "root", "123456");

        //获取语句执行平台Statement
        Statement statement = con.createStatement();

        // 执行创建表操作
        String sql = "create table test(id int, name varchar(20), age int)";
        // 调用增删改方法
        int i = statement.executeUpdate(sql);
        System.out.println(i);

        // 关闭流并释放相关资源
        statement.close();
        con.close();
    }
}
