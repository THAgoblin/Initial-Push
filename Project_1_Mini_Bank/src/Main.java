import java.util.Scanner;

void main() {
        Scanner scanner = new Scanner(System.in);
        BankOperations ops = new BankOperations();


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

                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    while (true) {

                        if(!scanner.hasNextLine()) {
                            System.out.print("Invalid input ,enter the Name in Letters: ");
                            scanner.nextLine();
                        }
                        else {
                            System.out.print("Enter Your Name : ");
                            double amount = scanner.nextDouble();
                            scanner.nextLine();
                            break; //🔹 with break → exits loop after valid input 🚪
                        }
                    }

                    while (true) {
                    if(!scanner.hasNextDouble()) {
                        System.out.print("Invalid input ,enter the Amount in Numbers: ");
                        scanner.nextLine();
                    }
                    else {
                        System.out.print("Enter the Amount : ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine();
                        break; //🔹 with break → exits loop after valid input 🚪
                    }
                    }

                    while (true) {

                        if (!scanner.hasNextLine()){

                            System.out.print("Enter you Currency: ");
                            String currency = scanner.nextLine();
                            scanner.nextLine();
                        }
                        else{
                            String currency = scanner.nextLine();
                            scanner.nextLine();
                            break; //🔹 with break → exits loop after valid input 🚪

                        }
                    }

                    while (true) {
                        if(!scanner.hasNextLine()) {

                            System.out.print("Type (Checking/Savings): ");
                            String type = scanner.nextLine();
                            scanner.nextLine();
                        }
                        else{
                            System.out.print("Type (Checking/Savings): ");
                            scanner.nextLine();
break;
                        }
                    }

                    System.out.print("Status (Active/Blocked): ");
                    String status = scanner.nextLine();


                    bankAccount acc = new bankAccount(name , amount, type, status, currency);
                    ops.addAccount(acc);
                }

                case 2 -> { // Withdraw
                    System.out.print("Account ID to withdraw: ");
                    int id = scanner.nextInt();

                    System.out.print("Amount to withdraw: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();

                    ops.withdraw(id, amount);
                }

                case 3 -> { // Deposit
                    System.out.print("Account ID to deposit: ");
                    int id = scanner.nextInt();

                    System.out.print("Amount to deposit: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();

                    ops.deposit(id, amount);
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

            System.out.println(); // extra line for readability
        }
    }