package hello.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

/**
 * packageName    : com.kovo.domain.ticketlink
 * fileName       : DecoratorPatternClient
 * author         : 이광호
 * date           : 2025-01-15
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-15        이광호       최초 생성
 */
@Slf4j
public class DecoratorPatternClient {

    private final Component component;

    public DecoratorPatternClient(final Component component) {
        this.component = component;
    }

    public void execute() {
        log.info("result={}", component.operation());
    }
}
