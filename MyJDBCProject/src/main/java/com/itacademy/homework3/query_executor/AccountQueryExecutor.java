package com.itacademy.homework3.query_executor;

import com.itacademy.homework3.model.Accounts;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static java.lang.String.format;

public class AccountQueryExecutor {
    public static void addAccount(Connection connection, Accounts account) throws SQLException {
        Statement statement = connection.createStatement();
            if (account.getCurrency().equals("BYN") || account.getCurrency().equals("RUR") ||
                    account.getCurrency().equals("EUR") || account.getCurrency().equals("USD")) {
                ResultSet resultSet = statement.executeQuery("SELECT currency FROM Accounts WHERE userId="
                        + account.getUserId());
                ArrayList<String> currencies = new ArrayList<>();
                while (resultSet.next()) {
                    currencies.add(String.valueOf(resultSet.getString("currency")));
                }
                if (!currencies.contains(Accounts.getCurrency())) {
                    statement.executeUpdate(format("\n" + "INSERT INTO Accounts (userId, balance, currency) " +
                                    "VALUES ('%d', '%s', '%s')",
                            account.getUserId(), account.getBalance(), account.getCurrency()));
                    System.out.println("Account was created");
                    resultSet.close();
                    statement.close();
                } else {
                    System.out.println(" User already have an account in this currency");
                }
            } else {
                System.out.println("You have selected a currency not from the list");
            }
        }
    }
