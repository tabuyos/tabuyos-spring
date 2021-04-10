package com.tabuyos.jpa.entity.examination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Tabuyos
 * @Time 2020/4/22 13:57
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class Question {
    private String selItemCount;
    private List<Item> items = new ArrayList<>();
    private String content;
    private List<Attach> attaches = new ArrayList<>();
    private Solution solution;
    private Map<String, String> properties = new HashMap<>();

    public String getSelItemCount() {
        return selItemCount;
    }

    public void setSelItemCount(String selItemCount) {
        this.selItemCount = selItemCount;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Attach> getAttaches() {
        return attaches;
    }

    public void setAttaches(List<Attach> attaches) {
        this.attaches = attaches;
    }

    public Solution getSolution() {
        return solution;
    }

    public void setSolution(Solution solution) {
        this.solution = solution;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Question{" +
                "selItemCount='" + selItemCount + '\'' +
                ", items=" + items +
                ", content='" + content + '\'' +
                ", attaches=" + attaches +
                ", solution=" + solution +
                ", properties=" + properties +
                '}';
    }
}
