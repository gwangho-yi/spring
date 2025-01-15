package hello.proxy.config.v1_proxy.interface_proxy;

import hello.proxy.app.v1.OrderControllerV1;
import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

/**
 * packageName    : com.kovo.domain.ticketlink
 * fileName       : OrderControllerInterfaceProxy
 * author         : 이광호
 * date           : 2025-01-15
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-15        이광호       최초 생성
 */
@RequiredArgsConstructor
public class OrderControllerInterfaceProxy implements OrderControllerV1 {

    private final OrderControllerV1 target;

    private final LogTrace logTrace;
    @Override
    public String request(final String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderController.request()");

            // target 호출
            String result =  target.request(itemId);
            logTrace.end(status);

            return result;
        }
         catch (Exception e) {
            logTrace.exception(status, e );
            throw e;
         }
    }

    @Override
    public String noLog() {
        return target.noLog();
    }
}
