package en93.sample.northwindmodulith.webapp.customers;

import en93.sample.northwindmodulith.generated.webapp.api.CustomerApi;
import en93.sample.northwindmodulith.generated.webapp.model.GetCustomers200ResponseDTO;
import en93.sample.northwindmodulith.webapp.utils.PaginationUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController implements CustomerApi {

    private final CustomerService customerService;
    private final PaginationUtil paginationUtil;

    public CustomerController(CustomerService customerService, PaginationUtil paginationUtil) {
        this.customerService = customerService;
        this.paginationUtil = paginationUtil;
    }

    @Override
    public ResponseEntity<GetCustomers200ResponseDTO> getCustomers(String customerKey, String searchCustomerName, Integer limit, Integer offset, String sortDirection) {

        var response = new GetCustomers200ResponseDTO();

        var customers = customerService.getCustomers(customerKey, searchCustomerName, limit, offset, sortDirection);
        response.setData(customers);

        var pagination = paginationUtil.buildPaginationResponse(limit, offset);
        response.setPagination(pagination);

        return ResponseEntity.ok(response);
    }
}
