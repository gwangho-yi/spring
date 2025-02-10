package hello.proxy.config.v1_proxy.concrete_proxy;

import hello.proxy.app.v2.OrderRepositoryV2;
import hello.proxy.app.v3.OrderRepositoryV3;
import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

/**
 * packageName    : com.kovo.domain.ticketlink
 * fileName       : OrderRepositoryConcreteProxy
 * author         : 이광호
 * date           : 2025-02-10
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-02-10        이광호       최초 생성
 */
@RequiredArgsConstructor
public class OrderRepositoryConcreteProxy extends OrderRepositoryV2 {

    private final OrderRepositoryV2 target;
    private final LogTrace trace;


    @Override
    public void save(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("orderRepository.requast()");

            // target 호출
            target.save(itemId);
            trace.end(status);
        }
         catch (Exception e) {
            trace.exception(status, e );
            throw e;
         }
    }
}
