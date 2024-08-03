package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceStatus;

/**
 * packageName    : com.kovo.domain.ticketlink
 * fileName       : LogTrace
 * author         : 이광호
 * date           : 2024-08-03
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-08-03        이광호       최초 생성
 */
public interface LogTrace {
    TraceStatus begin(String message);

    void end(TraceStatus status);

    void exception(TraceStatus status, Exception e);
}
