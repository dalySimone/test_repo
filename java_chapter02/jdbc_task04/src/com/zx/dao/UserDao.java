package com.zx.dao;

import com.zx.entity.User;
import com.zx.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import java.sql.SQLException;

public class UserDao {

    /**
     * 需求一: 编写一个注册用户的方法,接收的参数是一个User对象
     */
    //
    public int register(User user) throws SQLException {

        // 1.创建QueryRunner
        QueryRunner qr = new QueryRunner(DruidUtils.dataSource);

        // 2.编写sql
        String sql = "insert into user values(?,?,?,?,?,?)";

        // 3.设置参数
        Object[] param = {user.getUid(), user.getUsername(), user.getPassword(), user.getTelephone(),
        user.getBirthday(), user.getSex()};

        // 4.执行sql
        int i = qr.update(sql, param);

        // 5.返回受影响行数
        return i;
    }

    /**
     * 需求二: 编写一个 用户登录的方法,接收的参数是 用户名 和密码, 返回
     * 值是User对象
     */
    public User Login(String username, String password) throws SQLException {

        // 1.创建QueryRunner
        QueryRunner qr = new QueryRunner(DruidUtils.dataSource);

        // 2.编写sql
        String sql = "select * from user where username = ? and password = ?";

        // 3.执行sql
        User user1 = qr.query(sql, new BeanHandler<User>(User.class), username, password);

        return user1;
    }
}
