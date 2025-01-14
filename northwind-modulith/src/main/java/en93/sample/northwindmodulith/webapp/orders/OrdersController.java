package en93.sample.northwindmodulith.webapp.orders;

import en93.sample.northwindmodulith.generated.webapp.api.OrdersApi;
import en93.sample.northwindmodulith.generated.webapp.model.OrderDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrdersController implements OrdersApi {

    private final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @Override
    public ResponseEntity<List<OrderDTO>> getOrders(String orderKey, String customerKey) {
        return ResponseEntity.ok(ordersService.getOrders(orderKey, customerKey));
    }
}
