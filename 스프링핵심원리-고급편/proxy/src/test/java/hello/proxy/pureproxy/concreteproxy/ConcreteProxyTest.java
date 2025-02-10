package hello.proxy.pureproxy.concreteproxy;

import hello.proxy.pureproxy.concreteproxy.code.ConcreteClient;
import hello.proxy.pureproxy.concreteproxy.code.ConcreteLogic;
import hello.proxy.pureproxy.concreteproxy.code.TimeProxy;
import org.junit.jupiter.api.Test;

/**
 * packageName    : com.kovo.domain.ticketlink
 * fileName       : ConcreteProxyTest
 * author         : 이광호
 * date           : 2025-01-15
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-15        이광호       최초 생성
 */
public class ConcreteProxyTest {

    @Test
    void noProxy() {

        final ConcreteLogic concreteLogic = new ConcreteLogic();
        final ConcreteClient client = new ConcreteClient(concreteLogic);

        client.execute();
    }

    @Test
    void addProxy() {
        final ConcreteLogic concreteLogic = new ConcreteLogic();
        final TimeProxy timeProxy = new TimeProxy(concreteLogic);
        final ConcreteClient client = new ConcreteClient(timeProxy);
        client.execute();
    }


}
