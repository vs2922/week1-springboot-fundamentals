package com.pharmainventory.inventory.repo;

import com.pharmainventory.inventory.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findByDescriptionContainingIgnoreCase(String keyword);
    long countByCompletedTrue();
    long countByCompletedFalse();
}
