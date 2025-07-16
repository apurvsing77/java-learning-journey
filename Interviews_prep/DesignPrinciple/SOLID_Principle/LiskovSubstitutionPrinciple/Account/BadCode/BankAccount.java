package Interviews_prep.DesignPrinciple.SOLID_Principle.LiskovSubstitutionPrinciple.Account.BadCode;

public class BankAccount {
    protected double amount;

    public void getBalance() {
        System.out.println("Current balance: " + amount);
    }
    public void withdraw(double amount) {
        System.out.println("Withdrawing: " + amount);
    }
}
class SavingsAccount extends BankAccount {
    public void withdraw(double amount) {
        System.out.println("Withdrawing from savings account: " + amount);
    }
}
class  FixedDepositAccount extends BankAccount {
    public void withdraw(double amount) {

        throw new IllegalArgumentException("Fixed deposit accounts cannot be withdrawn from.");
    }
}
class main {
    public static void main(String[] args) {
        BankAccount account = new SavingsAccount();
        account.withdraw(100);
        BankAccount account1 = new  FixedDepositAccount();
        account1.withdraw(200);// This will print: Withdrawing from savings account: 100
    }
}
