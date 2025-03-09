package en93.sample.northwindmodulith.webapp.controllers;

import en93.sample.northwindmodulith.generated.webapp.api.OrdersApi;
import en93.sample.northwindmodulith.generated.webapp.model.GetOrders200ResponseDTO;
import en93.sample.northwindmodulith.generated.webapp.model.OrderSortEnumDTO;
import en93.sample.northwindmodulith.generated.webapp.model.SortDirectionEnumDTO;
import en93.sample.northwindmodulith.webapp.services.OrderService;
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
    public ResponseEntity<GetOrders200ResponseDTO> getOrders(String orderKey, String customerKey, Integer limit, Integer offset, OrderSortEnumDTO sortField, SortDirectionEnumDTO sortDirection) {
        var orders = orderService.getOrders(orderKey, customerKey, limit, offset, sortDirection, sortField);

        var response = new GetOrders200ResponseDTO();
        response.setData(orders.getContent());

        var pagination = paginationUtil.buildPaginationResponse(orders);
        response.setPagination(pagination);

        return ResponseEntity.ok(response);
    }

}
