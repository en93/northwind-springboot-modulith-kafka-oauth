package en93.sample.northwindmodulith.webapp.services;


import en93.sample.northwindmodulith.generated.webapp.model.CustomerDTO;
import en93.sample.northwindmodulith.generated.webapp.model.CustomerSortEnumDTO;
import en93.sample.northwindmodulith.generated.webapp.model.SortDirectionEnumDTO;
import en93.sample.northwindmodulith.webapp.repositories.CustomerRepository;
import en93.sample.northwindmodulith.webapp.mappers.CustomerMapper;
import en93.sample.northwindmodulith.webapp.utils.PaginationUtil;
import en93.sample.northwindmodulith.webapp.utils.SortConversionUtil;
import en93.sample.northwindmodulith.webapp.utils.TextSearchUtil;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final PaginationUtil paginationUtil;
    private final SortConversionUtil sortConversionUtil;
    private final TextSearchUtil textSearchUtil;
    private static final Map<CustomerSortEnumDTO, String> SORT_MAP =
            Map.of(CustomerSortEnumDTO.KEY, "customerID",
                    CustomerSortEnumDTO.NAME, "customerName");

    public CustomerService(CustomerRepository customerRepository, PaginationUtil paginationUtil, SortConversionUtil sortConversionUtil, TextSearchUtil textSearchUtil) {
        this.customerRepository = customerRepository;
        this.paginationUtil = paginationUtil;
        this.sortConversionUtil = sortConversionUtil;
        this.textSearchUtil = textSearchUtil;
    }

    public Page<CustomerDTO> getCustomers(String customerKey, String searchCustomer, Integer limit, Integer offset, SortDirectionEnumDTO sortDirection, CustomerSortEnumDTO sortField) {

        var formattedSearch = textSearchUtil.formatQueryForSearch(searchCustomer);
        var entitySortField = sortConversionUtil.getEntitySortField(sortField, SORT_MAP);
        var pageable = paginationUtil.buildPageRequest(limit, offset, entitySortField, sortDirection);

        return customerRepository.searchCustomers(customerKey, formattedSearch, pageable).map(CustomerMapper.INSTANCE::toDTO);

    }

}
