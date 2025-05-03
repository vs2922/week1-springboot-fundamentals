package com.pharmainventory.inventory.api;

import com.pharmainventory.inventory.enums.DeliveryPriority;
import com.pharmainventory.inventory.model.Pallet;
import com.pharmainventory.inventory.service.InventoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pallets")
public class PalletController {
    private final InventoryService svc;

    public PalletController(InventoryService svc) {
        this.svc = svc;
    }

    @GetMapping
    public List<Pallet> all() {
        return svc.listPallets();
    }

    @PostMapping
    public Pallet create(@RequestBody CreatePalletRequest req) {
        return svc.createPallet(req.getMedicines(), DeliveryPriority.valueOf(req.getPriority().toUpperCase()));
    }

    @PutMapping("/{id}/process")
    public Pallet process(@PathVariable Long id) {
        return svc.processPallet(id);
    }
}

// DTO for pallet creation
class CreatePalletRequest {
    private java.util.List<com.pharmainventory.inventory.model.Medicine> medicines;
    private String priority;

    public java.util.List<com.pharmainventory.inventory.model.Medicine> getMedicines() {
        return medicines;
    }
    public void setMedicines(java.util.List<com.pharmainventory.inventory.model.Medicine> medicines) {
        this.medicines = medicines;
    }
    public String getPriority() {
        return priority;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }
}
