package hello.advanced.app.V1;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName    : com.kovo.domain.ticketlink
 * fileName       : OrderControllerV0
 * author         : 이광호
 * date           : 2024-07-29
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-29        이광호       최초 생성
 */
@RestController
@RequiredArgsConstructor
public class OrderControllerV1 {

    private final OrderServiceV1 orderService;

    private final HelloTraceV1 trace;

    @GetMapping("/v1/request")
    public String request(String itemId) {
        TraceStatus status = null;
        status = trace.begin("OrderController.request()");
        try {
            orderService.orderItem(itemId);
            trace.end(status);
            return "ok";
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }

    }
}
