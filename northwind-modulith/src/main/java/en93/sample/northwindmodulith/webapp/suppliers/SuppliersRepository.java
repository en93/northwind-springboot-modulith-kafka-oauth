package en93.sample.northwindmodulith.webapp.suppliers;

import en93.sample.northwindmodulith.generated.jooq.Tables;
import en93.sample.northwindmodulith.generated.jooq.tables.pojos.SuppliersEntity;
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

    public List<SuppliersEntity> getSuppliers(String supplierKey, String searchSupplierName) {
        return dslContext.selectFrom(Tables.SUPPLIERS)
                .where(StringUtils.isNotBlank(supplierKey) ? Tables.SUPPLIERS.SUPPLIERID.eq(Integer.valueOf(supplierKey)) : DSL.trueCondition())
                .fetchInto(SuppliersEntity.class);
    }
}
