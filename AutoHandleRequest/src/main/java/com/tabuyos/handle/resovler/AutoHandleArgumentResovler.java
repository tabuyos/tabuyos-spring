package com.tabuyos.handle.resovler;

import com.tabuyos.handle.annotation.AutoHandle;
import org.springframework.core.MethodParameter;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @Author Tabuyos
 * @Time 2020/5/12 9:01
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class AutoHandleArgumentResovler implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(AutoHandle.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, @Nullable ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, @Nullable WebDataBinderFactory binderFactory) throws Exception {
        return null;
    }
}
