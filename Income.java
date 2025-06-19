package com.moneyminder.model;

import java.time.LocalDate;

public class Income extends Transaction {
    public Income(double amount, String category, LocalDate date, String note) {
        super(amount, category, date, note);
    }

    @Override
    public String getType() {
        return "Income";
    }
}
