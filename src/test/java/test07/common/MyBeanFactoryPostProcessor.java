package test07.common;

import io.unnode.beans.BeanFactoryPostProcessor;
import io.unnode.beans.ConfigurableListableBeanFactory;
import io.unnode.beans.support.BeanDefinition;
import io.unnode.beans.support.PropertyValue;
import io.unnode.beans.support.PropertyValues;
import io.unnode.utils.BeansException;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "change to nodeX"));
    }

}