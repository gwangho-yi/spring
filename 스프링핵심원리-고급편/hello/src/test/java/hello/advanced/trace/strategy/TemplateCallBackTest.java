package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.template.Callback;
import hello.advanced.trace.strategy.code.template.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * packageName    : com.kovo.domain.ticketlink
 * fileName       : TemplateCallBackTest
 * author         : 이광호
 * date           : 2024-08-15
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-08-15        이광호       최초 생성
 */
@Slf4j
public class TemplateCallBackTest {


    /**
     * 템플릿 콜백 패턴 - 익명 내부 클래스
     * */
    @Test
    void callbackV1() {
        TimeLogTemplate timeLogTemplate = new TimeLogTemplate();
        timeLogTemplate.execute(new Callback() {
                @Override
                public void call() {
                    log.info("비즈니스 로직1 실행");
            }
        });
    }


    @Test
    void callbackV2() {
        TimeLogTemplate timeLogTemplate = new TimeLogTemplate();
        timeLogTemplate.execute(()-> log.info("비즈니스 로직1 실행"));
    }
}
