package com.zx.xml03;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class DOM4JTest {

    @Test
    public void test01() throws DocumentException {

        // 1.创建SaxReader对象
        SAXReader saxReader = new SAXReader();

        // 2.获取Document对象
        Document document = saxReader.read("E:\\IdeaProtect\\java_chapter02\\xml_task03\\src\\com\\zx\\xml03\\user.xml");

        // 3.获取根节点
        Element rootElement = document.getRootElement();

        // 4.获取所有子节点
        List<Element> elements = rootElement.elements();

        // 5.获取第一个子节点
        Element user = elements.get(0);

        // 6.获取第一个子节点的所有元素
        String id = user.attributeValue("id");
        String name = user.elementText("name");
        String age = user.elementText("age");
        // 通过getText获取当前元素
        String hobby = user.element("hobby").getText();

        // 7.打印信息
        System.out.println(id + " " + name + " " + age + " " +hobby);

    }

}
