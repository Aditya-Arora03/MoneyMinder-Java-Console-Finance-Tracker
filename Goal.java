package com.moneyminder.model;

public class Goal {
    private double targetAmount;
    private String description;

    public Goal(double targetAmount, String description) {
        this.targetAmount = targetAmount;
        this.description = description;
    }

    public double getTargetAmount() {
        return targetAmount;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Goal: Save Rs. " + targetAmount + " - " + description;
    }
}
