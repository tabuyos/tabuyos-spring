package com.tabuyos.multirequestbody.resovler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tabuyos.multirequestbody.annotation.MultiRequestBody;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ValueConstants;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @Author Tabuyos
 * @Time 2020/5/12 9:01
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description Auto handle argument of method in controller, capture multi-argument for the class.
 */
public class MultiRequestBodyArgumentResolver implements HandlerMethodArgumentResolver {

    private ObjectMapper objectMapper;
    private static final String JSON = "application/json";
    private static final String CONTENT_TYPE = "content-type";
    private static final String FORM_DATA = "multipart/form-data";
    private static final String JSON_REQUEST_BODY = "JSON_REQUEST_BODY";
    private static final String X_WWW_FORM_URLENCODED = "application/x-www-form-urlencoded";

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
        return parameter.hasParameterAnnotation(MultiRequestBody.class);
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
        Map<String, Object> map;
        String contentType = httpServletRequest.getHeader(CONTENT_TYPE);
        System.out.println(contentType);
        if (contentType.contains(FORM_DATA)) {
            map = getRequestParameter(httpServletRequest);
        } else if (contentType.contains(X_WWW_FORM_URLENCODED)) {
            map = getRequestBodyFromUrlEncoded(httpServletRequest);
        } else if (contentType.contains(JSON)) {
            map = getRequestBodyFromJson(httpServletRequest);
        } else {
            return null;
        }
        String parameterString = objectMapper.writeValueAsString(map);
        MultiRequestBody multiRequestBody = parameter.getParameterAnnotation(MultiRequestBody.class);
        if (multiRequestBody == null) {
            throw new NullPointerException("Auto handle(annotation: AutoHandle) must be not null!");
        }
        String key = multiRequestBody.value();
        Object value;
        if (StringUtils.isNotEmpty(key)) {
            value = map.get(key);
            if (value == null && multiRequestBody.required()) {
                throw new IllegalArgumentException(String.format("Required parameter %s is not present!", key));
            }
        } else {
            key = parameter.getParameterName();
            value = map.get(key);
        }

        Class<?> type = parameter.getParameterType();
        if (value != null) {
            return getValue(parameterString, value, type);
        }

        if (isBasicType(type) || type.isPrimitive()) {
            if (ValueConstants.DEFAULT_NONE.equals(multiRequestBody.defaultValue())) {
                if (multiRequestBody.required()) {
                    throw new IllegalArgumentException(String.format("Required parameter %s is not present!", key));
                } else {
                    return null;
                }
            } else {
                return getValue(parameterString, multiRequestBody.defaultValue(), type);
            }
        }

        if (!multiRequestBody.parseAllFields()) {
            if (multiRequestBody.required()) {
                throw new IllegalArgumentException(String.format("Required parameter %s is not present!", key));
            }
            return null;
        }

        return getResult(parameterString, multiRequestBody, key, type);
    }

    private Object getResult(String parameterString, MultiRequestBody multiRequestBody, String key, Class<?> type) throws IllegalAccessException {
        Object result;
        try {
            result = objectMapper.readValue(parameterString, type);
        } catch (Exception e) {
            e.printStackTrace();
            result = null;
        }

        if (multiRequestBody.required()) {
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

    private Object getValue(String parameterString, Object value, Class<?> type) throws JsonProcessingException {
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

    private Map<String, Object> getRequestBodyFromUrlEncoded(HttpServletRequest httpServletRequest) throws IOException {
        Map<String, List<String>> pendingMap = new HashMap<>(7);
        Map<String, Object> map = new HashMap<>(7);
        Object pendingUrlencoded = httpServletRequest.getAttribute(JSON_REQUEST_BODY);
        if (pendingUrlencoded == null) {
            pendingUrlencoded = IOUtils.toString(httpServletRequest.getReader());
            httpServletRequest.setAttribute(JSON_REQUEST_BODY, pendingUrlencoded);
        }
        String urlencoded = pendingUrlencoded.toString();
        String[] split = urlencoded.trim().split("&");
        for (String segment : split) {
            List<String> list = new ArrayList<>();
            String[] keyValuePair = segment.split("=");
            String key = keyValuePair[0];
            String value = URLDecoder.decode(keyValuePair[1], StandardCharsets.UTF_8.name());
            if (pendingMap.containsKey(key) && pendingMap.get(key) != null) {
                list = pendingMap.get(key);
            }
            list.add(value);
            pendingMap.put(key, list);
        }
        for (String key : pendingMap.keySet()) {
            List<String> list = pendingMap.get(key);
            if (list.size() > 1) {
                map.put(key, list);
            } else {
                map.put(key, list.get(0));
            }
        }
        return map;
    }

    private Map<String, Object> getRequestBodyFromJson(HttpServletRequest httpServletRequest) throws IOException {
        Map<String, Object> map = new HashMap<>(7);
        Object pendingBody = httpServletRequest.getAttribute(JSON_REQUEST_BODY);
        if (pendingBody == null) {
            pendingBody = IOUtils.toString(httpServletRequest.getReader());
            httpServletRequest.setAttribute(JSON_REQUEST_BODY, pendingBody);
        }
        Map<?, ?> pendingMap = objectMapper.readValue(pendingBody.toString(), Map.class);
        for (Object key : pendingMap.keySet()) {
            map.put(key.toString(), pendingMap.get(key));
        }
        return map;
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
