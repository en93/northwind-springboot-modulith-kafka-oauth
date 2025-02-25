package en93.sample.northwindmodulith.mappers;

import en93.sample.northwindmodulith.entities.CustomerEntity;
import en93.sample.northwindmodulith.generated.webapp.model.CustomerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(source = "customerID", target="customerKey")
    @Mapping(source = "customerName", target = "customerName")
    @Mapping(source = "address", target="addressDetails.address")
    @Mapping(source = "city", target="addressDetails.city")
    @Mapping(source = "postalCode", target="addressDetails.postalCode")
    @Mapping(source = "country", target="addressDetails.country")
    CustomerDTO toDTO(CustomerEntity customerEntity);

}
