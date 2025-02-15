package hello.proxy.jdkdynamic.code;

import lombok.extern.slf4j.Slf4j;

/**
 * packageName    : com.kovo.domain.ticketlink
 * fileName       : AImpl
 * author         : 이광호
 * date           : 2025-02-15
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-02-15        이광호       최초 생성
 */

@Slf4j
public class AImpl implements AInterface{

    @Override
    public String call() {
        log.info("A 호출");
        return "a";
    }

    public void callB() {

    }
}
