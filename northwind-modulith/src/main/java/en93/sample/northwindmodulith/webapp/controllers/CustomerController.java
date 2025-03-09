package en93.sample.northwindmodulith.webapp.controllers;

import en93.sample.northwindmodulith.generated.webapp.api.CustomerApi;
import en93.sample.northwindmodulith.generated.webapp.model.CustomerSortEnumDTO;
import en93.sample.northwindmodulith.generated.webapp.model.GetCustomers200ResponseDTO;
import en93.sample.northwindmodulith.generated.webapp.model.SortDirectionEnumDTO;
import en93.sample.northwindmodulith.webapp.services.CustomerService;
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
    public ResponseEntity<GetCustomers200ResponseDTO> getCustomers(String customerKey, String searchCustomer, Integer limit, Integer offset, CustomerSortEnumDTO sortField, SortDirectionEnumDTO sortDirection) {
        var customers = customerService.getCustomers(customerKey, searchCustomer, limit, offset, sortDirection, sortField);

        var response = new GetCustomers200ResponseDTO();
        response.setData(customers.getContent());

        var pagination = paginationUtil.buildPaginationResponse(customers);
        response.setPagination(pagination);

        return ResponseEntity.ok(response);
    }
}
