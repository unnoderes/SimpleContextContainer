package io.unnode.context;

import io.unnode.beans.BeanFactoryPostProcessor;
import io.unnode.beans.BeanPostProcessor;
import io.unnode.beans.ConfigurableListableBeanFactory;
import io.unnode.core.support.DefaultResourceLoader;
import io.unnode.utils.BeansException;

import java.util.Map;

/**
 *
 * AbstractApplicationContext 继承 DefaultResourceLoader 以处理 spring.xml 配置资源加载
 *
 * 在 refresh() 内定义实现过程
 * 1. 创建 BeanFactory，并加载 BeanDefinition
 * 2. 获取 BeanFactory
 * 3. 在 Bean 实例化之前，执行 BeanFactoryPostProcessor (Invoke factory processors registered as beans in the context.)
 * 4. BeanPostProcessor 需要提前于其他 Bean 对象实例化之前执行注册操作
 * 5. 提前实例化单例Bean对象
 *
 * 定义抽象方法：refreshBeanFactory() && getBeanFactory()
 */

public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    @Override
    public void refresh() throws BeansException {
        // 创建beanFactory，加载beanDefinition
        refreshBeanFactory();
        // 获取beanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        // 在bean实例化前执行前执行自定义操作方法 BeanFactoryPostProcessor
        invokeBeanFactoryPostProcessors(beanFactory);
        // BeanPostProcessor 需要提前于其他 Bean 对象实例化之前执行注册操作
        registerBeanPostProcessors(beanFactory);
        // 提前实例化单例Bean对象
        beanFactory.preInstantiateSingletons();

    }

    protected abstract void refreshBeanFactory() throws BeansException;

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    // 引用
    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory){
        Map<String, BeanFactoryPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor value : beanPostProcessorMap.values()) {
            value.postProcessBeanFactory(beanFactory);
        }
    }

    // 注册
    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory){
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor value : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(value);
        }
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return getBeanFactory().getBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name, requiredType);
    }
}
