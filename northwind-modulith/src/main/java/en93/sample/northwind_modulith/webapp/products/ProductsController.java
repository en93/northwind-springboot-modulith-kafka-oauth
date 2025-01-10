package en93.sample.northwind_modulith.webapp.products;


import en93.sample.northwind_modulith.generated.webapp.api.ProductsApi;
import en93.sample.northwind_modulith.generated.webapp.model.Category;
import en93.sample.northwind_modulith.generated.webapp.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductsController implements ProductsApi {

    private final ProductsService productsService;

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

//    @Override
//    public ResponseEntity<Product> addProduct(Product product) {
//        return null;
//    }

    @Override
    public ResponseEntity<List<Product>> getProducts(String productKey, String searchProductName) {
        Category sampleCategory = new Category();
        sampleCategory.setCategoryId(1);
        sampleCategory.setDescription("Category description");
        sampleCategory.setCategoryName("Category name");

        Product sampleProduct = new Product();
        sampleProduct.setCategory(sampleCategory);
        sampleProduct.setName("prod1");
        sampleProduct.setDescription("desc1");
        sampleProduct.setPrice(5f);
        sampleProduct.setSupplierId(2);
        sampleProduct.setProductKey("key");
        sampleProduct.setUnit("shelf");

        Product sampleProduct2 = new Product();
        sampleProduct2.setCategory(sampleCategory);
        sampleProduct2.setName("test");
        sampleProduct2.setDescription("desc2");
        sampleProduct2.setPrice(7f);
        sampleProduct2.setSupplierId(2);
        sampleProduct2.setProductKey("key2");
        sampleProduct2.setUnit("box");

        Product sampleProduct3 = new Product();
        sampleProduct3.setCategory(null);
        sampleProduct3.setName("test");
        sampleProduct3.setDescription("desc2");
        sampleProduct3.setPrice(7f);
        sampleProduct3.setSupplierId(2);
        sampleProduct3.setProductKey("key3");
        sampleProduct3.setUnit("box");

        return ResponseEntity.ok(List.of(sampleProduct, sampleProduct2, sampleProduct3));
    }
}
