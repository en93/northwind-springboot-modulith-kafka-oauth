package en93.sample.northwindmodulith.webapp.services;

import en93.sample.northwindmodulith.generated.webapp.model.SortDirectionEnumDTO;
import en93.sample.northwindmodulith.generated.webapp.model.SupplierDTO;
import en93.sample.northwindmodulith.generated.webapp.model.SupplierSortEnumDTO;
import en93.sample.northwindmodulith.webapp.mappers.SupplierMapper;
import en93.sample.northwindmodulith.webapp.repositories.SupplierRepository;
import en93.sample.northwindmodulith.webapp.utils.PaginationUtil;
import en93.sample.northwindmodulith.webapp.utils.SortConversionUtil;
import en93.sample.northwindmodulith.webapp.utils.TextSearchUtil;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;
    private final PaginationUtil paginationUtil;
    private final SortConversionUtil sortConversionUtil;
    private final TextSearchUtil textSearchUtil;
    private static final Map<SupplierSortEnumDTO, String> SORT_MAP =//todo switch to use enum pattern matching
            Map.of(SupplierSortEnumDTO.KEY, "supplierID",
                    SupplierSortEnumDTO.NAME, "supplierName");

    public SupplierService(SupplierRepository supplierRepository, PaginationUtil paginationUtil, SortConversionUtil sortConversionUtil, TextSearchUtil textSearchUtil) {
        this.supplierRepository = supplierRepository;
        this.paginationUtil = paginationUtil;
        this.sortConversionUtil = sortConversionUtil;
        this.textSearchUtil = textSearchUtil;
    }

    public Page<SupplierDTO> getSuppliers(String supplierKey, String searchSupplier, Integer limit, Integer offset, SortDirectionEnumDTO sortDirection, SupplierSortEnumDTO sortField) {

        var formattedSearch = textSearchUtil.formatQueryForSearch(searchSupplier);
        var entitySortField = sortConversionUtil.getEntitySortField(sortField, SORT_MAP);
        var pageable = paginationUtil.buildPageRequest(limit, offset, entitySortField, sortDirection);

        return supplierRepository.searchSuppliers(supplierKey, formattedSearch, pageable).map(SupplierMapper.INSTANCE::toDTO);
    }
}
