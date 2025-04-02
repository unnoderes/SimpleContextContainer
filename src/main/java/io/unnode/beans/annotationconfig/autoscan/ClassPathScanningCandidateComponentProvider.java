package io.unnode.beans.annotationconfig.autoscan;

import cn.hutool.core.util.ClassUtil;
import io.unnode.beans.annotationconfig.autoscan.annotation.Component;
import io.unnode.beans.support.BeanDefinition;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * 方法 findCandidateComponents 用于基于配置路径basePackage=“xxx”解析出 classes 信息;
 * 以此通过该方法实现扫描到所有被 @Component 所注解的 Bean 对象.
 *
 */
public class ClassPathScanningCandidateComponentProvider {

    public Set<BeanDefinition> findCandidateComponents(String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }

}



