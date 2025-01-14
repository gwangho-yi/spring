package hello.proxy.pureproxy.proxy.code;

/**
 * packageName    : com.kovo.domain.ticketlink
 * fileName       : ProxyPatternClient
 * author         : 이광호
 * date           : 2025-01-15
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-15        이광호       최초 생성
 */
public class ProxyPatternClient {

    private Subject subject;

    public ProxyPatternClient(final Subject subject) {
        this.subject = subject;
    }

    public void execute() {
        subject.operation();
    }
}
