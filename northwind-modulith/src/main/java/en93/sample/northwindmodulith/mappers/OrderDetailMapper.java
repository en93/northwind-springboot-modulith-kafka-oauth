package en93.sample.northwindmodulith.mappers;

import en93.sample.northwindmodulith.entities.OrderDetailEntity;
import en93.sample.northwindmodulith.generated.webapp.model.OrderDetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = ProductMapper.class)
public interface OrderDetailMapper {


    @Mapping(source = "product", target = "product")
    @Mapping(source = "quantity", target = "quantity")
    OrderDetailDTO toDTO(OrderDetailEntity orderDetailEntity);

}
