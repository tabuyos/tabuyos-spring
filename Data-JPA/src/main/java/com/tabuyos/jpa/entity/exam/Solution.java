package com.tabuyos.jpa.entity.exam;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * @Author Tabuyos
 * @Time 2020/4/22 13:57
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class Solution {
    @JacksonXmlProperty(localName = "answer")
    private Answer answer;
    @JacksonXmlProperty(localName = "answerDesc")
    private AnswerDesc answerDesc;
    @JacksonXmlProperty(isAttribute = true, localName = "id")
    private String id;
    @JacksonXmlProperty(isAttribute = true, localName = "type")
    private String type;

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public AnswerDesc getAnswerDesc() {
        return answerDesc;
    }

    public void setAnswerDesc(AnswerDesc answerDesc) {
        this.answerDesc = answerDesc;
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
        return "Solution{" +
                "answer=" + answer +
                ", answerDesc=" + answerDesc +
                ", id='" + id + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
