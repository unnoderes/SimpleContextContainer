package io.unnode.utils;

public class ClassUtils {

    public static ClassLoader getDefaultClassLoader(){
        ClassLoader classLoader = null;
        try {
            // 1. 获取当前线程的上下文类加载器
            classLoader = Thread.currentThread().getContextClassLoader();
        } catch (Throwable e) {
            // 捕获异常（通常是 `SecurityException`），不做处理
        }
        // 2. 如果获取失败，使用 `ClassUtils` 自身的类加载器
        if (classLoader == null) {
            classLoader = ClassUtils.class.getClassLoader();
        }
        // 3. 返回最终获取到的类加载器
        return classLoader;
    }
}
