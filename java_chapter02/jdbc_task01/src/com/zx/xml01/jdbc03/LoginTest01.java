package com.zx.xml01.jdbc03;

import com.zx.xml01.jdbcutils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LoginTest01 {

    /**
     * 用户登录案例
     * @param args
     */
    public static void main(String[] args) throws SQLException {

        // 1.连接数据库
        Connection connection = JDBCUtils.getConnection();

        // 2.获取Statement对象
        Statement statement = connection.createStatement();

        // 3.用户输入账号和密码
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入账号：");
        String name = sc.nextLine();
        System.out.println("请输入密码：");
        String pass = sc.nextLine();

        // 4.编写sql
        String sql = "select * from jdbc_user where username = '"+name+"' and password = '"+pass+"' ";
        System.out.println(sql);

        // 5.获取resultSet结果集
        ResultSet resultSet = statement.executeQuery(sql);

        // 6.处理结果集
        if (resultSet.next()){
            System.out.println("登录成功！");
        }else{
            System.out.println("登录失败！");
        }

        // 7.关闭流
        JDBCUtils.close(connection, statement, resultSet);
    }
}
