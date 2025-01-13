package en93.sample.northwind_modulith.webapp.orders;

import en93.sample.northwind_modulith.generated.webapp.model.OrderDTO;
import en93.sample.northwind_modulith.generated.webapp.model.OrderDetailDTO;
import en93.sample.northwind_modulith.webapp.generated.jooq.tables.pojos.OrdersEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {
    private final OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public List<OrderDTO> getOrders(String orderKey, String customerKey) {
        List<OrdersEntity> orders = ordersRepository.getOrders(orderKey, customerKey);
        return null;
    }
}
