package com.tabuyos.shiro.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Tabuyos
 * @Time 2020/5/13 22:53
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class MyExceptionHandler implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception ex) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> attributes = new HashMap<>();
        if (ex instanceof UnauthenticatedException) {
            attributes.put("code", "1000001");
            attributes.put("msg", "token错误");
            System.out.println(1);
        } else if (ex instanceof UnauthorizedException) {
            attributes.put("code", "1000002");
            attributes.put("msg", "用户无权限");
            System.out.println(2);
        } else {
            attributes.put("code", "1000003");
            attributes.put("msg", ex.getMessage());
            System.out.println(3);
        }
        try {
            response.getWriter().write(mapper.writeValueAsString(attributes));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}