package com.tabuyos.jpa.entity.exam;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.Collection;

/**
 * @Author Tabuyos
 * @Time 2020/4/22 13:21
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@JacksonXmlRootElement(localName = "Subject")
public class Subject {
    @JacksonXmlProperty(localName = "title")
    private String title;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "attach")
    private Collection<Attach> attaches;
    @JacksonXmlProperty(localName = "origialText")
    private String origialText;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "question")
    private Collection<Question> questions;
    @JacksonXmlProperty(isAttribute = true, localName = "id")
    private String id;
    @JacksonXmlProperty(isAttribute = true, localName = "type")
    private String type;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title.trim();
    }

    public Collection<Attach> getAttaches() {
        return attaches;
    }

    public void setAttaches(Collection<Attach> attaches) {
        this.attaches = attaches;
    }

    public String getOrigialText() {
        return origialText;
    }

    public void setOrigialText(String origialText) {
        this.origialText = origialText.trim();
    }

    public Collection<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Collection<Question> questions) {
        this.questions = questions;
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
        return "Subject{" +
                "title='" + title + '\'' +
                ", attaches=" + attaches +
                ", origialText='" + origialText + '\'' +
                ", questions=" + questions +
                ", id='" + id + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
