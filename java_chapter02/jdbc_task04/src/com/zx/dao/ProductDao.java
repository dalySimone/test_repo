package com.zx.dao;

import com.zx.entity.Category;
import com.zx.entity.Product;
import com.zx.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class ProductDao {

    /**
     * 需求1: 根据商品ID 获取商品名称 ,商品价格 以及商品所属分类的名称
     *       参数pid, 返回值 product对象
     */
    public Product findProductById(String pid) throws SQLException {

        // 1.创建QueryRunner
        QueryRunner qr = new QueryRunner(DruidUtils.dataSource);

        // 2.编写sql
        String sql = "select * from product where pid = ?";

        // 3.执行sql
        Product product = qr.query(sql, new BeanHandler<Product>(Product.class), pid);

        // 4.查找商品分类名称
        Category category = findCategoryById(product.getCid());

        // 5.放入Product中
        product.setCategory(category);

        return product;

    }
    /**
     * 根据分类id获取分类信息
     */
    public Category findCategoryById(String cid) throws SQLException {

        // 1.创建QueryRunner
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

        // 2.编写sql
        String sql = "select * from category where cid = ?";

        // 3.执行sql
        Category category = qr.query(sql, new BeanHandler<Category>(Category.class), cid);

        return category;
    }

    /**
     * 需求2: 根据分类ID 获取商品分类信息
     *       参数 cid , 返回值 category对象
     */
    public Category findCategory(String cid) throws SQLException {

        // 1.创建QueryRunner
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

        // 2.编写sql
        String sql = "select * from category where cid = ?";

        // 3.执行sql
        Category category = qr.query(sql, new BeanHandler<Category>(Category.class), cid);

        return category;
    }

    /**
     * 需求3: 查询指定分类ID 下的商品个数
     *       参数 cid , 返回值 int类型 商品个数
     */
    public int selectProductCount(String cid) throws SQLException {

        // 1.创建QueryRunner
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

        // 2.编写sql
        String sql = "select count(*) from product where cid = ?";

        // 3.执行sql
        Long count = qr.query(sql, new ScalarHandler<>(), cid);

        return count.intValue();
    }

    /**
     * 需求4: 查询指定分类ID 下的所有商品信息
     *       参数分类ID ,返回值 List集合 集合中保存商品对象
     */
    public List<Product> findProductByCid(String cid) throws SQLException {

        // 1.创建QueryRunner
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

        // 2.编写sql
        String sql = "select * from Product where cid = ?";

        // 3.执行sql
        List<Product> list = qr.query(sql, new BeanListHandler<Product>(Product.class), cid);

        return list;
    }
    /**
     * 根据商品id，获取商品的所有信息
     */
    public Product findProductByPid(String pid) throws SQLException {

        // 1.创建QueryRunner
        QueryRunner qr = new QueryRunner(DruidUtils.dataSource);

        // 2.编写sql
        String sql = "select * from product where pid = ?";

        // 3.执行sql
        Product product = qr.query(sql, new BeanHandler<Product>(Product.class), pid);

        return product;

    }

}
