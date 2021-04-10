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
public class Solution {
    private Answer answer;
    private AnswerDes answerDes;
    private Map<String, String> properties = new HashMap<>();

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public AnswerDes getAnswerDes() {
        return answerDes;
    }

    public void setAnswerDes(AnswerDes answerDes) {
        this.answerDes = answerDes;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Solution{" +
                "answers=" + answer +
                ", answerDes=" + answerDes +
                ", properties=" + properties +
                '}';
    }
}
