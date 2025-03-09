package en93.sample.northwindmodulith.webapp.controllers;

import en93.sample.northwindmodulith.generated.webapp.api.SuppliersApi;
import en93.sample.northwindmodulith.generated.webapp.model.GetSuppliers200ResponseDTO;
import en93.sample.northwindmodulith.generated.webapp.model.SortDirectionEnumDTO;
import en93.sample.northwindmodulith.generated.webapp.model.SupplierSortEnumDTO;
import en93.sample.northwindmodulith.webapp.services.SupplierService;
import en93.sample.northwindmodulith.webapp.utils.PaginationUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupplierController implements SuppliersApi {

    private final SupplierService supplierService;
    private final PaginationUtil paginationUtil;

    public SupplierController(SupplierService supplierService, PaginationUtil paginationUtil) {
        this.supplierService = supplierService;
        this.paginationUtil = paginationUtil;
    }

    @Override
    public ResponseEntity<GetSuppliers200ResponseDTO> getSuppliers(String supplierKey, String searchSupplierName, Integer limit, Integer offset, SupplierSortEnumDTO sortField, SortDirectionEnumDTO sortDirection) {
        var response = new  GetSuppliers200ResponseDTO();

        var suppliers = supplierService.getSuppliers(supplierKey, searchSupplierName, limit, offset, sortDirection, sortField);
        response.setData(suppliers.getContent());

        var pagination = paginationUtil.buildPaginationResponse(suppliers);
        response.setPagination(pagination);

        return ResponseEntity.ok(response);
    }

}
