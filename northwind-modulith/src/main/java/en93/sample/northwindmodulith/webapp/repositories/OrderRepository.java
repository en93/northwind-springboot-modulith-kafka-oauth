package en93.sample.northwindmodulith.webapp.repositories;

import en93.sample.northwindmodulith.webapp.entities.OrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

    @Query(value = "SELECT o FROM OrderEntity o " +
            "WHERE (:orderKey IS NULL OR :orderKey = o.orderID ) " +
            "AND (:customerKey IS NOT NULL OR :customerKey IS NULL)", nativeQuery = true)
    Page<OrderEntity> searchOrders(String orderKey, String customerKey, Pageable pageable);

}
