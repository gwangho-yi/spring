package hello.proxy.app.v3;

import org.springframework.stereotype.Service;

/**
 * packageName    : com.kovo.domain.ticketlink
 * fileName       : OrderServiceV3
 * author         : 이광호
 * date           : 2025-01-14
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-14        이광호       최초 생성
 */
@Service
public class OrderServiceV3 {

    private final OrderRepositoryV3 orderRepository;

    public OrderServiceV3(final OrderRepositoryV3 orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }

}
