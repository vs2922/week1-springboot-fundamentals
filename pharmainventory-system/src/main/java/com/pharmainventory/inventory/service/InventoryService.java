package com.pharmainventory.inventory.service;

import com.pharmainventory.inventory.dto.SummaryReport;
import com.pharmainventory.inventory.enums.DeliveryPriority;
import com.pharmainventory.inventory.enums.DrugCondition;
import com.pharmainventory.inventory.exception.ResourceNotFoundException;
import com.pharmainventory.inventory.model.Medicine;
import com.pharmainventory.inventory.model.Pallet;
import com.pharmainventory.inventory.model.Task;
import com.pharmainventory.inventory.repo.MedicineRepository;
import com.pharmainventory.inventory.repo.PalletRepository;
import com.pharmainventory.inventory.repo.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional 

import java.time.LocalDate;
import java.util.List;

@Service
public class InventoryService {
    private final MedicineRepository medRepo;
    private final PalletRepository palletRepo;
    private final TaskRepository taskRepo;

    public InventoryService(MedicineRepository medRepo, PalletRepository palletRepo, TaskRepository taskRepo) {
        this.medRepo = medRepo;
        this.palletRepo = palletRepo;
        this.taskRepo = taskRepo;
    }

    // Medicine operations
    public List<Medicine> listMeds() {
        return medRepo.findAll();
    }

    public Medicine addMed(Medicine m) {
        return medRepo.save(m);
    }

    public List<Medicine> listExpiredMedicines() {
        return medRepo.findByExpiryDateBefore(LocalDate.now());
    }

    public List<Medicine> listMedicinesByCondition(DrugCondition cond) {
        return medRepo.findByCondition(cond);
    }

    // Pallet operations
    @Transactional
    public Pallet createPallet(List<Medicine> meds, DeliveryPriority prio) {
        Pallet p = new Pallet(meds, prio);
        return palletRepo.save(p);
    }

    public List<Pallet> listPallets() {
        return palletRepo.findAll();
    }

    public Pallet processPallet(Long id) {
        Pallet p = palletRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Pallet", id));
        p.setProcessed(true);
        return p;
    }

    public List<Pallet> listPalletsByPriority(DeliveryPriority prio) {
        return palletRepo.findByPriority(prio);
    }

    // Task operations
    public Task addTask(Task t) {
        return taskRepo.save(t);
    }

    public List<Task> listTasks() {
        return taskRepo.findAll();
    }

    public Task completeTask(Long id) {
        Task t = taskRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Task", id));
        t.setCompleted(true);
        return t;
    }

    public List<Task> listUrgentTasks() {
        return taskRepo.findByDescriptionContainingIgnoreCase("urgent");
    }

    // Summary
    public SummaryReport getSummary() {
        long totalMeds = medRepo.count();
        long expired = medRepo.countByCondition(DrugCondition.EXPIRED);
        long refrigerated = medRepo.countByCondition(DrugCondition.REFRIGERATED);

        long totalP = palletRepo.count();
        long proc = palletRepo.countByProcessedTrue();
        long unproc = palletRepo.countByProcessedFalse();

        long totalT = taskRepo.count();
        long done = taskRepo.countByCompletedTrue();
        long pend = taskRepo.countByCompletedFalse();
        long urgent = listUrgentTasks().size();

        return new SummaryReport(
            totalMeds, expired, refrigerated,
            totalP, proc, unproc,
            totalT, done, pend, urgent
        );
    }
}
