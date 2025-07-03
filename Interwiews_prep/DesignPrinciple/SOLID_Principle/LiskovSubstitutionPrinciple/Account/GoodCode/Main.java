package Interwiews_prep.DesignPrinciple.SOLID_Principle.LiskovSubstitutionPrinciple.Account.GoodCode;

class Main { // Class name 'main' ki jagah 'Main' hona chahiye as per Java conventions
    public static void main(String[] args) {
        System.out.println("--- BankAccount Test ---");
        BankAccount bk = new BankAccount(5000); // Initial balance ke saath create karein
        bk.deposit(10000);
        bk.getBalance(); // Output: Current balance: 15000.0

        System.out.println("\n--- SavingsAccount Test ---");
        // SavingsAccount ko as Withdrawal type reference karein
        Withdrawal account = new SavingsAccount(2000); // Initial balance 2000

        // SavingsAccount ke deposit method ko call kar sakte hain (inherit kiya hua BankAccount se)
        ((SavingsAccount)account).deposit(1111); // Output: Deposited: 1111.0
        ((SavingsAccount)account).getBalance(); // Output: Current balance: 3111.0

        account.withdraw(250); // Output: Withdrawing from savings account: 250.0, New balance: 2861.0
        ((SavingsAccount)account).getBalance(); // Output: Current balance: 2861.0

        System.out.println("\n--- FixedDepositAccount Test ---");
        BankAccount fixedAccount = new FixedDepositAccount(0); // Initial balance 0
        fixedAccount.getBalance(); // Output: Current balance: 0.0

        fixedAccount.deposit(311); // Output: Deposited: 311.0, Initial deposit made...
        fixedAccount.getBalance(); // Output: Current balance: 311.0

        fixedAccount.deposit(500); // Output: Cannot deposit more funds...
        fixedAccount.getBalance(); // Output: Current balance: 311.0 (unchanged)

        // FixedDepositAccount se withdraw nahi kar sakte, isliye ye Withdrawal interface implement nahi karta.
        // Ye LSP ka accha example hai.
        // Agar main yahan fixedAccount.withdraw(100); likhta, to compile-time error aayega
        // kyunki BankAccount mein withdraw nahi hai aur FixedDepositAccount Withdrawal implement nahi karta.
    }
}