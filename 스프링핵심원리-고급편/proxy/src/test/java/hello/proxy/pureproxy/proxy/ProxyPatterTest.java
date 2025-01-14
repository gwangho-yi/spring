package hello.proxy.pureproxy.proxy;

import hello.proxy.pureproxy.proxy.code.CacheProxy;
import hello.proxy.pureproxy.proxy.code.ProxyPatternClient;
import hello.proxy.pureproxy.proxy.code.RealSubject;
import org.junit.jupiter.api.Test;

/**
 * packageName    : com.kovo.domain.ticketlink
 * fileName       : ProxyPatterTest
 * author         : 이광호
 * date           : 2025-01-15
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-15        이광호       최초 생성
 */
public class ProxyPatterTest {


    @Test
    void noProxyTest() {
        final RealSubject realSubject = new RealSubject();
        final ProxyPatternClient client = new ProxyPatternClient(realSubject);

        client.execute();
        client.execute();
        client.execute();
    }

    @Test
    void cacheProxyTest() {
        final RealSubject realSubject = new RealSubject();
        final CacheProxy cacheProxy = new CacheProxy(realSubject);
        final ProxyPatternClient client = new ProxyPatternClient(cacheProxy);

        client.execute();
        client.execute();
        client.execute();

    }
}
