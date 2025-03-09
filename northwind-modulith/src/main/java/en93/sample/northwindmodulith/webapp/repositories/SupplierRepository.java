package en93.sample.northwindmodulith.webapp.repositories;


import en93.sample.northwindmodulith.webapp.entities.SupplierEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<SupplierEntity, Integer> {

    @Query(value = "SELECT * from suppliers s " +
            "WHERE (:supplierKey IS NULL OR :supplierKey = s.supplierKey) " +
            "AND (:searchSupplier IS NULL OR s.tsv_content @@ to_tsquery(:searchSupplier))", nativeQuery = true)
    Page<SupplierEntity> searchSuppliers(String supplierKey, String searchSupplier, Pageable pageable);
}
