package hello.proxy.advisor;

import hello.proxy.common.advice.TimeAdvice;
import hello.proxy.common.service.ServiceImpl;
import hello.proxy.common.service.ServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import java.lang.reflect.Method;

@Slf4j
public class AdvisorTest {

    @Test
    void advisorTest1() {

        ServiceInterface target = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(Pointcut.TRUE, new TimeAdvice()); // Pointcut.TRUE은 항상 true를 반환한다.
        proxyFactory.addAdvisor(advisor);

        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();
        proxy.save();
        proxy.find();

    }

    @Test
    void advisorTest2() {

        ServiceInterface target = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(new MyPointcut(), new TimeAdvice());
        proxyFactory.addAdvisor(advisor);

        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();
        proxy.save();
        proxy.find();

    }

    static class MyPointcut implements Pointcut {

        @Override
        public ClassFilter getClassFilter() {
            return ClassFilter.TRUE;
        }

        @Override
        public MethodMatcher getMethodMatcher() {
            return new MyMethodMatcher();
        }
    }

    static class MyMethodMatcher implements MethodMatcher {

        private final String matchName = "save";

        @Override
        public boolean matches(Method method, Class<?> targetClass) {
            log.info("method 이름 = {} , class 이름 = {}", method.getName(), targetClass.getName());
            return method.getName().equals(matchName);
        }

        @Override
        public boolean isRuntime() {
            /**
             * isRuntime 이 true 이면 아래 matches 메서드가 호출된다.
             * 이유 ? 성능 때문이다. 아래 matches는 메서드 인자값까지 체킹을 할 수 있다.
             * 정적 캐싱 O - 인자 값을 체킹하지 않으면 캐싱이 가능하다.
             * 동적 캐싱 X - 인자 값까지 체킹하는건 인자 값이 동적으로 변하기 때문에 캐싱이 불가능하다.
             * 즉 , 캐싱 여부에 따라 성능이 결정된다.
             * */
            return false;
        }

        @Override
        public boolean matches(Method method, Class<?> targetClass, Object... args) {
            throw new UnsupportedOperationException();
        }
    }
}
