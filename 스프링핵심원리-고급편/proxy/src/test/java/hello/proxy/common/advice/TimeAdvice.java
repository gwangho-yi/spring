package hello.proxy.common.advice;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@Slf4j
public class TimeAdvice implements MethodInterceptor { // MethodInterceptor -> Interceptor -> Advice 상속
    @Override
    public Object invoke(final MethodInvocation invocation) throws Throwable { // MethodInvocation: 클래스의 실행 정보를 담고 있음
        log.info("TimeProxy 실행");
        final long startTime = System.currentTimeMillis();

        final Object result = invocation.proceed(); // invocation에 기존 target의 정보가 포함.

        final long endTime = System.currentTimeMillis();

        long resultTime = endTime - startTime;

        log.info("TimeProxy 종료 resultTime={}", resultTime);
        return result;
    }
}
