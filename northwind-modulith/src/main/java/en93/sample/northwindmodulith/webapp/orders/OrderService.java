package en93.sample.northwindmodulith.webapp.orders;

import en93.sample.northwindmodulith.generated.webapp.model.OrderDTO;
import en93.sample.northwindmodulith.mappers.OrderMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderDTO> getOrders(String orderKey, String customerKey) {
        var key = orderKey != null ? Integer.valueOf(orderKey) : null;
        var orderEntities = orderRepository.searchOrders(key);
        return orderEntities.stream()
                .map(OrderMapper.INSTANCE::toDto)
                .toList();
    }
}
