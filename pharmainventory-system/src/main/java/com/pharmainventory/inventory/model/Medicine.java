package com.pharmainventory.inventory.model;

import com.pharmainventory.inventory.enums.DrugCondition;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
public class Medicine {
    @Id @GeneratedValue private Long id;

    @NotBlank private String name;
    @NotBlank private String manufacturer;
    private LocalDate expiryDate;

    @Enumerated(EnumType.STRING)
    private DrugCondition condition;

    public Medicine() {}
    public Medicine(String name, String manufacturer, LocalDate expiryDate, DrugCondition condition) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.expiryDate = expiryDate;
        this.condition = condition;
    }
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }
    public LocalDate getExpiryDate() { return expiryDate; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }
    public DrugCondition getCondition() { return condition; }
    public void setCondition(DrugCondition condition) { this.condition = condition; }
}
