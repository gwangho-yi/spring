package hello.proxy.jdkdynamic.code;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import lombok.extern.slf4j.Slf4j;

/**
 * packageName    : com.kovo.domain.ticketlink
 * fileName       : TimeInvocationHandler
 * author         : 이광호
 * date           : 2025-02-15
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-02-15        이광호       최초 생성
 */
@Slf4j
public class TimeInvocationHandler implements InvocationHandler {

    private final Object target;

    public TimeInvocationHandler(Object target) {this.target = target;}

    @Override
    public Object invoke(
        final Object proxy,
        final Method method,
        final Object[] args
    ) throws Throwable {
        log.info("TimeProxy 실행");
        final long startTime = System.currentTimeMillis();

        final Object result = method.invoke(target, args); // target의 메서드를 실행한다.

        final long endTime = System.currentTimeMillis();

        long resultTime = endTime - startTime;

        log.info("TimeProxy 종료 resultTime={}", resultTime);
        return result;
    }
}
