package en93.sample.northwindmodulith.webapp.orders;

import en93.sample.northwindmodulith.generated.jooq.Tables;
import en93.sample.northwindmodulith.generated.jooq.tables.pojos.OrdersEntity;
import org.apache.commons.lang3.StringUtils;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrdersRepository {
    private final DSLContext dslContext;

    public OrdersRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    public List<OrdersEntity> getOrders(String orderKey, String customerKey) {
        return dslContext.selectFrom(Tables.ORDERS)
                .where(StringUtils.isNotEmpty(orderKey) ? Tables.ORDERS.ORDERID.eq(Integer.valueOf(orderKey)) : DSL.trueCondition())
                .fetchInto(OrdersEntity.class);
    }
}
