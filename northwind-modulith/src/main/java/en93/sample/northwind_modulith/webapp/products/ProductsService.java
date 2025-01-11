package en93.sample.northwind_modulith.webapp.products;

import en93.sample.northwind_modulith.generated.webapp.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductsService {
    private final ProductsRepository repository;

    public ProductsService(ProductsRepository repository) {
        this.repository = repository;
    }

    protected List<Product> getProducts(String productKey, String searchProductName) {
        return repository.findProducts(productKey, searchProductName).stream()
                .map(entity -> {
                    //Is there an easier way to map? Externalise to own lib
                    final Product product = new Product();
                    product.setProductKey("" + entity.getProductid());
                    product.setSupplierId(entity.getSupplierid());
                    product.setUnit(entity.getUnit());
                    product.setName(entity.getProductname());
                    product.setCategory(null);//todo
                    product.setPrice(entity.getPrice().floatValue());
                    return product;
                })
                .collect(Collectors.toList());
    }
}
