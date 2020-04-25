package com.tabuyos.jpa.entity.examination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Tabuyos
 * @Time 2020/4/22 13:21
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class Subject {

    private String title;
    private List<Attach> attaches = new ArrayList<>();
    private String OrigialText;
    private List<Question> questions = new ArrayList<>();
    private Map<String, String> properties = new HashMap<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Attach> getAttaches() {
        return attaches;
    }

    public void setAttaches(List<Attach> attaches) {
        this.attaches = attaches;
    }

    public String getOrigialText() {
        return OrigialText;
    }

    public void setOrigialText(String origialText) {
        OrigialText = origialText;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    public String getType() {
        for (String key : properties.keySet()) {
            if (key.toLowerCase().equals("type")) {
                return properties.get(key);
            }
        }
        return "null";
    }

    @Override
    public String toString() {
        return "Subject{" +
                "title='" + title + '\'' +
                ", attaches=" + attaches +
                ", OrigialText='" + OrigialText + '\'' +
                ", questions=" + questions +
                ", properties=" + properties +
                '}';
    }
}
