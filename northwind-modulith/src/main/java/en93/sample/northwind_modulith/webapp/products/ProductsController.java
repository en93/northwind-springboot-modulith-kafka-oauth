package en93.sample.northwind_modulith.webapp.products;


import en93.sample.northwind_modulith.generated.webapp.api.ProductsApi;
import en93.sample.northwind_modulith.generated.webapp.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductsController implements ProductsApi {

    private ProductsService productsService;

    @Override
    @PostMapping
    public ResponseEntity<Product> addProduct(Product product) {
        return null;
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Product>> getProducts(String searchName, Integer supplierId, Integer categoryId, Float minPrice, Float maxPrice, Integer page, Integer limit, String sort, String direction) {
        return productsService.getProducts(searchName, supplierId, categoryId, minPrice, maxPrice, page, limit, sort, direction);
    }
}
