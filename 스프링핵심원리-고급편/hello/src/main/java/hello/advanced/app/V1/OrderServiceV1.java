package hello.advanced.app.V1;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * packageName    : com.kovo.domain.ticketlink
 * fileName       : OrderService
 * author         : 이광호
 * date           : 2024-07-29
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-29        이광호       최초 생성
 */
@Service
@RequiredArgsConstructor
public class OrderServiceV1 {
    private final OrderRepositoryV1 orderRepository;

    private final HelloTraceV1 trace;


    public void orderItem(String itemId) {

        TraceStatus status = null;
        status = trace.begin("OrderService.orderItem()");
        try {
            orderRepository.save(itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
