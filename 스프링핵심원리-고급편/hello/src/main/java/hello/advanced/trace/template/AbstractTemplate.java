package hello.advanced.trace.template;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;

/**
 * packageName    : com.kovo.domain.ticketlink
 * fileName       : AbstractTemplate
 * author         : 이광호
 * date           : 2024-08-04
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-08-04        이광호       최초 생성
 */
public abstract class AbstractTemplate<T> {

    private final LogTrace trace;

    public AbstractTemplate(LogTrace trace) {
        this.trace = trace;
    }


    public T execute(String message) {
        TraceStatus status = null;

        try {
            status = trace.begin(message);

            // 로직 호출
            T result = call();

            trace.end(status);

            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

    protected abstract T call();
}
