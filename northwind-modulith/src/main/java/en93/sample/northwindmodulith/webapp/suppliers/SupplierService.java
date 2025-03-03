package en93.sample.northwindmodulith.webapp.suppliers;

import en93.sample.northwindmodulith.generated.webapp.model.SortDirectionEnumDTO;
import en93.sample.northwindmodulith.generated.webapp.model.SupplierDTO;
import en93.sample.northwindmodulith.generated.webapp.model.SupplierSortEnumDTO;
import en93.sample.northwindmodulith.mappers.SupplierMapper;
import en93.sample.northwindmodulith.webapp.utils.PaginationUtil;
import en93.sample.northwindmodulith.webapp.utils.SortConversionUtil;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;
    private final PaginationUtil paginationUtil;
    private final SortConversionUtil sortConversionUtil;
    private static final Map<SupplierSortEnumDTO, String> SORT_MAP =//todo switch to use enum pattern matching
            Map.of(SupplierSortEnumDTO.KEY, "supplierID",
                    SupplierSortEnumDTO.NAME, "supplierName");

    public SupplierService(SupplierRepository supplierRepository, PaginationUtil paginationUtil, SortConversionUtil sortConversionUtil) {
        this.supplierRepository = supplierRepository;
        this.paginationUtil = paginationUtil;
        this.sortConversionUtil = sortConversionUtil;
    }

    public Page<SupplierDTO> getSuppliers(String supplierKey, String searchSupplierName, Integer limit, Integer offset, SortDirectionEnumDTO sortDirection, SupplierSortEnumDTO sortField) {
        var key = supplierKey != null ? Integer.valueOf(supplierKey) : null;
        var entitySortField = sortConversionUtil.getEntitySortField(sortField, SORT_MAP);
        var pageable = paginationUtil.buildPageRequest(limit, offset, entitySortField, sortDirection);

        return supplierRepository.searchSuppliers(key, pageable).map(SupplierMapper.INSTANCE::toDTO);
    }
}
