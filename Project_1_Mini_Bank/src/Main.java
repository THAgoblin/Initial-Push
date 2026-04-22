import model.BankAccount;
import service.BankOperations;
import model.BankAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

void main() {
    Scanner scanner = new Scanner(System.in);
    BankOperations ops = new BankOperations();
    Set<String> currencies = Set.of("USD", "EUR", "GBP", "JPY", "CHF");

    while (true) {

        System.out.println("""
                ------------------------------
                Choose an option:
                1) Add Account
                2) Withdraw
                3) Deposit
                4) Show Accounts
                5) Clear Balance
                6) Delete Account
                7) Exit
                ------------------------------""");

        System.out.println("Enter your Choice from 1-7 : ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1 -> { // Add Account

                // NAME (must not be empty)
                String name;
                while (true) {
                    System.out.print("Name: ");
                    name = scanner.nextLine().trim();
                    System.out.println("You Name is : " + name);
                    if (!name.isEmpty()) break;
                    System.out.println("Invalid name. Try again.");
                }

                // AMOUNT (must be number)
                double amount;
                while (true) {
                    System.out.print("Amount: ");
                    if (scanner.hasNextDouble()) {
                        amount = scanner.nextDouble();
                        System.out.println("Amount: " + amount + " $.");
                        scanner.nextLine();
                        break;
                    } else {
                        System.out.println("Invalid amount. Try again.");
                        scanner.nextLine();
                    }
                }

                String currency;

                while (true) {
                    System.out.println("Currency (USD/EUR/GBP/JPY/CHF): ");
                    currency = scanner.nextLine().trim().toUpperCase();

                    if (currencies.contains(currency)) {
                        System.out.println("Currency is: " + currency);
                        break;
                    } else {
                        System.out.println("Invalid currency. Choose from (USD/EUR/GBP/JPY/CHF)");
                    }
                }

                // TYPE (Checking/Savings only)
                String type;
                while (true) {
                    System.out.print("Account Type (Checking/Saving): ");
                    type = scanner.nextLine().trim().toLowerCase();
                    if (type.equals("saving") || type.equals("checking")) {
                        System.out.println("You Account Type is : " + type);
                        break;
                    }
                    System.out.println("Invalid type. Try again.");
                }

                // STATUS (Active/Blocked only)
                String status;
                while (true) {
                    System.out.print("Status (Active/Blocked): ");
                    status = scanner.nextLine().trim();

                    if (status.equalsIgnoreCase("Active") || status.equalsIgnoreCase("Blocked")) {
                        System.out.println("Your status is: " + status);
                        break;
                    }

                    System.out.println("Invalid status. Try again.");
                }

                BankAccount acc = new BankAccount(name, amount, type, status, currency);
                ops.addAccount(acc);
            }
            case 2 -> { // Withdraw
                System.out.print("Account ID to withdraw: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                BankAccount dbId =ops.findById(id);

                if (dbId == null) {
                    System.out.println("Account not found");
                }
                else if (dbId.getStatus().equalsIgnoreCase("Blocked")) {
                    System.out.println("Sorry, your account is Blocked .");
                }
                else {
                    System.out.print("Amount to withdraw: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();

                    ops.withdraw(id, amount);
                }
            }


            case 3 -> {//Deposit
                    System.out.print("Account ID to deposit: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                 BankAccount dbId =ops.findById(id);

                        if (dbId == null) {
                        System.out.println("Account not found");
                    } else if (dbId.getStatus().equalsIgnoreCase("Blocked")) {
                        System.out.println("Account is blocked.");
                    } else {
                        System.out.print("Amount to deposit: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine();

                        ops.deposit(id, amount);
                    }
                }


            case 4 -> ops.showAccounts(); // Show all accounts

            case 5 -> { // Clear balance
                System.out.print("Account ID to clear balance: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                ops.clear(id);
            }

            case 6 -> { // Delete account
                System.out.print("Account ID to delete: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                ops.deleteAccount(id);
            }

            case 7 -> { // Exit
                System.out.println("Exiting...");
                scanner.close();
                return;
            }

            default -> System.out.println("Invalid choice! Please choose 1-7.");
        }
    }
}