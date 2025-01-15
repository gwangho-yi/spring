package hello.proxy.config.v1_proxy.interface_proxy;

import hello.proxy.app.v1.OrderRepositoryV1;
import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * packageName    : com.kovo.domain.ticketlink
 * fileName       : OrderRepositoryInterfacePro
 * author         : 이광호
 * date           : 2025-01-15
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-15        이광호       최초 생성
 */
@RequiredArgsConstructor
public class OrderRepositoryInterfaceProxy implements OrderRepositoryV1 {

    private final OrderRepositoryV1 target;
    private final LogTrace logTrace;
    @Override
    public void save(final String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("orderRepository.requast()");

            // target 호출!!
            target.save(itemId);
            logTrace.end(status);
        }
         catch (Exception e) {
            logTrace.exception(status, e );
            throw e;
         }

    }
}
