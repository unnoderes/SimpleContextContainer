package io.unnode.beans.autoscan.annotation;

import java.lang.annotation.*;

/**
 * 容器组件注解;
 * 用于将对象识别为容器组件.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {

    String value() default "";

}
