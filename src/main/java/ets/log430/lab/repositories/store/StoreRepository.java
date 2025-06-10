package ets.log430.lab.repositories.store;

import ets.log430.lab.models.dto.stores.StoreBasicInfo;
import ets.log430.lab.models.store.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
    @Query("SELECT s.id as id, s.name as name FROM Store s")
    List<StoreBasicInfo> findAllIdAndName();

    StoreBasicInfo findIdAndNameById(Long id);
}
