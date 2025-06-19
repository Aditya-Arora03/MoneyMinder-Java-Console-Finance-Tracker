package com.moneyminder.model;

import java.time.LocalDate;

public abstract class Transaction {
    protected double amount;
    protected String category;
    protected LocalDate date;
    protected String note;

    public Transaction(double amount, String category, LocalDate date, String note) {
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.note = note;
    }

    public double getAmount() { return amount; }
    public String getCategory() { return category; }
    public LocalDate getDate() { return date; }
    public String getNote() { return note; }

    public abstract String getType();

    @Override
    public String toString() {
        return "[" + getType() + "] " + date + " | " + category + " | Rs. " + amount + " | " + note;
    }
}
