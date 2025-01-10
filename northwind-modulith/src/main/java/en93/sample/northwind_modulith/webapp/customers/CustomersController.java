package en93.sample.northwind_modulith.webapp.customers;

import en93.sample.northwind_modulith.generated.webapp.api.CustomerApi;
import en93.sample.northwind_modulith.generated.webapp.model.Supplier;
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
    public ResponseEntity<List<Supplier>> getCustomers(String supplierKey, String searchSupplierName) {
        return null;
    }
}
