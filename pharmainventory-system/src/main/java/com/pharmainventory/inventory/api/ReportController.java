package com.pharmainventory.inventory.api;

import com.pharmainventory.inventory.dto.SummaryReport;
import com.pharmainventory.inventory.enums.DeliveryPriority;
import com.pharmainventory.inventory.enums.DrugCondition;
import com.pharmainventory.inventory.model.Medicine;
import com.pharmainventory.inventory.model.Pallet;
import com.pharmainventory.inventory.model.Task;
import com.pharmainventory.inventory.service.InventoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {
    private final InventoryService svc;

    public ReportController(InventoryService svc) {
        this.svc = svc;
    }

    @GetMapping("/expired-medicines")
    public List<Medicine> expiredMedicines() {
        return svc.listExpiredMedicines();
    }

    @GetMapping("/urgent-tasks")
    public List<Task> urgentTasks() {
        return svc.listUrgentTasks();
    }

    @GetMapping("/refrigerated-medicines")
    public List<Medicine> refrigeratedMeds() {
        return svc.listMedicinesByCondition(DrugCondition.REFRIGERATED);
    }

    @GetMapping("/pallets-by-priority/{prio}")
    public List<Pallet> palletsByPriority(@PathVariable String prio) {
        return svc.listPalletsByPriority(DeliveryPriority.valueOf(prio.toUpperCase()));
    }

    @GetMapping("/summary")
    public SummaryReport summary() {
        return svc.getSummary();
    }
}
