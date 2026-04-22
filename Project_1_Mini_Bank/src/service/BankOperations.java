package service;

import model.BankAccount;
import repository.DbAccounts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankOperations {

    // Add a new account
    public void addAccount(BankAccount acc) {
        String sql = "INSERT INTO bankaccount (ownerName, amount, currency, type, status) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DbAccounts.getConnection()) {
            System.out.println("Database connected successfully!");

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, acc.getOwnerName());
            stmt.setDouble(2, acc.getAmount());
            stmt.setString(3, acc.getCurrency());
            stmt.setString(4, acc.getType());
            stmt.setString(5, acc.getStatus());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Account added successfully");
            } else {
                System.out.println("No rows affected.");
            }

        } catch (SQLException e) {
            System.out.println("Error adding account: " + e.getMessage());
        }
    }

    // Deposit money into existing account
    public void deposit(int id, double amount) {
        String sql = "UPDATE bankaccount SET amount = amount + ? WHERE id = ?";

        try (Connection conn = DbAccounts.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, amount);
            stmt.setInt(2, id);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Deposit successful");
            } else {
                System.out.println("Account not found");
            }

        } catch (SQLException e) {
            System.out.println("Error depositing: " + e.getMessage());
        }
    }

    // Withdraw money from existing account
    public void withdraw(int id, double amount ) {
        String sql = "UPDATE bankaccount SET amount = amount - ? WHERE id = ?";

        try (Connection conn = DbAccounts.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, amount);
            stmt.setInt(2, id);

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Withdrawal successful");
            } else {
                System.out.println("Account not found or insufficient funds");
            }

        } catch (SQLException e) {
            System.out.println("Error withdrawing: " + e.getMessage());
        }
    }

    // Show all accounts
    public void showAccounts() {
        String sql = "SELECT * FROM bankaccount";

        try (Connection conn = DbAccounts.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("ID | Name | Amount (Balance) | Currency | Type | Status");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("ownerName") + " | " +
                                rs.getDouble("amount") + " | " +
                                rs.getString("currency") + " | " +
                                rs.getString("type") + " | " +
                                rs.getString("status")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error showing accounts: " + e.getMessage());
        }
    }

    // Clear balance of a specific account (without deleting)
    public void clear(int id) {
        String sql = "UPDATE bankaccount SET amount = 0 WHERE id = ?";

        try (Connection conn = DbAccounts.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Account balance cleared for ID " + id);
            } else {
                System.out.println("Account not found");
            }

        } catch (SQLException e) {
            System.out.println("Error clearing account: " + e.getMessage());
        }
    }

    // Delete an account completely
    public void deleteAccount(int id) {
        String sql = "DELETE FROM bankaccount WHERE id = ?";

        try (Connection conn = DbAccounts.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Account deleted for ID " + id);
            } else {
                System.out.println("Account not found");
            }

        } catch (SQLException e) {
            System.out.println("Error deleting account: " + e.getMessage());
        }
    }
//    ✔ What does BankAccount mean here?
//    It means: “This method will return a BankAccount object.”
public BankAccount findById(int id) {
    String sql = "SELECT * FROM bankaccount WHERE id = ?";

    try (Connection conn = DbAccounts.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return new BankAccount(
                    rs.getString("ownerName"),
                    rs.getDouble("amount"),
                    rs.getString("type"),
                    rs.getString("status"),
                    rs.getString("currency")
            );
        }

    } catch (SQLException e) {
        System.out.println("Error finding account: " + e.getMessage());
    }

    return null;
}
}