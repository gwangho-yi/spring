package hello.advanced.trace.teamplate.code;

import lombok.extern.slf4j.Slf4j;

/**
 * packageName    : com.kovo.domain.ticketlink
 * fileName       : AbstractTemplate
 * author         : 이광호
 * date           : 2024-08-04
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-08-04        이광호       최초 생성
 */

@Slf4j
public abstract class AbstractTemplate {

    public void execute() {
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
//        log.info("비즈니스 로직1 실행");
        call(); // 상속
        // 비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("완료시간 = {}", resultTime);
    }

    protected abstract void call();
}
