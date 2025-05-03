package com.pharmainventory.inventory.dto;

public class SummaryReport {
    public long totalMedicines;
    public long expiredMedicines;
    public long refrigeratedMedicines;
    public long totalPallets;
    public long processedPallets;
    public long unprocessedPallets;
    public long totalTasks;
    public long completedTasks;
    public long pendingTasks;
    public long urgentTasks;

    public SummaryReport(long totalMedicines,
                         long expiredMedicines,
                         long refrigeratedMedicines,
                         long totalPallets,
                         long processedPallets,
                         long unprocessedPallets,
                         long totalTasks,
                         long completedTasks,
                         long pendingTasks,
                         long urgentTasks) {
        this.totalMedicines = totalMedicines;
        this.expiredMedicines = expiredMedicines;
        this.refrigeratedMedicines = refrigeratedMedicines;
        this.totalPallets = totalPallets;
        this.processedPallets = processedPallets;
        this.unprocessedPallets = unprocessedPallets;
        this.totalTasks = totalTasks;
        this.completedTasks = completedTasks;
        this.pendingTasks = pendingTasks;
        this.urgentTasks = urgentTasks;
    }
}
