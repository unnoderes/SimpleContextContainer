package io.unnode.beans.annotationconfig.autodi;

/**
 * 解析字符串操作接口
 * 把读取到属性填充到容器
 */
public interface StringValueResolver {

    String resolveStringValue(String strVal);

}
