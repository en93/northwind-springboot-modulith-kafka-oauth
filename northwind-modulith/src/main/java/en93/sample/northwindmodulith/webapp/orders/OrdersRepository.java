package en93.sample.northwindmodulith.webapp.orders;

import en93.sample.northwindmodulith.generated.jooq.Tables;
import en93.sample.northwindmodulith.generated.jooq.tables.pojos.OrdersEntity;
import en93.sample.northwindmodulith.generated.jooq.tables.pojos.ShippersEntity;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
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

    public List<Pair<OrdersEntity, ShippersEntity>> getOrders(String orderKey, String customerKey) {
        return dslContext.select()
                .from(Tables.ORDERS)
                .leftOuterJoin(Tables.SHIPPERS)
                .on(Tables.ORDERS.SHIPPERID.eq(Tables.SHIPPERS.SHIPPERID))
                .where(StringUtils.isNotEmpty(orderKey) ? Tables.ORDERS.ORDERID.eq(Integer.valueOf(orderKey)) : DSL.trueCondition())
                .fetch()
                .map( record -> {
                        var order = record.into(OrdersEntity.class);
                        var shipper = record.into(ShippersEntity.class);
                        return Pair.of(order, shipper);
                });
    }
}
