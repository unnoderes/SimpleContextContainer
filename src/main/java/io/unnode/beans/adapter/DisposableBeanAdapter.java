package io.unnode.beans.adapter;

import cn.hutool.core.util.StrUtil;
import io.unnode.beans.DisposableBean;
import io.unnode.beans.support.BeanDefinition;
import io.unnode.utils.BeansException;

import java.lang.reflect.Method;

public class DisposableBeanAdapter implements DisposableBean {

    final Object bean;
    final String beanName;
    String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        // 1. 实现接口 DisposableBean
        if (bean instanceof DisposableBean) {
            ((DisposableBean)bean).destroy();
        }

        // 2. 配置信息 destroy-method (判断是为了避免二次执行销毁)
        if ((StrUtil.isNotEmpty(destroyMethodName) && !(bean instanceof DisposableBean && "destroy".equals(this.destroyMethodName)))) {
            Method destroyMethod = bean.getClass().getMethod(destroyMethodName);
            if (null == destroyMethod) {
                throw new BeansException("找不到目标销毁方法" + destroyMethodName);
            }
            destroyMethod.invoke(bean);
        }

    }
}
