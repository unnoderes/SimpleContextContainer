package io.unnode.context;

import io.unnode.beans.HierarchicalBeanFactory;
import io.unnode.beans.ListableBeanFactory;
import io.unnode.context.event.ApplicationEventPublisher;
import io.unnode.core.ResourceLoader;

/**
 *
 *
 * 应用程序上下文
 *
 * Central 接口
 *
 *
 *
 * */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {
}
