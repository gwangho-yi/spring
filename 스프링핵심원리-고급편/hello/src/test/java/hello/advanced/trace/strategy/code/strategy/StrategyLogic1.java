package hello.advanced.trace.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * packageName    : com.kovo.domain.ticketlink
 * fileName       : StrategyLogic1
 * author         : 이광호
 * date           : 2024-08-15
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-08-15        이광호       최초 생성
 */

@Slf4j
public class StrategyLogic1 implements Strategy {
    @Override
    public void call() {
      log.info("비즈니스 로직1 실행");
    }
}
