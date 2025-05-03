package com.pharmainventory.inventory.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Task {
    @Id @GeneratedValue private Long id;

    @NotBlank private String description;
    @NotBlank private String assignee;
    private boolean completed = false;

    public Task() {}
    public Task(String description, String assignee) {
        this.description = description;
        this.assignee = assignee;
    }
    public Long getId() { return id; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getAssignee() { return assignee; }
    public void setAssignee(String assignee) { this.assignee = assignee; }
    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}
