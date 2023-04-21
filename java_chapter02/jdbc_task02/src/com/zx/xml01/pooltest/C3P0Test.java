package com.zx.xml01.pooltest;

import com.zx.xml01.utils.C3P0Utils;

import java.sql.*;

public class C3P0Test {

    public static void main(String[] args) throws SQLException {

        // 1.过去连接
        Connection connection = C3P0Utils.getConnection();

        // 2.获取预处理对象
        PreparedStatement ps = connection.prepareStatement("select * from employee where ename = ?");

        // 3.填充占位符
        ps.setString(1, "李白");
        ResultSet resultSet = ps.executeQuery();

        // 4.处理结果集
        while (resultSet.next()){

            int eid = resultSet.getInt("eid");
            String ename = resultSet.getString("ename");
            int age = resultSet.getInt("age");
            String sex = resultSet.getString("sex");
            double salary = resultSet.getDouble("salary");
            Date empdate = resultSet.getDate("empdate");

            System.out.println(eid+" : "+ename+" : "+age+" : "+sex+" : "+salary+" : "+empdate);
        }
        C3P0Utils.close(connection, ps, resultSet);
    }
}
