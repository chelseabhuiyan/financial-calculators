package com.chelseabhuiyan.financialcalculators;   /* Packages are like folders that help organize your code and avoid name conflicts.*/

import java.util.Scanner;  /*Scanner class is needed to reap input from user*/

public class Main {
    public static void main(String[] args) { /* public:anyone can access it. Static: belongs to the class. void: doesnt return anything string[] arg included by default */
        Scanner scanner = new Scanner(System.in);   /* New scanner created to read input from the keyboard (system.in)*/

        System.out.println("Please input the number corresponding to the type of calculator you would like:");
        System.out.println("1. Mortgage Calculator");
        System.out.println("2. Future Value Calculator");
        System.out.println("0. Exit");
        System.out.print("Your choice: ");  /*asks user for input on the same line*/

        int choice = scanner.nextInt();  /*stores the user input as the value for variable choice*/

        switch (choice) {
            case 1 -> MortgageCalculator.run(scanner);  /*if 1 is clicked it calls the run method from Mortgagecalculator class and passes the scanner for input handling */
            case 2 -> FutureValueCalculator.run(scanner);
            case 0 -> System.out.println("Goodbye!");
            default -> System.out.println("Invalid input. Please enter 1, 2, or 0."); /*if anything other than 1,2,3,0 is typed it returns this message to the user*/
        }
    }
}


class MortgageCalculator {
    public static void run(Scanner scanner) { // scanner scanner allows the method to reuse the input object from main.java
        System.out.print("Input loan principal in dollars: ");
        double principal = scanner.nextDouble(); //stores as a decimal number the user input for principle

        System.out.print("Input annual interest rate in percentage: ");
        double annualInterestRate = scanner.nextDouble() / 100;  //user input for annual interest rate is stored as a decimal

        System.out.print("Input loan term in years: ");
        int years = scanner.nextInt();    // user input for length of loan stored as a whole number

        double monthlyRate = annualInterestRate / 12;   //monthly rate found by dividing the yearly interest rate by 12
        int numberOfPayments = years * 12;          //Number of payments found by multiplying how many years in the loan term by 12 since it is paid monthly

        //calculate monthly payment
        double monthlyPayment = principal * (monthlyRate * Math.pow(1 + monthlyRate, numberOfPayments)) /
                (Math.pow(1 + monthlyRate, numberOfPayments) - 1);

        //calculate total payment by multiplying the monthly payment by number of payments needed
        double totalPayment = monthlyPayment * numberOfPayments;

        //Interest found by doing the total payment minus the principal amount
        double totalInterest = totalPayment - principal;

        //Display the monthly payment and total interest
        System.out.printf("Your expected monthly payment is $%.2f%n",monthlyPayment);
        System.out.printf("The total interest you paid is $%.2f%n",totalInterest);

    }
}

class FutureValueCalculator {
    public static void run(Scanner scanner) {

        System.out.print("Enter deposit amount ($): ");
        double principal = scanner.nextDouble();

        System.out.println("Enter the annual interest Rate (in percentage):  ");
        double interestRate=scanner.nextDouble()/100; //convert the annual interest rate to a decimal

        System.out.println("Enter the number of years: ");
        double years=scanner.nextInt();

        double totalDays=years*365;
        double dailyRate=interestRate/365;

        double futureValue = principal * Math.pow(1 + dailyRate, totalDays);
        double totalInterest=futureValue-principal;

        //Display result
        System.out.printf("Your CD's ending balance will be: $%.2f%n", futureValue);
        System.out.printf("Total interest earned: $%.2f%n", totalInterest);
    }
}



