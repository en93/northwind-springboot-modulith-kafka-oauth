package en93.sample.northwindmodulith.webapp.orders;

import en93.sample.northwindmodulith.generated.webapp.model.OrderDTO;
import en93.sample.northwindmodulith.mappers.OrderMapper;
import en93.sample.northwindmodulith.webapp.utils.PaginationUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final PaginationUtil paginationUtil;

    public OrderService(OrderRepository orderRepository, PaginationUtil paginationUtil) {
        this.orderRepository = orderRepository;
        this.paginationUtil = paginationUtil;
    }

    public List<OrderDTO> getOrders(String orderKey, String customerKey, Integer limit, Integer offset, String sortDirection) {
        var key = orderKey != null ? Integer.valueOf(orderKey) : null;
        var pageable = paginationUtil.buildPageRequest(limit, offset);

        var orderEntities = orderRepository.searchOrders(key, pageable);
        return orderEntities.stream()
                .map(OrderMapper.INSTANCE::toDto)
                .toList();
    }
}
