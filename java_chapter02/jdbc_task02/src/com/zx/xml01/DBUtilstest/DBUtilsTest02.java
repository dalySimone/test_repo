package com.zx.xml01.DBUtilstest;

import com.zx.xml01.utils.DruidUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class DBUtilsTest02 {

    /**
     * 插入操作
     */
    @Test
    public void insertTest() throws SQLException {

        // 1.创建QueryRunner
        QueryRunner qr = new QueryRunner();

        // 2.编写sql语句
        String sql = "insert into employee values(?, ?, ?, ?, ?, ?)";

        // 3.设置占位符参数
        Object[] params = {null, "李华", 20, "男", 10000, "2010/10/12"};


        Connection connection = DruidUtils.getConnection();
        // 4.执行update
        int i = qr.update(connection, sql, params);

        // 5.释放资源
        DbUtils.close(connection);
    }

    /**
     * 修改操作
     */
    @Test
    public void updateTest() throws SQLException {

        // 1.创建自动QueryRunner对象
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

        // 2.编写sql
        String sql = "update employee set salary = ? where ename = ?";

        // 3.设置占位符参数
        Object[] params = {15000, "李华"};

        // 4.执行sql
        int i = qr.update(sql, params);

    }

    /**
     * 删除操作
     */
    @Test
    public void deleteTest() throws SQLException {

        // 1.创建QueryRunner对象
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

        // 2.编写sql语句
        String sql = "delete from employee where eid = ?";

        // 3.执行sql
        qr.update(sql, 1);
    }
}
