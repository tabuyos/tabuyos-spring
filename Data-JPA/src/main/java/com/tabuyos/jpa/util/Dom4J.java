package com.tabuyos.jpa.util;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;

/**
 * @Author Tabuyos
 * @Time 2020/4/22 18:01
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class Dom4J {
    public void parserXml() {
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(new File("F:\\Tabuyos\\Desktop\\xml\\3__SSS_SINGLE_MULTI_SEL.xml"));
            System.out.println(document.getRootElement().getName());
            for (Attribute attribute : document.getRootElement().attributes()) {
                System.out.println(attribute.getName());
                System.out.println(attribute.getValue());
            }
            Element employees = document.getRootElement();
            Iterator<?> i = employees.elementIterator();
            if (i.hasNext()) {
                Element employee = (Element) i.next();
                for (Iterator<?> j = employee.elementIterator(); j.hasNext(); ) {
                    Element node = (Element) j.next();
                    System.out.println(node.getName() + ":" + node.getText());
                }
            }
        } catch (DocumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("dom4j parserXml");
    }

    public static void main(String[] args) {
        Dom4J dom4J = new Dom4J();
        dom4J.parserXml();
    }
}
