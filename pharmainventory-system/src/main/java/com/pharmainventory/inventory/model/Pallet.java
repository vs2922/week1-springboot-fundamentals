package com.pharmainventory.inventory.model;

import com.pharmainventory.inventory.enums.DeliveryPriority;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class Pallet {
    @Id @GeneratedValue private Long id;

    @NotEmpty
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="pallet_medicines",
      joinColumns=@JoinColumn(name="pallet_id"),
      inverseJoinColumns=@JoinColumn(name="medicine_id"))
    private List<Medicine> medicines;

    @Enumerated(EnumType.STRING)
    private DeliveryPriority priority;

    private boolean processed = false;

    public Pallet() {}
    public Pallet(List<Medicine> medicines, DeliveryPriority priority) {
        if (medicines == null || medicines.isEmpty()) {
            throw new IllegalArgumentException("Must contain at least one medicine");
        }
        this.medicines = medicines;
        this.priority = priority;
    }
    public Long getId() { return id; }
    public List<Medicine> getMedicines() { return medicines; }
    public void setMedicines(List<Medicine> medicines) { this.medicines = medicines; }
    public DeliveryPriority getPriority() { return priority; }
    public void setPriority(DeliveryPriority priority) { this.priority = priority; }
    public boolean isProcessed() { return processed; }
    public void setProcessed(boolean processed) { this.processed = processed; }
}
