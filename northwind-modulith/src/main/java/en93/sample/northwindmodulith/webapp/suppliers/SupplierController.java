package en93.sample.northwindmodulith.webapp.suppliers;

import en93.sample.northwindmodulith.generated.webapp.api.SuppliersApi;
import en93.sample.northwindmodulith.generated.webapp.model.SupplierDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SupplierController implements SuppliersApi {

    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @Override
    public ResponseEntity<List<SupplierDTO>> getSuppliers(String supplierKey, String searchSupplierName) {
        return ResponseEntity.ok(supplierService.getSuppliers(supplierKey, searchSupplierName));
    }
}
