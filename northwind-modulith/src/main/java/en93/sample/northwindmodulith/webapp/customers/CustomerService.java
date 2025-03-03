package en93.sample.northwindmodulith.webapp.customers;


import en93.sample.northwindmodulith.generated.webapp.model.CustomerDTO;
import en93.sample.northwindmodulith.generated.webapp.model.CustomerSortEnumDTO;
import en93.sample.northwindmodulith.generated.webapp.model.SortDirectionEnumDTO;
import en93.sample.northwindmodulith.mappers.CustomerMapper;
import en93.sample.northwindmodulith.webapp.utils.PaginationUtil;
import en93.sample.northwindmodulith.webapp.utils.SortConversionUtil;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final PaginationUtil paginationUtil;
    private final SortConversionUtil sortConversionUtil;
    private static final Map<CustomerSortEnumDTO, String> SORT_MAP =
            Map.of(CustomerSortEnumDTO.KEY, "customerID",
                    CustomerSortEnumDTO.NAME, "customerName");

    public CustomerService(CustomerRepository customerRepository, PaginationUtil paginationUtil, SortConversionUtil sortConversionUtil) {
        this.customerRepository = customerRepository;
        this.paginationUtil = paginationUtil;
        this.sortConversionUtil = sortConversionUtil;
    }

    public Page<CustomerDTO> getCustomers(String customerKey, String searchCustomerName, Integer limit, Integer offset, SortDirectionEnumDTO sortDirection, CustomerSortEnumDTO sortField) {

        //todo clean up inputs and validation
        var key = customerKey != null ? Integer.valueOf(customerKey) : null;
        var entitySortField = sortConversionUtil.getEntitySortField(sortField, SORT_MAP);
        var pageable = paginationUtil.buildPageRequest(limit, offset, entitySortField, sortDirection);

        return customerRepository.searchCustomers(key, pageable).map(CustomerMapper.INSTANCE::toDTO);

    }

}
