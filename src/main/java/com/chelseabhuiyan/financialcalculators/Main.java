package com.chelseabhuiyan.financialcalculators;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input the number corresponding to the type of calculator you would like:");
        System.out.println("1. Mortgage Calculator");
        System.out.println("2. Future Value Calculator");
        System.out.println("0. Exit");
        System.out.print("Your choice: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> MortgageCalculator.run(scanner);
            case 2 -> FutureValueCalculator.run(scanner);
            case 0 -> System.out.println("Goodbye!");
            default -> System.out.println("Invalid input. Please enter 1, 2, or 0.");
        }
    }
}
