package en93.sample.northwindmodulith.webapp.products;


import en93.sample.northwindmodulith.generated.webapp.api.ProductsApi;
import en93.sample.northwindmodulith.generated.webapp.model.GetProducts200ResponseDTO;
import en93.sample.northwindmodulith.generated.webapp.model.ProductSortEnumDTO;
import en93.sample.northwindmodulith.generated.webapp.model.SortDirectionEnumDTO;
import en93.sample.northwindmodulith.webapp.utils.PaginationUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController implements ProductsApi {

    private final ProductService productService;
    private final PaginationUtil paginationUtil;

    public ProductController(ProductService productService, PaginationUtil paginationUtil) {
        this.productService = productService;
        this.paginationUtil = paginationUtil;
    }

    @Override
    public ResponseEntity<GetProducts200ResponseDTO> getProducts(String productKey, String searchProductName, Integer limit, Integer offset, ProductSortEnumDTO sortField, SortDirectionEnumDTO sortDirection) {

        var response = new GetProducts200ResponseDTO();

        var products = productService.getProducts(productKey, searchProductName, limit, offset, sortDirection, sortField);
        response.setData(products.getContent());

        var pagination = paginationUtil.buildPaginationResponse(products);
        response.setPagination(pagination);

        return ResponseEntity.ok(response);
    }

}
