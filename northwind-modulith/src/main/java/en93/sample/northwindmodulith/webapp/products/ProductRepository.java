package en93.sample.northwindmodulith.webapp.products;

import en93.sample.northwindmodulith.entities.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    @Query(value = "SELECT * from products p " +
            "WHERE (:productKey IS NULL OR :productKey = p.productKey) " +
            "AND (:searchProduct IS NULL OR p.tsv_content @@ to_tsquery(:searchProduct))", nativeQuery = true)
    Page<ProductEntity> searchProducts(String productKey, String searchProduct, Pageable pageable);

}
