package com.tabuyos.spring.util;

import com.tabuyos.spring.exception.TabuyosException;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/**
 * @Author Tabuyos
 * @Time 3/4/20 3:33 PM
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class BeanFactory {

    Map<String, Object> map = new HashMap<>();

    public BeanFactory(String xml) {
        parseXml(xml);
    }

    public void parseXml(String xml) {
        // load xml
        File file = new File(Objects.requireNonNull(this.getClass().getClassLoader().getResource(xml)).getPath());
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(file);
            // get root tag
            Element elementRoot = document.getRootElement();
            Attribute autowired = elementRoot.attribute("autowired");
            boolean flag = false;
            if (autowired != null) {
                flag = true;
            }
            for (Iterator<Element> it = elementRoot.elementIterator(); it.hasNext(); ) {
                Element elementFirstLevel = it.next();
                String beanName = elementFirstLevel.attribute("id").getValue();
                String className = elementFirstLevel.attribute("class").getValue();
                Class<?> clazz = Class.forName(className);
                Object object = null;//clazz.getDeclaredConstructor().newInstance()
                for (Iterator<Element> it1 = elementFirstLevel.elementIterator(); it1.hasNext(); ){
                    Element elementSecondLevel = it1.next();
                    if (elementSecondLevel.getName().equals("property")){
                        // 由于是Setter， 没有特殊的构造方法， so
                        object = clazz.getDeclaredConstructor().newInstance();
                        String fieldName = elementSecondLevel.attribute("name").getValue();
                        String refBeanName = elementSecondLevel.attribute("ref").getValue();
                        Object injectObject = map.get(refBeanName);
                        Field field = clazz.getDeclaredField(fieldName);
                        field.setAccessible(true);
                        field.set(object, injectObject);
                    } else {
                        // 证明有特殊构造方法
                        String fieldName = elementSecondLevel.attribute("name").getValue();
                        String refBeanName = elementSecondLevel.attribute("ref").getValue();
                        Field field = clazz.getDeclaredField(fieldName);
                        Object injectObject = map.get(refBeanName);
//                        Class<?> injectObjectClass = injectObject.getClass();
                        Constructor<?> constructor = clazz.getConstructor(field.getType());
                        object = constructor.newInstance(injectObject);
                    }
                }
                if (object == null) {
                    if (flag) {
                        if (autowired.getValue().equals("byType")) {
                            // determine if exist dependence
                            Field[] fields = clazz.getDeclaredFields();
                            for (Field field : fields) {
                                // get type
                                Class<?> injectObjectClass = field.getType();
                                // 由于是byType， 因此需要遍历map中所有的对象， 判断对象的类型是不是和这个injectObjectClass相同
                                int count = 0;
                                Object injectObject = null;
                                for (String key : map.keySet()) {
                                    Class<?> temp = map.get(key).getClass().getInterfaces()[0];
                                    if (temp.getName().equals(injectObjectClass.getName())) {
                                        // maybe find multi-result
                                        injectObject = map.get(key);
                                        count++;
                                    }
                                }
                                if (count > 1) {
                                    throw new TabuyosException("need one object but find multi-object");
                                } else {
                                    object = clazz.getDeclaredConstructor().newInstance();
                                    field.setAccessible(true);
                                    field.set(object, injectObject);
                                }
                            }
                        }
                    }

                }
                /*
                  维护依赖关系
                  看这个对象有没有依赖（判断是否有property， 或者判断类是否有属性）
                  有则注入
                 */
                if (object == null) {
                    object = clazz.getDeclaredConstructor().newInstance();
                }
                map.put(beanName, object);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(map);
    }

    public Object getBean(String beanName) {
        return map.get(beanName);
    }
}
