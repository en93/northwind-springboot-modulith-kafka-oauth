package en93.sample.northwindmodulith.webapp.products;

import en93.sample.northwindmodulith.generated.webapp.model.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductsService {
    private final ProductsRepository productsRepository;

    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    protected List<ProductDTO> getProducts(String productKey, String searchProductName) {
        return productsRepository.findProducts(productKey, searchProductName).stream()
                .map(entity -> {
                    //Is there an easier way to map? Externalise to own lib
                    final var product = new ProductDTO();
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
