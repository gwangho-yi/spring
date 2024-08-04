package hello.advanced.trace.ThredLocal.code;

import lombok.extern.slf4j.Slf4j;



/**
 * packageName    : com.kovo.domain.ticketlink
 * fileName       : FieldService
 * author         : 이광호
 * date           : 2024-08-03
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-08-03        이광호       최초 생성
 */
@Slf4j
public class FieldService {
    private String nameStore;


    public String logic(String name) {
        log.info("저장 name = {} -> nameStore={}", name, nameStore);
        nameStore = name;
        sleep(1000);
        log.info("조회 nameStore = {}", nameStore);
        return nameStore;
    }

    private void sleep(int millis) {
        try{
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
