package en93.sample.northwind_modulith.webapp.products;

import en93.sample.northwind_modulith.generated.webapp.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    protected ResponseEntity<List<Product>> getProducts(String searchName, Integer supplierId, Integer categoryId, Float minPrice, Float maxPrice, Integer page, Integer limit, String sort, String direction) {
        return null;
    }
}
