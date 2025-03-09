package en93.sample.northwindmodulith.webapp.customers;


import en93.sample.northwindmodulith.entities.CustomerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

    @Query(value = "SELECT * FROM customers c " +
            "WHERE (:customerKey IS NULL OR :customerKey = c.customerKey) " +
            "AND (:searchCustomer IS NULL OR c.tsv_content @@ to_tsquery(:searchCustomer))", nativeQuery = true)
    Page<CustomerEntity> searchCustomers(String customerKey, String searchCustomer, Pageable pageable);

}
