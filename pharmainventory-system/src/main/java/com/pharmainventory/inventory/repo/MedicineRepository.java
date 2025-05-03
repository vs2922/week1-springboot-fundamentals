package com.pharmainventory.inventory.repo;

import com.pharmainventory.inventory.enums.DrugCondition;
import com.pharmainventory.inventory.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface MedicineRepository extends JpaRepository<Medicine,Long> {
    List<Medicine> findByExpiryDateBefore(LocalDate cutoff);
    List<Medicine> findByCondition(DrugCondition condition);
    long countByCondition(DrugCondition condition);
}
