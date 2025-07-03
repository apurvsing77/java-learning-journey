package Interwiews_prep.DesignPrinciple.SOLID_Principle.LiskovSubstitutionPrinciple.Account.GoodCode;

// FixedDepositAccount ek BankAccount hai jismein ek baar hi deposit hota hai aur withdrawal nahi hota
class FixedDepositAccount extends BankAccount {

    protected boolean isDeposited = false; // Check karne ke liye ki deposit ho chuka hai ya nahi

    public FixedDepositAccount(double initialAmount) {
        super(initialAmount); // Base class constructor ko call karega
        System.out.println("Fixed Deposit Account created with balance.");
        // Agar initial deposit diya gaya hai, to use deposited mark karein
        if (initialAmount > 0) {
            isDeposited = true;
        }

    }


    public FixedDepositAccount() {
        super();
        System.out.println("Fixed Deposit Account created without balance.");
    }


    @Override
    public void deposit(double amount) {
        if (!isDeposited) {
            super.deposit(amount); // Base class ke deposit method ko call karein
            isDeposited = true; // Mark as deposited after first successful deposit
            System.out.println("Initial deposit made to Fixed Deposit Account.");
        } else {
            System.out.println("Cannot deposit more funds into a Fixed Deposit Account after initial deposit.");
        }
    }

    // FixedDepositAccount mein withdraw method nahi hai, isliye ye Withdrawal interface ko implement nahi karta.
    // Ye LSP ka accha example hai - FixedDepositAccount ko BankAccount ki tarah treat kiya ja sakta hai
    // deposit aur getBalance ke liye, lekin Withdrawal ke liye nahi.
}
