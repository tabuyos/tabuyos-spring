package com.tabuyos.handle.resovler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tabuyos.handle.annotation.AutoHandle;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @Author Tabuyos
 * @Time 2020/5/12 9:01
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description Auto handle argument of method in controller, capture multi-argument for the class.
 */
public class AutoHandleArgumentResolver implements HandlerMethodArgumentResolver {

    private ObjectMapper objectMapper;
    private static final String JSON_REQUEST_BODY = "JSON_REQUEST_BODY";

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * true: take in resolveArgument method.
     * false: next annotation.
     *
     * @param parameter parameter of method.
     * @return boolean.
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(AutoHandle.class);
    }

    /**
     * handle argument if true supportsParameter for return.
     *
     * @param parameter     parameter of method.
     * @param mavContainer  model and view container.
     * @param webRequest    native web request for http/https.
     * @param binderFactory web data bind factory.
     * @return result of handle.
     * @throws Exception exception.
     */
    @Override
    public Object resolveArgument(MethodParameter parameter, @Nullable ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, @Nullable WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest httpServletRequest = webRequest.getNativeRequest(HttpServletRequest.class);
        if (httpServletRequest == null) {
            return null;
        }
        Map<String, Object> map = getRequestParameter(httpServletRequest);
        String parameterString = objectMapper.writeValueAsString(map);
        AutoHandle autoHandle = parameter.getParameterAnnotation(AutoHandle.class);
        if (autoHandle == null) {
            throw new NullPointerException("Auto handle(annotation: AutoHandle) must be not null!");
        }
        String key = autoHandle.value();
        Object value;
        if (StringUtils.isNotEmpty(key)) {
            value = map.get(key);
            if (value == null && autoHandle.required()) {
                throw new IllegalArgumentException(String.format("Required parameter %s is not present!", key));
            }
        } else {
            key = parameter.getParameterName();
            value = map.get(key);
        }

        Class<?> type = parameter.getParameterType();
        if (value != null) {
            if (type.isPrimitive()) {
                return parsePrimitive(type.getName(), value);
            } else if (isBasicType(type)) {
                return parseBasicTypeWrapper(type, value);
            } else if (type == String.class) {
                return value.toString();
            } else {
                return objectMapper.readValue(parameterString, type);
            }
        }

        if (isBasicType(type) || type.isPrimitive()) {
            if (autoHandle.required()) {
                throw new IllegalArgumentException(String.format("Required parameter %s is not present!", key));
            } else {
                return null;
            }
        }

        if (!autoHandle.parseAllFields()) {
            if (autoHandle.required()) {
                throw new IllegalArgumentException(String.format("Required parameter %s is not present!", key));
            }
            return null;
        }

        Object result;
        try {
            result = objectMapper.readValue(parameterString, type);
        } catch (Exception e) {
            e.printStackTrace();
            result = null;
        }

        if (autoHandle.required()) {
            boolean haveValue = false;
            Field[] fields = type.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.get(result) != null) {
                    haveValue = true;
                    break;
                }
            }
            if (!haveValue) {
                throw new IllegalArgumentException(String.format("Required parameter %s is not present!", key));
            }
        }

        return result;
    }

    private Object getRequestBody(HttpServletRequest httpServletRequest) {

        System.out.println("=========================parameterNames=========================");
        Enumeration<String> parameterNames = httpServletRequest.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String key = parameterNames.nextElement();
            System.out.println(key + " => " + Arrays.toString(httpServletRequest.getParameterValues(key)));
        }

        System.out.println("=========================headerNames=========================");
        Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            System.out.println(key + " => " + httpServletRequest.getHeader(key));
        }

        System.out.println("=========================attributeNames=========================");
        Enumeration<String> attributeNames = httpServletRequest.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String key = attributeNames.nextElement();
            System.out.println(key + " => " + httpServletRequest.getAttribute(key));
        }

        System.out.println("=========================parameterMap=========================");
        Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
        for (String key : parameterMap.keySet()) {
            System.out.println(key + " => " + Arrays.toString(parameterMap.get(key)));
        }

        Object jsonBody = httpServletRequest.getAttribute(JSON_REQUEST_BODY);
        if (jsonBody == null) {
            try {
                jsonBody = IOUtils.toString(httpServletRequest.getReader());
                httpServletRequest.setAttribute(JSON_REQUEST_BODY, jsonBody);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return jsonBody;
    }

    private Map<String, Object> getRequestParameter(HttpServletRequest httpServletRequest) {
        Map<String, Object> map = new HashMap<>(7);
        for (String key : httpServletRequest.getParameterMap().keySet()) {
            String[] value = httpServletRequest.getParameterValues(key);
            if (value.length > 1) {
                map.put(key, value);
            } else {
                map.put(key, value[0]);
            }
        }
        return map;
    }

    private Object parsePrimitive(String typeName, Object value) {
        final String intTypeName = "int";
        final String longTypeName = "long";
        final String charTypeName = "char";
        final String byteTypeName = "byte";
        final String shortTypeName = "short";
        final String floatTypeName = "float";
        final String doubleTypeName = "double";
        final String booleanTypeName = "boolean";

        if (booleanTypeName.equals(typeName)) {
            if ("".equals(value)) {
                return false;
            }
            return Boolean.valueOf(value.toString());
        }
        if (intTypeName.equals(typeName)) {
            if ("".equals(value)) {
                return 0;
            }
            return Integer.valueOf(value.toString());
        }
        if (charTypeName.equals(typeName)) {
            if ("".equals(value)) {
                return ' ';
            }
            return value.toString().charAt(0);
        }
        if (shortTypeName.equals(typeName)) {
            if ("".equals(value)) {
                return 0;
            }
            return Short.valueOf(value.toString());
        }
        if (longTypeName.equals(typeName)) {
            if ("".equals(value)) {
                return 0;
            }
            return Long.valueOf(value.toString());
        }
        if (floatTypeName.equals(typeName)) {
            if ("".equals(value)) {
                return 0;
            }
            return Float.valueOf(value.toString());
        }
        if (doubleTypeName.equals(typeName)) {
            if ("".equals(value)) {
                return 0;
            }
            return Double.valueOf(value.toString());
        }
        if (byteTypeName.equals(typeName)) {
            if ("".equals(value)) {
                return 0;
            }
            return Byte.valueOf(value.toString());
        }
        return null;
    }

    private boolean isBasicType(Class<?> clazz) {
        Set<Class<?>> classSet = new HashSet<>();
        classSet.add(Byte.class);
        classSet.add(Long.class);
        classSet.add(Short.class);
        classSet.add(Float.class);
        classSet.add(Double.class);
        classSet.add(Integer.class);
        classSet.add(Boolean.class);
        classSet.add(Character.class);
        return classSet.contains(clazz);
    }

    private Object parseBasicTypeWrapper(Class<?> type, Object value) {
        if (Number.class.isAssignableFrom(type)) {
            Number number = (Number) value;
            if (type == Integer.class) {
                return number.intValue();
            } else if (type == Short.class) {
                return number.shortValue();
            } else if (type == Long.class) {
                return number.longValue();
            } else if (type == Float.class) {
                return number.floatValue();
            } else if (type == Double.class) {
                return number.doubleValue();
            } else if (type == Byte.class) {
                return number.byteValue();
            }
        } else if (type == Boolean.class) {
            return value.toString();
        } else if (type == Character.class) {
            return value.toString().charAt(0);
        }
        return null;
    }
}
