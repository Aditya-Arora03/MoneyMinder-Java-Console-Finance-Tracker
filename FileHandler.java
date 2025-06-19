package com.moneyminder.util;

import com.moneyminder.model.*;
import com.moneyminder.service.FinanceManager;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private static final String FILE_NAME = "data/transactions.txt";

    public static void saveData(FinanceManager manager) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Transaction t : manager.getTransactions()) {
                writer.write(t.getType() + "," + t.getAmount() + "," + t.getCategory() + "," +
                        t.getDate() + "," + t.getNote());
                writer.newLine();
            }

            Goal goal = manager.getGoal();
            if (goal != null) {
                writer.write("GOAL," + goal.getTargetAmount() + "," + goal.getDescription());
            }

            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public static void loadData(FinanceManager manager) {
        List<Transaction> loadedTransactions = new ArrayList<>();
        Goal loadedGoal = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals("Income")) {
                    loadedTransactions.add(new Income(Double.parseDouble(parts[1]), parts[2],
                            LocalDate.parse(parts[3]), parts[4]));
                } else if (parts[0].equals("Expense")) {
                    loadedTransactions.add(new Expense(Double.parseDouble(parts[1]), parts[2],
                            LocalDate.parse(parts[3]), parts[4]));
                } else if (parts[0].equals("GOAL")) {
                    loadedGoal = new Goal(Double.parseDouble(parts[1]), parts[2]);
                }
            }

            manager.setTransactions(loadedTransactions);
            manager.setGoal(loadedGoal);
            System.out.println("Data loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}
