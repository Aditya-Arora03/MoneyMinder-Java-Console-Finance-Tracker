package com.moneyminder.model;

import java.time.LocalDate;

public class Expense extends Transaction {
    public Expense(double amount, String category, LocalDate date, String note) {
        super(amount, category, date, note);
    }

    @Override
    public String getType() {
        return "Expense";
    }
}
