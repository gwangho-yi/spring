package hello.proxy.jdkdynamic;

import hello.proxy.jdkdynamic.code.AImpl;
import hello.proxy.jdkdynamic.code.AInterface;
import hello.proxy.jdkdynamic.code.BImpl;
import hello.proxy.jdkdynamic.code.BInterface;
import hello.proxy.jdkdynamic.code.TimeInvocationHandler;
import java.lang.reflect.Proxy;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class JdkDynamicProxyTest {

    @Test
    void dynamicA() {
        final AImpl target = new AImpl();

        final TimeInvocationHandler handler = new TimeInvocationHandler(target);

        // 프록시 클래스 자동 생성
        AInterface proxy = (AInterface) Proxy.newProxyInstance(
            AInterface.class.getClassLoader(),
            new Class[]{AInterface.class},
            handler);

        proxy.call();

        proxy.callB();

        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());
    }

    @Test
    void dynamicB() {
        final BImpl target = new BImpl();

        final TimeInvocationHandler handler = new TimeInvocationHandler(target);

        // 프록시 클래스 자동 생성
        BInterface proxy = (BInterface) Proxy.newProxyInstance(
            BInterface.class.getClassLoader(),
            new Class[]{BInterface.class},
            handler);

        proxy.call();


        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());
    }
}
