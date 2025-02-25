package en93.sample.northwindmodulith.webapp.orders;

import en93.sample.northwindmodulith.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

    //todo switch to queryDSL later

    @Query("SELECT o FROM OrderEntity o " +
            "WHERE (:orderKey IS NULL OR :orderKey = o.orderID ) ")
//            "AND (:customerKey IS NOT NULL OR :customerKey IS NULL")
    List<OrderEntity> searchOrders(Integer orderKey);
//    private final DSLContext dslContext;
//    private final DBUtils dbUtils;
//
//    public OrdersRepository(DSLContext dslContext, DBUtils dbUtils) {
//        this.dslContext = dslContext;
//        this.dbUtils = dbUtils;
//    }
//
//    public List<Pair<OrdersEntity, ShippersEntity>> getOrders(String orderKey, String customerKey) {
//        Result<Record> fetch = dslContext.select()
//                .from(Tables.ORDERS)
//                .leftOuterJoin(Tables.SHIPPERS)
//                .on(Tables.ORDERS.SHIPPERID.eq(Tables.SHIPPERS.SHIPPERID))
//                .where(StringUtils.isNotEmpty(orderKey) ? Tables.ORDERS.ORDERID.eq(Integer.valueOf(orderKey)) : DSL.trueCondition())
//                .fetch(Records.mapping(OrdersEntity::new));
////        System.out.println(fetch);
////        List<OrdersEntity> list = fetch.stream()
////                .map(new GenericRecordMapper<>(OrdersEntity.class))
////                .toList();
////        System.out.println(list);
////        return fetch.map(record -> {
////            OrdersEntity order = dbUtils.filterType(record, OrdersEntity.class, "orders");
////            ShippersEntity shippers = dbUtils.filterType(record, ShippersEntity.class, "shippers");
////            return Pair.of(order, shippers);
////        });
//
//    }


}
