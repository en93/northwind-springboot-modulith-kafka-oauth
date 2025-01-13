package en93.sample.northwind_modulith.webapp.suppliers;

import en93.sample.northwind_modulith.generated.webapp.api.SuppliersApi;
import en93.sample.northwind_modulith.generated.webapp.model.SupplierDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SuppliersController implements SuppliersApi {

    private final SuppliersService suppliersService;

    public SuppliersController(SuppliersService suppliersService) {
        this.suppliersService = suppliersService;
    }

    @Override
    public ResponseEntity<List<SupplierDTO>> getSuppliers(String customerKey, String searchCustomerName) {
        return ResponseEntity.ok(suppliersService.getSuppliers(customerKey, searchCustomerName));
    }
}
