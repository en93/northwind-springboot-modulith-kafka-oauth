package en93.sample.northwindmodulith.webapp.mappers;

import en93.sample.northwindmodulith.webapp.entities.ShipperEntity;
import en93.sample.northwindmodulith.generated.webapp.model.ShipperDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ShipperMapper {

    @Mapping(source = "shipperID", target = "shipperId")
    @Mapping(source = "shipperName", target = "shipperName")
    @Mapping(source = "phone", target = "shipperPhone")
    ShipperDTO toDTO(ShipperEntity shipperEntity);

}
