package io.unnode.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 *
 * MethodInterceptor 实现类
 *
 * MethodBeforeAdviceInterceptor 实现了 MethodInterceptor 接口;
 * 在 invoke 方法中调用 advice 中的 before 方法，传入对应的参数信息;
 * advice.before 用于自己实现 MethodBeforeAdvice 接口后做的相应处理.
 */
public class MethodBeforeAdviceInterceptor implements MethodInterceptor {

    private MethodBeforeAdvice advice;

    public MethodBeforeAdviceInterceptor() {
    }

    public MethodBeforeAdviceInterceptor(MethodBeforeAdvice advice) {
        this.advice = advice;
    }

    public MethodBeforeAdvice getAdvice() {
        return advice;
    }

    public void setAdvice(MethodBeforeAdvice advice) {
        this.advice = advice;
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        this.advice.before(methodInvocation.getMethod(), methodInvocation.getArguments(), methodInvocation.getThis());
        return methodInvocation.proceed();
    }

}