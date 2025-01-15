package hello.proxy.pureproxy.decorator;

import hello.proxy.pureproxy.decorator.code.Component;
import hello.proxy.pureproxy.decorator.code.DecoratorPatternClient;
import hello.proxy.pureproxy.decorator.code.MessageDecorator;
import hello.proxy.pureproxy.decorator.code.RealComponent;
import hello.proxy.pureproxy.decorator.code.TimeDecorator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * packageName    : com.kovo.domain.ticketlink
 * fileName       : DecoratorPatternTest
 * author         : 이광호
 * date           : 2025-01-15
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-15        이광호       최초 생성
 */
@Slf4j
public class DecoratorPatternTest {

    @Test
    void noDecorator() {
        final Component realComponent = new RealComponent();
        final DecoratorPatternClient client = new DecoratorPatternClient(realComponent);
        client.execute();
    }

    @Test
    void decorator1() {
        final Component realComponent = new RealComponent();
        final Component messageDecorator = new MessageDecorator(realComponent);
        final DecoratorPatternClient client = new DecoratorPatternClient(messageDecorator);
        client.execute();
    }

    @Test
    void decorator2() {
        final Component realComponent = new RealComponent();
        final Component messageDecorator = new MessageDecorator(realComponent);
        final Component timeDecorator = new TimeDecorator(messageDecorator);

        final DecoratorPatternClient client = new DecoratorPatternClient(timeDecorator);
        client.execute();
    }
}
