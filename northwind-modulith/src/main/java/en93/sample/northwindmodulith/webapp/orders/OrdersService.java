package en93.sample.northwindmodulith.webapp.orders;

import en93.sample.northwindmodulith.generated.webapp.model.OrderDTO;
import en93.sample.northwindmodulith.generated.jooq.tables.pojos.OrdersEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class OrdersService {
    private final OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public List<OrderDTO> getOrders(String orderKey, String customerKey) {
        List<OrdersEntity> orders = ordersRepository.getOrders(orderKey, customerKey);
        return orders.stream()
                .map( entity -> {
                    OrderDTO dto = new OrderDTO();
//                    dto.setOrderDate(entity.getOrderdate());//todo change to use local date time on api layer
                    dto.setOrderDate(null);
                    dto.setOrderKey(""+entity.getOrderid());
                    dto.setShipmentId(""+entity.getShipperid());
                    //todo explore jooq and foreign key relationships, one to many
                    dto.setOrderDetails(Collections.emptyList());
                    return dto;
                }).toList();
    }
}
