package com.moneyminder.service;

import com.moneyminder.model.*;
import com.moneyminder.util.DateUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FinanceManager {
    private List<Transaction> transactions;
    private Goal goal;

    public FinanceManager() {
        this.transactions = new ArrayList<>();
    }

    public void addIncome(Scanner sc) {
        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter category: ");
        String category = sc.nextLine();
        System.out.print("Enter note: ");
        String note = sc.nextLine();
        LocalDate date = LocalDate.now();

        transactions.add(new Income(amount, category, date, note));
        System.out.println("Income added successfully!");
    }

    public void addExpense(Scanner sc) {
        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter category: ");
        String category = sc.nextLine();
        System.out.print("Enter note: ");
        String note = sc.nextLine();
        LocalDate date = LocalDate.now();

        transactions.add(new Expense(amount, category, date, note));
        System.out.println("Expense added successfully!");
    }

    public void viewTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (Transaction t : transactions) {
                System.out.println(t);
            }
        }
    }

    public void setGoal(Scanner sc) {
        System.out.print("Enter target amount: ");
        double target = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter description: ");
        String desc = sc.nextLine();
        this.goal = new Goal(target, desc);
        System.out.println("Goal set successfully!");
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }
}
