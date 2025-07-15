package ets.log430.sales.repositories.logistics;

import ets.log430.sales.models.logistics.LogisticsCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogisticsCenterRepository extends JpaRepository<LogisticsCenter, Long> {
}
