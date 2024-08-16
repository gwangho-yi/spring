package hello.proxy.app.v1;

/**
 * packageName    : com.kovo.domain.ticketlink
 * fileName       : OrderServiceV1Impl
 * author         : 이광호
 * date           : 2024-08-16
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-08-16        이광호       최초 생성
 */
public class OrderServiceV1Impl implements OrderServiceV1{

    private final OrderRepositoryV1 orderRepository;

    public OrderServiceV1Impl(OrderRepositoryV1 orderRepositoryV1) {
        this.orderRepository = orderRepositoryV1;
    }


    @Override
    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }
}
