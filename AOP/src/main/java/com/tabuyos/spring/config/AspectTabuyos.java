package com.tabuyos.spring.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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

//    @Before("pointCut()")
//    public void before() {
//        System.out.println("Proxy before.");
//    }
//
//    @After("pointCut()")
//    public void after() {
//        System.out.println("Proxy after.");
//    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        // 1 预处理
        Object[] args = proceedingJoinPoint.getArgs();
        if (args != null && args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                args[i] += " world";
            }
        }
        // 2 执行
        try {
            System.out.println("Proxy before.");
            Object o = proceedingJoinPoint.proceed(args);
            System.out.println("Execute result: " + o);
            System.out.println("Proxy after.");
            System.out.println("Proxy around.");
            return o;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }
    }
}
