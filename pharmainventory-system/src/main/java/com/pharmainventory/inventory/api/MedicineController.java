package com.pharmainventory.inventory.api;

import com.pharmainventory.inventory.model.Medicine;
import com.pharmainventory.inventory.service.InventoryService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/medicines")
public class MedicineController {
    private final InventoryService svc;

    public MedicineController(InventoryService svc) {
        this.svc = svc;
    }

    @GetMapping
    public List<Medicine> all() {
        return svc.listMeds();
    }

    @PostMapping
    public Medicine create(@RequestBody @Valid Medicine m) {
        return svc.addMed(m);
    }
}
