package en93.sample.northwindmodulith.webapp.products;

import en93.sample.northwindmodulith.generated.webapp.model.OrderSortEnumDTO;
import en93.sample.northwindmodulith.generated.webapp.model.ProductDTO;
import en93.sample.northwindmodulith.generated.webapp.model.ProductSortEnumDTO;
import en93.sample.northwindmodulith.generated.webapp.model.SortDirectionEnumDTO;
import en93.sample.northwindmodulith.mappers.ProductMapper;
import en93.sample.northwindmodulith.webapp.utils.PaginationUtil;
import en93.sample.northwindmodulith.webapp.utils.SortConversionUtil;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final PaginationUtil paginationUtil;
    private final SortConversionUtil sortConversionUtil;
    private static final Map<ProductSortEnumDTO, String> SORT_MAP =//todo switch to use enum pattern matching
            Map.of(ProductSortEnumDTO.KEY, "productID",
                    ProductSortEnumDTO.NAME, "productName",
                    ProductSortEnumDTO.PRICE, "price");

    public ProductService(ProductRepository productRepository, PaginationUtil paginationUtil, SortConversionUtil sortConversionUtil) {
        this.productRepository = productRepository;
        this.paginationUtil = paginationUtil;
        this.sortConversionUtil = sortConversionUtil;
    }

    Page<ProductDTO> getProducts(String productKey, String searchProductName, Integer limit, Integer offset, SortDirectionEnumDTO sortDirection, ProductSortEnumDTO sortField) {
        var key = productKey != null ? Integer.valueOf(productKey) : null;
        var entitySortField = sortConversionUtil.getEntitySortField(sortField, SORT_MAP);
        var pageable = paginationUtil.buildPageRequest(limit, offset, entitySortField, sortDirection);

        return productRepository.searchProducts(key, pageable).map(ProductMapper.INSTANCE::toDTO);

    }
}
