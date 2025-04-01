package io.unnode.beans;

import io.unnode.core.ResourceLoader;
import io.unnode.core.support.DefaultResourceLoader;

public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{

    final BeanDefinitionRegistry registry;

    ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
