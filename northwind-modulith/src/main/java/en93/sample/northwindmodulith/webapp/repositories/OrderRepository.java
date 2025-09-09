package en93.sample.northwindmodulith.webapp.repositories;

import en93.sample.northwindmodulith.webapp.entities.OrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

    @Query(value = "SELECT * FROM orders o " +
            "LEFT JOIN customers c on c.customerid = o.customerid " +
            "WHERE (:orderKey IS NULL OR :orderKey = o.orderKey ) " +
            "AND (:customerKey IS NULL OR :customerKey = c.customerkey)", nativeQuery = true)
    Page<OrderEntity> searchOrders(String orderKey, String customerKey, Pageable pageable);

}
