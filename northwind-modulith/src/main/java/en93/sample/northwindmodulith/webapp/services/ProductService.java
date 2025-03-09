package en93.sample.northwindmodulith.webapp.services;

import en93.sample.northwindmodulith.generated.webapp.model.ProductDTO;
import en93.sample.northwindmodulith.generated.webapp.model.ProductSortEnumDTO;
import en93.sample.northwindmodulith.generated.webapp.model.SortDirectionEnumDTO;
import en93.sample.northwindmodulith.webapp.mappers.ProductMapper;
import en93.sample.northwindmodulith.webapp.repositories.ProductRepository;
import en93.sample.northwindmodulith.webapp.utils.PaginationUtil;
import en93.sample.northwindmodulith.webapp.utils.SortConversionUtil;
import en93.sample.northwindmodulith.webapp.utils.TextSearchUtil;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final PaginationUtil paginationUtil;
    private final SortConversionUtil sortConversionUtil;
    private final TextSearchUtil textSearchUtil;
    private static final Map<ProductSortEnumDTO, String> SORT_MAP =//todo switch to use enum pattern matching
            Map.of(ProductSortEnumDTO.KEY, "productID",
                    ProductSortEnumDTO.NAME, "productName",
                    ProductSortEnumDTO.PRICE, "price");

    public ProductService(ProductRepository productRepository, PaginationUtil paginationUtil, SortConversionUtil sortConversionUtil, TextSearchUtil textSearchUtil) {
        this.productRepository = productRepository;
        this.paginationUtil = paginationUtil;
        this.sortConversionUtil = sortConversionUtil;
        this.textSearchUtil = textSearchUtil;
    }

    public Page<ProductDTO> getProducts(String productKey, String searchProduct, Integer limit, Integer offset, SortDirectionEnumDTO sortDirection, ProductSortEnumDTO sortField) {

        var formattedSearch = textSearchUtil.formatQueryForSearch(searchProduct);
        var entitySortField = sortConversionUtil.getEntitySortField(sortField, SORT_MAP);
        var pageable = paginationUtil.buildPageRequest(limit, offset, entitySortField, sortDirection);

        return productRepository.searchProducts(productKey, formattedSearch, pageable).map(ProductMapper.INSTANCE::toDTO);

    }
}
