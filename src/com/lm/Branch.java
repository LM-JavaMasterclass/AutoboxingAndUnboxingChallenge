package com.lm;

import java.util.ArrayList;

public class Branch {
    private int branchID;
    private ArrayList<Customer> customers;

    private Branch(int branchID) {
        this.branchID = branchID;
        this.customers = new ArrayList<Customer>();
    }

    public static Branch createBranch (int branchID){
        return new Branch (branchID);
    }

    public int getBranchID() {
        return branchID;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean addCustomer (String name, double initial) {

            if (customerExists(name) != null){
                System.out.println("Customer with name " + name + " already exists.");
                System.out.println("Customer not added.");
                return false;
            }

        this.customers.add(Customer.createCustomer(name, initial));
        System.out.println("New customer " + name + " added to branch " + this.branchID);
        return true;
    }

    public boolean addTransaction (String name, double transaction) {
        Customer foundCustomer = customerExists(name);
            if (foundCustomer != null) {
                foundCustomer.addTransaction(transaction);
                return true;
            }
        return false;
    }

    public boolean listCustomers () {
        System.out.println("Customers for branch " + this.branchID);
        for (int i=0; i<this.customers.size(); i++) {
            System.out.println((i+1) + ". " + this.customers.get(i).getName());
        }
        return true;
    }

    public Customer customerExists(String name) {
        for (int i = 0; i < customers.size(); i++) {
            if (name.equals(this.customers.get(i).getName())) {
                Customer foundCustomer = this.customers.get(i);
                return foundCustomer;
            }
        }
        System.out.println("Customer " + name + " not found.");
        return null;
    }
}
