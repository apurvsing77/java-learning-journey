/*
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

        ((SavingsAccount)account).deposit(1111);
        account.withdraw(250);
        ((SavingsAccount)account).getBalance();

        BankAccount bankAccount = new FixedDepositAccount();
        bankAccount.getBalance();
        bankAccount.deposit(311);
        System.out.println("\nCorrect usage for FixedDepositAccount:");
         bankAccount.getBalance();

    }
}*/


package Interwiews_prep.DesignPrinciple.SOLID_Principle.LiskovSubstitutionPrinciple.Account.GoodCode;



// BankAccount base class hai sabhi accounts ke liye
public class BankAccount {
    protected double amount; // Protected rakha hai takki child classes access kar saken

    // Constructor to initialize the balance
    public BankAccount(double initialAmount) {
        this.amount = initialAmount;
        System.out.println("New Bank Account created with initial balance: " + initialAmount);
    }
    // Default constructor (if needed, but usually better to initialize)
    public BankAccount() {
        this(0.0); // Call the other constructor with default 0.0
    }

    public void getBalance() {
        System.out.println("Current balance: " + amount);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.amount += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Not sufficient balance .");
        }
    }
}




