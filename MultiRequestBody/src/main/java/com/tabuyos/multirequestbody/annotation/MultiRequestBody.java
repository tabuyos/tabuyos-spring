package com.tabuyos.multirequestbody.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.ValueConstants;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author Tabuyos
 * @Time 2020/5/12 9:24
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface MultiRequestBody {

    /**
     * Alias for {@link #name}.
     */
    @AliasFor("name")
    String value() default "";

    /**
     * The name of the request parameter to bind to.
     */
    @AliasFor("value")
    String name() default "";

    /**
     * Whether the parameter is required.
     * Defaults to {@code true}, leading to an exception being thrown if the parameter is missing in the request.
     * Switch this to {@code false} if you prefer a {@code null} value if the parameter is not present in the request.
     * Alternatively, provide a {@link #defaultValue}, which implicitly sets this flag to {@code false}.
     */
    boolean required() default true;

    /**
     * Whether resolve outermost attribute.
     */
    boolean parseAllFields() default true;

    /**
     * The default value to use as a fallback when the request parameter is not provided or has an empty value.
     * Supplying a default value implicitly sets {@link #required} to {@code false}.
     */
    String defaultValue() default ValueConstants.DEFAULT_NONE;
}
