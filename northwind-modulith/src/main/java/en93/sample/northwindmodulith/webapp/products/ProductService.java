package en93.sample.northwindmodulith.webapp.products;

import en93.sample.northwindmodulith.generated.webapp.model.ProductDTO;
import en93.sample.northwindmodulith.mappers.ProductMapper;
import en93.sample.northwindmodulith.webapp.utils.PaginationUtil;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final PaginationUtil paginationUtil;

    public ProductService(ProductRepository productRepository, PaginationUtil paginationUtil) {
        this.productRepository = productRepository;
        this.paginationUtil = paginationUtil;
    }

    protected List<ProductDTO> getProducts(String productKey, String searchProductName, Integer limit, Integer offset, String sortDirection) {
        var key = productKey != null ? Integer.valueOf(productKey) : null;
        var pageable = paginationUtil.buildPageRequest(limit, offset);

        var productEntities = productRepository.searchProducts(key, pageable);
        return productEntities.stream()
                .map(ProductMapper.INSTANCE::toDTO)
                .toList();
    }
}
