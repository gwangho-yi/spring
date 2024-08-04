package hello.advanced.app.V2;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV1;
import hello.advanced.trace.hellotrace.HelloTraceV2;
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
public class OrderServiceV2 {
    private final OrderRepositoryV2 orderRepository;

    private final HelloTraceV2 trace;


    public void orderItem(TraceId traceId, String itemId) {

        TraceStatus status = null;
        status = trace.beginSync(traceId,"OrderService.orderItem()");
        try {
            orderRepository.save(status.getTraceId(), itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
