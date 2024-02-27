// Student name: Koichi Nakata (ID: knakata595)

package org.example;

import java.util.Date;

public class BankAccount {
    private double balance;
    private String owner;
    private Date dateCreated;

    public BankAccount() { this(0.0, "Unknown"); }

    public BankAccount(double balance, String owner) {
        deposit(balance);
        setOwner(owner);
        dateCreated = new Date();
    }

    public double getBalance() { return balance; }
    public void setOwner(String owner) { this.owner = owner; }
    public String getOwner() { return owner; }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Deposited %.2f\nUpdated balance: %.2f\n",
                    amount, getBalance());
        }
        else System.out.println("Amount to deposit must be positive..");
    }

    public void withdraw(double amount) {
        double bal = getBalance();
        if (bal > amount) {
            balance -= amount;
            System.out.printf("Withdrew %.2f\nUpdated balance: %.2f\n",
                    amount, getBalance());
        }
        else System.out.println("Amount to withdraw cannot exceed the balance..");
    }

    public void report() {
        String report = String.format("""
                        Owner: %s
                        Date created: %s
                        Balance: $%.2f""",
                getOwner(), dateCreated.toString(), getBalance());
        System.out.println(report);
    }
}
