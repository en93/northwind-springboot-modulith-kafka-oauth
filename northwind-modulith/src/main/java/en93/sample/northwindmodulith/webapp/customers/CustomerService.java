package en93.sample.northwindmodulith.webapp.customers;

import en93.sample.northwindmodulith.generated.jooq.tables.pojos.CustomersEntity;
import en93.sample.northwindmodulith.generated.webapp.model.AddressDetailsDTO;
import en93.sample.northwindmodulith.generated.webapp.model.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomersRepository customersRepository;

    public CustomerService(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    public List<CustomerDTO> getCustomers(String customerKey, String searchCustomerName) {
        List<CustomersEntity> customersEntities = customersRepository.getCustomers(customerKey, searchCustomerName);
        return customersEntities.stream()
                .map(entity -> {
                    var dto = new CustomerDTO();
                    dto.setCustomerKey(""+entity.getCustomerid());
                    dto.setCustomerName(entity.getCustomername());

                    var addressDetailsDTO = new AddressDetailsDTO();
                    addressDetailsDTO.setCountry(entity.getCountry());
                    addressDetailsDTO.setPostalCode(entity.getPostalcode());
                    addressDetailsDTO.setCity(entity.getCity());
                    addressDetailsDTO.setAddress(entity.getAddress());
                    dto.setAddressDetails(addressDetailsDTO);

                    return dto;
                })
                .toList();
    }
}
