package com.tabuyos.spring.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author Tabuyos
 * @Time 3/11/20 5:19 PM
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@Component
@Aspect
public class AspectTabuyos {

    @Pointcut("execution(* com.tabuyos.spring.dao..*.*(..))")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void before() {
        System.out.println("Proxy before.");
    }
}
