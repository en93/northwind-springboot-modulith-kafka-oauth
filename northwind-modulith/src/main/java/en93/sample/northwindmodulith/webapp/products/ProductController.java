package en93.sample.northwindmodulith.webapp.products;


import en93.sample.northwindmodulith.generated.webapp.api.ProductsApi;
import en93.sample.northwindmodulith.generated.webapp.model.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController implements ProductsApi {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

//    @Override
//    public ResponseEntity<Product> addProduct(Product product) {
//        return null;
//    }

    @Override
    public ResponseEntity<List<ProductDTO>> getProducts(String productKey, String searchProductName) {
        List<ProductDTO> products = productService.getProducts(productKey, searchProductName);

        //todo error handling
        return ResponseEntity.ok(products);
    }
}
