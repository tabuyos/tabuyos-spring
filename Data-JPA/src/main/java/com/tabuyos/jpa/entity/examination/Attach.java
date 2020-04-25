package com.tabuyos.jpa.entity.examination;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Tabuyos
 * @Time 2020/4/22 13:57
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class Attach {
    private String value;
    private Map<String, String> properties = new HashMap<>();

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Attach{" +
                "value='" + value + '\'' +
                ", properties=" + properties +
                '}';
    }
}
