package com.zx.app;

import com.zx.dao.OrdersDao;
import com.zx.entity.Orders;
import com.zx.entity.Product;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class OrdersDaoTest {

    OrdersDao ordersDao = new OrdersDao();
    /**
     * 需求1: 获取 uid为 001 的用户的所有订单信息
     */
    @Test
    public void findOrdersTest() throws SQLException {

        List<Orders> list = ordersDao.findOrders("001");

        for (Orders order : list){

            System.out.println(order);
        }
    }

    /**
     * 需求2: 获取订单编号为 order001的订单中的所有商品信息
     *       参数 oid, 返回值List 商品集合
     */
    @Test
    public void getProductsTest() throws SQLException {

        List<Product> list = ordersDao.getProducts("order001");

        for (Product product : list){
            System.out.println(product);
        }

    }
}
