package en93.sample.northwindmodulith.webapp.orders;

import en93.sample.northwindmodulith.generated.webapp.model.CustomerSortEnumDTO;
import en93.sample.northwindmodulith.generated.webapp.model.OrderDTO;
import en93.sample.northwindmodulith.generated.webapp.model.OrderSortEnumDTO;
import en93.sample.northwindmodulith.generated.webapp.model.SortDirectionEnumDTO;
import en93.sample.northwindmodulith.mappers.OrderMapper;
import en93.sample.northwindmodulith.webapp.utils.PaginationUtil;
import en93.sample.northwindmodulith.webapp.utils.SortConversionUtil;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final PaginationUtil paginationUtil;
    private final SortConversionUtil sortConversionUtil;
    private static final Map<OrderSortEnumDTO, String> SORT_MAP =//todo switch to use enum pattern matching
            Map.of(OrderSortEnumDTO.KEY, "orderID",
                    OrderSortEnumDTO.ORDERDATE, "orderDate");

    public OrderService(OrderRepository orderRepository, PaginationUtil paginationUtil, SortConversionUtil sortConversionUtil) {
        this.orderRepository = orderRepository;
        this.paginationUtil = paginationUtil;
        this.sortConversionUtil = sortConversionUtil;
    }

    public Page<OrderDTO> getOrders(String orderKey, String customerKey, Integer limit, Integer offset, SortDirectionEnumDTO sortDirection, OrderSortEnumDTO sortField) {
        var key = orderKey != null ? Integer.valueOf(orderKey) : null;
        var entitySortField = sortConversionUtil.getEntitySortField(sortField, SORT_MAP);
        var pageable = paginationUtil.buildPageRequest(limit, offset, entitySortField, sortDirection);

        return orderRepository.searchOrders(key, pageable).map(OrderMapper.INSTANCE::toDto);
    }
}
