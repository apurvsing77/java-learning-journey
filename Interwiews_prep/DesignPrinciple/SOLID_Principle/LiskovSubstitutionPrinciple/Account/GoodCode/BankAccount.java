package Interwiews_prep.DesignPrinciple.SOLID_Principle.LiskovSubstitutionPrinciple.Account.GoodCode;

import java.nio.file.Watchable;

interface Withdrawal {
    void withdraw(double amount);
}
public class BankAccount {
    protected double amount;

//    public BankAccount(double amount) {
//        this.amount = amount;
//    }

    public void getBalance() {
        System.out.println("Current balance: " + amount);
    }
    public void deposit(double amount) {
        this.amount += amount;
        System.out.println("Deposited: " + amount);
    }
}
class SavingsAccount extends BankAccount implements Withdrawal {
    public void withdraw(double amount) {
        System.out.println("Withdrawing from savings account: " + amount);
    }
}
class  FixedDepositAccount extends BankAccount {

    protected  boolean isDeposited = false;
    public void deposit(double amount) {
    if(!isDeposited) {
        this.amount += amount;
        isDeposited = true;
    }
    }


}
class main {
    public static void main(String[] args) {
        BankAccount bk = new BankAccount();
        bk.deposit(10000);
        bk.getBalance();
        Withdrawal account = new SavingsAccount();

        account.withdraw(250);
        ((BankAccount)account).getBalance();

        BankAccount bankAccount = new FixedDepositAccount();
        bankAccount.getBalance();
        bankAccount.deposit(311);
        System.out.println("\nCorrect usage for FixedDepositAccount:");
         bankAccount.getBalance();

    }
}