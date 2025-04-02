package io.unnode.beans.autoscan.annotation;

import java.lang.annotation.*;

/**
 * 定义拦截注解;
 * 用于配置作用域的自定义注解，方便通过配置Bean对象注解的时拿到Bean对象的作用域;
 * 缺省值 singleton.
 *
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scope {

    String value() default "singleton";

}

