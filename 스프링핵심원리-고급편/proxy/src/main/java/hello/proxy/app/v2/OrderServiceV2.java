package hello.proxy.app.v2;

import hello.proxy.app.v1.OrderRepositoryV1;

/**
 * packageName    : com.kovo.domain.ticketlink
 * fileName       : OrderServiceV2
 * author         : 이광호
 * date           : 2024-08-16
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-08-16        이광호       최초 생성
 */
public class OrderServiceV2 {
    private final OrderRepositoryV2 orderRepository;

    public OrderServiceV2(OrderRepositoryV2 orderRepository) {
        this.orderRepository = orderRepository;
    }


    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }
}
