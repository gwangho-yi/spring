package hello.advanced.trace.ThredLocal.code;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * packageName    : com.kovo.domain.ticketlink
 * fileName       : FieldServiceTest
 * author         : 이광호
 * date           : 2024-08-03
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-08-03        이광호       최초 생성
 */
@Slf4j
public class FieldServiceTest {

    private FieldService fieldService = new FieldService();


    @Test
    void field() {
        log.info("main start");

        Runnable userA = () -> {
            fieldService.logic("userA");
        };
        Runnable userB = () -> {
            fieldService.logic("userB");
        };

        Thread threadA = new Thread(userA);
        Thread threadB = new Thread(userB);

        threadA.setName("thread-A");
        threadB.setName("thread-B");

        threadA.start();
        sleep(100); //  동시성 문제 발생 O
        threadB.start();

        sleep(3000); // 메인 쓰레드 종료 대기

        log.info("main exit");
    }

    private void sleep(int millis) {
        try{
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
