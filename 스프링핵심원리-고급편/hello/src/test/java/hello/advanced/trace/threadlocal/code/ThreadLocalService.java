package hello.advanced.trace.threadlocal.code;

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
public class ThreadLocalService {
    private ThreadLocal<String> nameStore = new ThreadLocal<>();


    public String logic(String name) {
        log.info("저장 name = {} -> nameStore={}", name, nameStore.get());

        nameStore.set(name);
        sleep(1000);
        log.info("조회 nameStore = {}", nameStore.get());
        return nameStore.get();
    }

    private void sleep(int millis) {
        try{
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
