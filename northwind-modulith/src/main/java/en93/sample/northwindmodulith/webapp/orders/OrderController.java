package en93.sample.northwindmodulith.webapp.orders;

import en93.sample.northwindmodulith.generated.webapp.api.OrdersApi;
import en93.sample.northwindmodulith.generated.webapp.model.GetOrders200ResponseDTO;
import en93.sample.northwindmodulith.webapp.utils.PaginationUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController implements OrdersApi {

    private final OrderService orderService;
    private final PaginationUtil paginationUtil;

    public OrderController(OrderService orderService, PaginationUtil paginationUtil) {
        this.orderService = orderService;
        this.paginationUtil = paginationUtil;
    }

    @Override
    public ResponseEntity<GetOrders200ResponseDTO> getOrders(String orderKey, String customerKey, Integer limit, Integer offset, String sortDirection) {
        var orders = orderService.getOrders(orderKey, customerKey, limit, offset, sortDirection);

        var response = new GetOrders200ResponseDTO();
        response.setData(orders);

        var pagination = paginationUtil.buildPaginationResponse(limit, offset);
        response.setPagination(pagination);

        return ResponseEntity.ok(response);
    }


}
