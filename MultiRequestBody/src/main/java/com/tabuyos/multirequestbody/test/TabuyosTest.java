package com.tabuyos.multirequestbody.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tabuyos.multirequestbody.entity.Tabuyos;

/**
 * @Author Tabuyos
 * @Time 2020/6/8 9:09
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class TabuyosTest {

    public static void main(String[] args) {
        String string = "{\"nian\":\"\",\"gender\":\"female\",\"age\":\"12\",\"years\":\"2020\"," +
                "\"username\":[\"Tabuyos\",\"Aaron Liew\"],\"sex\":\"20\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        try {
            System.out.println(string);
            Tabuyos tabuyos = objectMapper.readValue(string, Tabuyos.class);
            System.out.println(tabuyos.toString());
        } catch (JsonProcessingException jsonProcessingException) {
            jsonProcessingException.printStackTrace();
        }
    }
}
