package hello.advanced.trace;

import lombok.Getter;

/**
 * packageName    : com.kovo.domain.ticketlink
 * fileName       : TraceStatus
 * author         : 이광호
 * date           : 2024-07-29
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-29        이광호       최초 생성
 */
@Getter
public class TraceStatus {
    private TraceId traceId;
    private Long startTimeMs;
    private String Message;

    public TraceStatus(TraceId traceId, Long startTimeMs, String message) {
        this.traceId = traceId;
        this.startTimeMs = startTimeMs;
        Message = message;
    }
}
