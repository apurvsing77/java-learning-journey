package Interviews_prep.DesignPrinciple.SOLID_Principle.LiskovSubstitutionPrinciple.Account.GoodCode;

// Withdrawal interface define karta hai ki kaun se accounts se paise nikale ja sakte hain

interface Withdrawal {
    void withdraw(double amount);
}