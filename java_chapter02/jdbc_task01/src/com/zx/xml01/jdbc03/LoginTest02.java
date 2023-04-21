package com.zx.xml01.jdbc03;

import com.zx.xml01.jdbcutils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginTest02 {

    public static void main(String[] args) throws SQLException {

        //获取连接
        Connection connection = JDBCUtils.getConnection();

        // 编写sql语句, 使用问号？表示占位符
        String sql = "select * from jdbc_user where username = ? and password = ?";

        // 获取预处理对象
        PreparedStatement ps = connection.prepareStatement(sql);

        // 输入用户名和密码
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name = sc.nextLine();
        System.out.println("请输入密码：");
        String pass = sc.nextLine();

        // 设置占位符参数
        ps.setString(1, name);
        ps.setString(2, pass);

        // 执行sql
        ResultSet resultSet = ps.executeQuery();

        // 处理结果集
        if (resultSet.next()){
            System.out.println("登录成功！");
        }else{
            System.out.println("登录失败！");
        }

        // 关闭流
        JDBCUtils.close(connection, ps, resultSet);
    }
}
