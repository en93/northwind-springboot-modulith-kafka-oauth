package en93.sample.northwindmodulith.mappers;

import en93.sample.northwindmodulith.entities.OrderEntity;
import en93.sample.northwindmodulith.generated.webapp.model.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;

@Mapper(uses = {OrderDetailMapper.class, ShipperMapper.class})
public interface OrderMapper {

    //todo can I move this to a component class?
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(source = "orderID", target = "orderKey")
    @Mapping(source = "orderDate", target = "orderDate")
    @Mapping(source = "shipper", target = "shipper")
    @Mapping(source = "details", target = "orderDetails")
    OrderDTO toDto(OrderEntity orderEntity);


    default OffsetDateTime localDateTimeToOffsetDateTime(LocalDateTime localDateTime) {
        if (localDateTime != null) {
            var zoneId = ZoneId.of("Pacific/Auckland");
            return localDateTime.atOffset(zoneId.getRules().getOffset(localDateTime));
        }
        return null;
    }

}


