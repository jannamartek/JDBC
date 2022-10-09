package com.itacademy.homework3.query_executor;

import com.itacademy.homework3.model.Transactions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.String.format;

public class TransactionQueryExecutor {
    public static void addBalance(Transactions transaction, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        if (transaction.getAmount() <= 100_000_000) {
            ResultSet resultSet = statement.executeQuery("SELECT balance FROM Accounts WHERE accountId ="
                    + transaction.getAccountId());
            int balance = resultSet.getInt("balance");
            if (balance < 2000000000) {
                statement.executeUpdate(format("INSERT INTO Transactions (accountId, amount) VALUES('%d', '%d')",
                        transaction.getAccountId(), transaction.getAmount()));
                statement.executeUpdate(format("UPDATE Accounts SET balance = '%d' WHERE accountId = %d; ",
                        balance + transaction.getAmount(), transaction.getAccountId()));
                System.out.println("Transaction was successful");
                resultSet.close();
                statement.close();
            } else {
                System.out.println("The balance cannot exceed 2,000,000,000");
            }
        } else {
            System.out.println("Transaction amount cannot exceed 100,000,000");
        }
    }

    public static void addTransaction(Transactions transaction, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(format("INSERT INTO Transactions (accountId, amount) VALUES('%d', '%d')",
                transaction.getAccountId(), transaction.getAmount()));
        statement.close();
    }

    public static void accountSpend(Transactions transaction, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        if (transaction.getAmount() <= 100_000_000) {
        ResultSet resultSet = statement.executeQuery("SELECT balance FROM Accounts WHERE accountId ="
                + transaction.getAccountId());
        resultSet.next();
        int currentBalance = resultSet.getInt("balance");
        if ((currentBalance - transaction.getAmount() >= 0)) {
            statement.executeUpdate(format("INSERT INTO Transactions (accountId, amount) VALUES('%d', '%d')",
                    transaction.getAccountId(), -transaction.getAmount()));
            statement.executeUpdate(format("UPDATE Accounts SET balance = '%d' WHERE accountId = %d; ",
                    currentBalance - transaction.getAmount(), transaction.getAccountId()));
            System.out.println("Transaction was successful");
            resultSet.close();
            statement.close();
        } else {
            System.out.println("Insufficient funds");
        }
        } else {
            System.out.println("Transaction amount cannot exceed 100,000,000");
        }
    }
}
