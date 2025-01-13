package en93.sample.northwind_modulith.webapp.suppliers;

import en93.sample.northwind_modulith.webapp.generated.jooq.Tables;
import en93.sample.northwind_modulith.webapp.generated.jooq.tables.pojos.SuppliersEntity;
import org.apache.commons.lang3.StringUtils;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SuppliersRepository {

    private final DSLContext dslContext;

    public SuppliersRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    public List<SuppliersEntity> getSuppliers(String customerKey, String searchCustomerName) {
        return dslContext.selectFrom(Tables.SUPPLIERS)
                .where(StringUtils.isNotBlank(customerKey) ? Tables.SUPPLIERS.SUPPLIERID.eq(Integer.valueOf(customerKey)) : DSL.trueCondition())
                .fetchInto(SuppliersEntity.class);
    }
}
