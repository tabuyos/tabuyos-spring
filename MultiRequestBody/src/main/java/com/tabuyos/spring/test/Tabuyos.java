package com.tabuyos.spring.test;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Tabuyos
 * @Time 2020/5/9 14:45
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class Tabuyos {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        String string = mapper.writeValueAsString(list);
        System.out.println(string);
        List<?> list1 = mapper.readValue(string, List.class);
        System.out.println(mapper.readValue(list1.toString(), List.class));
    }
}
