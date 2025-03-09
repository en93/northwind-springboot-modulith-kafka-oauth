package en93.sample.northwindmodulith.webapp.mappers;

import en93.sample.northwindmodulith.webapp.entities.ProductEntity;
import en93.sample.northwindmodulith.generated.webapp.model.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = SupplierMapper.class)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "productKey", target = "productKey")
    @Mapping(source = "productName", target = "name")
//    @Mapping(source = "?", target = "description")//todo remove?
    @Mapping(source = "supplier", target = "supplier")
    @Mapping(source = "category", target = "category")
    @Mapping(source= "unit", target = "unit")
    @Mapping(source = "price", target = "price")
    ProductDTO toDTO(ProductEntity productEntity);


}
