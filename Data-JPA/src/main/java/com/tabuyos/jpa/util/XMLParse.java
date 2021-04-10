package com.tabuyos.jpa.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tabuyos.jpa.entity.examination.*;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;

/**
 * @Author Tabuyos
 * @Time 2020/4/22 11:36
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class XMLParse {

    private final Subject subject = new Subject();

    public void parserXml() throws Exception {
        String fileName = "F:\\Tabuyos\\Desktop\\xml\\3__SSS_SINGLE_MULTI_SEL.xml";
        File inputXml = new File(fileName);
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(inputXml);
        Element element = document.getRootElement();
        parseSubject(element);
    }

    public void parseSubject(Element element) {
        for (Attribute attribute : element.attributes()) {
            subject.getProperties().put(attribute.getName().toLowerCase(), attribute.getValue());
        }
        for (Element childElement : element.elements()) {
            if (childElement.getName().toLowerCase().equals("Title".toLowerCase())) {
                subject.setTitle(childElement.getTextTrim());
            } else if (childElement.getName().toLowerCase().equals("OrigialText".toLowerCase())) {
                subject.setOrigialText(childElement.getTextTrim());
            } else if (childElement.getName().toLowerCase().equals("Attach".toLowerCase())) {
                subject.getAttaches().add(parseAttach(childElement));
            } else if (childElement.getName().toLowerCase().equals("Question".toLowerCase())) {
                subject.getQuestions().add(parseQuestion(childElement));
            }
        }
    }

    public Attach parseAttach(Element element) {
        Attach attach = new Attach();
        for (Attribute attribute : element.attributes()) {
            attach.getProperties().put(attribute.getName().toLowerCase(), attribute.getValue());
        }
        attach.setValue(element.getTextTrim());
        return attach;
    }

    public Question parseQuestion(Element element) {
        Question question = new Question();
        for (Attribute attribute : element.attributes()) {
            question.getProperties().put(attribute.getName().toLowerCase(), attribute.getValue());
        }
        for (Element childElement : element.elements()) {
            if (childElement.getName().toLowerCase().equals("SelItemCount".toLowerCase())) {
                question.setSelItemCount(childElement.getTextTrim());
            } else if (childElement.getName().toLowerCase().equals("Item".toLowerCase())) {
                question.getItems().add(parseItem(childElement));
            } else if (childElement.getName().toLowerCase().equals("Content".toLowerCase())) {
                question.setContent(childElement.getTextTrim());
            } else if (childElement.getName().toLowerCase().equals("Attach".toLowerCase())) {
                question.getAttaches().add(parseAttach(childElement));
            } else if (childElement.getName().toLowerCase().equals("Solution".toLowerCase())) {
                question.setSolution(parseSolution(childElement));
            }
        }
        return question;
    }

    public Item parseItem(Element element) {
        Item item = new Item();
        for (Attribute attribute : element.attributes()) {
            item.getProperties().put(attribute.getName().toLowerCase(), attribute.getValue());
        }
        for (Element childElement : element.elements()) {
            if (childElement.getName().toLowerCase().equals("Content".toLowerCase())) {
                item.setContent(childElement.getTextTrim());
            } else if (childElement.getName().toLowerCase().equals("Attach".toLowerCase())) {
                item.getAttaches().add(parseAttach(childElement));
            }
        }
        return item;
    }

    public Solution parseSolution(Element element) {
        Solution solution = new Solution();
        for (Attribute attribute : element.attributes()) {
            solution.getProperties().put(attribute.getName().toLowerCase(), attribute.getValue());
        }
        for (Element childElement : element.elements()) {
            if (childElement.getName().toLowerCase().equals("Answer".toLowerCase())) {
                solution.setAnswer(parseAnswer(childElement));
            } else if (childElement.getName().toLowerCase().equals("AnswerDes".toLowerCase())) {
                solution.setAnswerDes(parseAnswerDes(childElement));
            }
        }
        return solution;
    }

    public Answer parseAnswer(Element element) {
        Answer answer = new Answer();
        for (Attribute attribute : element.attributes()) {
            answer.getProperties().put(attribute.getName().toLowerCase(), attribute.getValue());
        }
        for (Element childElement : element.elements()) {
            if (childElement.getName().toLowerCase().equals("Content".toLowerCase())) {
                answer.setContent(childElement.getTextTrim());
            } else if (childElement.getName().toLowerCase().equals("Attach".toLowerCase())) {
                answer.getAttaches().add(parseAttach(childElement));
            }
        }
        return answer;
    }

    public AnswerDes parseAnswerDes(Element element) {
        AnswerDes answerDes = new AnswerDes();
        for (Attribute attribute : element.attributes()) {
            answerDes.getProperties().put(attribute.getName().toLowerCase(), attribute.getValue());
        }
        for (Element childElement : element.elements()) {
            if (childElement.getName().toLowerCase().equals("Content".toLowerCase())) {
                answerDes.setContent(childElement.getTextTrim());
            } else if (childElement.getName().toLowerCase().equals("Attach".toLowerCase())) {
                answerDes.getAttaches().add(parseAttach(childElement));
            }
        }
        return answerDes;
    }

    public static void main(String[] args) throws Exception {
        XMLParse dom4jUtil = new XMLParse();
        long beginTime = System.currentTimeMillis();
        dom4jUtil.parserXml();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - beginTime);
//        System.out.println(dom4jUtil.subject.getQuestions());

        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        System.out.println(objectMapper.writeValueAsString(dom4jUtil.subject));
    }
}
