package com.zx.app;

import com.zx.dao.UserDao;
import com.zx.entity.User;
import com.zx.utils.DateUtils;
import com.zx.utils.UUIDUtils;
import org.junit.Test;

import java.sql.SQLException;

public class UserDaoTest {

    UserDao userDao = new UserDao();
    /**
     * 用户注册
     */
    @Test
    public void registerTest() throws SQLException {

        // 1.创建用户
        User user = new User();
        user.setUid(UUIDUtils.getUUID());
        user.setUsername("张三");
        user.setPassword("123");
        user.setTelephone("1234566789");
        user.setBirthday(DateUtils.getDateFormart());
        user.setSex("男");

        // 2.执行注册
        int i = userDao.register(user);

        // 3.判断注册是否成功
        if(i > 0){
            System.out.println("注册成功");
        }else{
            System.out.println("注册失败");
        }
    }
    /**
     * 用户登录
     */
    @Test
    public void loginTest() throws SQLException {

        // 1.测试用户登录功能
        User user = userDao.Login("张三", "123");

        // 2.判断是否登录成功
        if (user != null){
            System.out.println("登录成功");
        }else{
            System.out.println("登陆失败");
        }

    }
}
