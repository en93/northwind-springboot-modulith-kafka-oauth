package en93.sample.northwindmodulith.webapp.orders;

import en93.sample.northwindmodulith.generated.jooq.tables.pojos.ShippersEntity;
import en93.sample.northwindmodulith.generated.webapp.model.OrderDTO;
import en93.sample.northwindmodulith.generated.jooq.tables.pojos.OrdersEntity;
import en93.sample.northwindmodulith.generated.webapp.model.ShipperDTO;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class OrdersService {
    private final OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public List<OrderDTO> getOrders(String orderKey, String customerKey) {
        List<Pair<OrdersEntity, ShippersEntity>> orders = ordersRepository.getOrders(orderKey, customerKey);
        return orders.stream()
                .map( row -> {
                    OrdersEntity orderEntity = row.getLeft();
                    ShippersEntity shipperEntity = row.getRight();

                    ZoneId zoneId = ZoneId.of("Pacific/Auckland");  // New Zealand Standard Time (NZST) or NZ Daylight Time (NZDT)
                    var zonedDateTime = orderEntity.getOrderdate().atZone(zoneId).toOffsetDateTime();


                    OrderDTO orderDTO = new OrderDTO();
                    orderDTO.setOrderDate(zonedDateTime);
                    orderDTO.setOrderDate(null);
                    orderDTO.setOrderKey("" + orderEntity.getOrderid());


                    var shipperDTO = new ShipperDTO();
                    shipperDTO.setShipperId("" + shipperEntity.getShipperid());
                    shipperDTO.setShipperName(shipperDTO.getShipperName());
                    shipperDTO.setShipperPhone(shipperEntity.getPhone());
                    orderDTO.setShipper(shipperDTO);
                    //todo explore jooq and foreign key relationships, one to many
                    orderDTO.setOrderDetails(Collections.emptyList());
                    return orderDTO;
                }).toList();
    }
}
