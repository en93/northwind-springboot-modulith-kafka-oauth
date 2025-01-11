package en93.sample.northwind_modulith.webapp.products;

import en93.sample.northwind_modulith.webapp.generated.jooq.Tables;
import en93.sample.northwind_modulith.webapp.generated.jooq.tables.ProductsTable;
import en93.sample.northwind_modulith.webapp.generated.jooq.tables.pojos.ProductsEntity;
import org.apache.commons.lang3.StringUtils;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductsRepository {

    private final DSLContext dslContext;

    public ProductsRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    public List<ProductsEntity> findProducts(String productKey, String searchProductName){
                return dslContext.selectFrom(Tables.PRODUCTS)
                        .where( StringUtils.isNotEmpty(productKey) ? Tables.PRODUCTS.PRODUCTID.eq(Integer.valueOf(productKey)) : DSL.trueCondition())
                        .fetchInto(ProductsEntity.class);
    }


}
