package com.zx.app;

import com.zx.dao.ProductDao;
import com.zx.entity.Category;
import com.zx.entity.Product;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;


public class ProductDaoTest {

    ProductDao productDao = new ProductDao();
    /**
     * 1.测试：需求1: 根据商品ID 获取商品名称 ,商品价格 以及商品所属分类的名称
     *              参数pid, 返回值 product对象
     */
    @Test
    public void findProductTest() throws SQLException {

        Product product = productDao.findProductById("1");

        String pname = product.getPname();
        double price = product.getPrice();
        String cname = product.getCategory().getCname();

        System.out.println(pname + " " + price + " " + cname);
    }

    /**
     * 测试：需求2: 根据分类ID 获取商品分类信息
     *            参数 cid , 返回值 category对象
     */
    @Test
    public void findCategoryTest() throws SQLException {

        // 分类id为1的商品分类信息
        Category category = productDao.findCategory("1");

        System.out.println(category);
    }

    /**
     * 需求3: 查询指定分类ID 下的商品个数
     *       参数 cid , 返回值 int类型 商品个数
     */
    @Test
    public void selectProductCountTest() throws SQLException {

        // 查询分类id为3的商品个数
        int i = productDao.selectProductCount("3");

        // 打印
        System.out.println("分类id为3的目录下有商品数量："+i);
    }

    /**
     * 需求4: 查询指定分类ID 下的所有商品信息
     */
    @Test
    public void findProductByCidTest() throws SQLException {

        // 查询id为2下的所有商品信息
        List<Product> list = productDao.findProductByCid("2");

        // 打印
        for (Product product : list){
            System.out.println(product);
        }
    }
}
