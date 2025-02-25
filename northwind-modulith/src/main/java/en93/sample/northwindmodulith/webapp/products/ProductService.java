package en93.sample.northwindmodulith.webapp.products;

import en93.sample.northwindmodulith.generated.webapp.model.ProductDTO;
import en93.sample.northwindmodulith.mappers.ProductMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    protected List<ProductDTO> getProducts(String productKey, String searchProductName) {
        var key = productKey != null ? Integer.valueOf(productKey) : null;
        var productEntities = productRepository.searchProducts(key);
        return productEntities.stream()
                .map(ProductMapper.INSTANCE::toDTO)
                .toList();
    }
}
