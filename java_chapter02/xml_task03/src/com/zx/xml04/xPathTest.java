package com.zx.xml04;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class xPathTest {

    @Test
    public void test01() throws DocumentException {

        // 1. 创建SaxReader对象
        SAXReader saxReader =  new SAXReader();

        // 2.获取文档对象
        Document document = saxReader.read("E:\\IdeaProtect\\java_chapter02\\xml_task03\\src\\com\\zx\\xml04\\book.xml");

        // 3.查找指定节点内容
        Node node = document.selectSingleNode("/bookstore/book/name");
        System.out.println(node.getName());
        System.out.println("书名："+ node.getText());

        // 4.查找其他节点内容
        Node node1 = document.selectSingleNode("/bookstore/book[2]/name");
        System.out.println(node1.getName());
        System.out.println("书名："+ node1.getText());
    }

    @Test
    public void test02() throws DocumentException {

        // 1.创建SAXReader对象
        SAXReader saxReader = new SAXReader();

        // 2.获取文档对象
        Document document = saxReader.read("E:\\IdeaProtect\\java_chapter02\\xml_task03\\src\\com\\zx\\xml04\\book.xml");

        // 3.获取节点属性
        Node node = document.selectSingleNode("/bookstore/book/attribute::id");
        System.out.println("属性名："+node.getText());

        // 4.获取最后一个节点的属性
        Node node1 = document.selectSingleNode("/bookstore/book[last()]/attribute::id");
        System.out.println("最后一个节点的属性名："+node1.getText());

        // 5.通过某个属性获取节点书名
        Node node2 = document.selectSingleNode("/bookstore/book[@id='book3']");
        Node name = node2.selectSingleNode("name");
        System.out.println("书名是："+name.getText());
    }

    @Test
    public void test03() throws DocumentException {

        // 1.创建SAXReader对象
        SAXReader saxReader = new SAXReader();

        // 2.获取文本对象
        Document document = saxReader.read("E:\\IdeaProtect\\java_chapter02\\xml_task03\\src\\com\\zx\\xml04\\book.xml");

        // 3.获取所有节点信息
        List<Node> nodes = document.selectNodes("//*");
        for (Node node : nodes){
            System.out.println("节点名称："+node.getName());
        }

        // 4.获取所有的书名
        List<Node> nodes1 = document.selectNodes("//name");
        for (Node node : nodes1){
            System.out.println("书名：" + node.getText());
        }

        // 5.获取指定属性为book1下的所有节点
        List<Node> nodes2 = document.selectNodes("/bookstore/book[@id='book1']//*");
        for (Node node : nodes2){
            System.out.println(node.getName() +" = "+ node.getText());
        }
    }
}
