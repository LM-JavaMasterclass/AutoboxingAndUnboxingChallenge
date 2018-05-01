package com.lm;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }


    public boolean addBranch(int newBranchID) {

            if (branchExisting(newBranchID) != null) {
                System.out.println("Branch with ID " + newBranchID + " already exists.");
                return false;
            }

        this.branches.add(Branch.createBranch(newBranchID));
        System.out.println("New branch added.");
        return true;
    }

    public boolean addCustomer(int branchID, String name, double initial) {
        Branch foundBranch = this.branchExisting(branchID);

        if (foundBranch != null) {
            foundBranch.addCustomer(name, initial);
            return true; // Since addCustomer is boolean, could've done:
                        // return foundBranch.addCustomer(name, initial);
        }

        return false;
    }

    public boolean addTransaction(int branchID, String name, double amount) {
        Branch foundBranch = this.branchExisting(branchID);

        if (foundBranch != null) {
            if (foundBranch.customerExists(name) != null) {
                foundBranch.addTransaction(name, amount);
                return true;
            } else {
                System.out.println("Customer does not exist.");
                return false;
            }
        }
        return false;
    }



    public boolean listCustomers(int branchID) {
        Branch foundBranch = this.branchExisting(branchID);

        if (foundBranch != null) {
            foundBranch.listCustomers();
            return true;
        }

        System.out.println("Branch ID " + branchID + " not found.");
        return false;
    }


    public boolean listTransactions(int branchID, String name) {
        Branch foundBranch = this.branchExisting(branchID);
        if (foundBranch != null) {
            Customer foundCustomer = foundBranch.customerExists(name);
            if (foundCustomer != null) {
                foundCustomer.listTransactions();
                return true;
            } else {
                System.out.println("Customer " + name + " does not exist in this branch.");
                return false;
            }
        }
        System.out.println("Branch ID " + branchID + " not found.");
        return false;
    }

    private Branch branchExisting(int branchID) { // working well
        for (int i = 0; i < branches.size(); i++) {
            Branch foundBranch = this.branches.get(i);
            if (foundBranch.getBranchID() == branchID) {
                return foundBranch;
            }
        }
        System.out.println("Branch " + branchID + " does not exist in this bank.");
        return null;
    }

    public boolean branchExists(int branchID) {
        if (branchExisting(branchID) != null) {
            return true;
        }
        return false;
    }
}
