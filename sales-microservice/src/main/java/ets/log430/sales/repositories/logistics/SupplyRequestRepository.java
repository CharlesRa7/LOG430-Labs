package ets.log430.sales.repositories.logistics;

import ets.log430.sales.models.logistics.SupplyRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplyRequestRepository extends JpaRepository <SupplyRequest, Long> {
}
