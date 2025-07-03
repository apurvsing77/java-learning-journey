package Interwiews_prep.DesignPrinciple.SOLID_Principle.LiskovSubstitutionPrinciple.Account.GoodCode;

// SavingsAccount ek BankAccount hai jisse paise nikale bhi ja sakte hain
class SavingsAccount extends BankAccount implements Withdrawal {

    // SavingsAccount ka constructor jo base class ke constructor ko call karta hai
    public SavingsAccount(double initialAmount) {
        super(initialAmount); // BankAccount constructor ko call karega
        System.out.println("Savings Account created with balance .");
    }
    public SavingsAccount() {
        super(); // Default BankAccount constructor ko call karega
        System.out.println("Savings Account created without balance .");
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && this.amount >= amount) {
            this.amount -= amount; // Yahan balance ghata rahe hain!
            System.out.println("Withdrawing from savings account: " + amount);
            System.out.println("New balance: " + this.amount);
        } else if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else {
            System.out.println("Insufficient funds for withdrawal. Current balance: " + this.amount);
        }
    }
}