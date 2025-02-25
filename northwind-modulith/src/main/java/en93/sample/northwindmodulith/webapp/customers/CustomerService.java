package en93.sample.northwindmodulith.webapp.customers;


import en93.sample.northwindmodulith.generated.webapp.model.CustomerDTO;
import en93.sample.northwindmodulith.mappers.CustomerMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerDTO> getCustomers(String customerKey, String searchCustomerName) {
        //todo change type to int on swagger?
        var key = customerKey != null ? Integer.valueOf(customerKey) : null;
        var customerEntities = customerRepository.searchCustomers(key);
        return customerEntities.stream()
                .map(CustomerMapper.INSTANCE::toDTO)
                .toList();

//        List<CustomersEntity> customersEntities = customersRepository.getCustomers(customerKey, searchCustomerName);
//        return customersEntities.stream()
//                .map(entity -> {
//                    var dto = new CustomerDTO();
//                    dto.setCustomerKey(""+entity.getCustomerid());
//                    dto.setCustomerName(entity.getCustomername());
//
//                    var addressDetailsDTO = new AddressDetailsDTO();
//                    addressDetailsDTO.setCountry(entity.getCountry());
//                    addressDetailsDTO.setPostalCode(entity.getPostalcode());
//                    addressDetailsDTO.setCity(entity.getCity());
//                    addressDetailsDTO.setAddress(entity.getAddress());
//                    dto.setAddressDetails(addressDetailsDTO);
//
//                    return dto;
//                })
//                .toList();
    }
}
