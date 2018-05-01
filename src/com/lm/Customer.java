package com.lm;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    private Customer(String name, ArrayList<Double> transactions) {
        this.name = name;
        this.transactions = transactions;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public static Customer createCustomer (String name, double initial){
        ArrayList<Double> transaction = new ArrayList<Double>();
        transaction.add(initial); // works by Autoboxing
        return new Customer (name, transaction);
    }

    public boolean addTransaction (double transaction) {
        this.transactions.add(transaction);
        return true;
    }

    public boolean listTransactions () {
        System.out.println("Transactions for customer: " + this.name);
        for (int i=0; i<this.transactions.size(); i++) {
            System.out.println((i+1) + ". " + this.transactions.get(i)); // Java unboxes Double
        }
        return true;
    }
}
