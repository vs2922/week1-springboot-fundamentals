package com.pharmainventory.inventory.repo;

import com.pharmainventory.inventory.enums.DeliveryPriority;
import com.pharmainventory.inventory.model.Pallet;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PalletRepository extends JpaRepository<Pallet,Long> {
    List<Pallet> findByPriority(DeliveryPriority priority);
    long countByProcessedTrue();
    long countByProcessedFalse();
}
