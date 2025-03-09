package en93.sample.northwindmodulith.webapp.mappers;

import en93.sample.northwindmodulith.webapp.entities.SupplierEntity;
import en93.sample.northwindmodulith.generated.webapp.model.SupplierDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SupplierMapper {

    SupplierMapper INSTANCE = Mappers.getMapper(SupplierMapper.class);

    @Mapping(source = "supplierKey", target = "supplierKey")
    @Mapping(source = "supplierName", target = "supplierName")
    @Mapping(source = "address", target="addressDetails.address")
    @Mapping(source = "city", target="addressDetails.city")
    @Mapping(source = "postalCode", target="addressDetails.postalCode")
    @Mapping(source = "country", target="addressDetails.country")
    @Mapping(source = "phone", target = "supplierPhone")
    SupplierDTO toDTO(SupplierEntity supplierEntity);


}
