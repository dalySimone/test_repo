package com.zx.xml01.DBUtilstest;

import com.zx.xml01.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;

public class DBUtilsTest01 {

    public static void main(String[] args) {

        // 1.手动创建QueryRunner对象
        QueryRunner queryRunner = new QueryRunner();

        // 2.自动创建QueryRunner对象,需要获取连接池对象
        QueryRunner queryRunner1 = new QueryRunner(DruidUtils.getDataSource());
    }

}
