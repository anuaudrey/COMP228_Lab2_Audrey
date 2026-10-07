package BankingSystem;

import java.util.Scanner;

public class MainDriver {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankAccount[] accounts = new BankAccount[3];

        System.out.println("=== BANK ACCOUNT SETUP ===");

        for (int i = 0; i < accounts.length; i++) {
            while (true) {
                try {
                    System.out.println("\nEnter details for Account " + (i + 1));

                    System.out.print("Account Number (min 9 digits): ");
                    long accountNumber = Long.parseLong(sc.nextLine());

                    System.out.print("Account Holder Name: ");
                    String name = sc.nextLine();

                    System.out.print("Initial Balance: ");
                    double accountBalance = Double.parseDouble(sc.nextLine());

                    accounts[i] = new BankAccount(accountNumber,accountBalance, name);
                    break; // exit loop if successful

                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                    System.out.println("Please re-enter the account details.");
                }
            }
        }

        System.out.println("\n=== TRANSACTIONS START ===");

        for (BankAccount acc : accounts) {
            acc.displayAccount();

            // Deposit
            try {
                System.out.print("Enter deposit amount: ");
                double dep = Double.parseDouble(sc.nextLine());
                acc.deposit(dep);
                System.out.println("Deposit successful.");
            } catch (Exception e) {
                System.out.println("Deposit Error: " + e.getMessage());
            } finally {
                System.out.println("Deposit transaction processed.\n");
            }

            // Withdrawal
            try {
                System.out.print("Enter withdrawal amount: ");
                double wd = Double.parseDouble(sc.nextLine());
                acc.withdraw(wd);
                System.out.println("Withdrawal successful.");
            } catch (InsufficientFundsException e) {
                System.out.println("Insufficient Funds: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Withdrawal Error: " + e.getMessage());
            } finally {
                System.out.println("Withdrawal transaction processed.\n");
            }

            acc.displayAccount();
            System.out.println("-----------------------------------");
        }

        System.out.println("All transactions completed.");
        sc.close();
    }
}
