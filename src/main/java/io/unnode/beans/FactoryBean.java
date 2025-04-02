package io.unnode.beans;

public interface FactoryBean<T> {

    // 获取对象
    T getObject() throws Exception;

    // 获取对象类型
    Class<?> getObjectType();

    // 判断是否是单例对象
    boolean isSingleton();
}
