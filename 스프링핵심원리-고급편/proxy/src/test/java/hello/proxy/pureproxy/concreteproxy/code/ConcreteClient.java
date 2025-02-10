package hello.proxy.pureproxy.concreteproxy.code;

/**
 * packageName    : com.kovo.domain.ticketlink
 * fileName       : ConcreteClient
 * author         : 이광호
 * date           : 2025-01-15
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-15        이광호       최초 생성
 */
public class ConcreteClient {
    private ConcreteLogic concreteLogic;

    public ConcreteClient(final ConcreteLogic concreteLogic) {
        this.concreteLogic = concreteLogic;
    }

    public void execute() {
        concreteLogic.operation();
    }
}
