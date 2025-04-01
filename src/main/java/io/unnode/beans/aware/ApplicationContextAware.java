package io.unnode.beans.aware;

import io.unnode.context.ApplicationContext;
import io.unnode.utils.BeansException;

/**
 *
 *
 * Interface to be implemented by any object that wishes to be notifiedof the {@link ApplicationContext} that it runs in.
 *
 * setApplicationContext 接口用于感知所属的 ApplicationContext
 */
public interface ApplicationContextAware extends Aware {


    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;


}
