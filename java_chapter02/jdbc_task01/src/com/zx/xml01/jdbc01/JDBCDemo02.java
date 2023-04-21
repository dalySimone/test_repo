package com.zx.xml01.jdbc01;

import java.sql.*;

public class JDBCDemo02 {

    public static void main(String[] args){

        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // 注册驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 连接数据库
            String url = "jdbc:mysql://localhost:3306/db4";
            con = DriverManager.getConnection(url, "root", "123456");

            // 获取执行平台
            statement = con.createStatement();

            // 执行语句
            String sql = "select * from jdbc_user";
            // 处理结果集 resultSet
            resultSet = statement.executeQuery(sql);

            // 通过while循环，遍历表中的数据
            while(resultSet.next()){

                // 获取id
                int id = resultSet.getInt("id");

                // 获取username
                String username = resultSet.getString("username");

                // 获取password
                String password = resultSet.getString("password");

                // 获取birthday
                Date birthday = resultSet.getDate("birthday");

                System.out.println(id + ":" + username + ":" + password + ":" + birthday);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            try {
                resultSet.close();
                statement.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
