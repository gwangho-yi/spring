package hello.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

/**
 * packageName    : com.kovo.domain.ticketlink
 * fileName       : TimeDecorator
 * author         : 이광호
 * date           : 2025-01-15
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-15        이광호       최초 생성
 */

@Slf4j
public class TimeDecorator implements Component {

    private Component component;

    public TimeDecorator(final Component component) {
        this.component = component;
    }

    @Override
    public String operation() {
        log.info("TimeDecorator 실행");
        final long startTime = System.currentTimeMillis();
        final String result = component.operation();
        final long endTime = System.currentTimeMillis();

        long resultTime = endTime-startTime;
        log.info("TimeDecorator 종료 resultTime={}ms", resultTime);
        return result;
    }
}
