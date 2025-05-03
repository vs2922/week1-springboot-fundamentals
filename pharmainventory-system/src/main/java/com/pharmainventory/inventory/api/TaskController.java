package com.pharmainventory.inventory.api;

import com.pharmainventory.inventory.model.Task;
import com.pharmainventory.inventory.service.InventoryService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final InventoryService svc;

    public TaskController(InventoryService svc) {
        this.svc = svc;
    }

    @GetMapping
    public List<Task> all() {
        return svc.listTasks();
    }

    @PostMapping
    public Task create(@RequestBody @Valid Task t) {
        return svc.addTask(t);
    }

    @PutMapping("/{id}/complete")
    public Task complete(@PathVariable Long id) {
        return svc.completeTask(id);
    }
}
