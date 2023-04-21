package com.zx.xml01.metadatatest;

import com.zx.xml01.utils.DruidUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DatabaseMetaData {

    /**
     * 获取数据库相关的信息
     */
    @Test
    public void metaDataTest01() throws SQLException {

        // 1.获取连接
        Connection connection = DruidUtils.getConnection();

        // 2.获取DatabaseMetaData
        java.sql.DatabaseMetaData metaData = connection.getMetaData();

        // 3.获取数据库元数据相关信息
        String url = metaData.getURL();
        System.out.println("数据库URL："+url);

        String userName = metaData.getUserName();
        System.out.println("用户名："+userName);

        String driverName = metaData.getDriverName();
        System.out.println("数据库驱动名称："+driverName);

        String databaseProductName = metaData.getDatabaseProductName();
        System.out.println("获取数据产品名称："+databaseProductName);

        String databaseProductVersion = metaData.getDatabaseProductVersion();
        System.out.println("数据库版本号："+databaseProductVersion);

        boolean b = metaData.isReadOnly();
        if (b){
            System.out.println("数据库只允许读操作");
        }else{
            System.out.println("数据库不只读");
        }
        connection.close();
    }
    /**
     * 获取表中元数据信息
     */
    @Test
    public void metaDataTest02() throws SQLException {

        // 1.获取链接
        Connection connection = DruidUtils.getConnection();

        // 2.编写sql
        String sql = "select * from employee";

        // 3.获取结果集平台
        PreparedStatement ps = connection.prepareStatement(sql);

        // 4.获取结果集元数据对象
        ResultSetMetaData metaData = ps.getMetaData();

        // 5.打印表中的总列数
        int count = metaData.getColumnCount();
        System.out.println("表中总共有："+count+"列");

        // 6.获取表中所有的字段名和字段类型
        for (int i=1; i<=count; i++) {
            String columnName = metaData.getColumnName(i);
            System.out.println("字段名：" + columnName);

            String columnTypeName = metaData.getColumnTypeName(i);
            System.out.println("字段类型是：" + columnTypeName);

            DruidUtils.close(connection, ps);
        }
    }
}
