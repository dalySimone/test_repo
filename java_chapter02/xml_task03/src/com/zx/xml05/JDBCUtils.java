package com.zx.xml05;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {

    public static String DRIVER_NAME;
    public static String URL;
    public static String USER;
    public static String PASSWORD;

    static{

        try {
            SAXReader saxReader = new SAXReader();

            Document document = saxReader.read("E:\\IdeaProtect\\java_chapter02\\xml_task03\\src\\com\\zx\\xml05\\jdbc.xml");

            Node node = document.selectSingleNode("/jdbc/property[@name = 'driverClass']");
            DRIVER_NAME = node.getText();

            Node node1 = document.selectSingleNode("/jdbc/property[@name = 'jdbcUrl']");
            URL = node1.getText();

            Node node2 = document.selectSingleNode("/jdbc/property[@name = 'user']");
            USER = node2.getText();

            Node node3 = document.selectSingleNode("/jdbc/property[@name = 'password']");
            PASSWORD = node3.getText();

            Class.forName(DRIVER_NAME);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){

        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
