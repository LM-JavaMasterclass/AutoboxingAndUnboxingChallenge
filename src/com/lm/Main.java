package com.lm;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Created by Laura Macia: 04/30/2018
    // Udemy Complete Java Masterclass with Tim Buchalka
    // Answer to Challenge: Autoboxing and Unboxing
    // You job is to create a simple banking application.
    // There should be a Bank class
    // It should have an arraylist of Branches
    // Each Branch should have an arraylist of Customers
    // The Customer class should have an arraylist of Doubles (transactions)
    // Customer:
    // Name, and the ArrayList of doubles.
    // Branch:
    // Need to be able to add a new customer and initial transaction amount.
    // Also needs to add additional transactions for that customer/branch
    // Bank:
    // Add a new branch
    // Add a customer to that branch with initial transaction
    // Add a transaction for an existing customer for that branch
    // Show a list of customers for a particular branch and optionally a list
    // of their transactions
    // Demonstration autoboxing and unboxing in your code
    // Hint: Transactions
    // Add data validation.
    // e.g. check if exists, or does not exist, etc.
    // Think about where you are adding the code to perform certain actions

    private static Scanner scanner = new Scanner(System.in);
    private static Bank myBank = new Bank("My Big Bank");

    public static void main(String[] args) {
        boolean quit = false;
        int choice;

        printOptions();

        while (!quit) {
            System.out.println("Enter your option (press 6 to print options):");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    newBranch();
                    break;
                case 2:
                    newCustomer();
                    break;
                case 3:
                    newTransaction();
                    break;
                case 4:
                    printCustomers();
                    break;
                case 5:
                    printTransactions();
                    break;
                case 6:
                    printOptions();
                    break;
            }
        }
    }

    public static void printCustomers(){
        System.out.print("Enter unique ID of branch:");
        int branchID = scanner.nextInt();
        scanner.nextLine();
        if (myBank.listCustomers(branchID)){
            System.out.println("End of list");
        } else {
            System.out.println("Could not print customers list.");
        }
    }

    public static void printTransactions(){
        System.out.print("Enter unique ID of branch:");
        int branchID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter name of customer: ");
        String name = scanner.nextLine();
        if (myBank.listTransactions(branchID,name)){
            System.out.println("End of transactions.");
        } else {
            System.out.println("Could not print transactions.");
        }
    }

    public static void newTransaction(){
        System.out.print("Enter name of customer: ");
        String name = scanner.nextLine();
        System.out.print("Enter unique ID of branch:");
        int branchID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter transaction amount: ");
        double transaction = scanner.nextDouble();
        scanner.nextLine();

        if (myBank.addTransaction(branchID, name, transaction)){
            System.out.println("New transaction of " + transaction + " added to customer " + name);
        } else {
            System.out.println("Could not add transaction.");
        }
    }


    public static void newCustomer(){
        System.out.print("Enter name of new customer: ");
        String name = scanner.nextLine();
        System.out.print("Enter initial transaction amount: ");
        double initial = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter unique ID of branch:");
        int branchID = scanner.nextInt();
        scanner.nextLine();
        if (myBank.branchExists(branchID)){
            myBank.addCustomer(branchID, name, initial);
        } else {
            System.out.println("Could not add customer.");
        }
    }


    public static void newBranch(){
        System.out.print("Enter unique ID of new branch:");
        int branchID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Branch to be entered: " + branchID);
//        myBank.addBranch(branchID);

        if (myBank.addBranch(branchID)){
            System.out.println("Branch " + branchID + " created.");
        } else {
            System.out.println("Could not add branch.");
        }
    }


    public static void printOptions(){
        System.out.println("\nOptions:");
        System.out.println("\t 0 - To quit the application.");
        System.out.println("\t 1 - To add a new branch.");
        System.out.println("\t 2 - To add a new customer to a branch.");
        System.out.println("\t 3 - To add a new transaction for an existing customer from a branch.");
        System.out.println("\t 4 - To print customers for a branch.");
        System.out.println("\t 5 - To print transactions for a customer.");
        System.out.println("\t 6 - To print options.");

    }
}
