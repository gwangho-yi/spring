package hello.advanced.trace.callback;

/**
 * packageName    : com.kovo.domain.ticketlink
 * fileName       : TraceCallback
 * author         : 이광호
 * date           : 2024-08-15
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-08-15        이광호       최초 생성
 */
public interface TraceCallback<T> {
    T call();
}
