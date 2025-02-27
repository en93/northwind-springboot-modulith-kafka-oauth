package en93.sample.northwindmodulith.webapp.products;

//import en93.sample.northwindmodulith.generated.jooq.Tables;
//import en93.sample.northwindmodulith.generated.jooq.tables.pojos.ProductsEntity;
//import org.apache.commons.lang3.StringUtils;
//import org.jooq.DSLContext;
//import org.jooq.impl.DSL;
import en93.sample.northwindmodulith.entities.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    @Query("SELECT p from ProductEntity p " +
            "WHERE :productKey IS NULL OR :productKey = p.productID")
    List<ProductEntity> searchProducts(Integer productKey, Pageable pageable);

}
