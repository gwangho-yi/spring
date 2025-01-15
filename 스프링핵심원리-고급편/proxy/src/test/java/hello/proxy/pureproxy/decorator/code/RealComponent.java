package hello.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

/**
 * packageName    : com.kovo.domain.ticketlink
 * fileName       : RealComponent
 * author         : 이광호
 * date           : 2025-01-15
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-15        이광호       최초 생성
 */

@Slf4j
public class RealComponent implements Component{
    @Override
    public String operation() {
        log.info("RealComponent 실행");
        return "data";
    }
}
