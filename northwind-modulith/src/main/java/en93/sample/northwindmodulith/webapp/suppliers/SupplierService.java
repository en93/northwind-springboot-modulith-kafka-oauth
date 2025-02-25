package en93.sample.northwindmodulith.webapp.suppliers;

import en93.sample.northwindmodulith.entities.SupplierEntity;
import en93.sample.northwindmodulith.generated.webapp.model.SupplierDTO;
import en93.sample.northwindmodulith.mappers.SupplierMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<SupplierDTO> getSuppliers(String supplierKey, String searchSupplierName) {
        var key = supplierKey != null ? Integer.valueOf(supplierKey) : null;
        var supplierEntities = supplierRepository.searchSuppliers(key);
        return supplierEntities.stream()
                .map(SupplierMapper.INSTANCE::toDTO)
                .toList();
//        List<SuppliersEntity> suppliers = suppliersRepository.getSuppliers(supplierKey, searchSupplierName);
//        return suppliers.stream()
//                .map(entity -> {
//                    var dto = new SupplierDTO();
//                    dto.setSupplierKey(""+entity.getSupplierid());
//                    dto.setSupplierName(entity.getSuppliername());
//                    dto.setSupplierPhone(entity.getPhone());
//
//                    var addressDetailsDTO = new AddressDetailsDTO();
//                    addressDetailsDTO.setAddress(entity.getAddress());
//                    addressDetailsDTO.setCity(entity.getCity());
//                    addressDetailsDTO.setPostalCode(entity.getPostalcode());
//                    addressDetailsDTO.setCountry(entity.getCountry());
//                    dto.setAddressDetails(addressDetailsDTO);
//
//                    return dto;
//                })
//                .toList();
    }
}
