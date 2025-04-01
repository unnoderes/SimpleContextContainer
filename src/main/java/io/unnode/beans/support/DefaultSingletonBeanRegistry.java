package io.unnode.beans.support;

import io.unnode.beans.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    Map<String, Object> singletonPool = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonPool.get(beanName);
    }

    public void addSingleton(String beanName, Object singletonBean){
        singletonPool.put(beanName, singletonBean);
    }
}