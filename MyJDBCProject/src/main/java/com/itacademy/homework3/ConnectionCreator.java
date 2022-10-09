package com.itacademy.homework3;

import com.itacademy.homework3.model.Accounts;
import com.itacademy.homework3.model.Transactions;
import com.itacademy.homework3.model.Users;
import com.itacademy.homework3.service.AccountService;
import com.itacademy.homework3.service.TransactionService;
import com.itacademy.homework3.service.UserService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import static com.itacademy.homework3.query_executor.AccountQueryExecutor.addAccount;
import static com.itacademy.homework3.query_executor.TransactionQueryExecutor.*;
import static com.itacademy.homework3.query_executor.UserQueryExecutor.*;

public class ConnectionCreator {
    public static final String JDBC_DRIVER = "org.sqlite.JDBC";
    public static final String DATABASE_URL = "jdbc:sqlite:C:\\JDBC\\myfirstdb1.db";

    public static void main(String[] args) throws SQLException {
        if (isDriverExists()) {
            Connection connection = DriverManager.getConnection(DATABASE_URL);
            String action;
            do {
                printMenu();
                action = new Scanner(System.in).nextLine();
                switch (action) {
                    case "1":
                        printAllUsers(connection);
                        break;
                    case "2":
                        Users users = UserService.inputUsers();
                        System.out.println(users.toString());
                        addUsers(connection, users);
                        break;
                    case "3":
                        Accounts account = AccountService.inputAccount();
                        System.out.println(account.toString());
                        addAccount(connection, account);
                        break;
                    case "4":
                        Transactions transaction = TransactionService.inputTransaction();
                        System.out.println(transaction.toString());
                       addTransaction(transaction, connection);
                        addBalance(transaction, connection);
                        break;
                    case "5":
                        Transactions transaction2 = TransactionService.withdrawTransaction();
                        System.out.println(transaction2.toString());
                        addTransaction(transaction2, connection);
                        accountSpend(transaction2, connection);
                        break;
                    case "6":
                        System.out.println("Thanks for using the program");
                        break;
                    default:
                        System.out.println("Unknown operation. Please, try again");
                }
            } while (!"6".equals(action));
            connection.close();
        }
    }

    private static void printMenu() {
        System.out.println("\n" + "1. Print All Users");
        System.out.println("2. Registration New User");
        System.out.println("3. Create Account");
        System.out.println("4. Refill Account");
        System.out.println("5. Withdrawal of Funds From Account");
        System.out.println("6. Exit");
    }

    public static boolean isDriverExists() {
        try {
            Class.forName(JDBC_DRIVER);
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("JDBC driver was not found");
            return false;
        }
    }
}

