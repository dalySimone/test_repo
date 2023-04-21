package com.zx.work01;

import com.zx.utils.DruidUtils;

import java.sql.*;

public class HomeWorkTest01 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

//        1.编写一个测试类，在该测试类中使用PrepareStatement
//        根据name和gender进行数据查询，并将结果打印在控制台。

        // 1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 2.获取连接
        String url = "jdbc:mysql://localhost:3306/db8?characterEncoding=UTF-8";
        Connection connection = DriverManager.getConnection(url, "root", "123456");

        // 2.编写sql
        String sql = "select * from employee where name = ? and gender = ?";

        // 3.创建预处理平台
        PreparedStatement ps = connection.prepareStatement(sql);

        // 4.设置参数
        ps.setString(1, "张三");
        ps.setString(2, "男");

        // 5.执行sql
        ResultSet resultSet = ps.executeQuery();

        // 6.处理结果集
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String gender = resultSet.getString("gender");
            double salary = resultSet.getDouble("salary");
            Date empdate = resultSet.getDate("empdate");

            System.out.println(id+" "+name+" "+gender+" "+salary+" "+empdate);
        }


    }
}
