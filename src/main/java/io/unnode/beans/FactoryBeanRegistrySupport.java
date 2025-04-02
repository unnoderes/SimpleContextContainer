package io.unnode.beans;

import io.unnode.beans.support.DefaultSingletonBeanRegistry;
import io.unnode.utils.BeansException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class FactoryBeanRegistrySupport extends DefaultSingletonBeanRegistry {

    /**
     * Cache of singleton objects created by FactoryBeans: FactoryBean name --> object
     */
    private final Map<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<String, Object>();

    /**
     * FactoryBeanRegistrySupport 类用于处理关于 FactoryBean 此类对象的注册操作;
     * 定义缓存操作 factoryBeanObjectCache，用于存放单例类型的对象，避免重复创建;
     * doGetObjectFromFactoryBean 是具体的获取 FactoryBean#getObject() 方法;
     * 因为既有缓存的处理也有对象的获取，所以额外提供了 getObjectFromFactoryBean 进行逻辑包装;
     * 类似于从Redis取数据，如果为空就从数据库获取并写入Redis.
     *
     * getCachedObjectForFactoryBean 获取内存内对象
     */
    protected Object getCachedObjectForFactoryBean(String beanName) {
        Object object = this.factoryBeanObjectCache.get(beanName);
        return (object != NULL_OBJECT ? object : null);
    }

    protected Object getObjectFromFactoryBean(FactoryBean factory, String beanName) {
        if (factory.isSingleton()) {
            Object object = this.factoryBeanObjectCache.get(beanName);
            if (object == null) {
                object = doGetObjectFromFactoryBean(factory, beanName);
                this.factoryBeanObjectCache.put(beanName, (object != null ? object : NULL_OBJECT));
            }
            return (object != NULL_OBJECT ? object : null);
        } else {
            return doGetObjectFromFactoryBean(factory, beanName);
        }
    }

    private Object doGetObjectFromFactoryBean(final FactoryBean factory, final String beanName){
        try {
            return factory.getObject();
        } catch (Exception e) {
            throw new BeansException("对象工厂创建此对象失败" + beanName,e);
        }
    }
}
