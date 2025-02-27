package en93.sample.northwindmodulith.webapp.customers;


import en93.sample.northwindmodulith.entities.CustomerEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

    @Query("SELECT c FROM CustomerEntity c " +
            "WHERE :customerKey IS NULL OR :customerKey = c.customerID")
    List<CustomerEntity> searchCustomers(Integer customerKey, Pageable pageable);

}
