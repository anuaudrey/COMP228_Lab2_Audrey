package BankingSystem;

public class BankAccount {

    private long accountNumber;
    private double accountBalance;
    private String name;

    public BankAccount(long accountNumber, double accountBalance, String name) {

        if (String.valueOf(accountNumber).length() < 9) {
            throw new IllegalArgumentException(
                    "Account Number must be at least 9 digits");
        }

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Name can't be blank");
        }

        if (accountBalance < 0) {
            throw new IllegalArgumentException(
                    "Initial balance cannot be negative.");
        }

        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.name = name;
    }

    public void deposit(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Deposit amount must be greater than zero.");
        }

        accountBalance += amount;

        System.out.printf("Deposit successful: $%.2f%n", amount);
        System.out.printf("New balance: $%.2f%n", accountBalance);
    }

    public void withdraw(double amount)
            throws InsufficientFundsException {

        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Withdrawal amount must be greater than zero.");
        }

        if (amount > accountBalance) {
            throw new InsufficientFundsException(
                    "Insufficient funds. Available balance: $"
                    + String.format("%.2f", accountBalance));
        }

        accountBalance -= amount;

        System.out.printf("Withdrawal successful: $%.2f%n", amount);
        System.out.printf("New balance: $%.2f%n", accountBalance);
    }

    public void displayAccount() {

        System.out.println("Account Number: " + accountNumber);
        System.out.println("Name: " + name);
        System.out.printf("Balance: $%.2f%n", accountBalance);
    }
}