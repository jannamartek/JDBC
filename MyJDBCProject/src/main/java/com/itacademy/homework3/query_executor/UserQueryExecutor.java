package com.itacademy.homework3.query_executor;

import com.itacademy.homework3.model.Users;

import java.sql.*;

import static java.lang.String.format;

public class UserQueryExecutor {
    private static final String FIND_ALL_USERS = "SELECT * FROM Users;";

    public static void printAllUsers(Connection connection) throws SQLException {
        PreparedStatement statement =
                connection.prepareStatement(FIND_ALL_USERS);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.println('\n' + "userId: " + resultSet.getInt("userId"));
            System.out.println("name: " + resultSet.getString("name"));
            System.out.println("address: " + resultSet.getString("address"));
        }
        resultSet.close();
        statement.close();
    }

    public static void addUsers(Connection connection, Users user) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(format("\n" + "INSERT INTO Users (name, address) VALUES ('%s', '%s')",
                user.getName(), user.getAddress()));
        System.out.println("User " + user.getName() + " created");
        statement.close();
    }
}
