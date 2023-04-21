package com.zx.work02;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.util.List;

public class GetBooksTest {

    public static void main(String[] args) throws DocumentException {

/*        // 1.创建解析器对象
        SAXReader saxReader = new SAXReader();

        // 2.获取文档对象
        Document document = saxReader.read("E:\\IdeaProtect\\java_chapter02\\jdbc_homework\\src\\com\\zx\\work02\\book.xml");

        // 3.获取所有节点
        List<Node> list = document.selectNodes("//*");

*//*        // 4.打印所有节点
        for (Node node : list){

            System.out.println("节点名是："+node.getName());
        }*//*

        // 4.获取第一本书信息
        List<Node> list1 = document.selectNodes("/books/book[@id = '01']//*");

        // 5.打印书本信息
        for (Node node : list1){

            System.out.print(node.getText());
            System.out.print(" ");
        }*/
        //1. 创建解析器
        SAXReader reader = new SAXReader();
        //2. 获取文档对象
        Document document = reader.read("E:\\IdeaProtect\\java_chapter02\\jdbc_homework\\src\\com\\zx\\work02\\book.xml");

        //3. 获取所有的book节点对象
        List<Element> books = document.selectNodes("/books/book");

        //4. 遍历book节点对象 list
        for (Element book : books) {
            // 获取当前book节点的属性: id
            String id = book.selectSingleNode("attribute::id").getText();
            // 获取出版社属性
            String publish = book.selectSingleNode("attribute::出版社").getText();
            // 获取书名的内容
            String name = book.selectSingleNode("name").getText();
            // 获取作者节点的内容
            String author = book.selectSingleNode("author").getText();
            // 获取当前图书价格
            String price = book.selectSingleNode("price").getText();
            //获取当前图书的库存
            String body = book.selectSingleNode("body").getText();

            // 打印图书信息
            System.out.print("id:" + id + ",出版社:" + publish + ",书名:" + name + ",作者:" + author);
            System.out.println(",价格:" + price + ", 库存:" + body);
            System.out.println("--------------------");
        }
    }
}
