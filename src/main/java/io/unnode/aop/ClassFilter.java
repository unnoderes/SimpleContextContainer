package io.unnode.aop;

/**
 *
 * 定义类匹配对象，用于切点找到给定的接口和目标类。
 *
 * */
public interface ClassFilter {

    /**
     * Should the pointcut apply to the given interface or target class?
     * @param clazz the candidate target class
     * @return whether the advice should apply to the given target class
     */
    boolean matches(Class<?> clazz);

}
