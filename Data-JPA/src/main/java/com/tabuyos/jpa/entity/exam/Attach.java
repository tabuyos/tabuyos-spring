package com.tabuyos.jpa.entity.exam;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

/**
 * @Author Tabuyos
 * @Time 2020/4/22 13:57
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class Attach {
    @JacksonXmlText
    private String value;
    @JacksonXmlProperty(isAttribute = true, localName = "id")
    private String id;
    @JacksonXmlProperty(isAttribute = true, localName = "type")
    private String type;
    @JacksonXmlProperty(isAttribute = true, localName = "format")
    private String format;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type.trim();
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format.trim();
    }

    @Override
    public String toString() {
        return "Attach{" +
                "value='" + value + '\'' +
                ", id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", format='" + format + '\'' +
                '}';
    }
}
