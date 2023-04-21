package com.zx.xml01.DBUtilstest;

import com.zx.xml01.entity.Employee;
import com.zx.xml01.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DBUtilsTest03 {

    /**
     * 查询操作：查询第五条数据
     * ArrayHandler 将结果的第一条数据封装到数组中
     */
    @Test
    public void selectTest01() throws SQLException {

        // 1.创建QueryRunner
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

        // 2.编写sql
        String sql = "select * from employee where eid = ?";

        // 3.执行sql
        Object[] query = qr.query(sql, new ArrayHandler(), 5);

        // 4.遍历结果集
        System.out.println(Arrays.toString(query));
    }

    /**
     * 查询操作：查询表中所有数据
     * ArrayListHandler,将每一条数据先封装到数组中，再将所有数组封装到集合中
     */
    @Test
    public void selectTest02() throws SQLException {

        // 1.创建QueryRunner
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

        // 2.编写sql
        String sql = "select * from employee";

        // 3.执行sql
        List<Object[]> query = qr.query(sql, new ArrayListHandler());

        // 4.遍历结果集
        for (Object[] objects: query){
            System.out.println(Arrays.toString(objects));
        }
    }
    /**
     * 查询操作：查询id为3的员工信息
     * BeanHandler, 将结果集的第一条数据封装到JavaBean中
     */
    @Test
    public void selectTest03() throws SQLException {

        // 1.创建QueryRunner
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

        // 2.编写sql
        String sql = "select * from employee where eid = ?";

        // 3.执行sql
        Employee employee = qr.query(sql, new BeanHandler<Employee>(Employee.class), 3);

        // 4.打印
        System.out.println(employee);
    }

    /**
     * 查询薪资大于 3000 的所员工信息,封装到JavaBean中再封装到List集合中
     * BeanListHandler ,将每一条数据封装到JavaBean中，再将JavaBean装到List集合中
     */
    @Test
    public void selectTest04() throws SQLException {

        // 1.创建QueryRunner
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

        // 2.编写sql
        String sql = "select * from employee where salary > ?";

        // 3.执行sql
        List<Employee> list = qr.query(sql, new BeanListHandler<Employee>(Employee.class), 3000);

        // 4.遍历query
        for(Employee employee: list){
            System.out.println(employee);
        }
    }

    /**
     *  查询姓名是 张百万的员工信息,将结果封装到Map集合中
     *  MapHandler, 将第一条记录封装到
     */
    @Test
    public void selectTest05() throws SQLException {

        // 1.获取QueryRunner
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

        // 2.编写sql
        String sql = "select * from employee where ename = ?";

        // 3.执行sql
        Map<String, Object> map = qr.query(sql, new MapHandler(), "李白");

        // 4.遍历map
        Set<Map.Entry<String, Object>> entries = map.entrySet();

        for (Map.Entry<String, Object> entry : entries) {
            System.out.println(entry.getKey() +" = "+ entry.getValue());
        }
    }
    /**
     * 查询所有员工的薪资总额
     * ScalarHandler, 用于封装单个数据
     */
    @Test
    public void selectTest06() throws SQLException {

        // 1.创建QueryRunner
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

        // 2.编写sql
        String sql = "select sum(salary) from employee";

        // 3.执行sql
        Double sum = (Double) qr.query(sql, new ScalarHandler<>());

        // 4.打印query
        System.out.println("所有员工的工资总和是："+ sum);
    }
}
