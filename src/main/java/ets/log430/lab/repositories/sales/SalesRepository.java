package ets.log430.lab.repositories.sales;

import ets.log430.lab.models.sales.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SalesRepository extends JpaRepository<Sale, Long> {
    @Query("SELECT s FROM Sale s WHERE s.date >= :startDate AND s.date <= :endDate")
    List<Sale> findAllForPeriod(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
    // Additional query methods can be defined here if needed
}
