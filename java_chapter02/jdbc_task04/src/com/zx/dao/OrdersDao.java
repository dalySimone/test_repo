package com.zx.dao;

import com.zx.entity.OrderItem;
import com.zx.entity.Orders;
import com.zx.entity.Product;
import com.zx.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdersDao {

    /**
     * 需求1: 获取 uid为 001 的用户的所有订单信息
     */
    public List<Orders> findOrders(String uid) throws SQLException {

        // 1.创建QueryRunner
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

        // 2.编写sql
        String sql = "select * from Orders where uid = ?";

        // 3.执行sql
        List<Orders> list = qr.query(sql, new BeanListHandler<Orders>(Orders.class), uid);

        return list;
    }

    /**
     * 需求2: 获取订单编号为 order001的订单中的所有商品信息
     *       参数 oid, 返回值List 商品集合
     */
    public List<Product> getProducts(String oid) throws SQLException {

        // 1.创建QueryRunner
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

        // 2.编写sql
        String sql = "select pid from orderitem where oid = ?";

        // 3.执行sql
        List<OrderItem> list = qr.query(sql, new BeanListHandler<OrderItem>(OrderItem.class), oid);

        ProductDao productDao = new ProductDao();
        List<Product> list1 = new ArrayList<>();

        for (OrderItem orderItem : list){

            String pid = orderItem.getPid();
            Product product = productDao.findProductByPid(pid);
            list1.add(product);
        }
        return list1;
    }
}
