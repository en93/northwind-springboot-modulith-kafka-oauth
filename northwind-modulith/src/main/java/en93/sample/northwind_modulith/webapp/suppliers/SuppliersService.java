package en93.sample.northwind_modulith.webapp.suppliers;

import en93.sample.northwind_modulith.generated.webapp.model.AddressDetailsDTO;
import en93.sample.northwind_modulith.generated.webapp.model.SupplierDTO;
import en93.sample.northwind_modulith.webapp.generated.jooq.tables.pojos.SuppliersEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuppliersService {

    private final SuppliersRepository suppliersRepository;

    public SuppliersService(SuppliersRepository suppliersRepository) {
        this.suppliersRepository = suppliersRepository;
    }

    public List<SupplierDTO> getSuppliers(String customerKey, String searchCustomerName) {
        List<SuppliersEntity> suppliers = suppliersRepository.getSuppliers(customerKey, searchCustomerName);
        return suppliers.stream()
                .map(entity -> {
                    var dto = new SupplierDTO();
                    dto.setSupplierKey(""+entity.getSupplierid());
                    dto.setSupplierName(entity.getSuppliername());
                    dto.setPhone(entity.getPhone());

                    var addressDetailsDTO = new AddressDetailsDTO();
                    addressDetailsDTO.setAddress(entity.getAddress());
                    addressDetailsDTO.setCity(entity.getCity());
                    addressDetailsDTO.setPostalCode(entity.getPostalcode());
                    addressDetailsDTO.setCountry(entity.getCountry());
                    dto.setAddressDetails(addressDetailsDTO);

                    return dto;
                })
                .toList();
    }
}
