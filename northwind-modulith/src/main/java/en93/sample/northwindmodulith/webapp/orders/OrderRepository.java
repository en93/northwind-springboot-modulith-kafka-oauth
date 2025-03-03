package en93.sample.northwindmodulith.webapp.orders;

import en93.sample.northwindmodulith.entities.OrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

    @Query("SELECT o FROM OrderEntity o " +
            "WHERE (:orderKey IS NULL OR :orderKey = o.orderID ) ")
//            "AND (:customerKey IS NOT NULL OR :customerKey IS NULL")
    Page<OrderEntity> searchOrders(Integer orderKey, Pageable pageable);

}
