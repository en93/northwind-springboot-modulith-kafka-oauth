package en93.sample.northwindmodulith.webapp.suppliers;


import en93.sample.northwindmodulith.entities.SupplierEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<SupplierEntity, Integer> {

    @Query("SELECT s from SupplierEntity s " +
            "WHERE :key IS NULL OR :key = s.supplierID")
    Page<SupplierEntity> searchSuppliers(Integer key, Pageable pageable);
}
