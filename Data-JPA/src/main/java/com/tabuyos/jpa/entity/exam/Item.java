package com.tabuyos.jpa.entity.exam;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Collection;

/**
 * @Author Tabuyos
 * @Time 2020/4/22 13:57
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class Item {
    @JacksonXmlProperty(localName = "content")
    private String content;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "attach")
    private Collection<Attach> attaches;
    @JacksonXmlProperty(isAttribute = true, localName = "id")
    private String id;
    @JacksonXmlProperty(isAttribute = true, localName = "type")
    private String type;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content.trim();
    }

    public Collection<Attach> getAttaches() {
        return attaches;
    }

    public void setAttaches(Collection<Attach> attaches) {
        this.attaches = attaches;
    }

    public String getId() {
        return id.trim();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type.trim();
    }

    @Override
    public String toString() {
        return "Item{" +
                "content='" + content + '\'' +
                ", attaches=" + attaches +
                ", id='" + id + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
