package com.zx.xml01.batchteat;

import com.zx.xml01.utils.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchInsert {

    /**
     * 插入10000条数据
     * @param args
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException {

        // 1.获取连接
        Connection connection = DruidUtils.getConnection();

        // 2.编写sql
        String sql = "insert into testBatch(uname) values(?)";

        // 3.获取预处理平台
        PreparedStatement ps = connection.prepareStatement(sql);

        // 4.设置占位符参数，使用for循环
        for (int i=0; i<10000; i++){
            ps.setString(1, "张三"+i);
            ps.addBatch();
        }
        // 添加时间戳
        long start = System.currentTimeMillis();

        ps.executeBatch();
        long end = System.currentTimeMillis();

        System.out.println("耗费的时间毫秒数是："+(end - start));

        DruidUtils.close(connection, ps);
    }
}
