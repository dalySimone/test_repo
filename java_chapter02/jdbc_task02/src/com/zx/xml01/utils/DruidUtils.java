package com.zx.xml01.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DruidUtils {

    // 1.定义成员变量
    public static DataSource dataSource;

    // 2.静态代码块，获取连接池对象
    static{

        try {
            // 3.创建属性集对象
            Properties p = new Properties();

            // 4.加载配置文件，Druid不能主动加载配置文件，需要指定文件
            InputStream inputStream = DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties");

            // 5.导出配置文件
            p.load(inputStream);

            // 6.获取连接池对象
            dataSource = DruidDataSourceFactory.createDataSource(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 7.获取连接
    public static Connection getConnection(){

        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
    public static DataSource getDataSource(){

        return dataSource;
    }
    // 8.关闭流
    public static void close(Connection connection, Statement statement){

        if (null != connection && null != statement){

            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(Connection connection, Statement statement, ResultSet resultSet){

        if (null != connection && null != statement){

            try {
                resultSet.close();
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
