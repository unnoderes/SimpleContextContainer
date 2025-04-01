package io.unnode.core;

/**
 *
 * 资源加载器封装
 */
public interface ResourceLoader {

    /**
     *
     * 用于从类路径加载的伪 URL 前缀： “classpath:”
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
