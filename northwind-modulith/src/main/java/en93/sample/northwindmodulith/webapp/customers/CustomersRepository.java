package en93.sample.northwindmodulith.webapp.customers;

import en93.sample.northwindmodulith.generated.jooq.Tables;
import en93.sample.northwindmodulith.generated.jooq.tables.pojos.CustomersEntity;
import org.apache.commons.lang3.StringUtils;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomersRepository {

    private final DSLContext dslContext;

    public CustomersRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    //todo type name seems funky, shouldn't be plural
    public List<CustomersEntity> getCustomers(String customerKey, String searchCustomerName) {
        return dslContext.selectFrom(Tables.CUSTOMERS)
                .where(StringUtils.isNotEmpty(customerKey) ? Tables.CUSTOMERS.CUSTOMERID.eq(Integer.valueOf(customerKey)) : DSL.trueCondition())
                .fetchInto(CustomersEntity.class);
    }
}
