package io.unnode.beans.annotationconfig.autodi.annotation;

import java.lang.annotation.*;

// 属性注入相关注解
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Value {

    /**
     * The actual value expression: e.g. "#{systemProperties.myProp}".
     */
    String value();

}

