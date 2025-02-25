package en93.sample.northwindmodulith.webapp.orders;

import en93.sample.northwindmodulith.generated.webapp.api.OrdersApi;
import en93.sample.northwindmodulith.generated.webapp.model.OrderDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController implements OrdersApi {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public ResponseEntity<List<OrderDTO>> getOrders(String orderKey, String customerKey) {
        return ResponseEntity.ok(orderService.getOrders(orderKey, customerKey));
    }
}
