package com.moneyminder;

import com.moneyminder.model.*;
import com.moneyminder.service.*;
import com.moneyminder.util.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FinanceManager manager = new FinanceManager();
        boolean exit = false;

        System.out.println("Welcome to MoneyMinder 💼");

        while (!exit) {
            System.out.println("\n====== MENU ======");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Transactions");
            System.out.println("4. Set Savings Goal");
            System.out.println("5. View Report");
            System.out.println("6. Save to File");
            System.out.println("7. Load from File");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> manager.addIncome(sc);
                case 2 -> manager.addExpense(sc);
                case 3 -> manager.viewTransactions();
                case 4 -> manager.setGoal(sc);
                case 5 -> ReportGenerator.generateMonthlyReport(manager);
                case 6 -> FileHandler.saveData(manager);
                case 7 -> FileHandler.loadData(manager);
                case 8 -> {
                    exit = true;
                    System.out.println("Thank you for using MoneyMinder!");
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }

        sc.close();
    }
}
