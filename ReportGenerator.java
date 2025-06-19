package com.moneyminder.service;

import com.moneyminder.model.Transaction;
import com.moneyminder.model.Goal;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportGenerator {

    public static void generateMonthlyReport(FinanceManager manager) {
        List<Transaction> transactions = manager.getTransactions();
        Goal goal = manager.getGoal();

        double incomeTotal = transactions.stream()
                .filter(t -> t.getType().equals("Income"))
                .mapToDouble(Transaction::getAmount)
                .sum();

        double expenseTotal = transactions.stream()
                .filter(t -> t.getType().equals("Expense"))
                .mapToDouble(Transaction::getAmount)
                .sum();

        System.out.println("\n===== Monthly Report =====");
        System.out.println("Total Income: Rs. " + incomeTotal);
        System.out.println("Total Expenses: Rs. " + expenseTotal);
        System.out.println("Balance: Rs. " + (incomeTotal - expenseTotal));

        if (goal != null) {
            System.out.println("Goal: " + goal);
            if ((incomeTotal - expenseTotal) >= goal.getTargetAmount()) {
                System.out.println("✅ Goal Achieved!");
            } else {
                System.out.println("⚠️ Goal Not Yet Achieved.");
            }
        }

        System.out.println("\nExpenses by Category:");
        Map<String, Double> expenseByCategory = transactions.stream()
                .filter(t -> t.getType().equals("Expense"))
                .collect(Collectors.groupingBy(Transaction::getCategory,
                        Collectors.summingDouble(Transaction::getAmount)));

        expenseByCategory.forEach((cat, amt) -> System.out.println(cat + ": Rs. " + amt));
    }
}
