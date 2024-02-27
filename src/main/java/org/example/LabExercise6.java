// Student name: Koichi Nakata (ID: knakata595)

package org.example;

import java.util.Locale;

public class LabExercise6 {
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount(100.0, "Koichi Nakata");
        SavingAccount mySavingAccount = new SavingAccount(150.0, "Victor Palacios",
                0.035, 3.50, 3);

        myAccount.withdraw(50);
        System.out.println();
        myAccount.report();
        System.out.println();

        mySavingAccount.withdraw(50);
        System.out.println();
        mySavingAccount.report();
        System.out.println();

        mySavingAccount.withdraw(25);
        System.out.println();
        mySavingAccount.withdraw(30);
        System.out.println();
        mySavingAccount.withdraw(10);
        System.out.println();
        mySavingAccount.report();
        System.out.println();
    }
}