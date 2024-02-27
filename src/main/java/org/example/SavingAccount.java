// Student name: Koichi Nakata (ID: knakata595)

package org.example;

public class SavingAccount extends BankAccount {
    private double annualRate;
    private double handlingFee;
    private int withdrawalLimit;

    public SavingAccount() {
        super();
        setAnnualRate(0.03);
        setHandlingFee(3.50);
        setWithdrawalLimit(3);
    }

    public SavingAccount(double balance, String owner, double annualRate,
                         double handlingFee, int withdrawalLimit) {
        super(balance, owner);
        setAnnualRate(annualRate);
        setHandlingFee(handlingFee);
        setWithdrawalLimit(withdrawalLimit);
    }

    public void setAnnualRate(double annualRate) {
        if (annualRate > 0 && annualRate < 1.0) this.annualRate = annualRate;
        else System.out.println("Annual rate must be between 0.0 and 1.0");
    }

    public double getAnnualRate() { return annualRate; }

    public void setHandlingFee(double handlingFee) {
        if (handlingFee >= 0.0 && handlingFee <= 10.0) this.handlingFee = handlingFee;
        else System.out.println("Handling fee must be between 0.0 and 10.0");
    }

    public double getHandlingFee() { return handlingFee; }

    public void setWithdrawalLimit(int withdrawalLimit) {
        if (withdrawalLimit >= 0) this.withdrawalLimit = withdrawalLimit;
        else System.out.println("Withdrawal limit must be positive");
    }

    public int getWithdrawalLimit() { return withdrawalLimit; }

    @Override
    public void withdraw(double amount) {
        int withdrawalLimit = getWithdrawalLimit();
        if (withdrawalLimit > 0) {
            super.withdraw(amount);
            setWithdrawalLimit(--withdrawalLimit);
            System.out.printf("Remaining withdrawal limit: %d\n", getWithdrawalLimit());
        } else {
            double handlingFee = getHandlingFee();
            super.withdraw(amount + handlingFee);
        }
    }

    @Override
    public void report() {
        super.report();
        String report = String.format("""
                Annual rate: %.3f
                Handling fee: %.2f
                Withdrawal limit (with free handling fee): %d""",
                getAnnualRate(), getHandlingFee(), getWithdrawalLimit());
        System.out.println(report);
    }
}
