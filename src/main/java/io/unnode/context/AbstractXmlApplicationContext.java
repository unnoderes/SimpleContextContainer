package io.unnode.context;

import io.unnode.beans.support.DefaultListableBeanFactory;
import io.unnode.beans.support.XmlBeanDefinitionReader;

/**
 * 实现上下文中对配置信息的加载
 * 在 AbstractXmlApplicationContext 抽象类的 loadBeanDefinitions 方法实现中，使用 XmlBeanDefinitionReader 类，处理了关于 XML 文件配置信息的操作
 * 抽象类方法 getConfigLocations() 是为了从入口上下文类拿到配置信息的地址描述
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations){
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();

}