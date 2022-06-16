package edu.mum.cs.cs525.labs.exercises.project.ui.framework;

import java.io.Serializable;
import java.time.LocalDate;

public class Transaction implements Serializable {
    private LocalDate date;
    private String description;
    private Double amount;

    public Transaction(LocalDate date, String description, Double amount) {
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public Double getAmount() {
        return amount;
    }
}
