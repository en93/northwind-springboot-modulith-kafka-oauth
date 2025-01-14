package en93.sample.northwindmodulith.webapp.customers;

import en93.sample.northwindmodulith.generated.webapp.api.CustomerApi;
import en93.sample.northwindmodulith.generated.webapp.model.CustomerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomersController implements CustomerApi {

    private final CustomerService customerService;

    public CustomersController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public ResponseEntity<List<CustomerDTO>> getCustomers(String customerKey, String searchCustomerName) {
        return ResponseEntity.ok(customerService.getCustomers(customerKey, searchCustomerName));
    }
}
