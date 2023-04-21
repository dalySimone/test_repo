package com.zx.xml01.jdbc04;

import com.zx.xml01.jdbcutils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTransactionTest {

    /**
     * 使用事务进行转账操作
     * @param args
     */
    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement ps = null;
        try {
            // 获取连接
            connection = JDBCUtils.getConnection();

            // 开启事务
            connection.setAutoCommit(false);

            // 获取预处理对象
            ps = connection.prepareStatement("update account set money = money - ? where name = ?");
            // 开始转账，tom账户减500
            ps.setDouble(1, 500.0);
            ps.setString(2, "tom");
            ps.executeUpdate();

//            System.out.println(1/0);

            ps = connection.prepareStatement("update account set money = money + ? where name = ?");
            // jack账户加500
            ps.setDouble(1,500.0);
            ps.setString(2,"jack");
            ps.executeUpdate();

            // 提交事务
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {

            JDBCUtils.close(connection, ps);
        }

    }

}
