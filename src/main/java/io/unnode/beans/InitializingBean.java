package io.unnode.beans;

public interface InitializingBean {

    /**
     *
     * Bean 在执行DI（属性填充）后调用
     *
     */
    void afterPropertiesSet() throws Exception;
}
