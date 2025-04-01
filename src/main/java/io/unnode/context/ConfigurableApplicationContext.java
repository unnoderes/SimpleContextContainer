package io.unnode.context;

import io.unnode.utils.BeansException;

public interface ConfigurableApplicationContext extends ApplicationContext{

    // 刷新容器方法
    void refresh() throws BeansException;

    void registerShutdownHook();

    void close();

}
