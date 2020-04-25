package com.tabuyos.jpa.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.vip.vers.entity.exam.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @Author Tabuyos
 * @Time 2020/4/23 9:17
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class JacksonParse {
    public static void main(String[] args) throws Exception {
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//        objectMapper.enable(MapperFeature.USE_STD_BEAN_NAMING);

        XmlMapper xmlMapper = new XmlMapper();
        /* 字段为null，自动忽略，不再序列化 */
        xmlMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        /* 设置转换模式 */
//        xmlMapper.enable(MapperFeature.USE_STD_BEAN_NAMING);
//        xmlMapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
//        xmlMapper.enable(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN);
//        xmlMapper.enable(JsonParser.Feature.ALLOW_MISSING_VALUES);
        xmlMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        xmlMapper.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);

        long beginTime = System.currentTimeMillis();
        String fileName = "F:\\Tabuyos\\Desktop\\xml\\3__SSS_SINGLE_MULTI_SEL.xml";
        File inputXml = new File(fileName);
        Subject map = xmlMapper.readValue(inputXml, Subject.class);
        long endTime = System.currentTimeMillis();

        System.out.println(endTime - beginTime);
        System.out.println(map);

        Subject subject = new Subject();
        subject.setId("12");
        subject.setTitle("Tabuyos");
        subject.setType("ok");
        subject.setOrigialText("fff");

        Collection<Attach> collectionAttach = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Attach attach = new Attach();
            attach.setFormat("Format"+i);
            attach.setId("id"+i);
            attach.setValue("hhh"+i);
            attach.setType("fail");
            collectionAttach.add(attach);
        }
        subject.setAttaches(collectionAttach);

        Collection<Question> collectionQuestion = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Question question = new Question();
            question.setId("id"+i);
            question.setType("fail");
            Solution solution = new Solution();
            Answer answer = new Answer();
            AnswerDesc answerDesc = new AnswerDesc();
            answer.setId("12");
            answer.setContent("fds");
            answerDesc.setId("1212");
            answerDesc.setContent("fdfdss");
            solution.setAnswer(answer);
            solution.setAnswerDesc(answerDesc);
            question.setSolution(solution);
            collectionQuestion.add(question);
        }
        subject.setQuestions(collectionQuestion);
//
//        xmlMapper.enable(MapperFeature.USE_STD_BEAN_NAMING);
//        String resultXml = xmlMapper.writeValueAsString(subject);
//        System.out.println(resultXml);
    }
}
