package en93.sample.northwind_modulith.webapp.orders;

import en93.sample.northwind_modulith.generated.webapp.api.OrdersApi;
import en93.sample.northwind_modulith.generated.webapp.model.Order;
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
    public ResponseEntity<List<Order>> getOrders(String orderKey, String customerKey) {
        return null;
    }
}
