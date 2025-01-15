package hello.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

/**
 * packageName    : com.kovo.domain.ticketlink
 * fileName       : MessageDecorator
 * author         : 이광호
 * date           : 2025-01-15
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-15        이광호       최초 생성
 */
@Slf4j
public class MessageDecorator implements Component {

    private Component component;

    public MessageDecorator(final Component component) {
        this.component = component;
    }

    @Override
    public String operation() {
        log.info("MessageDecorator 실행");

        final String result = component.operation();
        String decoResult = "*****" + result + "******";
        log.info("MessageDecorator 꾸미기 적용 전={}, 적용후={}", result, decoResult);


        return decoResult;
    }
}
