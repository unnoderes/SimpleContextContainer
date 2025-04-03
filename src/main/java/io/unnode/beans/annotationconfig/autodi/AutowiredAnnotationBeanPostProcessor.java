package io.unnode.beans.annotationconfig.autodi;


import cn.hutool.core.bean.BeanUtil;
import io.unnode.aop.InstantiationAwareBeanPostProcessor;
import io.unnode.beans.BeanFactory;
import io.unnode.beans.BeanPostProcessor;
import io.unnode.beans.ConfigurableListableBeanFactory;
import io.unnode.beans.annotationconfig.autodi.annotation.Autowired;
import io.unnode.beans.annotationconfig.autodi.annotation.Qualifier;
import io.unnode.beans.annotationconfig.autodi.annotation.Value;
import io.unnode.beans.aware.BeanFactoryAware;
import io.unnode.beans.support.PropertyValues;
import io.unnode.utils.BeansException;
import io.unnode.utils.ClassUtils;

import java.lang.reflect.Field;

/**
 * {@link BeanPostProcessor} implementation
 * that autowires annotated fields, setter methods and arbitrary config methods.
 * Such members to be injected are detected through a Java 5 annotation: by default,
 * Spring's {@link Autowired @Autowired} and {@link Value @Value} annotations.
 * <p>
 * 处理 @Value、@Autowired，注解的 BeanPostProcessor
 * <p>
 *
 * 扫描自定义注解
 *
 * AutowiredAnnotationBeanPostProcessor 是实现接口 InstantiationAwareBeanPostProcessor 的一个用于在 Bean 对象实例化完成后，设置属性操作前的处理属性信息的类和操作方法。只有实现了 BeanPostProcessor 接口才有机会在 Bean 的生命周期中处理初始化信息
 * 核心方法 postProcessPropertyValues，主要用于处理类含有 @Value、@Autowired 注解的属性，进行属性信息的提取和设置。
 * 这里需要注意一点因为我们在 AbstractAutowireCapableBeanFactory 类中使用的是 CglibSubclassingInstantiationStrategy 进行类的创建，所以在 AutowiredAnnotationBeanPostProcessor#postProcessPropertyValues 中需要判断是否为 CGlib 创建对象，否则是不能正确拿到类信息的。ClassUtils.isCglibProxyClass(clazz) ? clazz.getSuperclass() : clazz;
 */
public class AutowiredAnnotationBeanPostProcessor implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

    private ConfigurableListableBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        // 1. 处理注解 @Value
        Class<?> clazz = bean.getClass();
        clazz = ClassUtils.isCglibProxyClass(clazz) ? clazz.getSuperclass() : clazz;

        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field field : declaredFields) {
            Value valueAnnotation = field.getAnnotation(Value.class);
            if (null != valueAnnotation) {
                String value = valueAnnotation.value();
                value = beanFactory.resolveEmbeddedValue(value);
                BeanUtil.setFieldValue(bean, field.getName(), value);
            }
        }

        // 2. 处理注解 @Autowired
        for (Field field : declaredFields) {
            Autowired autowiredAnnotation = field.getAnnotation(Autowired.class);
            if (null != autowiredAnnotation) {
                Class<?> fieldType = field.getType();
                String dependentBeanName = null;
                Qualifier qualifierAnnotation = field.getAnnotation(Qualifier.class);
                Object dependentBean = null;
                if (null != qualifierAnnotation) {
                    dependentBeanName = qualifierAnnotation.value();
                    dependentBean = beanFactory.getBean(dependentBeanName, fieldType);
                } else {
                    dependentBean = beanFactory.getBean(fieldType);
                }
                BeanUtil.setFieldValue(bean, field.getName(), dependentBean);
            }
        }

        return pvs;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return true;
    }

}