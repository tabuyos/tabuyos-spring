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
public class Question {
    @JacksonXmlProperty(localName = "selItemCount")
    private String selItemCount;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "item")
    private Collection<Item> items;
    @JacksonXmlProperty(localName = "content")
    private String content;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "attach")
    private Collection<Attach> attaches;
    @JacksonXmlProperty(localName = "solution")
    private Solution solution;
    @JacksonXmlProperty(isAttribute = true, localName = "id")
    private String id;
    @JacksonXmlProperty(isAttribute = true, localName = "type")
    private String type;

    public String getSelItemCount() {
        return selItemCount;
    }

    public void setSelItemCount(String selItemCount) {
        this.selItemCount = selItemCount.trim();
    }

    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }

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

    public Solution getSolution() {
        return solution;
    }

    public void setSolution(Solution solution) {
        this.solution = solution;
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

    @Override
    public String toString() {
        return "Question{" +
                "selItemCount='" + selItemCount + '\'' +
                ", items=" + items +
                ", content='" + content + '\'' +
                ", attaches=" + attaches +
                ", solution=" + solution +
                ", id='" + id + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
